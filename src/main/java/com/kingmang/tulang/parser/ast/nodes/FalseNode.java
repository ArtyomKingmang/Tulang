package com.kingmang.tulang.parser.ast.nodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class FalseNode extends ANode {

    public static final FalseNode INSTANCE = new FalseNode();

    private FalseNode() { }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitFalseNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return EMPTY_LIST;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.FALSE;
    }
}
