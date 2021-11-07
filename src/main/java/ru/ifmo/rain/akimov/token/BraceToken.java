package ru.ifmo.rain.akimov.token;

import ru.ifmo.rain.akimov.visitor.TokenVisitor;

public abstract class BraceToken implements Token {
    @Override
    public void accept(TokenVisitor visitor) {
        visitor.visit(this);
    }
}
