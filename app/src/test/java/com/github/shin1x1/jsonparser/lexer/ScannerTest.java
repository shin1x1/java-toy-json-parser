package com.github.shin1x1.jsonparser.lexer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScannerTest {
    @Test
    void peek() {
        var sut = new Scanner("1");
        assertEquals('1', sut.peek().orElseThrow());
    }

    @Test
    void consume() {
        var sut = new Scanner("123");
        assertEquals('1', sut.consume().orElseThrow());
        assertEquals('2', sut.consume().orElseThrow());
        assertEquals('3', sut.consume().orElseThrow());
        assertTrue(sut.consume().isEmpty());
    }

    @Test
    void isEot() {
        var sut = new Scanner("1");
        assertFalse(sut.isEot());
        sut.consume();
        assertTrue(sut.isEot());
    }
}