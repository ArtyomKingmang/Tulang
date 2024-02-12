package com.kingmang.tulang.interpreter;

public class Symbol<T> {

    private final String type;
    private final T value;

    Symbol(String type, T value) {
        this.type = type;
        this.value = value;
    }

    String getType() {
        return type;
    }

    public T getValue() {
        return value;
    }
}
