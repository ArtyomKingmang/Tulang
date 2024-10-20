package com.kingmang.tulang.parser.ast;

import com.kingmang.tulang.parser.ANode;

import java.util.List;

public abstract class ABinaryOperationNode extends ANode {

    private final ANode first;
    private final ANode second;

    protected ABinaryOperationNode(ANode first, ANode second) {
        this.first = first;
        this.second = second;
    }

    public ANode getFirstNode() {
        return first;
    }

    public ANode getSecondNode() {
        return second;
    }

    @Override
    public List<ANode> childNodes() {
        return createList(first, second);
    }
}
