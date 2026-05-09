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
            if (i % 3 ==0) {
                individuos.add(new Individuo(dimensiones, -100,-40));
            }
            else if (i % 4 == 1){
                individuos.add(new Individuo(dimensiones, 40,100));
            }
            else {
                individuos.add(new Individuo(dimensiones, -100, 100));
            }
        }

    }

}
