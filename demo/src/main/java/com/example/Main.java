package com.example;

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

        // 3. SELECCIÓN POR RESTO (Genera las listas entera y decimal internamente)
        System.out.println("\nEjecutando Selección por Resto Esperado para filtrar a los mejores...");
        List<Individuo> seleccionados = Seleccion.seleccionPorResto(poblacion);

        // 4. SELECCIONAR EXACTAMENTE 2 PADRES
        // Tomamos los dos primeros elementos de la lista filtrada por el método de resto
        Individuo padre1 = seleccionados.get(0);
        Individuo padre2 = seleccionados.get(1);

        System.out.println("\n=== PADRES SELECCIONADOS ===");
        System.out.println("Padre 1 seleccionado: " + padre1);
        System.out.println("Padre 2 seleccionado: " + padre2);

        // 5. CRUZAMIENTO Y OBTENCIÓN DE 2 HIJOS
        System.out.println("\n=== CRUZAMIENTO MULTIPUNTO ===");
        Cruzamiento cruzamiento = new Cruzamiento(padre1, padre2);
        Individuo[] hijos = cruzamiento.cruzar();

        // 6. IMPRIMIR LOS 2 HIJOS RESULTANTES
        System.out.println("Hijo 1 generado: " + hijos[0]);
        System.out.println("Hijo 2 generado: " + hijos[1]);
    }
}
