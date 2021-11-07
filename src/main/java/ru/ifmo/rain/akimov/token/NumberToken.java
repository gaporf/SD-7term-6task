package ru.ifmo.rain.akimov.token;

import ru.ifmo.rain.akimov.visitor.TokenVisitor;

public class NumberToken implements Token {
    private final long value;

    public NumberToken(final long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    @Override
    public String getName() {
        return "NUMBER(" + value + ")";
    }

    @Override
    public void accept(final TokenVisitor visitor) {
        visitor.visit(this);
    }
}
