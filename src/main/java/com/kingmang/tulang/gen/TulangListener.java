// Generated from C:/Users/crowb/Desktop/Tulang/src/main/antlr4/Tulang.g4 by ANTLR 4.13.1

package com.kingmang.tulang.gen;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TulangParser}.
 */
public interface TulangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TulangParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(TulangParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(TulangParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TulangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TulangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TulangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TulangParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(TulangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(TulangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(TulangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(TulangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(TulangParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#functionCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(TulangParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(TulangParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(TulangParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(TulangParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(TulangParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(TulangParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(TulangParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void enterFunctionArguments(TulangParser.FunctionArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#functionArguments}.
	 * @param ctx the parse tree
	 */
	void exitFunctionArguments(TulangParser.FunctionArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(TulangParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(TulangParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(TulangParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(TulangParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(TulangParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(TulangParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TulangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TulangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(TulangParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(TulangParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TulangParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(TulangParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TulangParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(TulangParser.VariableContext ctx);
}