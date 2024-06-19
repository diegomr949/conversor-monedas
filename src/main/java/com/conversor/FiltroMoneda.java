package com.conversor;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FiltroMoneda {

    public Map<String, Double> filterCurrencies(Map<String, Double> exchangeRates, Set<String> currenciesOfInterest) {
        return exchangeRates.entrySet().stream()
                .filter(entry -> currenciesOfInterest.contains(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
