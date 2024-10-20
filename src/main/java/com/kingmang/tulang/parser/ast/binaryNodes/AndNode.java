package com.kingmang.tulang.parser.ast.binaryNodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;
import com.kingmang.tulang.parser.ast.ABinaryOperationNode;

public class AndNode extends ABinaryOperationNode {

    public AndNode(ANode first, ANode second) {
        super(first, second);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitAndNode(this);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.AND;
    }
}
