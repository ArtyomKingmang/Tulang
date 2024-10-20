package com.kingmang.tulang.compiler;

import com.kingmang.tulang.gen.TulangParser;
import com.kingmang.tulang.parser.ANode;
import com.kingmang.tulang.parser.ast.*;
import com.kingmang.tulang.parser.ast.binaryNodes.*;
import com.kingmang.tulang.parser.ast.listNodes.ArgsNode;
import com.kingmang.tulang.parser.ast.listNodes.BlockNode;
import com.kingmang.tulang.parser.ast.nodes.*;
import org.antlr.v4.runtime.tree.TerminalNode;

public class Transformer {

    public static ANode transform(TulangParser.StatementListContext ctx) {
        Transformer transformer = new Transformer();
        return transformer.visit(ctx);
    }

    private ANode visit(TulangParser.StatementListContext ctx) {
        BlockNode block = new BlockNode();
        for (TulangParser.StatementContext stmt : ctx.statement()) {
            block.add(visit(stmt));
        }
        return block;
    }

    private ANode visit(TulangParser.StatementContext stmt) {
        if (stmt.assignment() != null) {
            return visit(stmt.assignment());
        }
        if (stmt.breakStatement() != null) {
            return visit(stmt.breakStatement());
        }
        if (stmt.continueStatement() != null) {
            return visit(stmt.continueStatement());
        }
        if (stmt.functionCall() != null) {
            return visit(stmt.functionCall());
        }
        if (stmt.functionDeclaration() != null) {
            return visit(stmt.functionDeclaration());
        }
        if (stmt.ifStatement() != null) {
            return visit(stmt.ifStatement());
        }
        if (stmt.returnStatement() != null) {
            return visit(stmt.returnStatement());
        }
        if (stmt.whileStatement() != null) {
            return visit(stmt.whileStatement());
        }
        if (stmt.variableDeclaration() != null) {
            return visit(stmt.variableDeclaration());
        }
        throw new RuntimeException("unrecognized statement");
    }

    private ANode visit(TulangParser.VariableDeclarationContext variableDeclaration) {
        String name = variableDeclaration.Identifier().getText();
        ANode value = visit(variableDeclaration.expression());

        return new DeclarationNode(name, value);
    }

    private ANode visit(TulangParser.ExpressionContext expression) {
        if (expression.variable() != null) {
            return visit(expression.variable());
        }
        if (expression.literal() != null) {
            return visit(expression.literal());
        }
        if (expression.functionCall() != null) {
            return visit(expression.functionCall());
        }
        if (expression.getChildCount() == 2) {
            ANode value = visit(expression.expression(0));
            return new NegateNode(value);
        }
        if (expression.getChildCount() == 3) {
            if (expression.expression().size() == 1) {
                return visit(expression.expression(0));
            }

            ANode left = visit(expression.expression(0));
            ANode right = visit(expression.expression(1));
            String op = expression.getChild(1).getText();

            switch (op) {
                case "+":
                    return new AddNode(left, right);
                case "-":
                    return new SubtractNode(left, right);
                case "*":
                    return new MultiplyNode(left, right);
                case "/":
                    return new DivideNode(left, right);
                case "%":
                    return new ModulusNode(left, right);
                case "&&":
                    return new AndNode(left, right);
                case "||":
                    return new OrNode(left, right);
                case "<":
                    return new LessThanNode(left, right);
                case "<=":
                    return new LessEqualThanNode(left, right);
                case ">":
                    return new GreaterThanNode(left, right);
                case ">=":
                    return new GreaterEqualThanNode(left, right);
                case "==":
                    return new EqualNode(left, right);
                case "!=":
                    return new NotEqualNode(left, right);
            }
        }
        throw new RuntimeException("unrecognized expression");
    }

    private ANode visit(TulangParser.LiteralContext literal) {
        if (literal.IntegerLiteral() != null) {
            int value = Integer.parseInt(literal.IntegerLiteral().getText());
            return new IntegerLiteralNode(value);
        }
        if (literal.StringLiteral() != null) {
            String text = literal.StringLiteral().getText();
            String value = text.substring(1, text.length() - 1);
            return new StringLiteralNode(value);
        }

        String text = literal.getText();
        if (text.equals("true")) {
            return TrueNode.INSTANCE;
        } else if (text.equals("false")) {
            return FalseNode.INSTANCE;
        } else if (text.equals("nil")) {
            return NilNode.INSTANCE;
        }

        throw new RuntimeException("unrecognized literal type");
    }

    private ANode visit(TulangParser.VariableContext variable) {
        String name = variable.Identifier().getText();
        return new VariableNode(name);
    }

    private ANode visit(TulangParser.WhileStatementContext whileStatement) {
        ANode condition = visit(whileStatement.expression());
        ANode body = visit(whileStatement.statementList());

        return new WhileNode(condition, body);
    }

    private ANode visit(TulangParser.ReturnStatementContext returnStatement) {
        ANode value = visit(returnStatement.expression());

        return new ReturnNode(value);
    }

    private ANode visit(TulangParser.IfStatementContext ifStatement) {
        ANode condition = visit(ifStatement.expression());
        ANode thenBody = visit(ifStatement.statementList(0));

        if (ifStatement.statementList(1) != null) {
            ANode elseBody = visit(ifStatement.statementList(1));
            return new IfElseNode(condition, thenBody, elseBody);
        }

        return new IfNode(condition, thenBody);
    }

    private ANode visit(TulangParser.FunctionDeclarationContext functionDeclaration) {
        String name = functionDeclaration.Identifier().getText();
        ANode args = visit(functionDeclaration.functionArguments());
        ANode body = visit(functionDeclaration.statementList());

        return new FunctionNode(name, args, body);
    }

    private ANode visit(TulangParser.FunctionArgumentsContext functionArguments) {
        FunctionArgsNode args = new FunctionArgsNode();
        for (TerminalNode node : functionArguments.Identifier()) {
            args.add(node.getText());
        }
        return args;
    }

    private ANode visit(TulangParser.FunctionCallContext functionCall) {
        String name = functionCall.Identifier().getText();
        AListNode args = visit(functionCall.argumentList());
        return new CallNode(name, args);
    }

    private AListNode visit(TulangParser.ArgumentListContext argumentList) {
        ArgsNode args = new ArgsNode();
        for (TulangParser.ExpressionContext node : argumentList.expression()) {
            args.add(visit(node));
        }
        return args;
    }

    private ANode visit(TulangParser.ContinueStatementContext continueStatement) {
        return ContinueNode.INSTANCE;
    }

    private ANode visit(TulangParser.BreakStatementContext breakStatement) {
        return BreakNode.INSTANCE;
    }

    private ANode visit(TulangParser.AssignmentContext assignment) {
        String name = assignment.Identifier().getText();
        ANode value = visit(assignment.expression());

        return new AssignmentNode(name, value);
    }
}
