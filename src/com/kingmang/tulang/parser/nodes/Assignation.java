package com.kingmang.tulang.parser.nodes;

import com.kingmang.tulang.interpreter.NodeVisitor;

public class Assignation implements BinaryNode {

    private final String value;
    private final Variable left;
    private final Node right;

    public Assignation(String value, Variable left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public Node getRight() {
        return right;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitAssignation(this);
    }
}
