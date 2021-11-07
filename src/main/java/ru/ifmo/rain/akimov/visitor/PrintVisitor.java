package ru.ifmo.rain.akimov.visitor;

import ru.ifmo.rain.akimov.token.BraceToken;
import ru.ifmo.rain.akimov.token.NumberToken;
import ru.ifmo.rain.akimov.token.OperationToken;

public class PrintVisitor implements TokenVisitor {
    @Override
    public void visit(final NumberToken token) {
        System.out.print(token.getName() + " ");
    }

    @Override
    public void visit(final BraceToken token) {
        System.out.print(token.getName() + " ");
    }

    @Override
    public void visit(final OperationToken token) {
        System.out.print(token.getName() + " ");
    }
}
