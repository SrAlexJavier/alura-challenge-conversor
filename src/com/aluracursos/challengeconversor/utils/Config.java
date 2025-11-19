package com.aluracursos.challengeconversor.utils;

import com.aluracursos.challengeconversor.model.CurrencyPair;

import java.util.List;

public class Config {
    public static List<CurrencyPair> getCurrencyPairs() {
        return List.of(
                new CurrencyPair("USD", "PEN"),
                new CurrencyPair("PEN", "USD")
        );
    };
    public static final String API_KEY = "93484caea9a62211adf867e6";
}
