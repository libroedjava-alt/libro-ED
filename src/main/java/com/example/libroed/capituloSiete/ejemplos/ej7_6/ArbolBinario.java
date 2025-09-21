package com.example.libroed.capituloSiete.ejemplos.ej7_6;

import java.io.*;

/// inicio de la clase ArbolBinario
class ArbolBinario{

    //atributos
    public static Nodo raiz, movil;
    String datos = ""; // recorrido como texto
    String aux[] = new String[100]; // no utilizado directamente aquí pero se mantiene la firma
    int i = 0;
    int nodos[]= new int[100]; // buffer para persistencia

    //metodos
    ArbolBinario(){}
    public static void inicializar_arbol(){raiz=null;}

    // Inserta y retorna 0 si insertó, 1 si duplicado
    public int insertar_nodo(int num){
        if (raiz == null){
            Nodo nuevo = new Nodo();
            nuevo.dato= num;
            nuevo.subizq=null;
            nuevo.subder=null;
            raiz = nuevo;
            guardarEnBuffer(num);
            return 0;
        } else {
            Nodo actual = raiz;
            while (true){
                if (num == actual.dato){
                    return 1; // duplicado
                } else if (num < actual.dato){
                    if (actual.subizq == null){
                        Nodo nuevo = new Nodo();
                        nuevo.dato = num;
                        actual.subizq = nuevo;
                        guardarEnBuffer(num);
                        return 0;
                    }
                    actual = actual.subizq;
                } else { // num > actual.dato
                    if (actual.subder == null){
                        Nodo nuevo = new Nodo();
                        nuevo.dato = num;
                        actual.subder = nuevo;
                        guardarEnBuffer(num);
                        return 0;
                    }
                    actual = actual.subder;
                }
            }
        }
    }

    private void guardarEnBuffer(int num){
        if (i < nodos.length) {
            nodos[i] = num;
            i++;
        }
    }

    public void imprimir_arbol_preorden(Nodo m){
        if (m!=null){
            if (!datos.isEmpty()) datos += ", ";
            datos += m.dato;
            imprimir_arbol_preorden(m.subizq);
            imprimir_arbol_preorden(m.subder);
        }
    }

    public void imprimir_arbol_inorden(Nodo m){
        if (m!=null){
            imprimir_arbol_inorden(m.subizq);
            if (!datos.isEmpty()) datos += ", ";
            datos += m.dato;
            imprimir_arbol_inorden(m.subder);
        }
    }

    public void imprimir_arbol_postorden(Nodo m){
        if (m!=null){
            imprimir_arbol_postorden(m.subizq);
            imprimir_arbol_postorden(m.subder);
            if (!datos.isEmpty()) datos += ", ";
            datos += m.dato;
        }
    }

    public int buscar(Nodo m, int e){
        if (m ==null)
            return 0;
        if(m.dato < e)
            return buscar(m.subder,e);
        else if(m.dato > e)
            return buscar(m.subizq,e);
        else
            return 1;
    }

    public int contar(Nodo m){
        if (m == null)
            return 0;
        else
            return ( 1 + contar(m.subizq) + contar(m.subder));
    }

    // Borrar: 0 OK, 1 si árbol vacío o no encontrado al final del proceso
    public int borrar(Nodo movilr,int ele){
        int antes = contar(raiz);
        raiz = borrarRec(raiz, ele);
        int despues = contar(raiz);
        return (despues == antes) ? 1 : 0;
    }

    private Nodo borrarRec(Nodo n, int ele){
        if (n == null) return null;
        if (ele < n.dato){
            n.subizq = borrarRec(n.subizq, ele);
        } else if (ele > n.dato){
            n.subder = borrarRec(n.subder, ele);
        } else {
            // encontrado
            if (n.subizq == null && n.subder == null){
                return null; // hoja
            } else if (n.subizq == null){
                return n.subder; // solo derecho
            } else if (n.subder == null){
                return n.subizq; // solo izquierdo
            } else {
                // dos hijos: predecesor (máximo de las menores)
                Nodo pre = maxNodo(n.subizq);
                n.dato = pre.dato;
                n.subizq = borrarRec(n.subizq, pre.dato);
            }
        }
        return n;
    }

    private Nodo maxNodo(Nodo n){
        if (n == null) return null;
        while (n.subder != null) n = n.subder;
        return n;
    }

    public void sustituir(Nodo movilr, Nodo aux){
        // Mantener por compatibilidad: utiliza predecesor
        Nodo pre = maxNodo(movilr);
        if (pre != null) {
            aux.dato = pre.dato;
            raiz = borrarRec(raiz, pre.dato);
        }
    }

    public void trasladar( ){ // método que pasa la información del archivo al AB
        DataInputStream archivo = null;
        try{
            archivo = new DataInputStream(new FileInputStream("c\\Prueba\\arbolbinario.txt"));
            while (true) {
                int num = archivo.readInt();
                insertar_nodo(num);
            }
        } catch(FileNotFoundException fnfe) {
            // Archivo no encontrado: primera ejecución
        } catch (IOException ioe) {
            // EOF o error de lectura: finalizar
        } finally {
            if (archivo != null) try { archivo.close(); } catch (IOException ignored) {}
        }
    }
}
