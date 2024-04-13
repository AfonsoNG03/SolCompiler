package CodeGen; /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/


import Sol.*;
import org.antlr.v4.runtime.tree.*;


public class Annotator extends SolBaseVisitor<Void> {
    ParseTreeProperty<Type> values = new ParseTreeProperty<Type>();
    SemanticErrors sErr = new SemanticErrors();

    @Override public Void visitProg(SolParser.ProgContext ctx) {
        visitChildren(ctx);
        int nErr = this.sErr.getNumErr();
        if(nErr > 0) {
            new ErrorHandler(nErr + " errors found!");
            System.exit(0);
        }
        return null;
    }

    @Override public Void visitLine(SolParser.LineContext ctx) {
        visitChildren(ctx);
        Type type = values.get(ctx.getChild(1));
        values.put(ctx, type);
        return null;
    }

    @Override public Void visitOr(SolParser.OrContext ctx) {
        visitChildren(ctx);
        Type type1 = values.get(ctx.getChild(0));
        Type type2 = values.get(ctx.getChild(2));
        Type finalType = TypeChecker.BinaryOperationCheck(type1, type2);
        if(finalType == Type.ERRO) sErr.binaryOrOpErr(ctx);
        values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitAddSub(SolParser.AddSubContext ctx) {
        visitChildren(ctx);
        Type type1 = values.get(ctx.getChild(0));
        Type type2 = values.get(ctx.getChild(2));
        Type finalType = Type.ERRO;

        if (ctx.op.getType() == SolParser.ADD)
            finalType = TypeChecker.addCheck(type1, type2);
        else if (ctx.op.getType() == SolParser.SUB)
            finalType = TypeChecker.genericOperationCheck(type1, type2);
        if(finalType == Type.ERRO) sErr.addSubOpErr(ctx);
        values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitEqual(SolParser.EqualContext ctx) {
        visitChildren(ctx);
        Type type1 = values.get(ctx.getChild(0));
        Type type2 = values.get(ctx.getChild(2));
        Type finalType = TypeChecker.equalCheck(type1, type2);
        if(finalType == Type.ERRO) sErr.equalOpErr(ctx);
        values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitAnd(SolParser.AndContext ctx) {
        visitChildren(ctx);
        Type type1 = values.get(ctx.getChild(0));
        Type type2 = values.get(ctx.getChild(2));
        Type finalType = TypeChecker.BinaryOperationCheck(type1, type2);
        if(finalType == Type.ERRO) sErr.andOpErr(ctx);
        values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitLiteral(SolParser.LiteralContext ctx) {
        switch (ctx.op.getType()) {
            case SolParser.INT:
                values.put(ctx, Type.INT);
                break;
            case SolParser.DOUBLE:
                values.put(ctx, Type.REAL);
                break;
            case SolParser.STRING:
                values.put(ctx, Type.STRING);
                break;
            case SolParser.TRUE, SolParser.FALSE:
                values.put(ctx, Type.BOOL);
                break;
        }
        return null;
    }

    @Override public Void visitRel(SolParser.RelContext ctx) {
        visitChildren(ctx);
        Type type1 = values.get(ctx.getChild(0));
        Type type2 = values.get(ctx.getChild(2));
        Type finalType = TypeChecker.RelOpCheck(type1, type2);
        if(finalType == Type.ERRO) sErr.relOpErr(ctx);
        values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitUnary(SolParser.UnaryContext ctx) {
        visitChildren(ctx);
        Type type = values.get(ctx.getChild(1));
        Type finalType = Type.ERRO;
        if (ctx.op.getType() == SolParser.SUB)
            finalType = TypeChecker.UnaryCheck(type);
        else if (ctx.op.getType() == SolParser.NOT)
            finalType = TypeChecker.NotCheck(type);
        if(finalType == Type.ERRO) sErr.unaryOpErr(ctx);
        values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitParen(SolParser.ParenContext ctx) {
        visitChildren(ctx);
        Type type = values.get(ctx.getChild(1));
        values.put(ctx, type);
        return null;
    }

    @Override public Void visitMultDiv(SolParser.MultDivContext ctx) {
        visitChildren(ctx);
        Type type1 = values.get(ctx.getChild(0));
        Type type2 = values.get(ctx.getChild(2));
        Type finalType;
        if (ctx.op.getType() == SolParser.MOD)
            finalType = TypeChecker.modCheck(type1, type2);
        else
            finalType = TypeChecker.genericOperationCheck(type1, type2);
        if(finalType == Type.ERRO) sErr.multDivOpErr(ctx);
        values.put(ctx, finalType);
        return null;
    }

    public ParseTreeProperty<Type> getValues() {
        return values;
    }
}
