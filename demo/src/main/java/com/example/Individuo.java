package com.example;

import java.util.List;

public class Individuo {
    int[] genes;
    int[] fitness;

    public  Individuo(int dimensions, double  min, double  max) {
        genes = new int[dimensions];
        for (int i = 0; i < dimensions; i++) {
            genes[i] = (Math.random() > 0.5) ? 1:0;
        }

    }

    public void evaluar(List<Individuo> poblacion) {
        // Ejemplo de función de fitness: contar el número de genes en 1
        int count = 0;
        for (int gene : genes) {
            if (gene == 1) {
                count++;
            }
        }
        fitness = new int[]{count};
    }

}
