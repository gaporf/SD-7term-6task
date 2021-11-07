package ru.ifmo.rain.akimov.visitor;

import ru.ifmo.rain.akimov.token.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ParserVisitor implements TokenVisitor {
    final List<Token> result = new ArrayList<>();
    final Stack<Token> stack = new Stack<Token>();

    @Override
    public void visit(final NumberToken token) {
        result.add(token);
    }

    @Override
    public void visit(final BraceToken token) {
        if (token instanceof LeftBraceToken) {
            stack.push(token);
        } else if (token instanceof RightBraceToken) {
            boolean isEmpty = true;
            while (!stack.empty() && !(stack.peek() instanceof LeftBraceToken)) {
                result.add(stack.pop());
                isEmpty = false;
            }
            if (stack.empty()) {
                throw new VisitorException("Can't find left brace");
            }
            if (isEmpty) {
                throw new VisitorException("Incorrect expression in braces");
            }
            assert stack.peek() instanceof LeftBraceToken;
            stack.pop();
        } else {
            throw new VisitorException("Unknown type of brace");
        }
    }

    @Override
    public void visit(final OperationToken token) {
        while (!stack.empty() && stack.peek() instanceof OperationToken && ((OperationToken) stack.peek()).priority() <= token.priority()) {
            result.add(stack.pop());
        }
        stack.push(token);
    }

    public List<Token> getReversePolishNotation() {
        while (!stack.isEmpty()) {
            final Token token = stack.pop();
            if (!(token instanceof OperationToken)) {
                throw new VisitorException("Incorrect expression");
            }
            result.add(token);
        }
        return result;
    }
}
