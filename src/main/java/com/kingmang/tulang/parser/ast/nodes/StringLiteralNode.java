package com.kingmang.tulang.parser.ast.nodes;

import com.google.common.base.MoreObjects;
import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class StringLiteralNode extends ANode {

    private final String value;

    public StringLiteralNode(String value) {
        this.value = value;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitStringLiteralNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return EMPTY_LIST;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.STRINGLITERAL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringLiteralNode that = (StringLiteralNode) o;

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

    public String getValue() {
        return value;
    }
}
