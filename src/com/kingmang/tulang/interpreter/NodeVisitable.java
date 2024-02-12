package com.kingmang.tulang.interpreter;

public interface NodeVisitable {

    void accept(NodeVisitor visitor);
}
