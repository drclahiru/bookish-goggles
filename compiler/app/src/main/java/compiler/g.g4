grammar g;

@header {
package compiler.parser;
}

global_scope: statements* EOF;

statements:
	range_binding NEWLINE*
	| let_binding NEWLINE*;

range_binding: range ASSIGN list_expr;

/* let x Number = expr */
let_binding: LET ID type? ASSIGN expr;

let_expr: LET ID ASSIGN expr IN expr;

/* the order of rules defines their precedence, that's why operators are defined at multiple levels */
expr:
	expr (MULT | DIV | MOD) expr					# operator
	| expr (PLUS | MINUS) expr						# operator
	| expr (EQ | NEQ | LT | GT | LTEQ | GTEQ) expr	# operator
	| expr (AND) expr							    # operator
	| expr (OR) expr							    # operator
	| expr (CONS) expr								# operator
	| lambda										# expr_lambda
	| if_else										# expr_if_else
	| value											# expr_value
	| ID											# id
	| lambda_invocation                             # expr_invoke
	| let_expr										# expr_let
	| list_expr									    # expr_list
	| match_expr									# expr_match;

if_else: IF expr OBRACE expr ELSE expr CBRACE;

type: list_type | basic_type | lambda_type;

basic_type: BASIC_TYPE;

list_type: LIST_NAME OPAR type CPAR;

list_expr : OBRACE (expr (COMMA expr)*)? CBRACE;

match_expr : MATCH expr OBRACE match_expr_branch (COMMA match_expr_branch)* CBRACE;

match_expr_branch : pattern ARROW expr;

pattern :
	ID CONS pattern		#pattern_main_list_cons
	| OBRACE CBRACE 			#pattern_main_list_empty
	| ID					    #pattern_main_id
	;


/* (x) { x } */
lambda:
	OPAR (ID (COMMA ID)*)? CPAR OBRACE (let_binding NEWLINE)* (
		expr
	) CBRACE;

/* (String, String) -> Number */
lambda_type:
	OPAR (type (COMMA type)*)? CPAR ARROW type;

lambda_invocation:
	ID OPAR (expr (COMMA expr)*)? CPAR;

value: NUMBER # number | BOOL # bool | STRING # string;

range: CELL_ADDRESS ':' CELL_ADDRESS;

/* lexer rules and token definitions*/

BASIC_TYPE: 'String' | 'Bool' | 'Number';
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
CONS: '::';
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

LET: 'let';
IN: 'in';
LIST_NAME: 'List';
MATCH: 'match';

NUMBER: [0-9]+ | [0-9]+ '.' [0-9]+;

CELL_ADDRESS: [A-Z]+ [1-9]+[0-9]*;

ID: [a-z_]+ [a-z_0-9]*;

STRING: PAR CHARACTER* PAR;

BOOL: TRUE | FALSE;

TRUE: 'True';

FALSE: 'False';

CHARACTER: [a-zA-Z_0-9];

NEWLINE: '\r?\n';

WS: [ \t\r\n]+ -> skip;