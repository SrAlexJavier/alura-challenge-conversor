package com.aluracursos.challengeconversor;

import com.aluracursos.challengeconversor.menu.ConsolePrinter;
import com.aluracursos.challengeconversor.model.CurrencyPair;
import com.aluracursos.challengeconversor.utils.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<CurrencyPair> pairs = Config.getCurrencyPairs();
        ConsolePrinter console = new ConsolePrinter();

        while(true) {
            console.printOptions(pairs);
            System.out.println("Seleccione una opción (0 para salir)");
            int opcion = entrada.nextInt();

            if (opcion == 0) {
                System.out.println("Saliendo del programa ");
                break;
            }
        }
    }
}
