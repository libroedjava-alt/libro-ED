package com.example.libroed.capituloUno.ej1_2;

import java.util.Arrays;

/**
 * Ejemplo 1.2: Borrar un elemento j de la lista P.
 */
public class ListaEnterosEj1_2 {
    private final int[] P;
    private int L;

    public ListaEnterosEj1_2(int[] elementos) {
        this.P = elementos == null ? new int[0] : Arrays.copyOf(elementos, elementos.length);
        this.L = this.P.length;
    }

    public void borrarelemento(int j) {
        int i = 0;
        if (L == 0) {
            System.out.println("Error, lista vacía");
        } else if ((j >= 0) && (j < L)) {
            for (i = j; i < L - 1; i++) {
                P[i] = P[i + 1];
            }
            P[L - 1] = 0;
            L--;
        } else {
            System.out.println("Elemento no Existe ");
        }
    }

    public int longitud() { return L; }
    public int[] elementos() { return Arrays.copyOf(P, P.length); }
}
