package com.aluracursos.challengeconversor.menu;

import com.aluracursos.challengeconversor.model.CurrencyPair;

import java.util.List;

public class ConsolePrinter {
    public void printOptions(List<CurrencyPair> pairs) {
        for (int i = 0; i < pairs.size(); i++) {
            CurrencyPair pair = pairs.get(i);
            System.out.printf("%d) %s =>> %s%n", i + 1, pair.base(), pair.target());
        }
    }
}
