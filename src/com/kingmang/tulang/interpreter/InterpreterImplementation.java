package com.kingmang.tulang.interpreter;

import com.kingmang.tulang.parser.nodes.*;

import java.util.Stack;

public class InterpreterImplementation implements IInterpreter, NodeVisitor {

    private final SymbolTable symbolTable = new SymbolTable();
    private final Stack<Symbol> stack = new Stack<>();

    @Override
    public void interpret(Node node) {

        node.accept(this);
    }

    @Override
    public void visitCompound(Compound node) {
        node.getChildren().forEach(children -> children.accept(this));
    }

    @Override
    public void visitAssignation(Assignation node) {

        final String varName = node.getLeft().getValue();
        final boolean isDefined = symbolTable.isDefined(varName);
        if (!isDefined) throw new RuntimeException("Undeclared variable");
        node.getRight().accept(this);
        symbolTable.define(varName, stack.pop());
    }

    @Override
    public void visitDeclaration(Declaration node) {

        final String varName = node.getLeft().getValue();
        symbolTable.define(varName, null);
    }

    @Override
    public void visitVariable(Variable node) {

        final String varName = node.getValue();
        final Symbol value = symbolTable.lookup(varName);
        if (value != null) stack.push(value);
        else throw new RuntimeException("Null pointer exception: " + varName);
    }

    @Override
    public void visitBinaryOperation(BinaryOperation node) {

        try {
            switch (node.getValue()) {
                case "PLUS": {
                    evaluatePlus(node);
                    break;
                }
                case "MINUS": {
                    evaluateMinus(node);
                    break;
                }
                case "MUL": {
                    evaluateMul(node);
                    break;
                }
                default: {
                    evaluateDiv(node);
                    break;
                }
            }
        } catch (ClassCastException e) {
            throw new RuntimeException("Incompatible types");
        }
    }

    @Override
    public void visitNumber(NumberLiteral node) {

        stack.push(new Symbol<>("number", Integer.valueOf(node.getValue())));
    }

    @Override
    public void visitString(StringLiteral node) {

        stack.push(new Symbol<>("string", node.getValue()));
    }

    @Override
    public void visitPrint(Print node) {

        node.getNode().accept(this);
        System.out.println(stack.pop().getValue());
    }

    private void evaluatePlus(BinaryOperation node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);

        if (stack.peek().getType().equals("number")) {
            final Integer val1 = (Integer) stack.pop().getValue();
            final Integer val2 = (Integer) stack.pop().getValue();
            stack.push(new Symbol<>("number", val2 + val1));
        } else {
            final String val1 = (String) stack.pop().getValue();
            final String val2 = (String) stack.pop().getValue();
            stack.push(new Symbol<>("string", val2.concat(val1)));
        }
    }

    private void evaluateMinus(BinaryOperation node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        final Integer val1 = (Integer) stack.pop().getValue();
        final Integer val2 = (Integer) stack.pop().getValue();
        stack.push(new Symbol<>("number", val2 - val1));
    }

    private void evaluateMul(BinaryOperation node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        final Integer val1 = (Integer) stack.pop().getValue();
        final Integer val2 = (Integer) stack.pop().getValue();
        stack.push(new Symbol<>("number", val2 * val1));
    }

    private void evaluateDiv(BinaryOperation node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
        final Integer val1 = (Integer) stack.pop().getValue();
        final Integer val2 = (Integer) stack.pop().getValue();
        stack.push(new Symbol<>("number", val2 / val1));
    }
}
