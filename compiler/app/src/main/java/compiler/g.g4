grammar g;

@header {
package compiler.parser;
}

global_scope: statements* EOF;

statements:
	range_binding NEWLINE*
	| let_binding NEWLINE* /* expr and type under let_binding*/;

range_binding: range ASSIGN range_expr;

/* types are optional part of let binding.
 let x (String) = 4*4
 */
let_binding: LET ID type? ASSIGN expr;

let_expr: LET ID ASSIGN expr IN expr;

/*there is an issue with the operator_expression as it is defined in the grammar because
 it
 creates
 a mutual left recursion through expr which is not allowed in Antlr. That's why everything
 is
 defined
 in expr.
 */
/* the order of rules defines their precedence - that's why mult and div are in the beginning*/
expr:
	expr (MULT | DIV | MOD) expr					# operator /* 4*4, 4/4, 4%4 */
	| expr (PLUS | MINUS) expr						# operator /* 4+4, 4-4 */
	| expr (AND | OR) expr							# operator /* x&&y, x||y_Y */
	| expr (EQ | NEQ | LT | GT | LTEQ | GTEQ) expr	# operator
	| lambda										# expr_lambda
	| if_else										# expr_if_else /*accepts IDs starting with small letters or _ */
	| value											# expr_value /* accepts booleans, numbers and strings: True/False, "String", 4 */
	| ID											# id /*accepts IDs starting with small letters or _ */
	| lambda_invocation                             # expr_invoke
	| let_expr										# expr_let
	| range_expr									# expr_range;

/* example use:
 if x==3 {4/2 } else {7 }
 */
if_else: IF expr OBRACE expr CBRACE ELSE OBRACE expr CBRACE;

type: range_type | basic_type | lambda_type;

basic_type: BASIC_TYPE;
/* not sure if the type definition belongs to lexer or parser rules*/

/* Range type */
range_type: RANGE_NAME OPAR type CPAR;

range_expr : OBRACE (value (COMMA value)*)? CBRACE;

/* x(y,z) - invoking lambda*/
/* (String, String) -> Number (x) { let x (String) = 4*4 4*x} */
lambda:
	OPAR (ID (COMMA ID)*)? CPAR OBRACE (let_binding NEWLINE)* (
		expr
	) CBRACE;

/* () -> Number, (String, String) -> Number */
lambda_type:
	OPAR (type (COMMA type)*)? CPAR ARROW type;

lambda_invocation:
	ID OPAR (expr (COMMA expr)*)? CPAR;

value: NUMBER # number | BOOL # bool | STRING # string;

range: CELL_ADDRESS ':' CELL_ADDRESS;

BASIC_TYPE: 'String' | 'Bool' | 'Number';
/* lexer rules and token definitions*/
OR: '||';
AND: '&&';
EQ: '==';
NEQ: '!=';
GT: '>';
LT: '<';
GTEQ: '>=';
LTEQ: '<=';
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';

/* this operator definition won't assure correct operator precedence -
 it should rather be
 directly
 added to the expr in correct order
 */
OPERATOR:
	PLUS
	| MINUS
	| MULT
	| DIV
	| MOD
	| AND
	| OR
	| EQ
	| LT
	| LTEQ
	| GTEQ
	| GT;

ASSIGN: '=';
OPAR: '(';
CPAR: ')';
OBRACE: '{';
CBRACE: '}';

NULL: 'null';
IF: 'if';
ELSE: 'else';
PAR: '"';
COMMA: ',';
ARROW: '->';

/* because of the Top-Down type of parser, it is extremely important to have the lexer rules sorted
 in the correct
 order - the first lexer rule that will match the input will be used. This can
 easily lead to
 wrong classification - for instance, all keywords must be defined before the id
 definition, else they will
 get misclassified as ids. Similar problem is with character vs id and
 so on
 */

LET: 'let';
IN: 'in';
RANGE_NAME: 'Range';

/* I skipped the negative numbers definition because I found it is never correct to handle this as
 a
 lexer rule,
 we should handle it later in the Visitor class
 */
//RANGE: CELL_COL CELL_ROW ':' CELL_COL CELL_ROW;

NUMBER: [0-9]+ | [0-9]+ '.' [0-9]+;
CELL_ADDRESS: [A-Z]+ [1-9]+[0-9]*;
//CELL_COL: [A-Z]+;
//CELL_ROW: [1-9]+[0-9]*;

ID: [a-z_]+ [a-z_0-9]*;

// CELL_ID: [A-Z]+ [1-9] [0-9]*;

STRING: PAR CHARACTER* PAR;

BOOL: TRUE | FALSE;

TRUE: 'True';
FALSE: 'False';

CHARACTER: [a-zA-Z_0-9];

NEWLINE: '\r?\n';
WS: [ \t\r\n]+ -> skip;