package com.example.libroed.capituloUno.ejemplos.ej1_3;

/**
 * Demo Ejemplo 1.3: Insertar un elemento en la posición j de la lista P.
 */
public class TestListaEnterosEj1_3 {
    public static void main(String[] args) {
        System.out.println("-- Demo Ejemplo 1.3 --");
        // capacidad 5, carga inicial {10,20,30}
        ListaEnterosEj1_3 lista = new ListaEnterosEj1_3(new int[]{10, 20, 30}, 5);
        // insertar en posición válida
        lista.insertarelemento(1, 99); // esperado: {10,99,20,30,0} y L=4
        // intentar insertar cuando está llena
        lista.insertarelemento(0, 77); // {77,10,99,20,30} y L=5
        lista.insertarelemento(2, 55); // esperado: mensaje de lista llena
        // fuera de rango
        lista.insertarelemento(9, 11); // esperado: "Elemento no Existe "   
    }
}
