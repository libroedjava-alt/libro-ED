package com.example.libroed;

import java.util.Arrays;

/**
 * Implementación del Ejemplo 1.1
 * Estructura de datos de lista basada en un arreglo de enteros.
 */
public class ListaEnteros {
    /** Arreglo que contiene los elementos de la lista. */
    private final int[] P;
    /** Longitud de la lista. */
    private final int L;

    /**
     * Crea una lista a partir de un arreglo. Si el arreglo es null, se toma como lista vacía.
     * @param elementos arreglo de enteros (puede ser null)
     */
    public ListaEnteros(int[] elementos) {
        this.P = elementos == null ? new int[0] : Arrays.copyOf(elementos, elementos.length);
        this.L = this.P.length;
    }

    /**
     * Consulta el elemento j-ésimo según la lógica del ejemplo.
     * Se imprimen mensajes en consola conforme al algoritmo original.
     * Importante: siguiendo el código proporcionado, el índice válido es 0 <= j < L.
     *
     * @param j índice solicitado
     */
    public void consultarelemento(int j) {
        int B;
        if (L == 0) { // L es la longitud de la lista que esta declarado como atributo de la clase
            System.out.println("Error, lista vacía");
        } else if ((j >= 0) && (j < L)) { // recuerde que los vectores comienzan en la posición 0
            B = P[j];
            System.out.println("valor = " + B);
        } else {
            System.out.println("solicitado no existe en la Lista");
        }
    }

    // Métodos de consulta útiles y seguros para potencial uso futuro
    public int longitud() { return L; }
    public int[] elementos() { return Arrays.copyOf(P, P.length); }
}
