package com.example.libroed.capituloOcho.ejemplos.ej8_1;

// Nodo de lista de arcos (adyacencias)
class NodoArco {
    int peso;         // peso/distancia
    NodoVert destino; // referencia al vértice destino
    NodoArco sig;     // siguiente arco en la lista

    NodoArco(int peso, NodoVert destino) {
        this.peso = peso;
        this.destino = destino;
    }
}
