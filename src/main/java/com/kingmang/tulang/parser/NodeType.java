package com.kingmang.tulang.parser;

import org.objectweb.asm.Type;

public enum NodeType {
    ADD,
    AND,
    ARGS,
    BLOCK,
    CALL,
    DIVIDE,
    FALSE,
    IF,
    INTEGERLITERAL,
    MULTIPLY,
    NEGATE,
    OR,
    SUBTRACT,
    TRUE,
    WHILE,
    LESSTHAN,
    GREATERTHAN,
    EQUAL,
    FUNCTION,
    FUNCTIONARGS,
    RETURN,
    NIL,
    BREAK,
    CONTINUE,
    STRINGLITERAL,
    LESSEQUALSTHAN,
    GREATEREQUALTHAN,
    NOTEQUAL,
    MODULUS,
    ASSIGNMENT,
    DECLARATION,
    VARIABLE;

    public boolean isAlwaysTrue() {
        return this == TRUE;
    }

    public boolean isAlwaysFalse() {
        switch (this) {
            case FALSE:
            case NIL:
                return true;
            default:
                return false;
        }
    }

    public Type getType() {
        return switch (this) {
            case TRUE, FALSE, EQUAL, NOTEQUAL, LESSTHAN, LESSEQUALSTHAN, GREATERTHAN, GREATEREQUALTHAN, AND, OR ->
                    Type.BOOLEAN_TYPE;
            case INTEGERLITERAL, ADD, SUBTRACT, MULTIPLY, DIVIDE, MODULUS -> Type.INT_TYPE;
            case STRINGLITERAL, VARIABLE, CALL, NIL -> Type.getType(Object.class);
            default -> throw new RuntimeException("missing type info for node " + this);
        };
    }
}
