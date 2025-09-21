package com.example.libroed.capituloSiete.ejemplos.ej7_5;

import java.io.*;

//inicio de la Clase ArbolBinario
class ArbolBinario{

    //atributos
    public static Nodo raiz, movil;

    //metodos
    ArbolBinario(){}

    public static void inicializar_arbol(){
        raiz=null;
    }

    // metodo para insertar que no es recursivo (interactivo)
    public static void insertar_nodo()throws IOException{
        BufferedReader Teclado = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Digite el numero");
        int num = Integer.parseInt(Teclado.readLine());
        insertarIterativo(num);
    }

    // Inserta de forma iterativa una clave en el ABB
    private static void insertarIterativo(int num){
        Nodo nuevo = new Nodo();
        nuevo.dato = num;
        nuevo.subizq = null;
        nuevo.subder = null;
        if (raiz == null){
            raiz = nuevo;
            return;
        }
        Nodo actual = raiz;
        while (true){
            if (num == actual.dato){
                System.out.println("el numero ya existe");
                return;
            } else if (num < actual.dato){ // lado izquierdo para menores
                if (actual.subizq == null){
                    actual.subizq = nuevo;
                    return;
                }
                actual = actual.subizq;
            } else { // num > actual.dato, lado derecho para mayores
                if (actual.subder == null){
                    actual.subder = nuevo;
                    return;
                }
                actual = actual.subder;
            }
        }
    }

    // metodo de insercion recursiva (API compatible con el enunciado)
    public static void insertar_nodo_recursiva(Nodo m, int e){
        // ignoramos 'm' (por paso por valor) y actualizamos la raiz con helper
        raiz = insertarRec(raiz, e);
    }

    private static Nodo insertarRec(Nodo n, int e){
        if (n == null){
            Nodo nuevo = new Nodo();
            nuevo.dato = e;
            return nuevo;
        }
        if (e < n.dato) n.subizq = insertarRec(n.subizq, e);
        else if (e > n.dato) n.subder = insertarRec(n.subder, e);
        else System.out.println("el numero ya existe");
        return n;
    }

    //metodos para los recorridos 
    public static void imprimir_arbol_preorden(Nodo m){
        if (m!=null){
            System.out.println(m.dato);
            imprimir_arbol_preorden(m.subizq);
            imprimir_arbol_preorden(m.subder);
        }
    }

    public static void imprimir_arbol_inorden(Nodo m){
        if (m!=null){
            imprimir_arbol_inorden(m.subizq);
            System.out.println(m.dato);
            imprimir_arbol_inorden(m.subder);
        }
    }

    public static void imprimir_arbol_postorden(Nodo m){
        if (m!=null){
            imprimir_arbol_postorden(m.subizq);
            imprimir_arbol_postorden(m.subder);
            System.out.println(m.dato);
        }
    }

    public static int buscar(Nodo m, int e){
        if (m ==null)
            return 0;
        if(m.dato < e)
            return buscar(m.subder,e);
        else if(m.dato > e)
            return buscar(m.subizq,e);
        else
            return 1;
    }

    public static int contar(Nodo m){
        if (m == null)
            return 0;
        else
            return ( 1 + contar(m.subizq) + contar(m.subder));
    }

    public static void borrar(Nodo movilr,int ele){
        // API compatible; realmente actualizamos la raiz usando helper que retorna el nuevo subarbol
        raiz = borrarRec(raiz, ele);
    }

    private static Nodo borrarRec(Nodo n, int ele){
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
                // dos hijos: sustituir por el mayor de las menores (predecesor)
                Nodo pre = maxNodo(n.subizq);
                n.dato = pre.dato;
                n.subizq = borrarRec(n.subizq, pre.dato);
            }
        }
        return n;
    }

    private static Nodo maxNodo(Nodo n){
        if (n == null) return null;
        while (n.subder != null) n = n.subder;
        return n;
    }

    // Método sustituir del enunciado (no es estrictamente necesario con borrarRec)
    public static void sustituir(Nodo movilr, Nodo aux){
        // Implementación de relleno: la lógica real está en borrarRec
        // Se mantiene para compatibilidad del enunciado
        if (movilr == null || aux == null) return;
        Nodo pre = maxNodo(movilr);
        aux.dato = pre.dato;
        raiz = borrarRec(raiz, pre.dato);
    }
}
