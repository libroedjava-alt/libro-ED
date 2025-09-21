package com.example.libroed.capituloSiete.ejemplos.ej7_1;

import java.util.ArrayList;
import java.util.List;

class ArbolBinario {
    NodoA raiz;

    // Construye el árbol del ejemplo:
    //      G
    //     / \
    //    F   D
    //       / \
    //      K   L
    public void construirEjemplo() {
        NodoA g = new NodoA("G");
        NodoA f = new NodoA("F");
        NodoA d = new NodoA("D");
        NodoA k = new NodoA("K");
        NodoA l = new NodoA("L");
        g.izq = f;
        g.der = d;
        d.izq = k;
        d.der = l;
        this.raiz = g;
    }

    // Utilidades para imprimir paso a paso
    private void imprimirPasoAPaso(String titulo, List<String> nodos, int total) {
        for (int i = 1; i <= nodos.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(titulo).append(": ");
            for (int j = 0; j < i; j++) {
                sb.append(nodos.get(j));
                if (j < i - 1) sb.append(", ");
            }
            // si es el último paso (todos los nodos), termina en punto; si no, en coma
            if (i == total) sb.append("."); else sb.append(",");
            System.out.println(sb.toString());
            System.out.println();
        }
    }

    public void imprimirPreordenPasoAPaso() {
        List<String> result = new ArrayList<>();
        preorden(this.raiz, result);
        imprimirPasoAPaso("Recorrido Preorden (raíz, subarbizq, subarbder)", result, result.size());
    }

    public void imprimirInordenPasoAPaso() {
        List<String> result = new ArrayList<>();
        inorden(this.raiz, result);
        imprimirPasoAPaso("Recorrido Inorden (subarbizq, raíz, subarbder)", result, result.size());
    }

    public void imprimirPostordenPasoAPaso() {
        List<String> result = new ArrayList<>();
        postorden(this.raiz, result);
        imprimirPasoAPaso("Recorrido Postorden (subarbizq, subarbder, raíz)", result, result.size());
    }

    // Recorridos clásicos
    private void preorden(NodoA x, List<String> acc) {
        if (x == null) return;
        acc.add(x.dato);
        preorden(x.izq, acc);
        preorden(x.der, acc);
    }

    private void inorden(NodoA x, List<String> acc) {
        if (x == null) return;
        inorden(x.izq, acc);
        acc.add(x.dato);
        inorden(x.der, acc);
    }

    private void postorden(NodoA x, List<String> acc) {
        if (x == null) return;
        postorden(x.izq, acc);
        postorden(x.der, acc);
        acc.add(x.dato);
    }
}
