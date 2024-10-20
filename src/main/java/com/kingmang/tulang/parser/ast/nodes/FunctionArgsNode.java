package com.kingmang.tulang.parser.ast.nodes;

import com.google.common.base.MoreObjects;
import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionArgsNode extends ANode {

    private final List<String> list = new ArrayList<>();

    public void add(String arg) {
        list.add(arg);
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitFunctionArgsNode(this);
    }

    @Override
    public String getNodeName() {
        return MoreObjects.toStringHelper(this)
                .add("list", list)
                .toString();
    }

    @Override
    public List<ANode> childNodes() {
        return EMPTY_LIST;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.FUNCTIONARGS;
    }
}
