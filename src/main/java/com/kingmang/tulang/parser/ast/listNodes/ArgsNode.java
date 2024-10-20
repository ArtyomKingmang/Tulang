package com.kingmang.tulang.parser.ast.listNodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;
import com.kingmang.tulang.parser.ast.AListNode;

import java.util.List;

public class ArgsNode extends AListNode {

    public ArgsNode() {
        super();
    }

    public ArgsNode(List<ANode> list) {
        super(list);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitArgsNode(this);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.ARGS;
    }
}
