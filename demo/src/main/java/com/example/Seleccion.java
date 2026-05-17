package com.example;

import java.util.ArrayList;
import java.util.List;

public class Seleccion {

    public static List<Individuo> seleccionPorResto(Poblacion poblacionActual) {
        List<Individuo> viejos = poblacionActual.individuos;
        int N = poblacionActual.tamañoPoblacion;
        List<Individuo> nuevaLista = new ArrayList<>();

        // 1. Calcular Aptitud Total y Promedio
        double aptitudTotal = 0;
        for (Individuo ind : viejos) {
            aptitudTotal += ind.fitness[0];
        }

        if (aptitudTotal == 0) {
            for (Individuo ind : viejos) nuevaLista.add(clonarIndividuo(ind));
            return nuevaLista;
        }

        double aptitudPromedio = aptitudTotal / N;

        // 2. Calcular valor esperado, parte entera y resto (como diapositiva 6)
        int[] listaEntera = new int[N];
        double[] listaDecimal = new double[N];
        double sumaRestos = 0;

        System.out.println("\n=== TABLA SELECCIÓN POR RESTO ===");
        System.out.printf("%-12s %-12s %-12s %-12s %-12s%n",
                "Individuo", "Fitness", "e(i)=f/f̄", "Entera", "Resto");

        for (int i = 0; i < N; i++) {
            double valorEsperado = viejos.get(i).fitness[0] / aptitudPromedio;
            listaEntera[i] = (int) Math.floor(valorEsperado);
            listaDecimal[i] = valorEsperado - listaEntera[i];
            sumaRestos += listaDecimal[i];

            System.out.printf("%-12d %-12d %-12.4f %-12d %-12.4f%n",
                    i, viejos.get(i).fitness[0], valorEsperado,
                    listaEntera[i], listaDecimal[i]);
        }

        // 3. Fase entera: copias garantizadas
        System.out.println("\n=== FASE ENTERA (copias garantizadas) ===");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < listaEntera[i]; j++) {
                if (nuevaLista.size() < N) {
                    nuevaLista.add(clonarIndividuo(viejos.get(i)));
                    System.out.println("Copia garantizada → Individuo " + i
                            + " Fitness: " + viejos.get(i).fitness[0]);
                }
            }
        }

        // 4. Fase decimal: ruleta con restos para slots sobrantes
        int slotsRestantes = N - nuevaLista.size();
        System.out.println("\n=== FASE DECIMAL (" + slotsRestantes + " slots por ruleta) ===");
        while (nuevaLista.size() < N) {
            double giro = Math.random() * sumaRestos;
            double acumulado = 0;
            for (int i = 0; i < N; i++) {
                acumulado += listaDecimal[i];
                if (acumulado >= giro) {
                    nuevaLista.add(clonarIndividuo(viejos.get(i)));
                    System.out.println("Slot por resto → Individuo " + i
                            + " Fitness: " + viejos.get(i).fitness[0]);
                    break;
                }
            }
        }

        // 5. Ordenar por fitness descendente (los mejores primero)
        nuevaLista.sort((a, b) -> b.fitness[0] - a.fitness[0]);

        return nuevaLista;
    }

    private static Individuo clonarIndividuo(Individuo original) {
        Individuo clon = new Individuo(original.genes.length);
        System.arraycopy(original.genes, 0, clon.genes, 0, original.genes.length);
        clon.fitness = new int[1];
        clon.fitness[0] = original.fitness[0];
        return clon;
    }
}