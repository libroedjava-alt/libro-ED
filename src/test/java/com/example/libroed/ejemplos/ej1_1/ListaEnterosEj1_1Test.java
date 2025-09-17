package com.example.libroed.ejemplos.ej1_1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.libroed.capituloUno.ejemplos.ej1_1.ListaEnterosEj1_1;

class ListaEnterosEj1_1Test {
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
    void consultaElementoValido() {
        ListaEnterosEj1_1 lista = new ListaEnterosEj1_1(new int[]{10, 20, 30});
        lista.consultarelemento(1);
        String out = outContent.toString().trim();
        assertTrue(out.contains("valor = 20"));
    }

    @Test
    void consultaElementoFueraDeRango() {
        ListaEnterosEj1_1 lista = new ListaEnterosEj1_1(new int[]{10});
        lista.consultarelemento(5);
        String out = outContent.toString().trim();
        assertTrue(out.contains("solicitado no existe en la Lista"));
    }

    @Test
    void consultaListaVacia() {
        ListaEnterosEj1_1 lista = new ListaEnterosEj1_1(new int[]{});
        lista.consultarelemento(0);
        String out = outContent.toString().trim();
        assertTrue(out.contains("Error, lista vacía"));
    }
}
