package com.kingmang.tulang.parser.ast.nodes;

import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeType;
import com.kingmang.tulang.visitor.IVisitor;

import java.util.List;

public class FunctionNode extends ANode {

    private final String name;
    private final ANode args;
    private final ANode body;

    public FunctionNode(String name, ANode args, ANode body) {
        this.name = name;
        this.args = args;
        this.body = body;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visitFunctionNode(this);
    }

    @Override
    public List<ANode> childNodes() {
        return createList(args, body);
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.FUNCTION;
    }

    public String getName() {
        return name;
    }

    public FunctionArgsNode getArgs() {
        return (FunctionArgsNode)args;
    }

    public ANode getBody() {
        return body;
    }
}
