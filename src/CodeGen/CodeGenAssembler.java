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


public class CodeGenAssembler extends TasmBaseVisitor<Void> {
    private ArrayList<Instruction> instructions = new ArrayList<>();
    private ArrayList<Instruction> constantPool = new ArrayList<>();
    private Map<String, Integer> labels;
    public CodeGenAssembler(Map<String, Integer> labels) {
        this.labels = labels;
    }

    @Override public Void visitHalt(TasmParser.HaltContext ctx) {
        emit(OpCode.halt);
        return null;
    }

    @Override
    public Void visitNewInsts(TasmParser.NewInstsContext ctx) {
        visit(ctx.INT());
        if(ctx.op.getType() == TasmParser.LALLOC) {
            emit(OpCode.lalloc, Integer.parseInt(ctx.INT().getText()));
        } else if(ctx.op.getType() == TasmParser.LLOAD) {
            emit(OpCode.lload, Integer.parseInt(ctx.INT().getText()));
        } else if(ctx.op.getType() == TasmParser.LSTORE) {
            emit(OpCode.lstore, Integer.parseInt(ctx.INT().getText()));
        } else if(ctx.op.getType() == TasmParser.POP) {
            emit(OpCode.pop, Integer.parseInt(ctx.INT().getText()));
        } else if(ctx.op.getType() == TasmParser.CALL) {
            emit(OpCode.call, Integer.parseInt(ctx.INT().getText()));
        } else if(ctx.op.getType() == TasmParser.RETVAL) {
            emit(OpCode.retval, Integer.parseInt(ctx.INT().getText()));
        } else if(ctx.op.getType() == TasmParser.RET) {
            emit(OpCode.ret, Integer.parseInt(ctx.INT().getText()));
        }
        return null;
    }

    @Override
    public Void visitMemoryOp(TasmParser.MemoryOpContext ctx) {
        visit(ctx.INT());
        if (ctx.op.getType() == TasmParser.GALLOC) {
            emit(OpCode.galloc, Integer.parseInt(ctx.INT().getText()));
        } else if (ctx.op.getType() == TasmParser.GLOAD) {
            emit(OpCode.gload, Integer.parseInt(ctx.INT().getText()));
        } else{
            emit(OpCode.gstore, Integer.parseInt(ctx.INT().getText()));
        }

        return null;
    }

    @Override
    public Void visitIntConst(TasmParser.IntConstContext ctx) {
        visit(ctx.INT());
        emit(OpCode.iconst, Integer.parseInt(ctx.INT().getText()));
        return null;
    }

    @Override
    public Void visitDoubleConst(TasmParser.DoubleConstContext ctx) {
        if(ctx.stop.getType() == TasmParser.INT) {
            visit(ctx.INT());
            emit(OpCode.dconst, Double.parseDouble(ctx.INT().getText()));
        }
        else {
            visit(ctx.DOUBLE());
            emit(OpCode.dconst, Double.parseDouble(ctx.DOUBLE().getText()));
        }
        return null;
    }

    @Override
    public Void visitStringConst(TasmParser.StringConstContext ctx) {
        visit(ctx.STRING());
        String noEscapes = ctx.STRING().getText().substring(1, ctx.STRING().getText().length()-1).replace("\\", "");
        emit(OpCode.sconst, noEscapes);
        return null;
    }

    @Override
    public Void visitBooleanConst(TasmParser.BooleanConstContext ctx) {
        if (ctx.op.getType() == TasmParser.TCONST) {
            emit(OpCode.tconst);
        } else {
            emit(OpCode.fconst);
        }
        return null;
    }

    @Override
    public Void visitUnaryOp(TasmParser.UnaryOpContext ctx) {
        if (ctx.op.getType() == TasmParser.IUMINUS) {
            emit(OpCode.iuminus);
        } else {
            emit(OpCode.duminus);
        }
        return null;
    }

    @Override
    public Void visitJumpStat(TasmParser.JumpStatContext ctx) {
        visit(ctx.LABEL());
        if (!labels.containsKey(ctx.LABEL().getText()))
            new ErrorHandler("ERROR: Label not defined: " + ctx.LABEL().getText());
        if (ctx.op.getType() == TasmParser.JUMP) {
            emit(OpCode.jump, labels.get(ctx.LABEL().getText()));
        } else if (ctx.op.getType() == TasmParser.JUMPT) {
            emit(OpCode.jumpt, labels.get(ctx.LABEL().getText()));
        } else {
            emit(OpCode.jumpf, labels.get(ctx.LABEL().getText()));
        }
        return null;
    }

    @Override
    public Void visitCompareOp(TasmParser.CompareOpContext ctx) {
        if (ctx.op.getType() == TasmParser.IEQ) {
            emit(OpCode.ieq);
        } else if (ctx.op.getType() == TasmParser.INEQ) {
            emit(OpCode.ineq);
        } else if (ctx.op.getType() == TasmParser.ILT) {
            emit(OpCode.ilt);
        } else if (ctx.op.getType() == TasmParser.ILEQ) {
            emit(OpCode.ileq);
        } else if (ctx.op.getType() == TasmParser.DEQ) {
            emit(OpCode.deq);
        } else if (ctx.op.getType() == TasmParser.DNEQ) {
            emit(OpCode.dneq);
        } else if (ctx.op.getType() == TasmParser.DLT) {
            emit(OpCode.dlt);
        } else if (ctx.op.getType() == TasmParser.DLEQ) {
            emit(OpCode.dleq);
        } else if (ctx.op.getType() == TasmParser.BEQ) {
            emit(OpCode.beq);
        } else if (ctx.op.getType() == TasmParser.BNEQ){
            emit(OpCode.bneq);
        } else if (ctx.op.getType() == TasmParser.SEQ) {
            emit(OpCode.seq);
        } else {
            emit(OpCode.sneq);
        }
        return null;
    }

    @Override
    public Void visitBinaryOp(TasmParser.BinaryOpContext ctx) {
        if (ctx.op.getType() == TasmParser.AND) {
            emit(OpCode.and);
        } else if (ctx.op.getType() == TasmParser.OR) {
            emit(OpCode.or);
        } else {
            emit(OpCode.not);
        }
        return null;
    }

    @Override
    public Void visitOperations(TasmParser.OperationsContext ctx) {
        if (ctx.op.getType() == TasmParser.IADD)
            emit(OpCode.iadd);
        else if (ctx.op.getType() == TasmParser.ISUB)
            emit(OpCode.isub);
        else if (ctx.op.getType() == TasmParser.IMULT)
            emit(OpCode.imul);
        else if (ctx.op.getType() == TasmParser.IDIV)
            emit(OpCode.idiv);
        else if (ctx.op.getType() == TasmParser.IMOD)
            emit(OpCode.imod);
        else if (ctx.op.getType() == TasmParser.DADD)
            emit(OpCode.dadd);
        else if (ctx.op.getType() == TasmParser.DSUB)
            emit(OpCode.dsub);
        else if (ctx.op.getType() == TasmParser.DMULT)
            emit(OpCode.dmul);
        else if (ctx.op.getType() == TasmParser.DDIV)
            emit(OpCode.ddiv);
        else
            emit(OpCode.sadd);
        return null;
    }

    @Override
    public Void visitTypeConversion(TasmParser.TypeConversionContext ctx) {
        if (ctx.op.getType() == TasmParser.ITOS) {
            emit(OpCode.itos);
        } else if (ctx.op.getType() == TasmParser.ITOD) {
            emit(OpCode.itod);
        } else if (ctx.op.getType() == TasmParser.DTOS) {
            emit(OpCode.dtos);
        } else {
            emit(OpCode.btos);
        }
        return null;
    }
    @Override
    public Void visitPrintStat(TasmParser.PrintStatContext ctx) {
        if (ctx.op.getType() == TasmParser.IPRINT) {
            emit(OpCode.iprint);
        } else if (ctx.op.getType() == TasmParser.DPRINT) {
            emit(OpCode.dprint);
        } else if (ctx.op.getType() == TasmParser.SPRINT) {
            emit(OpCode.sprint);
        } else {
            emit(OpCode.bprint);
        }
        return null;
    }

    @Override
    public Void visitLabel(TasmParser.LabelContext ctx) {
        visit(ctx.inst());
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
