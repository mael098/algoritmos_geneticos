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

        System.out.println("Cruzamiento entre el mejor individuo y otro individuo aleatorio:");
        Individuo otro = poblacion.individuos.get((int)(Math.random() * tamañoPoblacion));
        System.out.println("Otro individuo:");
        System.out.println(otro);

    }
}