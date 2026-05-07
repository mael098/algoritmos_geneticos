package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int tamañoPoblacion = 100;
        int dimensiones = 2;
        List<Individuo> poblacion = new java.util.ArrayList<>();

        for (int i = 0; i < tamañoPoblacion; i++) {
            poblacion.add(new Individuo(dimensiones, -10, 10));
        }

        for (int i = 0; i < tamañoPoblacion; i++) {
            Individuo ind = poblacion.get(i);
            System.out.println("Individuo " + i + ": Genes = " + java.util.Arrays.toString(ind.genes));
        }


    }
}