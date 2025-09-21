package com.example.libroed.capituloDos.ejemplos.ej2_1;

import java.io.*;

// inicio de la clase TestLSE
public class TestLSE {

    public static void main(String[] args) throws IOException {
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        int opc;
        ListaSencillaEncadenada lista = new ListaSencillaEncadenada(); // crea lista
        lista.iniciar_lista(); // solo se llama una sola vez a este método
        do { // menu principal
            System.out.println("1.Almacenar un Numero en la Lista");
            System.out.println("2.Insertar Un Numero(Nodo) en una Posición");
            System.out.println("3.Borrar un Numero en una posición de la Lista ");
            System.out.println("4.Borrar el Numero al inicio de la Lista ");
            System.out.println("5.Borrar un Nodo de la lista mediante el Numero ");
            System.out.println("6.Imprimir lista");
            System.out.println("7.Consultar Información de un Nodo ");
            System.out.println("8.Consultar Información de un Nodo por medio de la Posición");
            System.out.println("9.Salir");
            System.out.println("digite la opción");
            opc = Integer.parseInt(Teclado.readLine());
            switch (opc) {
                case 1:
                    lista.insertar_nodo_inicio();
                    break;
                case 2:
                    lista.insertar_nodo_posicion();
                    break;
                case 3:
                    lista.borrar_nodo_posicion();
                    break;
                case 4:
                    lista.borrar_nodo_inicio();
                    break;
                case 5:
                    lista.borrar_nodo_informacion();
                    break;
                case 6:
                    lista.imprimir_lista();
                    break;
                case 7:
                    lista.consultar_informacion();
                    break;
                case 8:
                    lista.consultar_nodo();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opc != 9);
        lista.destruir_lista(); // se llama solo una vez para liberar la memoria reservada
    }
}
// fin de la clase TestLSE

