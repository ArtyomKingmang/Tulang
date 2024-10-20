package com.kingmang.tulang.parser.ast.nodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class ReturnNode extends ANode {

    private final ANode value;

    public ReturnNode(ANode value) {
        this.value = value;
    }


    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitReturnNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return createList(value);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.RETURN;
    }

    public ANode getValue() {
        return value;
    }


}
