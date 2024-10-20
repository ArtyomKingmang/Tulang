package com.kingmang.tulang.parser.ast.binaryNodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;
import com.kingmang.tulang.parser.ast.ABinaryOperationNode;

public class GreaterEqualThanNode extends ABinaryOperationNode {

    public GreaterEqualThanNode(ANode first, ANode second) {
        super(first, second);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitGreaterEqualThanNode(this);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.GREATEREQUALTHAN;
    }
}
