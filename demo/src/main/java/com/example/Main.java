package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int tamañoPoblacion = 100;
        int dimensiones = 10;

        // 1. Crear y evaluar la población inicial
        Poblacion poblacion = new Poblacion(tamañoPoblacion, dimensiones);
        poblacion.evaluarPoblacion();

        // 2. IMPRIMIR LOS 100 INDIVIDUOS DE LA POBLACIÓN
        System.out.println("=== LISTA DE LOS 100 INDIVIDUOS INICIALES ===");
        for (int i = 0; i < tamañoPoblacion; i++) {
            System.out.println("Individuo " + i + ": " + poblacion.individuos.get(i));
        }

        // 3. SELECCIÓN POR RESTO
        System.out.println("\nEjecutando Selección por Resto Esperado para filtrar a los mejores...");
        List<Individuo> seleccionados = Seleccion.seleccionPorResto(poblacion);

        // 4. GENERAR 50 HIJOS NUEVOS (25 parejas × 2 hijos)
        System.out.println("\n=== CRUZAMIENTO MULTIPUNTO (50 hijos nuevos) ===");
        List<Individuo> nuevaGeneracion = new ArrayList<>();

        for (int i = 0; i < 50; i += 2) {
            Individuo padre1 = seleccionados.get(i);
            Individuo padre2 = seleccionados.get(i + 1);

            Cruzamiento cruzamiento = new Cruzamiento(padre1, padre2);
            Individuo[] hijos = cruzamiento.cruzar();

            nuevaGeneracion.add(hijos[0]);
            nuevaGeneracion.add(hijos[1]);

            System.out.println("Pareja " + (i/2 + 1) + ":");
            System.out.println("  Padre 1: " + padre1);
            System.out.println("  Padre 2: " + padre2);
            System.out.println("  Hijo 1:  " + hijos[0]);
            System.out.println("  Hijo 2:  " + hijos[1]);
        }

        // 5. IMPRIMIR RESUMEN
        System.out.println("\n=== NUEVA GENERACIÓN (" + nuevaGeneracion.size() + " individuos) ===");
        for (int i = 0; i < nuevaGeneracion.size(); i++) {
            System.out.println("Individuo " + i + ": " + nuevaGeneracion.get(i));
        }
    }
}