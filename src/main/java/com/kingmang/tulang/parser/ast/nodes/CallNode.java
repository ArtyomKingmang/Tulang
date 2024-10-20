package com.kingmang.tulang.parser.ast.nodes;

import com.google.common.base.MoreObjects;
import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;
import com.kingmang.tulang.parser.ast.AListNode;

import java.util.List;

public class CallNode extends ANode {

    private final String name;
    private final AListNode args;

    public CallNode(String name, AListNode args) {
        this.name = name;
        this.args = args;
    }

    public String getName() {
        return name;
    }

    public AListNode getArgs() {
        return args;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitCallNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return createList(args);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.CALL;
    }

    @Override
    public String getNodeName() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .toString();
    }
}
