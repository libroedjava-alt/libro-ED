package com.example.libroed.capituloDos.ejemplos.ej2_1;

import java.io.*;

// inicio de la clase ListaSencillaEncadenada
public class ListaSencillaEncadenada {

    Nodo cab;   // puntero que permite referenciar el inicio de la lista
    Nodo movil; // puntero que permite moverse a través de toda la lista

    public ListaSencillaEncadenada() { } // método constructor

    public void iniciar_lista() {
        cab = null;
    }

    public void consultar_informacion() throws IOException {
        int ban = 0, num; // ban = 0 significa que no se ha encontrado la información
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite el numero: ");
        num = Integer.parseInt(Teclado.readLine());
        movil = cab; // posicionarse en el primer nodo de la lista
        while ((movil != null) && (ban == 0)) // realice mientras móvil no ha llegado al final de la lista y no haya encontrado la información
        {
            if (movil.dato == num) {
                System.out.println(" La información si se encuentra");
                ban = 1; // cambia estado de ban a encontrado
            }
            movil = movil.sig; // pasar al siguiente nodo
        }
        if (ban == 0)
            System.out.println("NO se encuentra la información");
    }

    public void consultar_nodo() throws IOException {
        int ban = 0, cn = 0, pos; // ban = 0 indica que no se ha encontrado el nodo
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite la posición: ");
        pos = Integer.parseInt(Teclado.readLine());
        movil = cab; // posicionarse en el primer nodo de la lista
        while ((movil != null) && (ban == 0)) // realice mientras móvil no ha llegado al final de la lista y no haya encontrado el nodo
        {
            cn++;
            if (cn == pos) // comparando
            {
                System.out.println(" La información del Nodo es: " + movil.dato);
                ban = 1; // cambia estado de ban a encontrado
            }
            movil = movil.sig; // pasar al siguiente nodo
        }
        if (ban == 0)
            System.out.println("NO se encuentra el Nodo");
    }

    public void insertar_nodo_inicio() throws IOException {
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        Nodo nuevo = new Nodo(); // crea nodo y abre espacio de memoria
        System.out.println("Digite el numero: ");
        // asignando valor al campo dato en el nodo
        nuevo.dato = Integer.parseInt(Teclado.readLine());
        // redireccionando nodos y punteros
        nuevo.sig = cab;
        cab = nuevo;
    }

    public void insertar_nodo_posicion() throws IOException {
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        int pos, cn, ban;
        Nodo aux; // puntero auxiliar
        cn = 1; // contador de nodos
        ban = 0;
        if (cab != null) { // la lista no esta vacía
            System.out.println("Digite la posición: ");
            pos = Integer.parseInt(Teclado.readLine());
            Nodo nuevo = new Nodo();
            System.out.println("Digite el numero: ");
            // asignando valor al campo dato en el nodo
            nuevo.dato = Integer.parseInt(Teclado.readLine());
            if (pos == 1) { // si el nodo se va insertar en la primera posición de la lista
                // redireccionando nodos y punteros
                nuevo.sig = cab;
                cab = nuevo;
            } else // si el nodo se va insertar después de la primera posición de la lista
            {
                movil = cab; // posicionarse en el primer nodo de la lista
                while ((movil != null) && (ban == 0)) // realice mientras móvil no ha llegado al final de la lista y no haya encontrado el nodo
                {
                    if (cn == pos - 1) {
                        ban = 1;
                        break; // salir del ciclo while
                    }
                    cn++;
                    movil = movil.sig; // pasar al siguiente nodo
                }
                if (ban == 0)
                    System.out.println("no es una posición valida");
                else { // redireccionando nodos y punteros
                    aux = movil.sig;
                    movil.sig = nuevo;
                    nuevo.sig = aux;
                }
            }
        } else
            System.out.println("NO hay elementos en la Lista");
    }

    public void borrar_nodo_posicion() throws IOException {
        int cn, pos;
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        cn = 1;
        Nodo borra; // puntero para borrar el nodo
        if (cab == null) { // la lista esta vacía
            System.out.println("NO hay elementos en la Lista");
            return;
        }
        System.out.println("Digite la posición: ");
        pos = Integer.parseInt(Teclado.readLine());
        movil = cab; // posicionarse en el primer nodo de la lista
        if ((movil != null) && (pos == 1)) { // si la lista no está vacía y posición del nodo igual a 1
            borra = cab;
            cab = movil.sig;
            borra = null; // borrar nodo
        } else // si el nodo que va a borrar es diferente de la posición 1
            while (movil != null) // repita hasta que sea final de la lista
            {
                if (cn + 1 == pos) { // redireccionando nodos y punteros
                    borra = movil.sig;
                    if (borra == null) break; // posición fuera de rango
                    movil.sig = borra.sig;
                    borra = null; // borrar nodo
                    break; // salir del ciclo while
                }
                movil = movil.sig; // moverse al siguiente nodo
                cn++;
            }
    }

    public void borrar_nodo_inicio() {
        Nodo borra;
        movil = cab; // posicionarse en el primer nodo de la lista
        if (cab == null) { // la lista esta vacía
            System.out.println("NO hay elementos en la Lista");
            return; // retorne al main
        }
        if (movil != null) { // la lista NO esta vacía
            borra = cab;
            cab = movil.sig;
            borra = null; // borrar nodo
        }
    }

    public void borrar_nodo_informacion() throws IOException {
        int elemento;
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        Nodo borra;
        if (cab == null) { // la lista esta vacía
            System.out.println("NO hay elementos en la Lista");
            return; // retorne al main
        }
        System.out.println("Digite elemento(numero): ");
        elemento = Integer.parseInt(Teclado.readLine());
        movil = cab; // posicionarse en el primer nodo de la lista
        if (movil.dato == elemento) { // si es el primer nodo que se va a borrar
            cab = movil.sig;
            borra = movil;
            borra = null; // borrar nodo
        } else { // si NO es el primer nodo que se va a borrar
            borra = movil.sig;
            while (movil != null && borra != null) {
                if (borra.dato == elemento) {
                    movil.sig = borra.sig;
                    borra = null; // borrar nodo
                    break; // salir del ciclo while
                }
                movil = movil.sig; // pasando al siguiente nodo de la lista
                borra = borra.sig;
            }
        }
    }

    public void imprimir_lista() {
        movil = cab; // posicionarse en el primer nodo de la lista
        while (movil != null) { // mientras no sea fin de la lista
            System.out.println(movil.dato + " ");
            movil = movil.sig; // pasando al siguiente nodo de la lista
        }
    }

    public void destruir_lista() {
        Nodo borra;
        borra = cab; // posicionarse en el primer nodo de la lista
        movil = cab; // posicionarse en el primer nodo de la lista
        while (movil != null) { // mientras no sea fin de la lista
            movil = movil.sig; // pasando al siguiente nodo de la lista
            borra = null; // borrar nodo
            borra = movil;
        }
    }
}
// fin de la clase ListaSencillamenteEncadenada

