package com.example.libroed.capituloSiete.ejemplos.ej7_4;

class ArbolAVLCheck {
    NodoAVL raiz;

    // Construye un árbol que cumple con los factores de balance dados:
    // A: -1 (2 - 3)
    // B:  1 (1 - 0)
    // C:  1 (2 - 1)
    // D:  0 (hoja)
    // E: -1 (0 - 1)
    // F:  0 (hoja)
    // G:  0 (hoja)
    // Estructura resultante:
    //        A
    //       / \
    //      B   C
    //     /   / \
    //    D   E   G
    //         \
    //          F
    public void construirEjemplo() {
        NodoAVL a = new NodoAVL("A");
        NodoAVL b = new NodoAVL("B");
        NodoAVL c = new NodoAVL("C");
        NodoAVL d = new NodoAVL("D");
        NodoAVL e = new NodoAVL("E");
        NodoAVL f = new NodoAVL("F");
        NodoAVL g = new NodoAVL("G");

        a.izq = b;
        a.der = c;
        b.izq = d; // B balance 1 -> solo hijo izquierdo (D)
        // b.der = null;
        c.izq = e; // C balance 1 -> izq altura 2, der altura 1
        c.der = g; // G hoja
        // e.izq = null;
        e.der = f; // E balance -1 -> solo hijo derecho (F)
        // f hoja

        this.raiz = a;
    }

    // Altura del nodo (nulo = 0). Hoja = 1.
    public int altura(NodoAVL n) {
        if (n == null) return 0;
        return 1 + Math.max(altura(n.izq), altura(n.der));
    }

    // Factor de balance = altura(izq) - altura(der)
    public int factorBalance(NodoAVL n) {
        if (n == null) return 0;
        return altura(n.izq) - altura(n.der);
    }

    // Verificación de AVL: |FB| <= 1 en todos los nodos
    public boolean esAVL() {
        return esAVLRec(raiz);
    }

    private boolean esAVLRec(NodoAVL n) {
        if (n == null) return true;
        int fb = factorBalance(n);
        if (fb < -1 || fb > 1) return false;
        return esAVLRec(n.izq) && esAVLRec(n.der);
    }

    // Impresión inorder con factores de balance
    public void imprimirFactoresInorden() {
        imprimirFBInordenRec(raiz);
    }

    private void imprimirFBInordenRec(NodoAVL n) {
        if (n == null) return;
        imprimirFBInordenRec(n.izq);
        System.out.println(n.dato + ": " + factorBalance(n));
        imprimirFBInordenRec(n.der);
    }
}
