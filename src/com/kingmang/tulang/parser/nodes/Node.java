package com.kingmang.tulang.parser.nodes;

import com.kingmang.tulang.interpreter.NodeVisitable;

public interface Node extends NodeVisitable {

    String getValue();
}
