package com.example.libroed.capituloSiete.ejemplos.ej7_3;

public class TestABB {
    public static void main(String[] args) {
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();

        // Inserciones paso a paso segun el enunciado
        int[] claves = {50, 30, 10, 80, 90, 40, 20};
        for (int c : claves) {
            abb.insertar(c);
        }

        System.out.println("Inorden:   " + ArbolBinarioBusqueda.join(abb.inorden()));
        System.out.println("Preorden:  " + ArbolBinarioBusqueda.join(abb.preorden()));
        System.out.println("Postorden: " + ArbolBinarioBusqueda.join(abb.postorden()));

        // Mostrar factores de balance informativos (AVL)
        abb.imprimirFactoresBalance();

        // Ejemplo de borrado (opcional): borrar 50 (raiz) usando predecesor
        // abb.borrar(50);
        // System.out.println("Inorden tras borrar 50: " + ArbolBinarioBusqueda.join(abb.inorden()));
    }
}
