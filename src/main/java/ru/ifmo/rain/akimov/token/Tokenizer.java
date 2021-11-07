package ru.ifmo.rain.akimov.token;

public class Tokenizer {
    final String expression;
    int currentIndex = 0;

    public Tokenizer(final String expression) {
        this.expression = expression;
    }

    private void skipSpaces() {
        while (currentIndex < expression.length() && Character.isWhitespace(expression.charAt(currentIndex))) {
            currentIndex++;
        }
    }

    private boolean isEnd() {
        skipSpaces();
        return currentIndex >= expression.length();
    }

    private long getNumber() {
        StringBuilder number = new StringBuilder();
        while (currentIndex < expression.length() && Character.isDigit(expression.charAt(currentIndex))) {
            number.append(expression.charAt(currentIndex++));
        }
        return Long.parseLong(number.toString());
    }

    public boolean hasToken() {
        return !isEnd();
    }

    public Token nextToken() {
        if (isEnd()) {
            throw new TokenException("No tokens left");
        }
        char currentChar = expression.charAt(currentIndex);
        if (Character.isDigit(currentChar)) {
            return new NumberToken(getNumber());
        } else {
            currentIndex++;
            return switch (currentChar) {
                case '(' -> new LeftBraceToken();
                case ')' -> new RightBraceToken();
                case '+' -> new PlusToken();
                case '-' -> new MinusToken();
                case '*' -> new MulToken();
                case '/' -> new DivToken();
                default -> throw new TokenException("Incorrect symbol");
            };
        }
    }
}
