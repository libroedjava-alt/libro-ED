package com.example.libroed.capituloOcho.ejemplos.ej8_1;

// Nodo de lista de vértices (representación enlazada)
class NodoVert {
    String nombre;
    int idx;              // índice del vértice en la matriz
    NodoArco primero;     // inicio de lista de arcos (adyacencias)
    NodoVert sig;         // siguiente vértice en la lista

    NodoVert(String nombre, int idx) {
        this.nombre = nombre;
        this.idx = idx;
    }
}
