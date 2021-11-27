package com.github.shin1x1.jsonparser.lexer;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LexerTest {
    @Test
    void getNextToken() {
        var sut = new Lexer(new Scanner("[]{}:,true,false,null123.45\"a\u3042bc\""));

        assertEquals(new Token.LeftBracket(), sut.getNextToken().orElseThrow());
        assertEquals(new Token.RightBracket(), sut.getNextToken().orElseThrow());
        assertEquals(new Token.LeftBrace(), sut.getNextToken().orElseThrow());
        assertEquals(new Token.RightBrace(), sut.getNextToken().orElseThrow());
        assertEquals(new Token.Colon(), sut.getNextToken().orElseThrow());
        assertEquals(new Token.Comma(), sut.getNextToken().orElseThrow());
        assertEquals(new Token.True(), sut.getNextToken().orElseThrow());
        assertEquals(new Token.Comma(), sut.getNextToken().orElseThrow());
        assertEquals(new Token.False(), sut.getNextToken().orElseThrow());
        assertEquals(new Token.Comma(), sut.getNextToken().orElseThrow());
        assertEquals(new Token.Null(), sut.getNextToken().orElseThrow());
        assertEquals(new Token.Number(BigDecimal.valueOf(123.45)), sut.getNextToken().orElseThrow());
        assertEquals(new Token.String("aあbc"), sut.getNextToken().orElseThrow());
    }

    @Test
    void getNextToken_string() {
        var sut = new Lexer(new Scanner("\"a\""));

        assertEquals(new Token.String("a"), sut.getNextToken().orElseThrow());
    }

    @Test
    void getNextToken_backslash() {
        var sut = new Lexer(new Scanner("\"\\\"\\/\\b\\f\\n\\r\\t\\u3042\""));

        assertEquals(new Token.String("\"/\b\f\n\r\tあ"), sut.getNextToken().orElseThrow());
    }

    @Test
    void getNextToken_number() {
        var sut = new Lexer(new Scanner("-123e5"));

        assertEquals(new Token.Number(new BigDecimal("-1.23e7")), sut.getNextToken().orElseThrow());
    }
}