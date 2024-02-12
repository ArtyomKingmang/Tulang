package com.kingmang.tulang.interpreter;

import java.util.HashMap;
import java.util.Map;

class SymbolTable {

    private final Map<String, Symbol> symbolTable;

    SymbolTable() {
        this.symbolTable = new HashMap<>();
    }

    void define(String varName, Symbol symbol) {
        symbolTable.put(varName, symbol);
    }

    Symbol lookup(String varName) {
        return symbolTable.get(varName);
    }

    boolean isDefined(String varName) {
        return symbolTable.containsKey(varName);
    }
}
