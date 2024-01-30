package com.kingmang.tulang.lexer;


import java.util.ArrayList;
import java.util.List;

public class LexerImplementation implements ILexer{

    private String input;
    private int pos;
    private Character current;

    @Override
    public List<IToken> tokenize(String input) {
        this.input = input;
        this.pos = 0;
        this.current = input.charAt(0);

        final List<IToken> tokens = new ArrayList<>();
        while(current != null){
            if(Character.isSpaceChar(current)){
                skipWhiteSpaces();
            }else if(current == '+'){
                tokens.add(new TokenImplementation(TokenType.PLUS, "+"));
                advance();
            }else if(current == '-'){
                tokens.add(new TokenImplementation(TokenType.MINUS, "-"));
                advance();
            }else if(current == '*'){
                tokens.add(new TokenImplementation(TokenType.MUL, "*"));
                advance();
            }else if(current == '/'){
                tokens.add(new TokenImplementation(TokenType.DIV, "/"));

            }else if(current == '='){
                tokens.add(new TokenImplementation(TokenType.ASSIGN, "="));

            }else if(current == '('){
                tokens.add(new TokenImplementation(TokenType.LPAREN, "("));
                advance();
            }else if(current == ')'){
                tokens.add(new TokenImplementation(TokenType.RPAREN, ")"));
                advance();
            }else if(current == ':'){
                tokens.add(new TokenImplementation(TokenType.COLON, ":"));
                advance();
            }else if(current == ';'){
                tokens.add(new TokenImplementation(TokenType.SEMICOLON, ";"));
                advance();
            }else if(Character.isDigit(current)){
                tokens.add(new TokenImplementation(TokenType.NUMBER_LITERAL, integer()));
                advance();
            }else if (current == '"' || current == '\''){
                tokens.add(new TokenImplementation(TokenType.STRING_LITERAL,consumeString(current)));
                advance();
            }else if(Character.isAlphabetic(current)){
                tokens.add(idOrKeyword());
            }else{
                throw new RuntimeException("Unrecognized token" + current);
            }
        }
        tokens.add(new TokenImplementation(TokenType.EOF, null));
        return tokens;
    }

    private void advance(){
        pos ++;
        if (pos > input.length() - 1){
            current = null;
        }else{
            current = input.charAt(pos);
        }
    }

    private void skipWhiteSpaces(){
        while(current != null && Character.isSpaceChar(current)){
            advance();
        }
    }

    private String consumeString(char type) {
        final StringBuilder stringBuilder = new StringBuilder();
        advance();
        while (current != null && current != type) {
            stringBuilder.append(current);
            advance();
        }
        return stringBuilder.toString();
    }

    private TokenImplementation idOrKeyword(){
        final StringBuilder stringBuilder = new StringBuilder();

        while(current != null && Character.isLetterOrDigit(current)){
            stringBuilder.append(current);
            advance();
        }
        final String result = stringBuilder.toString();
        if(result.equals("let")) return new TokenImplementation(TokenType.LET, result);
        if(result.equals("print")) return new TokenImplementation(TokenType.PRINT, result);
        if(result.equals("number")) return new TokenImplementation(TokenType.NUMBER, result);
        if(result.equals("string")) return new TokenImplementation(TokenType.STRING, result);
        else return new TokenImplementation(TokenType.ID, result);
    }

    private String integer(){
        final StringBuilder result = new StringBuilder();
        while(current != null && Character.isDigit(current)){
            result.append(current);
            advance();
        }
        return result.toString();
    }
}