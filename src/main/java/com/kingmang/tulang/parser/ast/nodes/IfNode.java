package com.kingmang.tulang.parser.ast.nodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class IfNode extends ANode {
    private final ANode condition;
    private final ANode thenBody;

    public IfNode(ANode condition, ANode thenBody) {
        this.condition = condition;
        this.thenBody = thenBody;
    }

    public ANode getCondition() {
        return condition;
    }

    public ANode getThenBody() {
        return thenBody;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitIfNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return ANode.createList(condition, thenBody);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.IF;
    }
}
