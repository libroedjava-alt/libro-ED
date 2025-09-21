package com.example.libroed.capituloOcho.ejemplos.ej8_1;

import java.util.*;

class Grafo {
    // Lista enlazada de vértices (cabecera)
    NodoVert cabv;
    // Índice rápido nombre -> vértice
    Map<String, NodoVert> map = new LinkedHashMap<>();
    // Mantener orden de inserción
    List<NodoVert> vertices = new ArrayList<>();

    public Grafo() {}

    public void construirDesdeMatriz(String[] nombres, int[][] matriz) {
        // Crear vértices y enlazarlos
        NodoVert previo = null;
        for (int i = 0; i < nombres.length; i++) {
            NodoVert v = new NodoVert(nombres[i], i);
            if (cabv == null) cabv = v; else previo.sig = v;
            previo = v;
            map.put(nombres[i], v);
            vertices.add(v);
        }
        // Crear arcos por cada celda > 0 (grafo dirigido y ponderado)
        int n = nombres.length;
        for (int i = 0; i < n; i++) {
            NodoVert origen = vertices.get(i);
            for (int j = 0; j < n; j++) {
                int w = matriz[i][j];
                if (w > 0) {
                    NodoVert destino = vertices.get(j);
                    // Insertar al final de la lista de arcos de 'origen'
                    NodoArco arco = new NodoArco(w, destino);
                    if (origen.primero == null) origen.primero = arco;
                    else {
                        NodoArco m = origen.primero;
                        while (m.sig != null) m = m.sig;
                        m.sig = arco;
                    }
                }
            }
        }
    }

    public void imprimirListaAdyacencia() {
        NodoVert v = cabv;
        while (v != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(v.nombre).append(": ");
            NodoArco a = v.primero;
            boolean first = true;
            while (a != null) {
                if (!first) sb.append(", ");
                sb.append(a.destino.nombre);
                first = false;
                a = a.sig;
            }
            sb.append(".");
            System.out.println(sb.toString());
            v = v.sig;
        }
    }

    public void imprimirRepresentacionEnlazada() {
        System.out.println("cabv (lista de vértices) -> ");
        NodoVert v = cabv;
        while (v != null) {
            System.out.print("  [" + v.nombre + "] -> ");
            NodoArco a = v.primero;
            while (a != null) {
                System.out.print(a.destino.nombre + "(" + a.peso + ") -> ");
                a = a.sig;
            }
            System.out.println("null");
            v = v.sig;
        }
    }

    // Dijkstra desde índice 'src'
    public int[] dijkstra(int src) {
        int n = vertices.size();
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE / 4);
        dist[src] = 0;
        for (int k = 0; k < n; k++) {
            int u = -1; int best = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) if (!vis[i] && dist[i] < best) { best = dist[i]; u = i; }
            if (u == -1) break;
            vis[u] = true;
            // Relajar aristas de u
            NodoArco a = vertices.get(u).primero;
            while (a != null) {
                int v = a.destino.idx;
                if (!vis[v] && dist[u] + a.peso < dist[v]) {
                    dist[v] = dist[u] + a.peso;
                }
                a = a.sig;
            }
        }
        return dist;
    }

    public void imprimirCaminosMinimos() {
        int n = vertices.size();
        for (int i = 0; i < n; i++) {
            int[] d = dijkstra(i);
            System.out.println("Desde " + vertices.get(i).nombre + ":");
            for (int j = 0; j < n; j++) {
                System.out.println("  a " + vertices.get(j).nombre + " = " + d[j]);
            }
            System.out.println();
        }
    }

    public int contarAristas() {
        int count = 0;
        NodoVert v = cabv;
        while (v != null) {
            NodoArco a = v.primero;
            while (a != null) { count++; a = a.sig; }
            v = v.sig;
        }
        return count;
    }
}
