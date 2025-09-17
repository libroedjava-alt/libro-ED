package com.example.libroed.capituloUno.ejemplos.ej1_4;

/**
 * Ejemplo 1.4: Programa que ejemplifica operaciones de una lista contigua.
 */
public class ListaContigua {
    public int[] P = {3, 5, 8, 23, 45, 89, 12, 78, 5, 1};
    public int L; // Longitud de la lista
    public int c; // cantidad de elementos que se pueden guardar en el vector

    public ListaContigua() {
        c = 10;
        L = 10;
    }

    public void consultarelemento(int j) {
        int B;
        if (L == 0) { // L es la longitud de la lista que está declarada como atributo de la clase
            System.out.println("Error, lista vacía");
        } else if ((j >= 0) && (j < L)) {
            B = P[j];
            System.out.println("valor = " + B);
        } else {
            System.out.println("solicitado no existe en la Lista");
        }
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

    public void insertarelemento(int j, int e) {
        int i = 0;
        if (L >= c) {
            System.out.println("Error, NO se puede insertar el elemento, borre un elemento para insertar el nuevo");
        } else if ((j >= 0) && (j < L)) {
            for (i = L - 1; i >= j; i--) {
                P[i + 1] = P[i];
            }
            P[j] = e;
            L++;
        } else {
            System.out.println("Elemento no Existe ");
        }
    }

    public void imprimirlista() {
        for (int i = 0; i < L; i++) {
            System.out.println("Elemento: " + i + ": " + P[i]);
        }
    }
}
