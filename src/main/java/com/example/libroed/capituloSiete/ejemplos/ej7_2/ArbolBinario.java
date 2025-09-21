package com.example.libroed.capituloSiete.ejemplos.ej7_2;

import java.util.ArrayList;
import java.util.List;

class ArbolBinario {
    NodoA raiz;

    // Construye el árbol del ejemplo 7_2:
    //          S
    //        /   \
    //       R     L
    //      /     / \
    //     T     M   O
    //      \         \
    //       P         N
    public void construirEjemplo() {
        NodoA s = new NodoA("S");
        NodoA r = new NodoA("R");
        NodoA t = new NodoA("T");
        NodoA p = new NodoA("P");
        NodoA l = new NodoA("L");
        NodoA m = new NodoA("M");
        NodoA o = new NodoA("O");
        NodoA n = new NodoA("N");

        s.izq = r;
        s.der = l;

        r.izq = t;
        // r.der = null;
        t.der = p;

        l.izq = m;
        l.der = o;
        // m has no children
        // o.izq = null;
        o.der = n;

        this.raiz = s;
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
