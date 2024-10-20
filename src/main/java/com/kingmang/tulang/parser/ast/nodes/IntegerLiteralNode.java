package com.kingmang.tulang.parser.ast.nodes;

import com.google.common.base.MoreObjects;
import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class IntegerLiteralNode extends ANode {

    private final Integer value;

    public IntegerLiteralNode(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitIntegerLiteralNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return EMPTY_LIST;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.INTEGERLITERAL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntegerLiteralNode that = (IntegerLiteralNode) o;

        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String getNodeName() {
        return MoreObjects.toStringHelper(this)
                .add("value", value)
                .toString();
    }
}
