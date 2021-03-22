grammar g;

@header {
package compiler.parser;
}

/*base_rule
    : global_scope
    ; */

global_scope
    : statements*  EOF
    ;

statements
    :
      range_binding NEWLINE*
    | let_binding   NEWLINE* /* expr and type under let_binding*/
    ;


range_binding
    : RANGE ASSIGN OPAR (value_type(COMMA value_type)*)? CPAR
    ;

/* types are optional part of let binding.
let x (String) = 4*4 */
let_binding
    : LET ID OPAR BASIC_TYPE CPAR ASSIGN (expr)
    ;

/* range_bindings : (range_binding NEWLINE+)* ;
let_bindings : let_binding (NEWLINE let_binding)* ; */


/*there is an issue with the operator_expression as it is defined in the grammar because
 it creates a mutual left recursion through expr which is not allowed in Antlr. That's why everything is defined
 in expr.*/
 /* the order of rules defines their precedence - that's why mult and div are in the beginning*/
expr
    : expr (MULT | DIV | MOD) expr  /* 4*4, 4/4, 4%4 */
    | expr (PLUS | MINUS) expr       /* 4+4, 4-4 */
    | expr (AND | OR) expr             /* x&&y, x||y_Y */
    | expr (EQ | NEQ | LT | GT | LTEQ | GTEQ) expr
    | lambda
    | if_else        /*accepts IDs starting with small letters or _ */
    | value_type   /* accepts booleans, numbers and strings: True/False, "String", 4 */
    | RANGE    /* A1:B5 */
    | ID  /*accepts IDs starting with small letters or _ */
    ;

/* example use:
    if x==3 {4/2 } else {7 } */
if_else
    : type? IF expr OBRACE
    expr  CBRACE ELSE OBRACE (expr | ) CBRACE   #visitorTest
    ;

type : range_type | BASIC_TYPE | lambda_type ;    /* not sure if the type definition belongs to lexer or parser rules*/

/* Range (String) */
range_type : RANGE_NAME OPAR BASIC_TYPE CPAR ;

/* x(y,z) - invoking lambda*/
/* (String, String) -> Number (x) { let x (String) = 4*4 4*x} */
lambda
    : (lambda_type)? OPAR (ID (COMMA ID)*)? CPAR OBRACE (let_binding)* (expr) CBRACE NEWLINE
    ;

/* () -> Number, (String, String) -> Number */
lambda_type : OPAR (BASIC_TYPE (COMMA BASIC_TYPE)*)? CPAR ARROW BASIC_TYPE;

value_type : NUMBER | BOOL | STRING ;
BASIC_TYPE : 'String' | 'Bool' | 'Number' ;
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

/* this operator definition won't assure correct operator precedence -
 it should rather be directly added to the expr in correct order
*/
OPERATOR : PLUS | MINUS | MULT | DIV | MOD | AND | OR | EQ | LT | LTEQ | GTEQ | GT ;

ASSIGN: '=';
OPAR : '(';
CPAR : ')';
OBRACE : '{';
CBRACE : '}';


NULL : 'null';
IF : 'if';
ELSE : 'else';
PAR: '"';
COMMA: ',' ;
ARROW: '->' ;

/* because of the Top-Down type of parser, it is extremely important to have the lexer rules sorted in the correct
order - the first lexer rule that will match the input will be used. This can easily lead to
wrong classification - for instance, all keywords must be defined before the id definition, else they will
get misclassified as ids. Similar problem is with character vs id and so on*/

LET : 'let';
RANGE_NAME : 'Range' ;

BOOL
    : TRUE
    | FALSE
    ;

TRUE : 'true';
FALSE : 'false';

ID
    : [a-z_]+ [a-z_0-9]*
    ;

RANGE : CELL_ID ':' CELL_ID ;

CELL_ID
    : [A-Z]+ [1-9] [0-9]* ;



/* I skipped the negative numbers definition because I found it is never correct to handle this as a lexer rule,
we should handle it later in the Visitor class*/
NUMBER
    : [0-9]+ | [0-9]+ '.' [0-9]+
    ;

STRING
    : PAR CHARACTER* PAR ;

CHARACTER
    : [a-zA-Z_0-9] ;

NEWLINE : '\n' ;
WS : [ \t\r\n]+ -> skip ;