package com.kingmang.tulang.optimization;


import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.NodeVisitorAdapter;
import com.kingmang.tulang.parser.ast.*;
import com.kingmang.tulang.parser.ast.binaryNodes.*;
import com.kingmang.tulang.parser.ast.listNodes.BlockNode;
import com.kingmang.tulang.parser.ast.nodes.*;

import java.util.ArrayList;
import java.util.List;

public class ConstantFolding extends NodeVisitorAdapter {

    @Override
    public ANode visitBlockNode(BlockNode node) {
        List<ANode> list = node.childNodes();
        List<ANode> newList = new ArrayList<>();

        for (ANode child : list) {
            child = child.accept(this);
            if (child instanceof BlockNode) {
                newList.addAll(child.childNodes());
            } else {
                newList.add(child);
            }
        }

        return new BlockNode(newList);
    }

    @Override
    public ANode visitAndNode(AndNode node) {
        ANode firstNode = node.getFirstNode().accept(this);
        ANode secondNode = node.getSecondNode().accept(this);

        boolean firstTrue = firstNode.getNodeType().isAlwaysTrue();
        boolean firstFalse = firstNode.getNodeType().isAlwaysFalse();
        boolean secondTrue = secondNode.getNodeType().isAlwaysTrue();
        boolean secondFalse = secondNode.getNodeType().isAlwaysFalse();

        if (firstFalse || secondFalse) {
            return FalseNode.INSTANCE;
        }

        if (firstTrue && secondTrue) {
            return TrueNode.INSTANCE;
        }

        if (firstTrue) {
            return secondNode;
        }

        if (secondTrue) {
            return firstNode;
        }

        return super.visitAndNode(node);
    }

    @Override
    public ANode visitOrNode(OrNode node) {
        ANode firstNode = node.getFirstNode().accept(this);
        ANode secondNode = node.getSecondNode().accept(this);

        boolean firstTrue = firstNode.getNodeType().isAlwaysTrue();
        boolean firstFalse = firstNode.getNodeType().isAlwaysFalse();
        boolean secondTrue = secondNode.getNodeType().isAlwaysTrue();
        boolean secondFalse = secondNode.getNodeType().isAlwaysFalse();

        if (firstFalse && secondFalse) {
            return FalseNode.INSTANCE;
        }

        if (firstTrue || secondTrue) {
            return TrueNode.INSTANCE;
        }

        if (firstFalse) {
            return secondNode;
        }

        if (secondFalse) {
            return firstNode;
        }

        return super.visitOrNode(node);
    }

    @Override
    public ANode visitIfNode(IfNode node) {
        ANode condition = node.getCondition().accept(this);

        if (condition.getNodeType().isAlwaysTrue()) {
            return node.getThenBody().accept(this);
        }

        if (condition.getNodeType().isAlwaysFalse()) {
            return new BlockNode(); /* empty block */
        }

        ANode thenBody = node.getThenBody().accept(this);
        return new IfNode(condition, thenBody);
    }

    @Override
    public ANode visitIfElseNode(IfElseNode node) {
        ANode condition = node.getCondition().accept(this);

        if (condition.getNodeType().isAlwaysTrue()) {
            return node.getThenBody().accept(this);
        }

        if (node.getCondition().getNodeType().isAlwaysFalse()) {
            return node.getElseBody().accept(this);
        }

        ANode thenBody = node.getThenBody().accept(this);
        ANode elseBody = node.getElseBody().accept(this);
        return new IfElseNode(condition, thenBody, elseBody);
    }

    @Override
    public ANode visitAddNode(AddNode node) {
        int[] nums = visitIntegerOperators(node);
        if (nums != null) {
            return new IntegerLiteralNode(nums[0] + nums[1]);
        }
        return new AddNode(node.getFirstNode(), node.getSecondNode());
    }

    @Override
    public ANode visitSubtractNode(SubtractNode node) {
        int[] nums = visitIntegerOperators(node);
        if (nums != null) {
            return new IntegerLiteralNode(nums[0] - nums[1]);
        }
        return new SubtractNode(node.getFirstNode(), node.getSecondNode());
    }

    @Override
    public ANode visitMultiplyNode(MultiplyNode node) {
        int[] nums = visitIntegerOperators(node);
        if (nums != null) {
            return new IntegerLiteralNode(nums[0] * nums[1]);
        }
        return new MultiplyNode(node.getFirstNode(), node.getSecondNode());
    }

    @Override
    public ANode visitDivideNode(DivideNode node) {
        int[] nums = visitIntegerOperators(node);
        if (nums != null) {
            return new IntegerLiteralNode(nums[0] / nums[1]);
        }
        return new DivideNode(node.getFirstNode(), node.getSecondNode());
    }

    @Override
    public ANode visitModulusNode(ModulusNode node) {
        int[] nums = visitIntegerOperators(node);
        if (nums != null) {
            return new IntegerLiteralNode(nums[0] % nums[1]);
        }
        return new ModulusNode(node.getFirstNode(), node.getSecondNode());
    }

    private int[] visitIntegerOperators(ABinaryOperationNode node) {
        ANode first = node.getFirstNode().accept(this);
        ANode second = node.getSecondNode().accept(this);

        if (first instanceof IntegerLiteralNode &&
                second instanceof IntegerLiteralNode) {

            int left = ((IntegerLiteralNode)first).getValue();
            int right = ((IntegerLiteralNode)second).getValue();

            return new int[] {left, right};
        }
        return null;
    }
}
