# Algoritmo Genético — Selección por Resto

Proyecto de la materia **Inteligencia Artificial** que implementa un algoritmo genético con el método de **Selección por Resto (Remainder Stochastic Sampling)** en Java con Maven.

## Equipo

- Mercado Gutiérrez Pedro Antonio (No. de Control: 22820315)
- Villegas Espinosa Ivan Asdrubal (No. de Control: 22820415)
- Tea Martínez Angeles Meyli (

---

## Descripción

Un **algoritmo genético** es una técnica de búsqueda y optimización inspirada en la evolución natural. Opera sobre una población de soluciones candidatas (individuos), aplicando operadores de selección, cruzamiento y mutación para generar nuevas generaciones de mejores soluciones.

Este proyecto implementa el flujo completo:

1. Generar una población inicial de 100 individuos aleatorios
2. Evaluar el fitness de cada individuo
3. Aplicar selección por resto para filtrar los mejores
4. Cruzamiento multipunto para generar 50 nuevos hijos
5. Obtener una nueva generación de mejor calidad

---

## Método de Selección por Resto

El método de **Selección por Resto** divide el proceso en dos fases:

**Fase Entera (determinista)**
Cada individuo recibe copias garantizadas según su valor esperado mediante la formula:

## e(i) = f(i) / f̄. 

Donde `f(i)` es el fitness del individuo y `f̄` es el fitness promedio de la población. La parte entera de `e(i)` determina cuántas copias garantizadas recibe ese individuo.

**Fase Decimal (ruleta)**
Los lugares restantes se asignan aleatoriamente usando los restos decimales como probabilidad. Los individuos con mayor resto tienen más probabilidad de obtener una copia extra.

## Clases

### `Individuo.java`
Representa una solución candidata como un arreglo de 0s y 1s. El fitness se calcula contando cuántos genes tienen valor 1.

### `Poblacion.java`
Crea y maneja una población de individuos. Incluye el método `evaluarPoblacion()` que calcula el fitness de todos los individuos y `getMejor()` que retorna el individuo con mayor fitness.

### `Seleccion.java`
Implementa la selección por resto en dos fases: entera (determinista) y decimal (ruleta). Retorna la lista de seleccionados ordenada por fitness descendente.

### `Cruzamiento.java`
Implementa cruzamiento multipunto. Selecciona dos puntos de corte aleatorios e intercambia el segmento entre ellos para generar dos hijos.

### `Main.java`
Orquesta el flujo completo: crea la población, evalúa, aplica selección por resto, realiza 25 cruces y genera 50 hijos nuevos.
