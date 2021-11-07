package ru.ifmo.rain.akimov.visitor;

import ru.ifmo.rain.akimov.token.BraceToken;
import ru.ifmo.rain.akimov.token.NumberToken;
import ru.ifmo.rain.akimov.token.OperationToken;

import java.util.Stack;

public class CalcVisitor implements TokenVisitor {
    final Stack<Long> stack = new Stack<>();

    @Override
    public void visit(final NumberToken token) {
        stack.push(token.getValue());
    }

    @Override
    public void visit(final BraceToken token) {
        assert false;
    }

    @Override
    public void visit(final OperationToken token) {
        if (stack.size() < 2) {
            throw new VisitorException("Incorrect expression");
        }
        final long b = stack.pop();
        final long a = stack.pop();
        stack.push(token.calculate(a, b));
    }

    public long calculate() {
        if (stack.size() != 1) {
            throw new VisitorException("Incorrect expression");
        }
        return stack.pop();
    }
}
