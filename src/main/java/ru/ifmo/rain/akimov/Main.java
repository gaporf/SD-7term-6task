package ru.ifmo.rain.akimov;

import ru.ifmo.rain.akimov.token.Token;
import ru.ifmo.rain.akimov.token.Tokenizer;
import ru.ifmo.rain.akimov.visitor.CalcVisitor;
import ru.ifmo.rain.akimov.visitor.ParserVisitor;
import ru.ifmo.rain.akimov.visitor.PrintVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            final Scanner scanner = new Scanner(System.in);
            final String expression = scanner.nextLine();
            final Tokenizer tokenizer = new Tokenizer(expression);
            final List<Token> tokens = new ArrayList<>();
            while (tokenizer.hasToken()) {
                tokens.add(tokenizer.nextToken());
            }
            final ParserVisitor parserVisitor = new ParserVisitor();
            for (final Token token : tokens) {
                token.accept(parserVisitor);
            }
            final List<Token> rpn = parserVisitor.getReversePolishNotation();
            final PrintVisitor printVisitor = new PrintVisitor();
            for (final Token token : rpn) {
                token.accept(printVisitor);
            }
            System.out.println();
            final CalcVisitor calcVisitor = new CalcVisitor();
            for (final Token token : rpn) {
                token.accept(calcVisitor);
            }
            System.out.println("Result = " + calcVisitor.calculate());
        } catch (final RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
