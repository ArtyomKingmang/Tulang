package com.kingmang.tulang.lexer;

public enum TokenType {
    PLUS,
    MINUS,
    MUL,
    DIV,

    NUMBER_LITERAL,
    STRING_LITERAL,

    NUMBER,
    STRING,

    LPAREN,
    RPAREN,

    ASSIGN,
    SEMICOLON,
    COLON,

    LET,
    ID,
    PRINT,
    EOF
}
