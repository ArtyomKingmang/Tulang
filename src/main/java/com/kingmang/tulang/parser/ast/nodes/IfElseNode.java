package com.kingmang.tulang.parser.ast.nodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class IfElseNode extends ANode {
    private final ANode condition;
    private final ANode thenBody;
    private final ANode elseBody;

    public IfElseNode(ANode condition, ANode thenBody, ANode elseBody) {
        this.condition = condition;
        this.thenBody = thenBody;
        this.elseBody = elseBody;
    }

    public ANode getCondition() {
        return condition;
    }

    public ANode getThenBody() {
        return thenBody;
    }

    public ANode getElseBody() {
        return elseBody;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitIfElseNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return createList(condition, thenBody, elseBody);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.IF;
    }
}
