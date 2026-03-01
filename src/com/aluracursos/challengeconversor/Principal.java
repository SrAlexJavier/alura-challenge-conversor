package com.aluracursos.challengeconversor;

import com.aluracursos.challengeconversor.menu.ConsolePrinter;
import com.aluracursos.challengeconversor.model.CurrencyPair;
import com.aluracursos.challengeconversor.service.CurrencyConverter;
import com.aluracursos.challengeconversor.utils.Config;

import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<CurrencyPair> pairs = Config.getCurrencyPairs();
        ConsolePrinter console = new ConsolePrinter();
        CurrencyConverter converter = new CurrencyConverter();
        int lastOption = pairs.size() + 1;

        while(true) {
            console.printOptions(pairs);
            System.out.println(lastOption + ") Salir");
            System.out.println("Elija una opción valida:");
            System.out.println("**********************************************\n");
            int opcion = entrada.nextInt();

            if (opcion == lastOption) {
                System.out.println("Saliendo del programa ");
                break;
            }

            if (opcion >= 1 && opcion <= pairs.size()) {
                CurrencyPair selectedPair = pairs.get(opcion - 1);

                System.out.print("\nIngrese la cantidad a convertir: \n");
                double amount = entrada.nextDouble();

                try {
                    CurrencyConverter.ConversionData result = converter.convert(selectedPair, amount);
                    result.displayResult();
                } catch (Exception e) {
                    System.out.println("Error al realizar la conversión: " + e.getMessage());
                }
            } else {
                System.out.println("Opción inválida. Intente nuevamente.\n");
            }
        }

        entrada.close();
    }
}
