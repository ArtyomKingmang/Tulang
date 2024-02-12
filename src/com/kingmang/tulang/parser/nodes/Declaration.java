package com.kingmang.tulang.parser.nodes;

import com.kingmang.tulang.interpreter.NodeVisitor;

public class Declaration implements BinaryNode {

    private final Variable variable;
    private final Type type;

    public Declaration(Variable variable, Type type) {
        this.variable = variable;
        this.type = type;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public Node getLeft() {
        return variable;
    }

    @Override
    public Node getRight() {
        return type;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitDeclaration(this);
    }
}
