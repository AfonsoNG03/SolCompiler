package CodeGen;

import Sol.SolLexer;
import Sol.SolParser;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class SemanticErrors {
    int numErr;
    ParseTreeProperty<Type> values;

    public SemanticErrors( ParseTreeProperty<Type> values) {
        this.numErr = 0;
        this.values = values;
    }

    public int getNumErr() {
        return this.numErr;
    }

    //Acho que dá para fazer assim um erro genérico ao invés de estar a especificar
    public void GenericErr(SolParser.InstContext ctx) {
        //line 2:20 error: operator - is invalid between bool and int
        System.out.println("line "+ctx.start.getLine() + " error: " + ctx.getChild(1) + " is invalid between " + values.get(ctx.getChild(0)) + " and " + values.get(ctx.getChild(2)));
        numErr++;
    }

    public void binaryOrOpErr(SolParser.OrContext ctx) {
        System.out.println("line "+ctx.start.getLine()+" error: invalid types for operation "+ ctx.op.getText());
        numErr++;
    }

    public void addSubOpErr(SolParser.AddSubContext ctx) {
        //line 2:20 error: operator - is invalid between bool and int
        System.out.println("line "+ctx.start.getLine()+" error: " + ctx.op.getText() + " is invalid between " + values.get(ctx.inst(0)) + " and " + values.get(ctx.inst(1)));
        numErr++;
    }

    public void equalOpErr(SolParser.EqualContext ctx) {
        System.out.println("line "+ctx.start.getLine()+" error: invalid types for operation "+ ctx.op.getText());
        numErr++;
    }

    public void andOpErr(SolParser.AndContext ctx) {
        System.out.println("line "+ctx.start.getLine()+" error: invalid types for operation "+ ctx.op.getText());
        numErr++;
    }

    public void relOpErr(SolParser.RelContext ctx) {
        System.out.println("line "+ctx.start.getLine()+" error: invalid types for operation "+ ctx.op.getText());
        numErr++;
    }

    public void multDivOpErr(SolParser.MultDivContext ctx) {
        System.out.println("line "+ctx.start.getLine()+" error: invalid types for operation "+ ctx.op.getText());
        numErr++;
    }

    public void unaryOpErr(SolParser.UnaryContext ctx) {
        System.out.println("line "+ctx.start.getLine()+" error: invalid types for operation "+ ctx.op.getText());
        numErr++;
    }

}
