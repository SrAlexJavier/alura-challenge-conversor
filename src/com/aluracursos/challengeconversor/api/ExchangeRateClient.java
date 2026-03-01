package com.aluracursos.challengeconversor.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.aluracursos.challengeconversor.utils.Config;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateClient {
    private final HttpClient client;
    private final String apiKey;

    public ExchangeRateClient() {
        this.client = HttpClient.newHttpClient();
        this.apiKey = Config.API_KEY;
    }

    public double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        String url = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, baseCurrency);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new Exception("Error en la API: " + response.statusCode());
        }

        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

        if (jsonResponse.has("conversion_rates")) {
            JsonObject rates = jsonResponse.getAsJsonObject("conversion_rates");
            if (rates.has(targetCurrency)) {
                return rates.get(targetCurrency).getAsDouble();
            } else {
                throw new Exception("Moneda destino no encontrada: " + targetCurrency);
            }
        } else {
            throw new Exception("Error en la respuesta de la API");
        }
    }
}
