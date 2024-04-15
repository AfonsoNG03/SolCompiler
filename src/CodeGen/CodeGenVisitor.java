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

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CodeGenVisitor extends SolBaseVisitor<Void> {
    private ArrayList<Instruction> instructions = new ArrayList<>();
    private ArrayList<Instruction> constantPool = new ArrayList<>();
    ParseTreeProperty<Type> values;

    public CodeGenVisitor( ParseTreeProperty<Type> values) {
        super();
        this.values = values;
    }


    @Override public Void visitLine(SolParser.LineContext ctx) {
        visitChildren(ctx);
        Type type = values.get(ctx);
        switch (type) {
            case Type.INT:
                emit(OpCode.iprint);
                break;
            case Type.REAL:
                emit(OpCode.dprint);
                break;
            case Type.STRING:
                emit(OpCode.sprint);
                break;
            case Type.BOOL:
                emit(OpCode.bprint);
                break;
        }

        return null;
    }

    @Override public Void visitOr(SolParser.OrContext ctx) {
        Type type = values.get(ctx.getParent());
        values.put(ctx, type);
        visitChildren(ctx);
        emit(OpCode.or);
        return null;
    }

    @Override public Void visitAddSub(SolParser.AddSubContext ctx) {
        Type type = values.get(ctx.getParent());
        values.put(ctx, type);
        visitChildren(ctx);
        if (ctx.op.getType() == SolParser.ADD) {
            if (type == Type.INT)
                emit(OpCode.iadd);
            else if (type == Type.REAL)
                emit(OpCode.dadd);
            else if (type == Type.STRING)
                emit(OpCode.sadd);
        } else if (ctx.op.getType() == SolParser.SUB) {
            if (type == Type.INT)
                emit(OpCode.isub);
            else if (type == Type.REAL)
                emit(OpCode.dsub);
        }
        return null;
    }

    @Override public Void visitEqual(SolParser.EqualContext ctx) {
        Type type1 = values.get(ctx.getChild(0));
        Type type2 = values.get(ctx.getChild(2));
        Type finalType = TypeChecker.equalCheckGenerator(type1, type2);
        values.put(ctx, finalType);
        visitChildren(ctx);

        switch (finalType) {
            case Type.INT:
                if (ctx.op.getType() == SolParser.EQ)
                    emit(OpCode.ieq);
                else
                    emit(OpCode.ineq);
                break;
            case Type.REAL:
                if (ctx.op.getType() == SolParser.EQ)
                    emit(OpCode.deq);
                else
                    emit(OpCode.dneq);
                break;
            case Type.STRING:
                if (ctx.op.getType() == SolParser.EQ)
                    emit(OpCode.seq);
                else
                    emit(OpCode.sneq);
                break;
            case Type.BOOL:
                if (ctx.op.getType() == SolParser.EQ)
                    emit(OpCode.beq);
                else
                    emit(OpCode.bneq);
                break;
        }
        if(values.get(ctx.getParent()) == Type.STRING)
            emit(OpCode.btos);
        return null;
    }

    @Override public Void visitAnd(SolParser.AndContext ctx) {
        Type type = values.get(ctx.getParent());
        values.put(ctx, type);
        visitChildren(ctx);
        emit(OpCode.and);
        return null;
    }

    @Override public Void visitLiteral(SolParser.LiteralContext ctx) {
        Type type = values.get(ctx.getParent());
        switch (ctx.op.getType()) {
            case SolParser.INT:
                emit(OpCode.iconst, Integer.parseInt(ctx.getText()));
                if (type == Type.REAL)
                    emit(OpCode.itod);
                if (type == Type.STRING)
                    emit(OpCode.itos);
                break;
            case SolParser.DOUBLE:
                emit(OpCode.dconst, Double.parseDouble(ctx.getText()));
                if (type == Type.STRING)
                    emit(OpCode.dtos);
                break;
            case SolParser.STRING:
                String noEscapes = ctx.getText().substring(1, ctx.STRING().getText().length()-1).replace("\\", "");
                emit(OpCode.sconst, noEscapes);
                break;
            case SolParser.TRUE:
                emit(OpCode.tconst);
                if (type == Type.STRING)
                    emit(OpCode.btos);
                break;
            case SolParser.FALSE:
                emit(OpCode.fconst);
                if (type == Type.STRING)
                    emit(OpCode.btos);
                break;
        }
        return null;
    }

    @Override public Void visitRel(SolParser.RelContext ctx) {
        Type type1 = values.get(ctx.getChild(0));
        Type type2 = values.get(ctx.getChild(2));
        Type finalType = TypeChecker.RelOpCheckGenerator(type1, type2);
        values.put(ctx, finalType);
        if (ctx.op.getType() == SolParser.GT || ctx.op.getType() == SolParser.GE) {
            visit(ctx.getChild(2));
            visit(ctx.getChild(0));
        } else
            visitChildren(ctx);

        switch (finalType) {
            case Type.INT:
                if (ctx.op.getType() == SolParser.LT || ctx.op.getType() == SolParser.GT)
                    emit(OpCode.ilt);
                else if (ctx.op.getType() == SolParser.LE || ctx.op.getType() == SolParser.GE)
                    emit(OpCode.ileq);
                break;
            case Type.REAL:
                if (ctx.op.getType() == SolParser.LT || ctx.op.getType() == SolParser.GT)
                    emit(OpCode.dlt);
                else if (ctx.op.getType() == SolParser.LE || ctx.op.getType() == SolParser.GE)
                    emit(OpCode.dlt);
                break;
        }

        if (values.get(ctx.getParent()) == Type.STRING)
            emit(OpCode.btos);
        return null;
    }

    @Override public Void visitUnary(SolParser.UnaryContext ctx) {
        Type type = values.get(ctx.getParent());
        values.put(ctx, type);
        visitChildren(ctx);
        if (ctx.op.getType() == SolParser.SUB)
            if (type == Type.INT)
                emit(OpCode.iuminus);
            else if (type == Type.REAL)
                emit(OpCode.duminus);
        else if (ctx.op.getType() == SolParser.NOT)
            emit(OpCode.not);
        return null;
    }

    @Override public Void visitParen(SolParser.ParenContext ctx) {
        Type type = values.get(ctx.getParent());
        values.put(ctx, type);
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitMultDiv(SolParser.MultDivContext ctx) {
        Type type = values.get(ctx.getParent());
        values.put(ctx, type);
        visitChildren(ctx);
        if (ctx.op.getType() == SolParser.MOD)
            emit(OpCode.imod);
        else if (ctx.op.getType() == SolParser.MULT){
            if (type == Type.INT)
                emit(OpCode.imul);
            else if (type == Type.REAL)
                emit(OpCode.dmul);}
        else if (ctx.op.getType() == SolParser.DIV){
            if (type == Type.INT)
                emit(OpCode.idiv);
            else if (type == Type.REAL)
                emit(OpCode.ddiv);}
        return null;
    }


    public void emit(OpCode opCode) {
        instructions.add(new Instruction(opCode));
    }

    public void emit(OpCode opCode, int arg) {
        instructions.add(new IntInstruction(opCode, arg));
    }

    public void emit(OpCode opCode, double arg) {
        instructions.add(new IntInstruction(opCode, constantPool.size()));
        constantPool.add(new DoubleInstruction(opCode, arg));
    }

    public void emit(OpCode opCode, String arg) {
        instructions.add(new IntInstruction(opCode, constantPool.size()));
        constantPool.add(new StringInstruction(opCode, arg));
    }

    public void emit(OpCode opCode, boolean arg) {
        instructions.add(new BooleanInstruction(opCode, arg));
    }

    public void write(DataOutputStream dos) throws IOException {
        try {
            for (Instruction instr : instructions) {
                instr.write(dos);
            }
            new Instruction(OpCode.end).write(dos);
            for (Instruction instr : constantPool) {
                instr.write(dos);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //print the instructions + the respective bytecode
    public void print() {
        int i = 0;
        System.out.println("Instructions:");
        for (Instruction instr : instructions) {
            System.out.print(i++ + ": ");
            if (instr instanceof IntInstruction) {
                System.out.println(instr.getOp() + " " + ((IntInstruction) instr).getArg());
            } else if (instr instanceof DoubleInstruction) {
                System.out.println(instr.getOp() + " " + ((DoubleInstruction) instr).getArg());
            } else if (instr instanceof StringInstruction) {
                System.out.println(instr.getOp() + " " + ((StringInstruction) instr).getArg());
            } else if (instr instanceof BooleanInstruction) {
                System.out.println(instr.getOp() + " " + ((BooleanInstruction) instr).getArg());
            }
            else {
                System.out.println(instr.getOp());
            }
        }
        if (constantPool.size() > 0)
            System.out.println("Constant Pool:");
        else
            return;
        int j=0;
        for (Instruction instr : constantPool) {
            if (instr instanceof DoubleInstruction) {
                System.out.println(j + ": \"" + ((DoubleInstruction) instr).getArg() + "\"");
            } else if (instr instanceof StringInstruction) {
                System.out.println(j + ": \"" + ((StringInstruction) instr).getArg() + "\"");
            }
            j++;
        }
    }
}
