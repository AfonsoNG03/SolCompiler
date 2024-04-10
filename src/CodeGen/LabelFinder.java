package CodeGen; /***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
 ***/

import Tasm.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class LabelFinder extends TasmBaseVisitor<Void> {
    private Map<String, Integer> labels = new java.util.HashMap<>();
    private int codeLine = 0;
    private boolean haltFound = false;
    //Apos certificarem-se que a gramtica esta correcta, implementem as verificaçoes
    //semanticas referidas na seccao 2.3 deste documento. Para tal devem usar um
    //visitor ou um listener que percorre a arvore de parsing e processa as etiquetas
    //transformando-as em numeros inteiros que correspondem a linhas de codigo.
    @Override
    public Void visitLabel(TasmParser.LabelContext ctx) {
        for (TerminalNode label: ctx.LABEL()) {
            if (labels.containsKey(label.getText())){
                new ErrorHandler("ERROR: "+ "line "+ codeLine + "- Label \"" + label.getText() + "\" is already defined!");
            }
            labels.put(label.getText(), codeLine);
        }
        visit(ctx.inst());
        return null;
    }

    @Override public Void visitHalt(TasmParser.HaltContext ctx) {
        haltFound = true;
        codeLine++;
        return null;
    }

    @Override
    public Void visitMemoryOp(TasmParser.MemoryOpContext ctx) {
        codeLine++;
        return null;
    }

    @Override
    public Void visitIntConst(TasmParser.IntConstContext ctx) {
        codeLine++;
        return null;
    }

    @Override
    public Void visitDoubleConst(TasmParser.DoubleConstContext ctx) {
        codeLine++;
        return null;
    }

    @Override
    public Void visitStringConst(TasmParser.StringConstContext ctx) {
        visit(ctx.STRING());
        codeLine++;
        return null;
    }

    @Override
    public Void visitBooleanConst(TasmParser.BooleanConstContext ctx) {
        codeLine++;
        return null;
    }

    @Override
    public Void visitUnaryOp(TasmParser.UnaryOpContext ctx) {
        codeLine++;
        return null;
    }

    @Override
    public Void visitJumpStat(TasmParser.JumpStatContext ctx) {
        codeLine++;
        visit(ctx.LABEL());
        return null;
    }

    @Override
    public Void visitCompareOp(TasmParser.CompareOpContext ctx) {
        codeLine++;
        return null;
    }

    @Override
    public Void visitBinaryOp(TasmParser.BinaryOpContext ctx) {
        codeLine++;
        return null;
    }

    @Override
    public Void visitOperations(TasmParser.OperationsContext ctx) {
        codeLine++;
        return null;
    }

    @Override
    public Void visitTypeConversion(TasmParser.TypeConversionContext ctx) {
        codeLine++;
        return null;
    }
    @Override
    public Void visitPrintStat(TasmParser.PrintStatContext ctx) {
        codeLine++;
        return null;
    }

    public Map<String, Integer> getLabels() {
        return labels;
    }

    public void isHaltFound() {
        if (!haltFound) {
            new ErrorHandler("ERROR: "+ "halt instruction not found");
        }
    }
}
