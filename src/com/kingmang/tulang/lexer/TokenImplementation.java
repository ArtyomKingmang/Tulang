package com.kingmang.tulang.lexer;

public class TokenImplementation implements IToken{
    private final TokenType type;
    private final String value;

    public TokenImplementation(TokenType tokenType, String value){
        this.type = tokenType;
        this.value = value;
    }
    @Override
    public TokenType getType() {
        return type;
    }

    @Override
    public String getValue() {
        return value;
    }
    public String toString(){
        return type.toString();
    }
}
