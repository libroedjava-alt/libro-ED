package com.example.libroed.capituloUno.ejemplos.ej1_5;

/**
 * Ejemplo 1.5: Programa que ejemplifica la utilización de referencias (punteros) en Java.
 */
public class TestPuntero {
    public static void main(String[] args) {
        Nodo p, q; // referencias a un elemento
        // asignar memoria para un elemento
        q = new Nodo(); // creación de espacio de memoria o nodo con dos campos: dato y sig
        // este elemento no tiene un sucesor al inicio
        p = null;
        q.sig = null;
        // operaciones cualesquiera
        q.dato = 100; // asignado al primer campo es decir dato = 100
        p = q; // puntero p referencia al nodo q
        System.out.println("Valor de q utilizando la referencia p: " + p.dato);
        p.dato = 200; // asignando un nuevo valor a q utilizando la referencia p
        System.out.println("Nuevo valor de q utilizando la referencia p: " + p.dato);
        System.out.println("Valor de q: " + q.dato);
        // permitir que se libere la memoria ocupada por elemento p y q
        p = null;
        q = null;
    }
}

