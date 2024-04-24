grammar Sol;

prog : (line | NEWLINE)*;

line : PRINT inst SEMICOLON NEWLINE
  | PRINT inst SEMICOLON EOF
  | var SEMICOLON NEWLINE | var SEMICOLON EOF;

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


var : type ID (COMMA ID)* (ASSIGN inst)?;

type : TYPEINT | TYPEDOUBLE | TYPESTRING | TYPEBOOL;

ASSIGN : '=' ;
TYPEINT : 'int' ;
TYPEDOUBLE : 'double' ;
TYPESTRING : 'string' ;
TYPEBOOL : 'bool' ;
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
COMMA: ',';
ID : [a-zA-Z_][a-zA-Z_0-9]* ;
WS : [ \t\r\n]+ -> skip ;
SL_COMMENT : '//' .*? (EOF|'\n') -> skip; // single-line comment
ML_COMMENT : '/*' .*? '*/' -> skip ; // multi-line comment


fragment DIGIT : [0-9] ;
fragment ESC : '\\"' | '\\\\' ; // 2-char sequences \" and \\

