grammar Sol;

prog : (line | NEWLINE)*;

line : inst NEWLINE | inst EOF;

inst :  op=(GALLOC | GLOAD | GSTORE) INT   #memoryOp
        | INT_CONST INT #intConst
        | DOUBLE_CONST (DOUBLE | INT) #doubleConst
        | STRING_CONST STRING #stringConst
        | op=(FCONST | TCONST) #booleanConst
        | op=(IUMINUS | DUMINUS) #unaryOp
        | op=(JUMP | JUMPF | JUMPT) LABEL #jumpStat
        | op=(IEQ | INEQ | ILT | ILEQ | DEQ | DNEQ | DLT | DLEQ | BEQ | BNEQ | SEQ | SNEQ) #compareOp
        | op=(AND | OR | NOT) #binaryOp
        | op=(IADD | ISUB | IMULT | IDIV | IMOD | DADD | DSUB | DMULT | DDIV | SADD) #operations
        | op=(ITOS | ITOD | DTOS | BTOS) #typeConversion
        | op=(IPRINT | DPRINT | SPRINT | BPRINT) #printStat
        | LABEL (',' LABEL)* ':' inst #label
        | HALT #halt
        ;


IPRINT : 'iprint';
DPRINT : 'dprint';
SPRINT : 'sprint';
BPRINT : 'bprint';


IUMINUS : 'iuminus';
DUMINUS : 'duminus';


IADD : 'iadd';
ISUB : 'isub';
IMULT : 'imult';
IDIV : 'idiv';
IMOD : 'imod';
DADD : 'dadd';
DSUB : 'dsub';
DMULT : 'dmult';
DDIV : 'ddiv';
SADD : 'sadd';


AND : 'and';
OR : 'or';
NOT : 'not';


IEQ : 'ieq';
INEQ : 'ineq';
ILT : 'ilt';
ILEQ : 'ileq';
DEQ : 'deq';
DNEQ : 'dneq';
DLT : 'dlt';
DLEQ : 'dleq';
BEQ : 'beq';
BNEQ : 'bneq';
SEQ : 'seq';
SNEQ : 'sneq';


ITOS : 'itos';
ITOD : 'itod';
DTOS : 'dtos';
BTOS : 'btos';


INT_CONST : 'iconst';
DOUBLE_CONST : 'dconst';
STRING_CONST : 'sconst';
TCONST : 'tconst';
FCONST : 'fconst';


JUMP : 'jump';
JUMPT : 'jumpt';
JUMPF : 'jumpf';


GALLOC : 'galloc';
GLOAD : 'gload';
GSTORE : 'gstore';


HALT : 'halt';


DOUBLE : DIGIT+ '.' DIGIT* | '.' DIGIT+;
INT : DIGIT+ ;
LABEL: [a-z_A-Z][a-zA-Z0-9_]*;
STRING: '"' (ESC|.)*? '"' ;
NEWLINE:'\r'? '\n' ;
WS : [ \t]+ -> skip ;

fragment DIGIT : [0-9] ;
fragment ESC : '\\"' | '\\\\' ; // 2-char sequences \" and \\

