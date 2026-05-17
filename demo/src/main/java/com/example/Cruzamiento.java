package com.example;

public class Cruzamiento {
    Individuo apto2;
    Individuo apto1;
    // cruzamiento multipunto

    public Cruzamiento(Individuo apto1, Individuo apto2) {
        this.apto1 = apto1;
        this.apto2 = apto2;
    }

    public Individuo[] cruzar() {
        // Crear dos hijos vacíos
        Individuo[] hijos = new Individuo[2];
        int longitudGenes = apto1.genes.length;

        // Con menos de 2 genes no es posible cruzamiento de dos puntos.
        if (longitudGenes < 2) {
            hijos[0] = new Individuo(longitudGenes);
            hijos[0].genes = apto1.genes.clone();
            hijos[0].evaluar();

            hijos[1] = new Individuo(longitudGenes);
            hijos[1].genes = apto2.genes.clone();
            hijos[1].evaluar();
            return hijos;
        }

        // Seleccionar dos puntos de corte aleatorios
        int puntoCorte1 = (int) (Math.random() * longitudGenes);
        int puntoCorte2 = (int) (Math.random() * longitudGenes);

        while (puntoCorte1 == puntoCorte2) {
            puntoCorte2 = (int) (Math.random() * longitudGenes);
        }

        // Asegurarse de que puntoCorte1 sea menor que puntoCorte2
        if (puntoCorte1 > puntoCorte2) {
            // Intercambiar los puntos de corte
            int temp = puntoCorte1;
            puntoCorte1 = puntoCorte2;
            puntoCorte2 = temp;
        }

        int[] hijo1Genes = new int[longitudGenes];
        int[] hijo2Genes = new int[longitudGenes];

        for (int i = 0; i < longitudGenes; i++) {
            if (i < puntoCorte1 || i > puntoCorte2) {
                hijo1Genes[i] = apto1.genes[i];
                hijo2Genes[i] = apto2.genes[i];
            } else {
                hijo1Genes[i] = apto2.genes[i];
                hijo2Genes[i] = apto1.genes[i];
            }
        }

        hijos[0] = new Individuo(hijo1Genes.length);
        hijos[0].genes = hijo1Genes;
        hijos[0].evaluar();

        hijos[1] = new Individuo(hijo2Genes.length);
        hijos[1].genes = hijo2Genes;
        hijos[1].evaluar();

        return hijos;
    }

}
