package com.example;

public class Main {
    public static void main(String[] args) {
        int tamañoPoblacion = 100;
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
        Individuo otro = poblacion.individuos.get((int) (Math.random() * tamañoPoblacion));
        Cruzamiento cruzamiento = new Cruzamiento(mejor, otro);
        Individuo[] hijos = cruzamiento.cruzar();
        System.out.println("Hijo 1: " + hijos[0]);
        System.out.println("Hijo 2: " + hijos[1]);
    }
}