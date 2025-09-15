package com.example.libroed;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    void appHasAGreeting() {
        assertEquals("Hola, Libro ED!", App.greet());
    }
}
