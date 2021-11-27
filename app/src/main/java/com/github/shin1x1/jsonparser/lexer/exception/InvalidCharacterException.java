package com.github.shin1x1.jsonparser.lexer.exception;

public class InvalidCharacterException extends RuntimeException {
    private final char ch;

    public InvalidCharacterException(char ch) {
        super();
        this.ch = ch;
    }
}
