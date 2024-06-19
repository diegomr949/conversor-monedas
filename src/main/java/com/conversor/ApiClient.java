package com.conversor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    private static final String API_KEY = "tu_clave_de_api_aqui";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public String getExchangeRates(String baseCurrency) throws IOException, InterruptedException {
        String url = BASE_URL + API_KEY + "/latest/" + baseCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "Java HttpClient")  // Opcional: agregar headers
                .GET()  // Configura el método HTTP como GET
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Manejo del código de estado
        int statusCode = response.statusCode();
        if (statusCode != 200) {
            throw new IOException("Error en la solicitud a la API. Código de estado: " + statusCode);
        }

        return response.body();
    }
}


