package ru.ifmo.rain.akimov.token;

import ru.ifmo.rain.akimov.visitor.TokenVisitor;

public interface Token {
    String getName();

    void accept(TokenVisitor visitor);
}
