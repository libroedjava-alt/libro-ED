package com.example.libroed.capituloUno.ejemplos.ej1_6;

/**
 * Ejemplo 1.6: Programa para realizar prueba de escritorio con referencias.
 */
public class PruebaPuntero {
    public static void main(String[] args) {
        Nodo a, b, c, d, e, p, q, r;

        // reservar memoria para nodos a..e
        a = new Nodo();
        b = new Nodo();
        c = new Nodo();
        d = new Nodo();
        e = new Nodo();

        // punteros iniciales
        p = null;
        q = null;
        r = null;

        // todos los nodos apuntan a null inicialmente
        a.sig = null;
        b.sig = null;
        c.sig = null;
        d.sig = null;
        e.sig = null;

        // asignación de datos
        a.dato = 100;
        b.dato = 12;
        c.dato = 5;
        d.dato = 600;
        e.dato = 1;

        // punteros referenciando
        p = e;
        q = b;
        r = c;

        a.dato = b.dato = d.dato;

        p = q = r;

        q.dato = 500;

        r = a;

        a.dato = p.dato++;

        r = p;

        q.dato = --c.dato;

        b.dato = 23;

        r.dato = 700 + c.dato;

        // imprimir valores
        System.out.println("Valor de a.dato: " + a.dato);
        System.out.println("Valor de b.dato: " + b.dato);
        System.out.println("Valor de c.dato: " + c.dato);
        System.out.println("Valor de d.dato: " + d.dato);
        System.out.println("Valor de e.dato: " + e.dato);
        System.out.println("Valor de p.dato: " + p.dato);
        System.out.println("Valor de q.dato: " + q.dato);
        System.out.println("Valor de r.dato: " + r.dato);

        System.out.println(" ");
        System.out.println("Direcciones Hexadecimales de los Nodos ");
        System.out.println("Valor de a: " + a);
        System.out.println("Valor de b: " + b);
        System.out.println("Valor de c: " + c);
        System.out.println("Valor de d: " + d);
        System.out.println("Valor de e: " + e);

        System.out.println(" ");
        System.out.println("Direcciones Hexadecimales Almacenadas por los Punteros");
        System.out.println("Valor de p: " + p);
        System.out.println("Valor de q: " + q);
        System.out.println("Valor de r: " + r);

        // liberar referencias
        a = null; b = null; c = null; d = null; e = null; p = null; q = null; r = null;
    }
}
