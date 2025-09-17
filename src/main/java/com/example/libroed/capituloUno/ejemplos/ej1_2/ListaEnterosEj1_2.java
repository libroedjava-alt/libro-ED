package com.example.libroed.capituloUno.ejemplos.ej1_2;

import java.util.Arrays;

/**
 * Ejemplo 1.2: Borrar un elemento j de la lista P.
 * Clase separada por ejemplo.
 */
public class ListaEnterosEj1_2 {
    /** Arreglo que contiene los elementos de la lista. */
    private final int[] P;
    /** Longitud de la lista (mutable, ya que al borrar se decrementa). */
    private int L;

    /**
     * Crea una lista a partir de un arreglo. Si el arreglo es null, se toma como lista vacía.
     * @param elementos arreglo de enteros (puede ser null)
     */
    public ListaEnterosEj1_2(int[] elementos) {
        this.P = elementos == null ? new int[0] : Arrays.copyOf(elementos, elementos.length);
        this.L = this.P.length;
    }

    /**
     * Borra el elemento j-ésimo desplazando a la izquierda y ajustando L, según la lógica del enunciado.
     * Imprime mensajes en consola conforme al algoritmo original (índices base 0).
     * @param j posición del elemento a borrar (0 <= j < L)
     */
    public void borrarelemento(int j) {
        int i = 0;
        if (L == 0) { // L es la longitud de la lista que está declarado como atributo de la clase
            System.out.println("Error, lista vacía");
        } else if ((j >= 0) && (j < L)) { // recuerde que los vectores comienzan desde la posición 0
            for (i = j; i < L - 1; i++) {
                P[i] = P[i + 1];
            }
            P[L - 1] = 0;
            L--;
        } else {
            System.out.println("Elemento no Existe ");
        }
    }

    // Accesores útiles
    public int longitud() { return L; }
    public int[] elementos() { return Arrays.copyOf(P, P.length); }
}
