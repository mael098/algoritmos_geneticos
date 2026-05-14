package com.example;

import java.util.ArrayList;
import java.util.List;

public class Poblacion {
    List<Individuo> individuos;
    int tamañoPoblacion;

    public Poblacion(int tamaño, int dimensiones) {
        this.tamañoPoblacion = tamaño;
        this.individuos = new ArrayList<>();
        // Crear individuos con diferentes rangos de genes

        for (int i = 0; i < tamañoPoblacion; i++) {
            // Alternar entre diferentes rangos de genes para crear diversidad
            if (i % 3 ==0) {
                individuos.add(new Individuo(dimensiones));
            }
            // Alternar entre diferentes rangos de genes para crear diversidad
            else if (i % 4 == 1){
                individuos.add(new Individuo(dimensiones));
            }
            // Alternar entre diferentes rangos de genes para crear diversidad
            else {
                individuos.add(new Individuo(dimensiones));
            }
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

