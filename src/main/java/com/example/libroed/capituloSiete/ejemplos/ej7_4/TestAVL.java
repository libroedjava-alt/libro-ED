package com.example.libroed.capituloSiete.ejemplos.ej7_4;

public class TestAVL {
    public static void main(String[] args) {
        ArbolAVLCheck arbol = new ArbolAVLCheck();
        arbol.construirEjemplo();

        System.out.println("Factores de balance (inorden):");
        arbol.imprimirFactoresInorden();

        System.out.println("\n¿Es AVL? " + (arbol.esAVL() ? "Sí" : "No"));
    }
}
