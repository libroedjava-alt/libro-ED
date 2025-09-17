package com.example.libroed.ejemplos.ej1_5;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.libroed.capituloUno.ejemplos.ej1_5.TestPuntero;

class TestPunteroTest {
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
    void ejecutaYVerificaSalida() {
        TestPuntero.main(new String[]{});
        String out = outContent.toString();
        assertTrue(out.contains("Valor de q utilizando la referencia p: 100"));
        assertTrue(out.contains("Nuevo valor de q utilizando la referencia p: 200"));
        assertTrue(out.contains("Valor de q: 200"));
    }
}
