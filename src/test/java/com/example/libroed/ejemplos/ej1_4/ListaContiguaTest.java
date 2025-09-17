package com.example.libroed.ejemplos.ej1_4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.libroed.capituloUno.ejemplos.ej1_4.ListaContigua;

class ListaContiguaTest {

    @Test
    void consultarElementoValidoImprimeValor() {
        ListaContigua lista = new ListaContigua();
        // No falla y usa índices base 0
        lista.consultarelemento(0);
        lista.consultarelemento(9);
    }

    @Test
    void borrarElementoDesplazaYDecrementaL() {
        ListaContigua lista = new ListaContigua();
        // Lista inicial: [3,5,8,23,45,89,12,78,5,1], L=10
        lista.borrarelemento(2); // borra 8
        assertEquals(9, lista.L);
        assertArrayEquals(new int[]{3,5,23,45,89,12,78,5,1,0}, lista.P);
    }

    @Test
    void insertarElementoDesplazaYIncrementaL() {
        ListaContigua lista = new ListaContigua();
        // Inserta 99 en posición 4
        lista.insertarelemento(4, 99);
        assertEquals(10, lista.L); // estaba llena, L=c, no debería insertar
        // Verificamos que no cambió cuando L>=c
        assertArrayEquals(new int[]{3,5,8,23,45,89,12,78,5,1}, lista.P);

        // Para probar inserción, primero borramos para crear espacio
        lista.borrarelemento(0); // ahora L=9
        lista.insertarelemento(4, 99);
        assertEquals(10, lista.L);
        assertArrayEquals(new int[]{5,8,23,45,99,89,12,78,5,1}, lista.P);
    }
}
