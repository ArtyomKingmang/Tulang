package com.kingmang.tulang.test;

import com.kingmang.tulang.lexer.ILexer;
import com.kingmang.tulang.lexer.IToken;
import com.kingmang.tulang.lexer.LexerImplementation;

import java.util.List;

public class TestLexer {
    public static void main(String[] args){
        ILexer lexer = new LexerImplementation();
        List<IToken> tokens = lexer.tokenize("let x :       number; gfh");
        for(IToken token : tokens){
            System.out.println(token);
        }
    }
}
