package com.example.libroed.ejemplos.ej1_3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.libroed.capituloUno.ejemplos.ej1_3.ListaEnterosEj1_3;

class ListaEnterosEj1_3Test {

    @Test
    void insertaEnPosicionValidaDesplazaYActualizaL() {
        int[] inicial = {10, 20, 30, 0, 0};
        ListaEnterosEj1_3 lista = new ListaEnterosEj1_3(new int[]{10, 20, 30}, 5);
        assertEquals(3, lista.longitud());
        assertArrayEquals(inicial, lista.elementos());

        lista.insertarelemento(1, 99);

        assertEquals(4, lista.longitud());
        assertArrayEquals(new int[]{10, 99, 20, 30, 0}, lista.elementos());
    }

    @Test
    void noInsertaSiListaLlena() {
        ListaEnterosEj1_3 lista = new ListaEnterosEj1_3(new int[]{1, 2, 3}, 3);
        lista.insertarelemento(1, 9);
        assertEquals(3, lista.longitud());
        assertArrayEquals(new int[]{1, 2, 3}, new int[]{lista.elementos()[0], lista.elementos()[1], lista.elementos()[2]});
    }
}
