package com.example;

import java.util.ArrayList;
import java.util.List;

public class Poblacion {
    List<Individuo> individuos;
    int tamañoPoblacion;

    public Poblacion(int tamaño, int dimensiones) {
        this.tamañoPoblacion = tamaño;
        this.individuos = new ArrayList<>();

        for (int i = 0; i < tamañoPoblacion; i++) {
            // Crear un nuevo individuo con el número de dimensiones especificado
            individuos.add(new Individuo(dimensiones));
        }

    }

    public void evaluarPoblacion(){
        for (Individuo ind : individuos) {
            ind.evaluar();
        }
    }

    public Individuo getMejor() {
        Individuo mejor = individuos.get(0);
        for (Individuo ind: individuos){
            if (ind.fitness[0] > mejor.fitness[0]){
                mejor = ind;
            }
        }
        return mejor;
    }

}

