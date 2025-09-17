package com.example.libroed.capituloUno.ejemplos.ej1_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ejemplo 1.4: Programa interactivo por consola para operar sobre una lista contigua.
 */
public class TestListaContigua {
    public static void main(String[] args) throws IOException {
        ListaContigua L = new ListaContigua();
        BufferedReader Teclado;
        Teclado = new BufferedReader(new InputStreamReader(System.in));
        int opc = 0, elemento = 0, posicion = 0;
        do {
            System.out.println("1. Consultar Elemento");
            System.out.println("2. Eliminar Elemento");
            System.out.println("3. Insertar Elemento");
            System.out.println("4. Imprimir Lista");
            System.out.println("5. Salir");
            System.out.println("Digite la opción:");
            try {
                opc = Integer.parseInt(Teclado.readLine());
            } catch (NumberFormatException e) {
                opc = 0; // opción inválida -> reintentar
            }
            switch (opc) {
                case 1:
                    System.out.println("Digite la posición del elemento en la Lista");
                    posicion = Integer.parseInt(Teclado.readLine());
                    L.consultarelemento(posicion);
                    break;
                case 2:
                    System.out.println("Digite la posición del elemento en la Lista");
                    posicion = Integer.parseInt(Teclado.readLine());
                    L.borrarelemento(posicion);
                    break;
                case 3:
                    System.out.println("Digite la posición del elemento en la Lista");
                    posicion = Integer.parseInt(Teclado.readLine());
                    System.out.println("Digite el valor del nuevo elemento en la Lista");
                    elemento = Integer.parseInt(Teclado.readLine());
                    L.insertarelemento(posicion, elemento);
                    break;
                case 4:
                    L.imprimirlista();
                    break;
                default:
                    // Opciones no válidas se ignoran, el menú se imprime de nuevo
                    break;
            }
        } while (opc != 5);
    }
}
