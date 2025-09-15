package com.example.libroed;

public class App {
    public static void main(String[] args) {
        System.out.println(greet());
        // Demostración del Ejemplo 1.1 usando clase separada
        int[] datos = {10, 20, 30};
        com.example.libroed.ejemplos.ej11.ListaEnterosEj11 lista =
                new com.example.libroed.ejemplos.ej11.ListaEnterosEj11(datos);
        // Consultar el elemento j-ésimo (índice 1 -> valor 20)
        lista.consultarelemento(1);
    }

    public static String greet() {
        return "Hola, Libro ED!";
    }
}
