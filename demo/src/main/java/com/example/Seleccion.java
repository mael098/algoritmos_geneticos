package com.example;

import java.util.ArrayList;
import java.util.List;

public class Seleccion {

    public static List<Individuo> seleccionPorResto(Poblacion poblacionActual) {
        List<Individuo> viejos = poblacionActual.individuos;
        int N = poblacionActual.tamañoPoblacion;
        List<Individuo> nuevaLista = new ArrayList<>();

        // 1. Calcular la Aptitud Total y Promedio
        double aptitudTotal = 0;
        for (Individuo ind : viejos) {
            aptitudTotal += ind.fitness[0]; // Usamos tu array de fitness
        }

        if (aptitudTotal == 0) {
            // Evitar división por cero si la población es totalmente nula
            for (Individuo ind : viejos) nuevaLista.add(clonarIndividuo(ind));
            return nuevaLista;
        }

        double aptitudPromedio = aptitudTotal / N;

        // 2. Generar las DOS LISTAS que necesitas: Entera y Decimal (Restos)
        int[] listaEntera = new int[N];
        double[] listaDecimal = new double[N];
        double sumaRestosDecimales = 0;

        for (int i = 0; i < N; i++) {
            double valorEsperado = viejos.get(i).fitness[0] / aptitudPromedio;

            listaEntera[i] = (int) Math.floor(valorEsperado);
            listaDecimal[i] = valorEsperado - listaEntera[i];
            sumaRestosDecimales += listaDecimal[i];
        }

        // 3. FASE ENTERA: Añadir copias fijas de forma determinista
        for (int i = 0; i < N; i++) {
            int copiasFijas = listaEntera[i];
            for (int j = 0; j < copiasFijas; j++) {
                if (nuevaLista.size() < N) {
                    nuevaLista.add(clonarIndividuo(viejos.get(i)));
                }
            }
        }

        // 4. FASE DECIMAL: Girar la ruleta con los residuos para llenar los huecos libres
        while (nuevaLista.size() < N) {
            double giroRuleta = Math.random() * sumaRestosDecimales;
            double acumulado = 0;

            for (int i = 0; i < N; i++) {
                acumulado += listaDecimal[i];
                if (acumulado >= giroRuleta) {
                    nuevaLista.add(clonarIndividuo(viejos.get(i)));
                    break;
                }
            }
        }

        return nuevaLista;
    }

    // Método de clonación profunda para que los hijos no compartan memoria con los padres
    private static Individuo clonarIndividuo(Individuo original) {
        Individuo clon = new Individuo(original.genes.length);
        System.arraycopy(original.genes, 0, clon.genes, 0, original.genes.length);
        clon.fitness = new int[1];
        clon.fitness[0] = original.fitness[0];
        return clon;
    }
}
