package CodeGen; /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/


import Sol.*;
import SymbolTable.FunctionSymbol;
import SymbolTable.Scope;
import SymbolTable.Symbol;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

import java.util.*;

public class FunctionSemantics extends SolBaseVisitor<Void> {
    ParseTreeProperty<Type> values = new ParseTreeProperty<Type>();
    Map<String, Object> vars = new HashMap<>();
    Scope currentScope = new Scope(null);
    SemanticErrors sErr = new SemanticErrors(values);
    Boolean LineError = false;
    Type Return = Type.VOID;
    Boolean hasReturn = false;

    @Override public Void visitProg(SolParser.ProgContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitFunctionCallExpression(SolParser.FunctionCallExpressionContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitFunction(SolParser.FunctionContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitReturn(SolParser.ReturnContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitFunctionCall(SolParser.FunctionCallContext ctx) {
        visitChildren(ctx);
        return null;
    }


    @Override public Void visitVar(SolParser.VarContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitId(SolParser.IdContext ctx) {
        return null;
    }

    @Override public Void visitAssign(SolParser.AssignContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitAssignInst(SolParser.AssignInstContext ctx) {
        visitChildren(ctx);
        return null;
    }


    @Override public Void visitType(SolParser.TypeContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitTypeFunction(SolParser.TypeFunctionContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitInstruction(SolParser.InstructionContext ctx) {
        visitChildren(ctx);
        return null;
    }


    @Override public Void visitPrint(SolParser.PrintContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitBlockCode(SolParser.BlockCodeContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitWhile(SolParser.WhileContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitFor(SolParser.ForContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitIf(SolParser.IfContext ctx) {
        visitChildren(ctx);
        return null;
    }

    //Check if it is inside of while or for loop
    @Override public Void visitBreakStatement(SolParser.BreakStatementContext ctx) {
        visitChildren(ctx);
        return null;
    }


    @Override public Void visitOr(SolParser.OrContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitAddSub(SolParser.AddSubContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitEqual(SolParser.EqualContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitAnd(SolParser.AndContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitLiteral(SolParser.LiteralContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitRel(SolParser.RelContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitUnary(SolParser.UnaryContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitParen(SolParser.ParenContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitMultDiv(SolParser.MultDivContext ctx) {
        visitChildren(ctx);
        return null;
    }

    public ParseTreeProperty<Type> getValues() {
        return values;
    }

    public Map<String, Object> getVars() {
        return vars;
    }

    public Scope getCurrentScope(){
        return currentScope;
    }
}
