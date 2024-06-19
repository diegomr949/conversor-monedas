package com.conversor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ApiClient apiClient = new ApiClient();
        ExchangeRateParser exchangeRateParser = new ExchangeRateParser();

        try {
            String baseCurrency = "USD";  // Moneda base
            String jsonResponse = apiClient.getExchangeRates(baseCurrency);

            // Monedas disponibles para la conversión
            String[] currencies = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

            Map<String, Double> exchangeRates = exchangeRateParser.parseExchangeRates(jsonResponse, currencies);

            Scanner scanner = new Scanner(System.in);
            boolean salir = false;

            while (!salir) {
                mostrarMenu();
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer de entrada

                switch (opcion) {
                    case 1:
                        realizarConversion("USD", "ARS", exchangeRates, scanner);
                        break;
                    case 2:
                        realizarConversion("USD", "BOB", exchangeRates, scanner);
                        break;
                    case 3:
                        realizarConversion("USD", "BRL", exchangeRates, scanner);
                        break;
                    case 4:
                        realizarConversion("USD", "CLP", exchangeRates, scanner);
                        break;
                    case 5:
                        realizarConversion("USD", "COP", exchangeRates, scanner);
                        break;
                    case 6:
                        salir = true;
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elige una opción válida.");
                        break;
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú de Conversión de Monedas ---");
        System.out.println("1. Convertir USD a ARS (Peso argentino)");
        System.out.println("2. Convertir USD a BOB (Boliviano boliviano)");
        System.out.println("3. Convertir USD a BRL (Real brasileño)");
        System.out.println("4. Convertir USD a CLP (Peso chileno)");
        System.out.println("5. Convertir USD a COP (Peso colombiano)");
        System.out.println("6. Salir");
        System.out.print("Elige una opción: ");
    }

    private static void realizarConversion(String fromCurrency, String toCurrency, Map<String, Double> exchangeRates, Scanner scanner) {
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            System.out.println("No se encontraron tasas de cambio para las monedas especificadas.");
            return;
        }

        System.out.printf("Introduce la cantidad en %s que deseas convertir a %s: ", fromCurrency, toCurrency);
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Limpiar el buffer de entrada

        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        // Convertir el monto de una moneda a otra
        double convertedAmount = amount * (toRate / fromRate);

        System.out.printf("%.2f %s = %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
    }
}
