package com.example.libroed.capituloUno.ejemplos.ej1_1;

import java.util.Arrays;

/**
 * Ejemplo 1.1: Consultar el elemento j-ésimo de una lista P.
 * Clase separada por ejemplo.
 */
public class ListaEnterosEj1_1 {
    /** Arreglo que contiene los elementos de la lista. */
    private final int[] P;
    /** Longitud de la lista. */
    private final int L;

    /**
     * Crea una lista a partir de un arreglo. Si el arreglo es null, se toma como lista vacía.
     * @param elementos arreglo de enteros (puede ser null)
     */
    public ListaEnterosEj1_1(int[] elementos) {
        this.P = elementos == null ? new int[0] : Arrays.copyOf(elementos, elementos.length);
        this.L = this.P.length;
    }

    /**
     * Consulta el elemento j-ésimo según la lógica del ejemplo.
     * Se imprimen mensajes en consola conforme al algoritmo original (índices base 0).
     * @param j índice solicitado
     */
    public void consultarelemento(int j) {
        int B;
        if (L == 0) {
            System.out.println("Error, lista vacía");
        } else if ((j >= 0) && (j < L)) {
            B = P[j];
            System.out.println("valor = " + B);
        } else {
            System.out.println("solicitado no existe en la Lista");
        }
    }

    // Accesores útiles
    public int longitud() { return L; }
    public int[] elementos() { return Arrays.copyOf(P, P.length); }
}
