package com.github.shin1x1.jsonparser.lexer;

import java.util.Optional;

public class Scanner {
    private int position = 0;
    private final String json;

    public Scanner(String json) {
        this.json = json;
    }

    public Optional<Character> peek() {
        if (isEot()) {
            return Optional.empty();
        }

        return Optional.of(json.charAt(position));
    }

    public Optional<Character> consume() {
        var ch = peek();

        if (!isEot()) {
            position++;
        }

        return ch;
    }

    public boolean isEot() {
        return position >= json.length();
    }
}
