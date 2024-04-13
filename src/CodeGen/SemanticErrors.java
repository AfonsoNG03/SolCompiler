package CodeGen;

import Sol.SolLexer;
import Sol.SolParser;

public class SemanticErrors {
    int numErr;

    public SemanticErrors() {
        this.numErr = 0;
    }

    public int getNumErr() {
        return this.numErr;
    }

    public void binaryOrOpErr(SolParser.OrContext ctx) {
        System.out.println("line "+ctx.start.getLine()+" error: invalid types for operation "+ ctx.op.getText());
        numErr++;
    }

    public void addSubOpErr(SolParser.AddSubContext ctx) {
        System.out.println("line "+ctx.start.getLine()+" error: invalid types for operation "+ ctx.op.getText());
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
