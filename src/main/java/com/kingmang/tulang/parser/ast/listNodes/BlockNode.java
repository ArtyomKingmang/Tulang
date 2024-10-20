package com.kingmang.tulang.parser.ast.listNodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;
import com.kingmang.tulang.parser.ast.AListNode;

import java.util.List;

public class BlockNode extends AListNode {

    public BlockNode() {
        super();
    }

    public BlockNode(List<ANode> list) {
        super(list);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitBlockNode(this);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.BLOCK;
    }
}
