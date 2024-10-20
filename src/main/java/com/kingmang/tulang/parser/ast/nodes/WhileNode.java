package com.kingmang.tulang.parser.ast.nodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class WhileNode extends ANode {

    private final ANode conditionNode;
    private final ANode bodyNode;

    public WhileNode(ANode conditionNode, ANode bodyNode) {
        this.conditionNode = conditionNode;
        this.bodyNode = bodyNode;
    }

    public ANode getBodyNode() {
        return bodyNode;
    }

    public ANode getConditionNode() {
        return conditionNode;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitWhileNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return createList(conditionNode, bodyNode);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.WHILE;
    }
}
