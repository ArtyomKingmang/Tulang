package com.kingmang.tulang.parser.ast;

import com.kingmang.tulang.parser.ANode;

import java.util.ArrayList;
import java.util.List;

public abstract class AListNode extends ANode {

    private final List<ANode> list;

    public AListNode() {
        list = new ArrayList<>();
    }

    public AListNode(List<ANode> list) {
        this.list = list;
    }

    public void add(ANode node) {
        list.add(node);
    }

    public List<ANode> childNodes() {
        return list;
    }
}
