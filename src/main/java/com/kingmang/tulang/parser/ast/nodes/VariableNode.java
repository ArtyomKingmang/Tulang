package com.kingmang.tulang.parser.ast.nodes;

import com.google.common.base.MoreObjects;
import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class VariableNode extends ANode {

    private final String name;

    public VariableNode(String name) {
        this.name = name;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitVariableNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return EMPTY_LIST;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.VARIABLE;
    }

    @Override
    public String getNodeName() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .toString();
    }

    public String getName() {
        return name;
    }
}
