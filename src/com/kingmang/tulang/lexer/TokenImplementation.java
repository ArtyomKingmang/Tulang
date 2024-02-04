package com.kingmang.tulang.lexer;

public class TokenImplementation implements IToken {

    private final TokenType kind;
    private final String value;

    TokenImplementation(TokenType tokenType, String value) {
        this.kind = tokenType;
        this.value = value;
    }

    @Override
    public TokenType getType() {
        return kind;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("TokenImpl(%s, %s)", kind.name(), value);
    }
}
