package ru.ifmo.rain.akimov.visitor;

import ru.ifmo.rain.akimov.token.BraceToken;
import ru.ifmo.rain.akimov.token.NumberToken;
import ru.ifmo.rain.akimov.token.OperationToken;

public interface TokenVisitor {
    void visit(NumberToken token);

    void visit(BraceToken token);

    void visit(OperationToken token);
}
