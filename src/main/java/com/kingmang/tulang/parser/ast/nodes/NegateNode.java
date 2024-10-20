package com.kingmang.tulang.parser.ast.nodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class NegateNode extends ANode {

    private final ANode node;

    public NegateNode(ANode node) {
        this.node = node;
    }

    public ANode getNode() {
        return node;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitNegateNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return createList(node);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.NEGATE;
    }
}
