package com.example;

public class Individuo {
    double[] genes;
    double fitness;

    public  Individuo(int dimensions, double  min, double  max) {
        genes = new double[dimensions];
        for (int i = 0; i < dimensions; i++) {
            genes[i] = min + (Math.random() * (max - min));
        }

        for (int i = 0; i < dimensions; i++) {
            fitness += genes[i] * genes[i];
        }
    }

}
