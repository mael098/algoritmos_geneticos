package com.example;

public class Cruzamiento {
    Individuo apto2;Individuo apto1;

    public Cruzamiento(Individuo apto1, Individuo apto2) {
        this.apto1 = apto1;
        this.apto2 = apto2;
    }

    public Individuo cruzar() {

        int dimensiones  = apto1.genes.length;
        Individuo hijo = new Individuo(dimensiones, 0, 1);
        for (int i = 0; i < dimensiones; i++) {
            // Elegir aleatoriamente el gen del padre 1 o del padre 2
            if (Math.random() > 0.5) {
                hijo.genes[i] = apto1.genes[i];
            } else {
                hijo.genes[i] = apto2.genes[i];
            }

        }
        return hijo;
    }







}
