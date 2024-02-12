package com.kingmang.tulang.parser.nodes;

import com.kingmang.tulang.interpreter.NodeVisitor;

public class Print implements Node {

    private final Node node;

    public Print(Node node) {
        this.node = node;
    }

    public Node getNode() {
        return node;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitPrint(this);
    }
}
