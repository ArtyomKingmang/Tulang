package com.kingmang.tulang.lexer;

import java.util.List;

public interface ILexer {

    List<IToken> tokenize(String input);
}
