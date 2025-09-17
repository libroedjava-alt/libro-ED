package com.example.libroed.capituloUno.ejemplos.ej1_3;

import java.util.Arrays;

/**
 * Ejemplo 1.3: Insertar un elemento en la posición j de la lista P.
 * Clase separada por ejemplo.
 */
public class ListaEnterosEj1_3 {
    /** Arreglo que contiene los elementos de la lista (capacidad fija c). */
    private final int[] P;
    /** Longitud de la lista (número de elementos usados). */
    private int L;
    /** Capacidad máxima del arreglo. */
    private final int c;

    /**
     * Crea una lista con capacidad c y carga inicial.
     * Si elementos es null, se toma lista vacía. Si c es menor que elementos.length, se ajusta a elementos.length.
     *
     * @param elementos carga inicial (puede ser null)
     * @param capacidad capacidad máxima (c)
     */
    public ListaEnterosEj1_3(int[] elementos, int capacidad) {
        int usados = (elementos == null) ? 0 : elementos.length;
        this.c = Math.max(capacidad, usados);
        this.P = new int[this.c];
        if (usados > 0) {
            System.arraycopy(elementos, 0, this.P, 0, usados);
        }
        this.L = usados;
    }

    /**
     * Inserta el elemento e en la posición j, desplazando a la derecha y actualizando L, según la lógica del enunciado.
     * Imprime mensajes en consola conforme al algoritmo original (índices base 0).
     * @param j posición donde insertar (0 <= j < L)
     * @param e elemento a insertar
     */
    public void insertarelemento(int j, int e) {
        int i = 0;
        if (L >= c) { // lista llena
            System.out.println("Error, NO se puede insertar el elemento, borre un elemento para insertar el nuevo");
        } else if ((j >= 0) && (j < L)) { // recuerde que los vectores comienzan en la posición 0
            for (i = L - 1; i >= j; i--) {
                P[i + 1] = P[i];
            }
            P[j] = e;
            L++;
        } else {
            System.out.println("Elemento no Existe ");
        }
    }

    // Accesores útiles
    public int longitud() { return L; }
    public int capacidad() { return c; }
    public int[] elementos() { return Arrays.copyOf(P, P.length); }
}
