package com.example.libroed.ejemplos.ej1_2;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.libroed.capituloUno.ejemplos.ej1_2.ListaEnterosEj1_2;

class ListaEnterosEj1_2Test {
    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void borraElementoValidoDesplazaYActualizaL() {
        ListaEnterosEj1_2 lista = new ListaEnterosEj1_2(new int[]{10, 20, 30, 40});
        lista.borrarelemento(1); // borrar 20
        assertEquals(3, lista.longitud());
        assertArrayEquals(new int[]{10, 30, 40, 0}, lista.elementos());
    }

    @Test
    void listaVaciaImprimeError() {
        ListaEnterosEj1_2 lista = new ListaEnterosEj1_2(new int[]{});
        lista.borrarelemento(0);
        assertTrue(outContent.toString().contains("Error, lista vacía"));
    }

    @Test
    void fueraDeRangoImprimeMensaje() {
        ListaEnterosEj1_2 lista = new ListaEnterosEj1_2(new int[]{1,2,3});
        lista.borrarelemento(9);
        assertTrue(outContent.toString().contains("Elemento no Existe "));
    }
}
