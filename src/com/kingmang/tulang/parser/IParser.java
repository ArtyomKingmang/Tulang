package com.kingmang.tulang.parser;

import com.kingmang.tulang.lexer.IToken;
import com.kingmang.tulang.parser.nodes.Node;

import java.util.List;

public interface IParser {

    Node parse(List<IToken> tokens);
}
