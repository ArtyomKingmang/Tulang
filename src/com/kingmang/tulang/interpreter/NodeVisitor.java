package com.kingmang.tulang.interpreter;

import com.kingmang.tulang.parser.nodes.*;

public interface NodeVisitor {

    void visitCompound(Compound node);
    void visitAssignation(Assignation node);
    void visitDeclaration(Declaration node);
    void visitVariable(Variable node);
    void visitBinaryOperation(BinaryOperation node);
    void visitNumber(NumberLiteral node);
    void visitString(StringLiteral node);
    void visitPrint(Print node);

    void visitPrintln(Println node);
}
