package com.kingmang.tulang.lexer;

import java.util.ArrayList;
import java.util.List;

public class LexerImplementation implements ILexer {

    private String input;
    private int pos;
    private Character current;

    @Override
    public List<IToken> tokenize(String input) {
        this.input = input;
        this.pos = 0;
        this.current = input.charAt(0);

        final List<IToken> tokens = new ArrayList<>();

        while (current != null) {
            if (Character.isSpaceChar(current)) {
                skipWitheSpaces();
            } else if (current == '+') {
                tokens.add(new TokenImplementation(TokenType.PLUS, "+"));
                advance();
            } else if (current == '-') {
                tokens.add(new TokenImplementation(TokenType.MINUS, "-"));
                advance();
            } else if (current == '*') {
                tokens.add(new TokenImplementation(TokenType.MUL, "*"));
                advance();
            } else if (current == '/') {
                tokens.add(new TokenImplementation(TokenType.DIV, "/"));
                advance();
            } else if (current == '=') {
                tokens.add(new TokenImplementation(TokenType.ASSIGN, "="));
                advance();
            } else if (current == '(') {
                tokens.add(new TokenImplementation(TokenType.LPAREN, "("));
                advance();
            } else if (current == ')') {
                tokens.add(new TokenImplementation(TokenType.RPAREN, ")"));
                advance();
            } else if (current == ';') {
                tokens.add(new TokenImplementation(TokenType.SEMICOLON, ";"));
                advance();
            } else if (current == ':') {
                tokens.add(new TokenImplementation(TokenType.COLON, ":"));
                advance();
            } else if (Character.isDigit(current)) {
                tokens.add(new TokenImplementation(TokenType.NUMBER_LITERAL, integer()));
            } else if (current == '"' || current == '\'') {
                tokens.add(new TokenImplementation(TokenType.STRING_LITERAL, consumeString(current)));
                advance();
            } else if (Character.isAlphabetic(current)) {
                tokens.add(identifierOrKeyword());
            } else {
                throw new RuntimeException("Unrecognized token: " + current);
            }
        }

        tokens.add(new TokenImplementation(TokenType.EOF, null));

        return tokens;
    }

    private void advance() {

        pos++;

        if (pos > input.length() - 1) {
            current = null;
        } else {
            current = input.charAt(pos);
        }
    }

    private void skipWitheSpaces() {

        while (current != null && Character.isSpaceChar(current)) {
            advance();
        }
    }

    private String consumeString(char type) {

        final StringBuilder sb = new StringBuilder();

        advance();

        while (current != null && current != type) {
            sb.append(current);
            advance();
        }

        return sb.toString();
    }

    private TokenImplementation identifierOrKeyword() {

        final StringBuilder sb = new StringBuilder();

        while (current != null && Character.isLetterOrDigit(current)) {
            sb.append(current);
            advance();
        }

        final String result = sb.toString();

        if (result.equals("let")) return new TokenImplementation(TokenType.LET, result);
        if (result.equals("print")) return new TokenImplementation(TokenType.PRINT, result);
        if (result.equals("number")) return new TokenImplementation(TokenType.NUMBER_DATATYPE, result);
        if (result.equals("string")) return new TokenImplementation(TokenType.STRING_DATATYPE, result);

        else return new TokenImplementation(TokenType.ID, result);
    }
    private String integer() {

        final StringBuilder result = new StringBuilder();

        while (current != null && Character.isDigit(current)) {
            result.append(current);
            advance();
        }

        return result.toString();
    }
}
