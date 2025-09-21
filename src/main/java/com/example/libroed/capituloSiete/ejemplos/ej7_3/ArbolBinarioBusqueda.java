package com.example.libroed.capituloSiete.ejemplos.ej7_3;

import java.util.ArrayList;
import java.util.List;

class ArbolBinarioBusqueda {
    NodoABB raiz;

    // Inserción estándar en ABB
    public void insertar(int clave) {
        raiz = insertarRec(raiz, clave);
    }

    private NodoABB insertarRec(NodoABB nodo, int clave) {
        if (nodo == null) return new NodoABB(clave);
        if (clave < nodo.clave) nodo.izq = insertarRec(nodo.izq, clave);
        else if (clave > nodo.clave) nodo.der = insertarRec(nodo.der, clave);
        // Si es igual, no insertamos duplicados (opcional)
        return nodo;
    }

    // Borrado en ABB (sustitución por el mayor de los menores - predecesor)
    public void borrar(int clave) {
        raiz = borrarRec(raiz, clave);
    }

    private NodoABB borrarRec(NodoABB nodo, int clave) {
        if (nodo == null) return null;
        if (clave < nodo.clave) nodo.izq = borrarRec(nodo.izq, clave);
        else if (clave > nodo.clave) nodo.der = borrarRec(nodo.der, clave);
        else {
            // Encontrado el nodo a borrar
            if (nodo.izq == null && nodo.der == null) {
                // Caso 1: sin hijos
                return null;
            } else if (nodo.izq == null) {
                // Caso 2: solo hijo derecho
                return nodo.der;
            } else if (nodo.der == null) {
                // Caso 2: solo hijo izquierdo
                return nodo.izq;
            } else {
                // Caso 3: dos hijos -> tomar predecesor (máximo del subárbol izquierdo)
                NodoABB predecesor = maxNodo(nodo.izq);
                nodo.clave = predecesor.clave;
                // Borrar el nodo que contenía el predecesor en el subárbol izquierdo
                nodo.izq = borrarRec(nodo.izq, predecesor.clave);
            }
        }
        return nodo;
    }

    private NodoABB maxNodo(NodoABB nodo) {
        while (nodo != null && nodo.der != null) nodo = nodo.der;
        return nodo;
    }

    // Recorridos
    public List<Integer> preorden() {
        List<Integer> out = new ArrayList<>();
        preordenRec(raiz, out);
        return out;
    }

    private void preordenRec(NodoABB n, List<Integer> out) {
        if (n == null) return;
        out.add(n.clave);
        preordenRec(n.izq, out);
        preordenRec(n.der, out);
    }

    public List<Integer> inorden() {
        List<Integer> out = new ArrayList<>();
        inordenRec(raiz, out);
        return out;
    }

    private void inordenRec(NodoABB n, List<Integer> out) {
        if (n == null) return;
        inordenRec(n.izq, out);
        out.add(n.clave);
        inordenRec(n.der, out);
    }

    public List<Integer> postorden() {
        List<Integer> out = new ArrayList<>();
        postordenRec(raiz, out);
        return out;
    }

    private void postordenRec(NodoABB n, List<Integer> out) {
        if (n == null) return;
        postordenRec(n.izq, out);
        postordenRec(n.der, out);
        out.add(n.clave);
    }

    // Altura de un nodo (para factores de balance AVL informativos)
    private int altura(NodoABB n) {
        if (n == null) return 0;
        return 1 + Math.max(altura(n.izq), altura(n.der));
    }

    private int factorBalance(NodoABB n) {
        if (n == null) return 0;
        return altura(n.izq) - altura(n.der);
    }

    // Impresión de recorridos como texto
    public static String join(List<Integer> vals) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vals.size(); i++) {
            sb.append(vals.get(i));
            if (i < vals.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    // Mostrar factores de balance (no modifica el árbol, solo calcula)
    public void imprimirFactoresBalance() {
        System.out.println("Factores de balance (altura izq - altura der):");
        imprimirFBRec(raiz);
    }

    private void imprimirFBRec(NodoABB n) {
        if (n == null) return;
        imprimirFBRec(n.izq);
        System.out.println("Nodo " + n.clave + ": FB = " + factorBalance(n));
        imprimirFBRec(n.der);
    }
}
