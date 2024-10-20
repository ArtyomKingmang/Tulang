grammar Tulang;

@header {
package com.kingmang.tulang.gen;
}

statementList
  : statement+ ;

statement
  : ifStatement
  | whileStatement
  | functionCall
  | functionDeclaration
  | returnStatement
  | continueStatement
  | breakStatement
  | variableDeclaration
  | assignment ;

expression
  : expression ('+' | '-' | '*' | '/' | '%') expression
  | expression ('&&' | '||') expression
  | expression ('<' | '>' | '<=' | '>=' | '==' | '!=') expression
  | '-' expression
  | '(' expression ')'
  | functionCall
  | variable
  | literal ;

ifStatement
  : 'if' '(' expression ')' '{' statementList '}' ('else' '{' statementList '}')? ;

whileStatement
  : 'while' '(' expression ')' '{' statementList '}' ;

functionCall
  : Identifier '(' argumentList ')' ;

argumentList
  : expression?
  | expression (',' expression)* ;

literal
  : IntegerLiteral | StringLiteral | 'true' | 'false' | 'null' ;

functionDeclaration
  : 'fn' Identifier functionArguments '{' statementList '}' ;

functionArguments
  : '(' (Identifier? | Identifier (',' Identifier)*) ')' ;

returnStatement
  : 'return' expression ;

continueStatement
  : 'continue' ;

breakStatement
  : 'break' ;

assignment
  : Identifier ('=' | '+=' | '-=' | '*=' | '/=' | '%=') expression ;

variableDeclaration
  : 'let' Identifier '=' expression ;

variable
  : Identifier ;

IntegerLiteral
  : [0-9]+ ;

Identifier
  : IdentifierStart IdentifierPart* ;

fragment
IdentifierStart
  : [a-zA-Z$_] ;

fragment
IdentifierPart
  : [a-zA-Z0-9$_] ;

StringLiteral
  : '"' DoubleQuotedStringCharacter* '"' ;

fragment
DoubleQuotedStringCharacter
  : ~["\r\n\\] | ('\\' .) ;

Whitespace
  : [ \t\r\n\u000C]+ -> skip ;

Comment
  : '//' ~[\r\n]* -> channel(HIDDEN) ;
