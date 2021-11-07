package ru.ifmo.rain.akimov.token;

import ru.ifmo.rain.akimov.visitor.TokenVisitor;

public abstract class OperationToken implements Token {
    abstract public long calculate(final long a, final long b);

    abstract public int priority();

    @Override
    public void accept(final TokenVisitor visitor) {
        visitor.visit(this);
    }
}
