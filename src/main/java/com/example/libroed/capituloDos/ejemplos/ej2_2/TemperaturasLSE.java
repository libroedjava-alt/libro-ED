package com.example.libroed.capituloDos.ejemplos.ej2_2;

import java.io.*;
import java.lang.*; // librería para equals para comparar cadenas

// inicio de la clase TemperaturasLSE
public class TemperaturasLSE {
    public static void main(String[] args) throws IOException {
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        int opc;
        ListaTemperaturas lista = new ListaTemperaturas(); // creando lista
        lista.iniciar_lista(); // solo se llama una sola vez a este metodo
        do { // menu principal
            System.out.println("1.Almacenar una temperatura");
            System.out.println("2.Borrar una temperatura de la Lista ");
            System.out.println("3.Imprimir lista");
            System.out.println("4.Sacar promedio de temperaturas de una ciudad");
            System.out.println("5.Salir");
            System.out.println("digite la opción");
            opc = Integer.parseInt(Teclado.readLine());

            switch (opc) {
                case 1:
                    lista.insertar_NodoT_inicio();
                    break;
                case 2:
                    lista.borrar_NodoT_informacion();
                    break;
                case 3:
                    lista.imprimir_lista();
                    break;
                case 4:
                    lista.imprimir_promedio_medio();
                    break;
            }
        } while (opc != 5);
        lista.destruir_lista(); // se llama solo una vez para liberar la memoria reservada
    }
} // fin de la clase TemperaturasLSE
