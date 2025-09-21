package com.example.libroed.capituloDos.ejemplos.ej2_2;

import java.io.*;
import java.lang.*; // librería para equals para comparar cadenas

// inicio de la clase ListaTemperaturas
public class ListaTemperaturas {
    NodoT cab;   // puntero que permite referenciar el inicio de la lista
    NodoT movil; // puntero que permite moverse a través de toda la lista

    public ListaTemperaturas() { } // método constructor

    public void iniciar_lista() {
        cab = null;
    }

    public void insertar_NodoT_inicio() throws IOException {
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        NodoT nuevo = new NodoT(); // creando Nodo y abriendo espacio de memoria
        System.out.println("Digite la ciudad: ");
        // asignando valor al campo ciudad en el Nodo
        nuevo.ciudad = (Teclado.readLine());
        System.out.println("Digite el mes: ");
        // asignando valor al campo mes en el Nodo
        nuevo.mes = (Teclado.readLine());
        System.out.println("Digite la temperatura: ");
        // asignando valor al campo temperatura en el Nodo
        nuevo.temp = Integer.parseInt(Teclado.readLine());
        // redireccionando Nodos y punteros
        nuevo.sig = cab;
        cab = nuevo;
    }

    public void borrar_NodoT_informacion() throws IOException {
        String c = new String("");
        String m = new String("");
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        NodoT borra;
        if (cab == null) { // la lista está vacía
            System.out.println("No hay elementos en la Lista");
            return; // retorne al main
        }
        System.out.println("Digite la ciudad: ");
        c = (Teclado.readLine());
        System.out.println("Digite el mes: ");
        m = (Teclado.readLine());
        movil = cab; // posicionarse en el primer Nodo de la lista
        if ((c.equals(movil.ciudad)) && (m.equals(movil.mes))) { // si es el primer Nodo que se va a borrar
            cab = movil.sig;
            borra = movil;
            borra = null; // borrar Nodo
        } else { // si NO es el primer Nodo que se va a borrar
            borra = movil.sig;
            while (movil != null) {
                if ((c.equals(movil.ciudad)) && (m.equals(movil.mes))) {
                    movil.sig = borra.sig;
                    borra = null; // borrar Nodo
                    break; // salir del ciclo while
                }
                movil = movil.sig; // pasando al siguiente Nodo de la lista
                borra = borra.sig;
            }
        }
    }

    public void imprimir_lista() {
        movil = cab; // posicionarse en el primer Nodo de la lista
        while (movil != null) { // mientras no sea fin de la lista
            System.out.println(movil.ciudad + ", " + movil.mes + ", " + movil.temp);
            movil = movil.sig; // pasando al siguiente Nodo de la lista
        }
    }

    public void imprimir_promedio_medio() throws IOException {
        int promedio = 0, ct = 0;
        String c = new String("");
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite la ciudad: ");
        c = (Teclado.readLine());
        movil = cab; // posicionarse en el primer Nodo de la lista
        while (movil != null) { // mientras no sea fin de la lista
            if (c.equals(movil.ciudad)) {
                System.out.println(movil.ciudad + ", " + movil.mes + ", " + movil.temp);
                promedio = promedio + movil.temp;
                ct++;
            }
            movil = movil.sig; // pasa al siguiente Nodo de la lista
        }
        System.out.println("Promedio de temperaturas es =" + (ct == 0 ? 0 : (promedio / ct)));
    }

    public void destruir_lista() {
        NodoT borra;
        borra = cab; // posicionarse en el primer Nodo de la lista
        movil = cab; // posicionarse en el primer Nodo de la lista
        while (movil != null) { // mientras no sea fin de la lista
            movil = movil.sig; // pasando al siguiente Nodo de la lista
            borra = null; // borrar Nodo
            borra = movil;
        }
    }
} // fin de la clase ListaTemperaturas
