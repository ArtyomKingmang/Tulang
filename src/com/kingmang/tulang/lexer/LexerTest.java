package com.kingmang.tulang.lexer;

import java.util.List;

public class LexerTest {
    public static void main(String[] args) {
        ILexer lexer = new LexerImplementation();
        List<IToken> tokens = lexer.tokenize("let x : number;" +
                "x = (10 + 2) * 2");
        for(IToken token : tokens){
            System.out.println(token.getType());
        }
    }
}
