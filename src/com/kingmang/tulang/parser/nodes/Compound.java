package com.kingmang.tulang.parser.nodes;

import com.kingmang.tulang.interpreter.NodeVisitor;

import java.util.List;

public class Compound implements Node {

    private final List<Node> children;

    public Compound(List<Node> children) {
        this.children = children;
    }

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visitCompound(this);
    }
}
