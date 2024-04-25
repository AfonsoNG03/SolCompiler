grammar Sol;

prog : var* line+;

line : PRINT inst SEMICOLON     # Print
  | inst SEMICOLON              # Instruction
  | block                       # BlockCode
  | while                       # WhileCycle
  | for                         # ForCycle
  | if                          # IfStatement
  | BREAK SEMICOLON             # BreakStatement
  | SEMICOLON                   # Empty
  ;

inst : LPAREN inst RPAREN 		        # Paren
  | op=(SUB|NOT) inst		            # Unary
  | inst op=(MULT|DIV|MOD) inst         # MultDiv
  | inst op=(ADD|SUB) inst 		        # AddSub
  | inst op=(LT|LE|GT|GE) inst	        # Rel
  | inst op=(EQ|NEQ) inst		        # Equal
  | inst op=AND inst			        # And
  | inst op=OR inst                     # Or
  | op=(INT|DOUBLE|STRING|TRUE|FALSE)   # Literal
  | ID ASSIGN inst			            # Assign
  | ID				                    # Id
  ;


var : type ID (ASSIGN inst)? (COMMA ID (ASSIGN inst)?)* SEMICOLON;

block : BEGIN line* END;

type : TYPEINT | TYPEDOUBLE | TYPESTRING | TYPEBOOL;

while : WHILE inst DO line;

for : FOR ID ASSIGN inst TO inst DO line;

if : IF inst THEN line (ELSE line)?;

ASSIGN : '=' ;
BREAK : 'break' ;
IF : 'if' ;
THEN : 'then' ;
ELSE : 'else' ;
FOR : 'for' ;
TO : 'to' ;
WHILE : 'while' ;
DO : 'do' ;
BEGIN : 'begin';
END : 'end' ;
TYPEINT : 'int' ;
TYPEDOUBLE : 'real' ;
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
PRINT: 'print';
SEMICOLON: ';';
COMMA: ',';
ID : [a-zA-Z_][a-zA-Z_0-9]* ;
WS : [ \t\r\n]+ -> skip ;
SL_COMMENT : '//' .*? (EOF|'\n') -> skip; // single-line comment
ML_COMMENT : '/*' .*? '*/' -> skip ; // multi-line comment

fragment DIGIT : [0-9] ;
fragment ESC : '\\"' | '\\\\' ; // 2-char sequences \" and \\

