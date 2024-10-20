package com.kingmang.tulang.parser;

import com.kingmang.tulang.visitor.IVisitor;
import com.kingmang.tulang.parser.ast.*;
import com.kingmang.tulang.parser.ast.binaryNodes.*;
import com.kingmang.tulang.parser.ast.listNodes.ArgsNode;
import com.kingmang.tulang.parser.ast.listNodes.BlockNode;
import com.kingmang.tulang.parser.ast.nodes.*;

import java.util.ArrayList;
import java.util.List;

public class NodeVisitorAdapter implements IVisitor<ANode> {

    @Override
    public ANode visitAddNode(AddNode node) {
        return new AddNode(node.getFirstNode().accept(this),
                           node.getSecondNode().accept(this));
    }

    @Override
    public ANode visitAndNode(AndNode node) {
        return new AndNode(node.getFirstNode().accept(this),
                node.getSecondNode().accept(this));
    }

    @Override
    public ANode visitArgsNode(ArgsNode node) {
        List<ANode> newList = new ArrayList<>();
        for (ANode child : node.childNodes()) {
            newList.add(child.accept(this));
        }
        return new ArgsNode(newList);
    }

    @Override
    public ANode visitAssignmentNode(AssignmentNode node) {
        return new AssignmentNode(node.getName(), node.getValue().accept(this));
    }

    @Override
    public ANode visitBlockNode(BlockNode node) {
        List<ANode> newList = new ArrayList<>();
        for (ANode child : node.childNodes()) {
            newList.add(child.accept(this));
        }
        return new BlockNode(newList);
    }

    @Override
    public ANode visitBreakNode(BreakNode node) {
        return node;
    }

    @Override
    public ANode visitCallNode(CallNode node) {
        return new CallNode(node.getName(), (AListNode)node.getArgs().accept(this));
    }

    @Override
    public ANode visitContinueNode(ContinueNode node) {
        return node;
    }

    @Override
    public ANode visitDeclarationNode(DeclarationNode node) {
        return new DeclarationNode(node.getName(), node.getValue().accept(this));
    }

    @Override
    public ANode visitDivideNode(DivideNode node) {
        return new DivideNode(node.getFirstNode().accept(this),
                              node.getSecondNode().accept(this));
    }

    @Override
    public ANode visitEqualNode(EqualNode node) {
        return new EqualNode(node.getFirstNode().accept(this),
                             node.getSecondNode().accept(this));
    }

    @Override
    public ANode visitFalseNode(FalseNode node) {
        return node;
    }

    @Override
    public ANode visitFunctionNode(FunctionNode node) {
        return new FunctionNode(node.getName(),
                node.getArgs().accept(this),
                node.getBody().accept(this));
    }


    @Override
    public ANode visitFunctionArgsNode(FunctionArgsNode node) {
        return node;
    }

    @Override
    public ANode visitGreaterThanNode(GreaterThanNode node) {
        return new GreaterThanNode(node.getFirstNode().accept(this),
                                   node.getSecondNode().accept(this));
    }

    @Override
    public ANode visitGreaterEqualThanNode(GreaterEqualThanNode node) {
        return new GreaterEqualThanNode(node.getFirstNode().accept(this),
                node.getSecondNode().accept(this));

    }
    @Override
    public ANode visitIfNode(IfNode node) {
        return new IfNode(node.getCondition().accept(this),
                          node.getThenBody().accept(this));
    }

    @Override
    public ANode visitIfElseNode(IfElseNode node) {
        return new IfElseNode(node.getCondition().accept(this),
                              node.getThenBody().accept(this),
                              node.getElseBody().accept(this));
    }

    @Override
    public ANode visitLessThanNode(LessThanNode node) {
        return new LessThanNode(node.getFirstNode().accept(this),
                                node.getSecondNode().accept(this));
    }
    @Override
    public ANode visitLessEqualThanNode(LessEqualThanNode node) {
        return new LessEqualThanNode(node.getFirstNode().accept(this),
                node.getSecondNode().accept(this));
    }
    @Override
    public ANode visitIntegerLiteralNode(IntegerLiteralNode node) {
        return node;
    }


    @Override
    public ANode visitMultiplyNode(MultiplyNode node) {
        return new MultiplyNode(node.getFirstNode().accept(this),
                                node.getSecondNode().accept(this));
    }

    @Override
    public ANode visitNegateNode(NegateNode node) {
        return new NegateNode(node.getNode().accept(this));
    }

    @Override
    public ANode visitNilNode(NilNode node) {
        return node;
    }

    @Override
    public ANode visitNotEqualNode(NotEqualNode node) {
        return new NotEqualNode(node.getFirstNode().accept(this),
                node.getSecondNode().accept(this));
    }

    @Override
    public ANode visitModulusNode(ModulusNode node) {
        return new ModulusNode(node.getFirstNode().accept(this),
                node.getSecondNode().accept(this));
    }

    @Override
    public ANode visitOrNode(OrNode node) {
        return new OrNode(node.getFirstNode().accept(this),
                          node.getSecondNode().accept(this));
    }

    @Override
    public ANode visitReturnNode(ReturnNode node) {
        return new ReturnNode(node.getValue().accept(this));
    }

    @Override
    public ANode visitStringLiteralNode(StringLiteralNode node) {
        return node;
    }

    @Override
    public ANode visitSubtractNode(SubtractNode node) {
        return new SubtractNode(node.getFirstNode().accept(this),
                                 node.getSecondNode().accept(this));
    }

    @Override
    public ANode visitTrueNode(TrueNode node) {
        return node;
    }

    @Override
    public ANode visitVariableNode(VariableNode node) {
        return node;
    }

    @Override
    public ANode visitWhileNode(WhileNode node) {
        return new WhileNode(node.getConditionNode().accept(this),
                             node.getBodyNode().accept(this));
    }

}
