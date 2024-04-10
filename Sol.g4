grammar Sol;

prog : (line | NEWLINE)*;

line : PRINT (inst SEMICOLON NEWLINE | inst SEMICOLON EOF);

inst : LPAREN inst RPAREN 		# Paren
  | SUB inst		            # Unary
  | inst op=(MULT|DIV|MOD) inst # MultDiv
  | inst op=(ADD|SUB) inst 		# AddSub
  | inst op=(LT|LE|GT|GE) inst	# Rel
  | inst op=(EQ|NEQ) inst		# Equal
  | inst op=AND inst			# And
  | inst op=OR inst			    # Or
  | INT                         # Int
  | DOUBLE                      # Double
  | STRING                      # String
  | TRUE                        # True
  | FALSE                       # False
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
WS : [ \t\r\n]+ -> skip ;
SL_COMMENT : '//' .*? (EOF|'\n') -> skip; // single-line comment
ML_COMMENT : '/*' .*? '*/' -> skip ; // multi-line comment


fragment DIGIT : [0-9] ;
fragment ESC : '\\"' | '\\\\' ; // 2-char sequences \" and \\

