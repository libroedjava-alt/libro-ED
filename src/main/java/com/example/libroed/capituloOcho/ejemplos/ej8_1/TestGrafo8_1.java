package com.example.libroed.capituloOcho.ejemplos.ej8_1;

public class TestGrafo8_1 {
    public static void main(String[] args) {
        String[] nombres = {"SAN SIMON", "OLAYA", "VENECIA", "ARQUIMIDEZ"};
        // Matriz de distancias tal como aparece en el enunciado (0 = sin arco)
        int[][] M = {
            {0,   300, 200, 0},
            {120,   0, 600, 400},
            {0,    45,   0, 1000},
            {330, 710, 460,   0}
        };

        Grafo g = new Grafo();
        g.construirDesdeMatriz(nombres, M);

        System.out.println("Lista de Adyacencia:");
        g.imprimirListaAdyacencia();
        System.out.println();

        System.out.println("Representación Enlazada:");
        g.imprimirRepresentacionEnlazada();
        System.out.println();

        System.out.println("Caminos mínimos (Dijkstra) desde cada vértice:");
        g.imprimirCaminosMinimos();

        System.out.println("Número de aristas: " + g.contarAristas());
    }
}
