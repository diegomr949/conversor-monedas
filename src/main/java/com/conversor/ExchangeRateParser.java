package com.conversor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRateParser {

    public Map<String, Double> parseExchangeRates(String jsonResponse, String... currencies) {
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        Map<String, Double> exchangeRates = new HashMap<>();

        for (String currency : currencies) {
            if (rates.has(currency)) {
                double rate = rates.get(currency).getAsDouble();
                exchangeRates.put(currency, rate);
            }
        }

        return exchangeRates;
    }
}
