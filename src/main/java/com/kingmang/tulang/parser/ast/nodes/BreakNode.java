package com.kingmang.tulang.parser.ast.nodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class BreakNode extends ANode {

    public static final BreakNode INSTANCE = new BreakNode();

    private BreakNode() { }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitBreakNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return EMPTY_LIST;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.BREAK;
    }
}
