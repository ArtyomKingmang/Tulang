package com.kingmang.tulang.parser.ast.nodes;

import com.google.common.base.MoreObjects;
import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class AssignmentNode extends ANode {

    private final String name;
    private final ANode value;

    public AssignmentNode(String name, ANode value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitAssignmentNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return createList(value);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.ASSIGNMENT;
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

    public ANode getValue() {
        return value;
    }
}
