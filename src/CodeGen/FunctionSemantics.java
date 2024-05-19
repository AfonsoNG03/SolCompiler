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
    Scope currentScope;
    SemanticErrors sErr = new SemanticErrors(values);

    public FunctionSemantics(Scope scope, ParseTreeProperty<Type> values) {
        super();
        this.currentScope = scope;
        this.values = values;
    }

    @Override public Void visitProg(SolParser.ProgContext ctx) {
        visitChildren(ctx);
        if(!currentScope.contains("main")){
            sErr.TesteErro("");
            new ErrorHandler("error: Main function not found");
        }
        return null;
    }

    @Override public Void visitFunctionCallExpression(SolParser.FunctionCallExpressionContext ctx) {
        FunctionSymbol function;
        if (currentScope.resolve(ctx.ID().getText()) == null) {
            sErr.TesteErro("line " + ctx.start.getLine() + " error: Function " + ctx.ID().getText() + " not found");
        } else {
            Symbol functionTemp = currentScope.resolve(ctx.ID().getText());
            if (!(functionTemp instanceof FunctionSymbol)) {
                sErr.TesteErro("line " + ctx.start.getLine() + " error: " + ctx.ID().getText() + " is not a function");
                return null;
            } else
                function = (FunctionSymbol) functionTemp;
            if (function.get_arguments().size() != ctx.inst().size()) {
                sErr.TesteErro("line " + ctx.start.getLine() + " error: Function " + ctx.ID().getText() + " has " + function.get_arguments().size() + " parameters");
            } else {
                for (int i = 0; i < ctx.inst().size(); i++) {
                    Type type = values.get(ctx.inst(i));
                    if (!type.equals(function.get_arguments().get(i).getType())) {
                        if (!(type == Type.INT && function.get_arguments().get(i).getType() == Type.REAL))
                            sErr.TesteErro("line " + ctx.start.getLine() + " error: Function " + ctx.ID().getText() + " parameter " + i + " is of type " + function.get_arguments().get(i).getType());
                    }
                }
            }
            if (function.getType() != Type.VOID){
                sErr.TesteErro("line " + ctx.start.getLine() + " error: Value of " + ctx.ID().getText() + " should be assigned to a variable");
            }
        }
        return null;
    }

    @Override public Void visitFunction(SolParser.FunctionContext ctx) {
        Scope GlobalScope = currentScope;
        for (Scope child: currentScope.getChildScopes()) {
            if (child.getName().equals(ctx.ID(0).getText())) {
                currentScope = child;
            }
        }
        visitChildren(ctx);
        currentScope = GlobalScope;
        return null;
    }

    @Override public Void visitFunctionCall(SolParser.FunctionCallContext ctx) {
        FunctionSymbol function;
        if (currentScope.resolve(ctx.ID().getText()) == null) {
            sErr.TesteErro("line " + ctx.start.getLine() + " error: Function " + ctx.ID().getText() + " not found");
        } else {
            Symbol functionTemp = currentScope.resolve(ctx.ID().getText());
            if (!(functionTemp instanceof FunctionSymbol)) {
                sErr.TesteErro("line " + ctx.start.getLine() + " error: " + ctx.ID().getText() + " is not a function");
                return null;
            } else
                function = (FunctionSymbol) functionTemp;
            if (function.get_arguments().size() != ctx.inst().size()) {
                sErr.TesteErro("line " + ctx.start.getLine() + " error: Function " + ctx.ID().getText() + " has " + function.get_arguments().size() + " parameters");
            } else {
                for (int i = 0; i < ctx.inst().size(); i++) {
                    Type type = values.get(ctx.inst(i));
                    if (!type.equals(function.get_arguments().get(i).getType())) {
                        if (!(type == Type.INT && function.get_arguments().get(i).getType() == Type.REAL))
                            sErr.TesteErro("line " + ctx.start.getLine() + " error: Function " + ctx.ID().getText() + " parameter " + i + " is of type " + function.get_arguments().get(i).getType());
                    }
                }
            }
            values.put(ctx, function.getType());
        }
        return null;
    }

    @Override public Void visitAssign(SolParser.AssignContext ctx) {
        visitChildren(ctx);
        Symbol s = null;
        if(ctx.inst() instanceof SolParser.FunctionCallContext)
            s = currentScope.resolve(ctx.ID().getText());
        if (s == null) {
            return null;
        }
        else if(s.getType() == Type.REAL && values.get(ctx.inst()) == Type.INT){
            values.put(ctx, Type.REAL);
        }
        else if(s.getType() != values.get(ctx.inst())){
            sErr.TesteErro("line " + ctx.start.getLine() + " error: Type mismatch");
        }
            return null;
    }

    public ParseTreeProperty<Type> getValues() {
        return values;
    }
    public Scope getCurrentScope(){
        return currentScope;
    }
}
