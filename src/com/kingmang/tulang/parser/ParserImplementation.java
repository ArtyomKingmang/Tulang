package com.kingmang.tulang.parser;

import com.kingmang.tulang.lexer.IToken;
import com.kingmang.tulang.lexer.TokenType;
import com.kingmang.tulang.parser.nodes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import static com.kingmang.tulang.lexer.TokenType.*;

public class ParserImplementation implements IParser {

    private Iterator<IToken> iterator;
    private IToken current;

    private HashMap<String, String> types = new HashMap<>();

    public Node parse(List<IToken> tokens) {
        iterator = tokens.iterator();
        current = iterator.next();
        return program();
    }

    private Node program() {

        final List<Node> nodes = statementList();

        return new Compound(nodes);
    }

    private List<Node> statementList() {

        final Node node = statement();

        eat(SEMICOLON);

        final List<Node> nodes = new ArrayList<>();

        nodes.add(node);

        while (current.getType() != EOF) {
            nodes.add(statement());
            eat(SEMICOLON);
        }

        return nodes;
    }

    private Node statement() {

        Node node;

        if (current.getType().equals(LET)) {
            node = declarationStatement();
        } else if (current.getType().equals(PRINT)) {
            node = printStatement();
        } else if (current.getType().equals(PRINTLN)) {
            node = printlnStatement();
        } else {
            node = assignmentStatement();
        }
        return node;
    }

    private Declaration declarationStatement() {

        eat(LET);

        final Variable variable = variable();

        eat(COLON);

        final Type type = type();

        types.put(variable.getValue(), type.getValue());

        return new Declaration(variable, type);
    }

    private Node printStatement() {

        eat(PRINT);

        eat(LPAREN);

        final Node expression = expression();

        eat(RPAREN);

        return new Print(expression);
    }

    private Node printlnStatement() {

        eat(PRINTLN);

        eat(LPAREN);

        final Node expression = expression();

        eat(RPAREN);

        return new Println(expression);
    }

    private Assignation assignmentStatement() {

        final Variable variable = variable();

        final IToken current = this.current;

        eat(ASSIGN);

        final Node expression = expression();

        return new Assignation(current.getValue(), variable, expression);
    }

    private Node expression() {

        if (current.getType().equals(NUMBER_LITERAL)) {
            return numberExpression();
        } else if (current.getType().equals(STRING_LITERAL)) {
            return stringExpression();
        } else {
            final String type = types.get(current.getValue());
            if (type.equals("number")) return numberExpression();
            else return stringExpression();
        }
    }

    private Node stringExpression() {

        Node node = stringTerm();

        while (current.getType().equals(PLUS)) {
            final IToken current = this.current;
            eat(PLUS);
            node = new BinaryOperation(current.getType().name(), node, stringExpression());
        }

        return node;
    }

    private Node stringTerm() {

        if (current.getType().equals(STRING_LITERAL)) {
            final IToken current = this.current;
            eat(STRING_LITERAL);
            return new StringLiteral(current.getValue());
        } else if (current.getType().equals(ID)) {
            return variable();
        } else {
            return expression();
        }
    }

    private Node numberExpression() {

        Node node = term();
        while (current.getType().equals(PLUS) || current.getType().equals(MINUS)) {
            final IToken current = this.current;
            if (current.getType().equals(PLUS)) {
                eat(PLUS);
            } else {
                eat(MINUS);
            }
            node = new BinaryOperation(current.getType().name(), node, term());
        }
        return node;
    }
    private Node term() {

        Node node = factor();

        while (current.getType().equals(MUL) || current.getType().equals(DIV)) {
            IToken current = this.current;
            if (current.getType().equals(MUL)) {
                eat(MUL);
            } else {
                eat(DIV);
            }
            node = new BinaryOperation(current.getType().name(), node, factor());
        }

        return node;
    }

    private Node factor() {

        final IToken token = current;

        if (token.getType().equals(NUMBER_LITERAL)) {
            eat(NUMBER_LITERAL);
            return new NumberLiteral(token.getValue());
        } else if (token.getType().equals(LPAREN)) {
            eat(LPAREN);
            Node node = numberExpression();
            eat(RPAREN);
            return node;
        } else {
            return variable();
        }
    }

    private Type type() {

        final Type type;

        if (current.getType().equals(NUMBER_DATATYPE)) {
            eat(NUMBER_DATATYPE);
            type = new Type("number");
        } else {
            eat(STRING_DATATYPE);
            type = new Type("string");
        }

        return type;
    }

    private Variable variable() {

        final Variable variable = new Variable(current.getValue());

        eat(ID);

        return variable;
    }

    private void eat(TokenType tokenType) {

        if (current.getType().equals(tokenType)) {
            current = iterator.next();
        } else {
            throw new RuntimeException("Invalid syntax, expected: " + tokenType.name());
        }
    }
}
