package com.kingmang.tulang.parser.nodes;

import com.kingmang.tulang.interpreter.NodeVisitor;

public class NumberLiteral implements Node {

    private final String value;

    public NumberLiteral(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitNumber(this);
    }
}
