package com.kingmang.tulang;

import com.kingmang.tulang.interpreter.IInterpreter;
import com.kingmang.tulang.interpreter.InterpreterImplementation;
import com.kingmang.tulang.lexer.ILexer;
import com.kingmang.tulang.lexer.IToken;
import com.kingmang.tulang.lexer.LexerImplementation;
import com.kingmang.tulang.parser.IParser;
import com.kingmang.tulang.parser.ParserImplementation;
import com.kingmang.tulang.parser.nodes.Node;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final ILexer lexer = new LexerImplementation();
        final IParser parser = new ParserImplementation();
        final IInterpreter interpreter = new InterpreterImplementation();
        final String code = "print(\"Hello World\");";
        final List<IToken> tokens = lexer.tokenize(code);
        final Node node = parser.parse(tokens);
        interpreter.interpret(node);
    }
}
