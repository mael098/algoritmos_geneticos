package com.example;

public class Individuo {
    int[] genes;
    int[] fitness;

    public  Individuo(int dimensions) {
        genes = new int[dimensions];
        for (int i = 0; i < dimensions; i++) {
            genes[i] = (Math.random() > 0.5) ? 1:0;
        }

    }

    public void evaluar() {
        // Ejemplo de función de fitness: contar el número de genes en 1
        int count = 0;
        // Contar el número de genes en 1
        for (int gene : genes) {
            // Si el gen es 1, incrementamos el contador
            if (gene == 1) count++;
        }
        // Asignar el valor de fitness al primer elemento del array
        this.fitness = new int[1];
        // El fitness es igual al número de genes en 1
        this.fitness[0] = count;
    }

    @Override
    public String toString(){
      return "Genes: " + java.util.Arrays.toString(genes) + " Fitness: " + fitness[0];
    }

}
