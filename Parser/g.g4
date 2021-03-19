grammar g;

base_rule
    : code_block EOF
    ;

code_block
    : stat*
    ;

stat
    : if_else
    | lambda
    | range_binding
    | let_binding
    | expr     /* ??*/
    | type   /* not sure where to connect the type to the top-bottom flow so it is here for now*/
    ;

if_else
    : IF expr OBRACE (expr | if_else) CBRACE ELSE OBRACE (expr | if_else | WS) CBRACE   #visitorTest
    ;

lambda
    : OPAR (ID (COMMA ID)*)? CPAR OBRACE (let_binding)* (expr | if_else) CBRACE NEWLINE
    ;

range_binding
    : RANGE ASSIGN OPAR (VALUE_TYPE(COMMA VALUE_TYPE)*)? CPAR
    ;

let_binding
    : LET ID OPAR BASIC_TYPE CPAR ASSIGN (expr | if_else) NEWLINE
    ;

range_bindings : (range_binding NEWLINE+)* ;
let_bindings : let_binding (NEWLINE let_binding)* ;

/* unused */
global_scope : range_bindings let_bindings ;

type : range_type | BASIC_TYPE | lambda_type ;    /* not sure if the type definition belongs to lexer or parser rules*/

range_type : RANGE_NAME OPAR BASIC_TYPE CPAR ;

lambda_type : OPAR (BASIC_TYPE (COMMA BASIC_TYPE)*)? CPAR ARROW BASIC_TYPE;

/*there is an issue with the operator_expression as it is defined in the grammar because
 it creates a mutual left recursion through expr which is not allowed in Antlr. That's why everything is defined
 in expr.*/
 /* the order of rules defines their precedence - that's why mult and div are in the beginning*/
expr
    : expr (MULT | DIV | MOD) expr
    | expr (PLUS | MINUS) expr
    | expr (AND | OR) expr
    | expr (EQ | NEQ | LT | GT | LTEQ | GTEQ) expr
    | ID
    | VALUE_TYPE
    | RANGE
    ;

/* lexer rules and token definitions*/
OR: '||';
AND: '&&';
EQ: '==';
NEQ : '!=';
GT : '>';
LT : '<';
GTEQ : '>=';
LTEQ : '<=';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
MOD: '%';

/* I am afraid this operator definition won't assure correct operator precedence -
 it should rather be directly added to the expr in correct order
*/
OPERATOR : PLUS | MINUS | MULT | DIV | MOD | AND | OR | EQ | LT | LTEQ | GTEQ | GT ;

ASSIGN: '=';
OPAR : '(';
CPAR : ')';
OBRACE : '{';
CBRACE : '}';

TRUE : 'true';
FALSE : 'false';
NULL : 'null';
IF : 'if';
ELSE : 'else';
PAR: '"';
COMMA: ',' ;
ARROW: '->' ;

LET : 'let';
BASIC_TYPE : 'String' | 'Bool' | 'Number' ;
RANGE_NAME : 'Range' ;

ID
    : [a-z_]+ [a-z_0-9]*
    ;

CELL_ID
    : [A-Z]+ [1-9] [0-9]* ;

BOOL
    : TRUE
    | FALSE
    ;

CHARACTER
    : [a-zA-Z_0-9] ;

STRING
    : PAR CHARACTER* PAR ;

/* I skipped the negative numbers definition because I found it is never correct to handle this as a lexer rule,
we should handle it later in the Visitor class*/
NUMBER
    : [0-9]+ | [0-9]+ '.' [0-9]+
    ;

RANGE : CELL_ID ':' CELL_ID ;

VALUE_TYPE : NUMBER | BOOL | STRING ;

NEWLINE : '\n' ;
WS : [ \t\r\n]+ -> skip ;