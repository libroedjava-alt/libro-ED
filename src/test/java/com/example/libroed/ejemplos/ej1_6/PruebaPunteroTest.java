package com.example.libroed.ejemplos.ej1_6;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.libroed.capituloUno.ejemplos.ej1_6.PruebaPuntero;

class PruebaPunteroTest {
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
    void ejecutaYVerificaValoresFinales() {
        PruebaPuntero.main(new String[]{});
        String out = outContent.toString();
        assertTrue(out.contains("Valor de a.dato: 500"));
        assertTrue(out.contains("Valor de b.dato: 23"));
        assertTrue(out.contains("Valor de c.dato: 1200"));
        assertTrue(out.contains("Valor de d.dato: 600"));
        assertTrue(out.contains("Valor de e.dato: 1"));
        assertTrue(out.contains("Valor de p.dato: 1200"));
        assertTrue(out.contains("Valor de q.dato: 1200"));
        assertTrue(out.contains("Valor de r.dato: 1200"));
    }
}
