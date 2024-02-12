package com.kingmang.tulang.parser.nodes;

import com.kingmang.tulang.interpreter.NodeVisitor;

public class BinaryOperation implements BinaryNode {

    private final String value;
    private final Node left;
    private final Node right;

    public BinaryOperation(String value, Node left, Node right) {
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
        visitor.visitBinaryOperation(this);
    }
}
