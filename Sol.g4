grammar Sol;

prog : (declaration | NEWLINE)* (line | NEWLINE)* EOF;

declaration : type ID assign? (',' ID assign?)* SEMICOLON;

assign: '=' (INT|DOUBLE|STRING|TRUE|FALSE);

type : 'bool' | 'real'| 'string' | 'int';

line : PRINT (inst SEMICOLON);

inst : LPAREN inst RPAREN 		        # Paren
  | op=(SUB|NOT) inst		            # Unary
  | inst op=(MULT|DIV|MOD) inst         # MultDiv
  | inst op=(ADD|SUB) inst 		        # AddSub
  | inst op=(LT|LE|GT|GE) inst	        # Rel
  | inst op=(EQ|NEQ) inst		        # Equal
  | inst op=AND inst			        # And
  | inst op=OR inst                     # Or
  | op=(INT|DOUBLE|STRING|TRUE|FALSE)   # Literal
  ;

MULT: '*' ;
ADD : '+' ;
SUB : '-' ;
DIV : '/' ;
MOD : '%' ;
TRUE : 'true' ;
FALSE : 'false' ;
LPAREN : '(' ;
RPAREN : ')' ;
NOT : 'not' ;
AND : 'and' ;
OR : 'or' ;
EQ : '==' ;
NEQ : '!=' ;
LT : '<' ;
LE : '<=' ;
GT : '>' ;
GE : '>=' ;
INT : DIGIT+ ;
DOUBLE : DIGIT+ '.' DIGIT* | '.' DIGIT+;
STRING: '"' (ESC|.)*? '"' ;
NEWLINE:'\r'? '\n' ;
PRINT: 'print';
SEMICOLON: ';';
ID: [a-zA-Z_] ([a-zA-Z_] | DIGIT)*;
WS : [ \t\r\n]+ -> skip ;
SL_COMMENT : '//' .*? (EOF|'\n') -> skip; // single-line comment
ML_COMMENT : '/*' .*? '*/' -> skip ; // multi-line comment


fragment DIGIT : [0-9] ;
fragment ESC : '\\"' | '\\\\' ; // 2-char sequences \" and \\

