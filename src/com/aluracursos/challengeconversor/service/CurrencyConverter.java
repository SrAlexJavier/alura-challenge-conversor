package com.aluracursos.challengeconversor.service;

import com.aluracursos.challengeconversor.api.ExchangeRateClient;
import com.aluracursos.challengeconversor.model.CurrencyPair;

public class CurrencyConverter {
    private final ExchangeRateClient apiClient;

    public CurrencyConverter() {
        this.apiClient = new ExchangeRateClient();
    }

    public ConversionData convert(CurrencyPair pair, double amount) throws Exception {
        double exchangeRate = apiClient.getExchangeRate(pair.base(), pair.target());
        double convertedAmount = amount * exchangeRate;
        return new ConversionData(pair.base(), pair.target(), amount, exchangeRate, convertedAmount);
    }

    public record ConversionData(
            String baseCurrency,
            String targetCurrency,
            double amount,
            double exchangeRate,
            double convertedAmount
    ) {
        public void displayResult() {
            System.out.printf("El valor %.2f [%s] corresponde al valor final de =>>> %.2f [%s]", amount, baseCurrency, convertedAmount, targetCurrency);
            System.out.printf("\n(Tasa de cambio: 1 %s = %.4f %s)%n%n", baseCurrency, exchangeRate, targetCurrency);
        }
    }
}
