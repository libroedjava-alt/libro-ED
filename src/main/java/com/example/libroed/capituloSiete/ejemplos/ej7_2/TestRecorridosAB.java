package com.example.libroed.capituloSiete.ejemplos.ej7_2;

public class TestRecorridosAB {
    public static void main(String[] args) {
        ArbolBinario ab = new ArbolBinario();
        ab.construirEjemplo();

        // Preorden paso a paso
        ab.imprimirPreordenPasoAPaso();
        // Inorden paso a paso
        ab.imprimirInordenPasoAPaso();
        // Postorden paso a paso
        ab.imprimirPostordenPasoAPaso();
    }
}
