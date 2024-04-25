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

import java.util.*;

public class Annotator extends SolBaseVisitor<Void> {
    ParseTreeProperty<Type> values = new ParseTreeProperty<Type>();
    Map<String, Object> vars = new HashMap<>();
    SemanticErrors sErr = new SemanticErrors(values);
    Boolean LineError = false;

    @Override public Void visitProg(SolParser.ProgContext ctx) {
        visitChildren(ctx);
        int nErr = this.sErr.getNumErr();
        if(nErr > 0) {
            new ErrorHandler(nErr + " errors found!");
        }
        return null;
    }

    @Override public Void visitVar(SolParser.VarContext ctx) {
        LineError = false;
        visitChildren(ctx);
        Type type = values.get(ctx.type());
        for (SolParser.AssignInstContext assignCtx: ctx.assignInst() ) {
            Type instType = values.get(assignCtx);
            if (instType == null)
                continue;
            if (instType != type) {
                sErr.VarErr(ctx, instType);
                LineError = true;
                break;
            }
        }
        return null;
    }

    @Override public Void visitId(SolParser.IdContext ctx) {
        if (LineError) return null;
        if (!vars.containsKey(ctx.ID().getText()))
            sErr.IDErr(ctx);
        else
            values.put(ctx, (Type) vars.get(ctx.ID().getText()));
        return null;
    }


    @Override public Void visitAssignInst(SolParser.AssignInstContext ctx) {
        if (LineError) return null;
        visitChildren(ctx);
        Type type = values.get(ctx.inst());
        values.put(ctx, type);
        if (vars.containsKey(ctx.ID().getText())){
            sErr.AssingErr(ctx);
        }
        vars.put(ctx.ID().getText(), type);
        return null;
    }


    @Override public Void visitType(SolParser.TypeContext ctx) {
        if (LineError) return null;
        switch (ctx.op.getType()) {
            case SolParser.TYPEINT:
                values.put(ctx, Type.INT);
                break;
            case SolParser.TYPEDOUBLE:
                values.put(ctx, Type.REAL);
                break;
            case SolParser.TYPESTRING:
                values.put(ctx, Type.STRING);
                break;
            case SolParser.TYPEBOOL:
                values.put(ctx, Type.BOOL);
                break;
        }
        return null;
    }

    /*@Override public Void visitLine(SolParser.LineContext ctx) {
        LineError = false;
        visitChildren(ctx);
        Type type = values.get(ctx.inst());
        values.put(ctx, type);
        //System.out.println("Line " + ctx.start.getLine() + " has type " + type);
        return null;
    }*/

    @Override public Void visitOr(SolParser.OrContext ctx) {
        visitChildren(ctx);
        if (LineError) return null;
        Type type1 = values.get(ctx.inst(0));
        Type type2 = values.get(ctx.inst(1));
        Type finalType = TypeChecker.BinaryOperationCheck(type1, type2);
        if(finalType == Type.ERRO) {
            sErr.GenericErr(ctx);
            LineError = true;
        }
        values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitAddSub(SolParser.AddSubContext ctx) {
        visitChildren(ctx);
        if (LineError) return null;
        Type type1 = values.get(ctx.inst(0));
        Type type2 = values.get(ctx.inst(1));
        Type finalType = Type.ERRO;

        if (ctx.op.getType() == SolParser.ADD)
            finalType = TypeChecker.addCheck(type1, type2);
        else if (ctx.op.getType() == SolParser.SUB)
            finalType = TypeChecker.genericOperationCheck(type1, type2);
        if(finalType == Type.ERRO) {
            sErr.GenericErr(ctx);
            LineError = true;
        }
        values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitEqual(SolParser.EqualContext ctx) {
        visitChildren(ctx);
        if (LineError) return null;
        Type type1 = values.get(ctx.inst(0));
        Type type2 = values.get(ctx.inst(1));
        Type finalType = TypeChecker.equalCheck(type1, type2);
        if(finalType == Type.ERRO) {
            sErr.GenericErr(ctx);
            LineError = true;
        }
        values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitAnd(SolParser.AndContext ctx) {
        visitChildren(ctx);
        if (LineError) return null;
        Type type1 = values.get(ctx.inst(0));
        Type type2 = values.get(ctx.inst(1));
        Type finalType = TypeChecker.BinaryOperationCheck(type1, type2);
        if(finalType == Type.ERRO) {
            sErr.GenericErr(ctx);
            LineError = true;
        }
        values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitLiteral(SolParser.LiteralContext ctx) {
        if (LineError) return null;
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
        if (LineError) return null;
        Type type1 = values.get(ctx.inst(0));
        Type type2 = values.get(ctx.inst(1));
        Type finalType = TypeChecker.RelOpCheck(type1, type2);
        if(finalType == Type.ERRO) {
            sErr.GenericErr(ctx);
            LineError = true;
        }
        values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitUnary(SolParser.UnaryContext ctx) {
        visitChildren(ctx);
        if (LineError) return null;
        Type type = values.get(ctx.inst());
        Type finalType = Type.ERRO;
        if (ctx.op.getType() == SolParser.SUB)
            finalType = TypeChecker.UnaryCheck(type);
        else if (ctx.op.getType() == SolParser.NOT)
            finalType = TypeChecker.NotCheck(type);
        if(finalType == Type.ERRO) {
            sErr.unaryOpErr(ctx);
            LineError = true;
        }
            values.put(ctx, finalType);
        return null;
    }

    @Override public Void visitParen(SolParser.ParenContext ctx) {
        visitChildren(ctx);
        if (LineError) return null;
        Type type = values.get(ctx.inst());
        values.put(ctx, type);
        return null;
    }

    @Override public Void visitMultDiv(SolParser.MultDivContext ctx) {
        visitChildren(ctx);
        if (LineError) return null;
        Type type1 = values.get(ctx.inst(0));
        Type type2 = values.get(ctx.inst(1));
        Type finalType;
        if (ctx.op.getType() == SolParser.MOD)
            finalType = TypeChecker.modCheck(type1, type2);
        else
            finalType = TypeChecker.genericOperationCheck(type1, type2);
        if(finalType == Type.ERRO) {
            sErr.GenericErr(ctx);
            LineError = true;
        }
        values.put(ctx, finalType);
        return null;
    }

    public ParseTreeProperty<Type> getValues() {
        return values;
    }
}
