package com.example.libroed.capituloUno.ej1_1;

/**
 * Demo Ejemplo 1.1: Consultar el elemento j-ésimo de una lista P.
 */
public class TestListaEnterosEj1_1 {
    public static void main(String[] args) {
        int[] datos = {10, 20, 30};
        ListaEnterosEj1_1 lista = new ListaEnterosEj1_1(datos);
        System.out.println("-- Demo Ejemplo 1.1 --");
        lista.consultarelemento(1); // esperado: valor = 20
        lista.consultarelemento(5); // esperado: solicitado no existe en la Lista
        ListaEnterosEj1_1 vacia = new ListaEnterosEj1_1(new int[]{});
        vacia.consultarelemento(0); // esperado: Error, lista vacía
    }
}
