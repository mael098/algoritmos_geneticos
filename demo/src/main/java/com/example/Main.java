package com.example;

public class Main {
    public static void main(String[] args) {
        int tamañoPoblacion = 40;
        int dimensiones = 10;

        Poblacion poblacion = new Poblacion(tamañoPoblacion, dimensiones);
        poblacion.evaluarPoblacion();

        for (int i = 0; i < tamañoPoblacion; i++) {
            System.out.println("individuo"+i+":"+poblacion.individuos.get(i));
        }

        System.out.println("Mejor individuo:");
        Individuo mejor = poblacion.getMejor();
        System.out.println(mejor);

    }
}