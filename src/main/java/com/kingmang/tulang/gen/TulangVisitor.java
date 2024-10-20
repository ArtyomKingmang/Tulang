// Generated from C:/Users/crowb/Desktop/Tulang/src/main/antlr4/Tulang.g4 by ANTLR 4.13.1

package com.kingmang.tulang.gen;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TulangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TulangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TulangParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(TulangParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TulangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(TulangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(TulangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(TulangParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(TulangParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(TulangParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(TulangParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(TulangParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#functionArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionArguments(TulangParser.FunctionArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(TulangParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(TulangParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(TulangParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(TulangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(TulangParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TulangParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(TulangParser.VariableContext ctx);
}