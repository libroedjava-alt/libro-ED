package com.example.libroed;

public class App {
    public static void main(String[] args) {
        System.out.println(greet());
        // Demostración del Ejemplo 1.1 usando clase separada (ruta actualizada a capituloUno/ejemplos)
        int[] datos = {10, 20, 30};
        com.example.libroed.capituloUno.ejemplos.ej1_1.ListaEnterosEj1_1 lista =
                new com.example.libroed.capituloUno.ejemplos.ej1_1.ListaEnterosEj1_1(datos);
        // Consultar el elemento j-ésimo (índice 1 -> valor 20)
        lista.consultarelemento(1);
    }

    public static String greet() {
        return "Hola, Libro ED!";
    }
}
 