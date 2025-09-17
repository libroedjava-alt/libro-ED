package com.example.libroed.capituloUno.ejemplos.ej1_2;

/**
 * Demo Ejemplo 1.2: Borrar el elemento j de la lista P.
 */
public class TestListaEnterosEj1_2 {
    public static void main(String[] args) {
        System.out.println("-- Demo Ejemplo 1.2 --");
        ListaEnterosEj1_2 lista = new ListaEnterosEj1_2(new int[]{10, 20, 30, 40});
        // borrar en posición válida
        lista.borrarelemento(1); // esperado desplaza e imprime nada adicional
        // borrar fuera de rango
        lista.borrarelemento(10); // esperado: Elemento no Existe 
        // lista vacía
        ListaEnterosEj1_2 vacia = new ListaEnterosEj1_2(new int[]{});
        vacia.borrarelemento(0); // esperado: Error, lista vacía
    }
}
