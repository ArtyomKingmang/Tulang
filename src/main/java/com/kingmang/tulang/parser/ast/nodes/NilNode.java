package com.kingmang.tulang.parser.ast.nodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class NilNode extends ANode {

    public static final NilNode INSTANCE = new NilNode();

    private NilNode() { }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitNilNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return EMPTY_LIST;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.NIL;
    }
}
