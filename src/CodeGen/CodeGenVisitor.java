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

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;


public class CodeGenVisitor extends SolBaseVisitor<Void> {
    private ArrayList<Instruction> instructions = new ArrayList<>();
    private ArrayList<Instruction> constantPool = new ArrayList<>();
    private ParseTreeProperty<Type> values;
    private Scope currentScope;
    private Map<String, Integer> functions = new HashMap<>();
    private Map<String, Integer> varIndex = new HashMap<>();
    private Map<Symbol, Integer> localVarIndex = new HashMap<>();
    private int breakLine = -1;
    private int Ip = 0;
    private int localPointer = 1;
    private FunctionSymbol currentFunction = null;
    private boolean hasReturn = false;
    private boolean hasIfReturn = false;
    private Map<Integer, String> unknownFunctions = new HashMap<>();
    private int blockCounter = 0;

    public CodeGenVisitor( ParseTreeProperty<Type> values, Scope scope) {
        super();
        this.values = values;
        this.currentScope = scope;
    }

    @Override public Void visitProg(SolParser.ProgContext ctx) {

        for (SolParser.VarContext c : ctx.var()) {
            visitVar(c);
        }
        emit(OpCode.call, -1);
        int callLine = Ip++;
        emit(OpCode.halt);
        Ip++;
        for (SolParser.FunctionContext c : ctx.function()) {
            functions.put(c.ID(0).getText(), 0);
        }
        for (SolParser.FunctionContext c : ctx.function()) {
            visitFunction(c);
        }
        instructions.set(callLine, new IntInstruction(OpCode.call, functions.get("main")));
        return null;
    }

    @Override public Void visitFunctionCallExpression(SolParser.FunctionCallExpressionContext ctx) {
        visitChildren(ctx);
        if (functions.get(ctx.ID().getText()) == 0){
            unknownFunctions.put(Ip, ctx.ID().getText());
        }
        /*if (functions.get(ctx.ID().getText()) == 0){
            functions.put(ctx.ID().getText(), Ip);
            unknownFunctions.add(ctx.ID().getText());
        }*/
        emit(OpCode.call, functions.get(ctx.ID().getText()));
        Ip++;
        return null;
    }

    @Override public Void visitFunction(SolParser.FunctionContext ctx) {
        hasReturn = false;
        localPointer = 1;
        int initial = localPointer;
        localVarIndex = new HashMap<>();
        currentFunction = (FunctionSymbol) (currentScope.resolve(ctx.ID(0).getText()));
        Scope Global = currentScope;
        for (Scope child : currentScope.getChildScopes()){
            if (ctx.ID(0).getText().equals(child.getName())){
                currentScope = child;
            }
        }

        if (unknownFunctions.containsValue(ctx.ID(0).getText())){
            for (Map.Entry<Integer, String> entry : unknownFunctions.entrySet()){
                if (entry.getValue().equals(ctx.ID(0).getText())){
                    instructions.set(entry.getKey(), new IntInstruction(OpCode.call, Ip));
                }
            }
        }
        /*if (unknownFunctions.contains(ctx.ID(0).getText())) {
            int line = functions.get(ctx.ID(0).getText());
            instructions.set(line, new IntInstruction(OpCode.call, Ip));
            unknownFunctions.remove(ctx.ID(0).getText());
        }*/
        functions.put(ctx.ID(0).getText(), Ip);
        visitChildren(ctx);
        currentScope = Global;
        if (!hasReturn) {
            if ((localPointer - initial) > 0) {
                emit(OpCode.pop, localPointer - initial);
                Ip++;
            }
            emit(OpCode.ret, currentFunction.get_arguments().size());
            Ip++;
        }
        return null;
    }

    @Override public Void visitReturn(SolParser.ReturnContext ctx) {
        visitChildren(ctx);
        Type type = values.get(ctx.inst());
        int numberArgs = currentFunction.get_arguments().size();
        if (type == Type.VOID)
            emit(OpCode.ret, numberArgs);
        else
            emit(OpCode.retval, numberArgs);
        hasReturn = true;
        ParserRuleContext c = ctx.getParent();
        while (true) {
            if (c instanceof SolParser.FunctionContext)
                break;
            if (c instanceof SolParser.IfStatementContext){
                hasIfReturn = true;
                break;
            }
            c = c.getParent();
        }
        Ip++;
        return null;
    }

    @Override public Void visitFunctionCall(SolParser.FunctionCallContext ctx) {
        visitChildren(ctx);
        if (functions.get(ctx.ID().getText()) == 0){
            unknownFunctions.put(Ip, ctx.ID().getText());
        }
        /*if (functions.get(ctx.ID().getText()) == 0){
            functions.put(ctx.ID().getText(), Ip);
            unknownFunctions.add(ctx.ID().getText());
        }*/
        emit(OpCode.call, functions.get(ctx.ID().getText()));
        Ip++;
        return null;
    }

    @Override public Void visitTypeFunction(SolParser.TypeFunctionContext ctx) {
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitBlockCode(SolParser.BlockCodeContext ctx) {
        int initial = localPointer;
        Scope global = currentScope;
        if (ctx.getParent() instanceof SolParser.BlockContext) {
            blockCounter = 0;
        }
        if (currentScope.getChildScopes().size() > 0) {
            currentScope = currentScope.getChildScopes().get(blockCounter);
            blockCounter++;
        }
        visitChildren(ctx);
        currentScope = global;
        int finalv = localPointer - initial;
        localPointer -= finalv;
        emit(OpCode.pop, finalv);
        Ip++;
        return null;
    }

    @Override public Void visitPrint(SolParser.PrintContext ctx) {
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
        Ip++;
        return null;
    }

    @Override public Void visitOr(SolParser.OrContext ctx) {
        visitChildren(ctx);
        emit(OpCode.or);
        TypeConverter(ctx);
        Ip++;
        return null;
    }

    @Override public Void visitAddSub(SolParser.AddSubContext ctx) {
        Type type = values.get(ctx);
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
        Ip++;
        TypeConverter(ctx);
        return null;

    }

    @Override public Void visitEqual(SolParser.EqualContext ctx) {
        Type type1 = values.get(ctx.inst(0));
        Type type2 = values.get(ctx.inst(1));
        Type finalType;
        Type tempType = values.get(ctx);
        if (type1 == Type.REAL || type2 == Type.REAL)
            finalType = Type.REAL;
        else if (type1 == Type.INT && type2 == Type.INT)
            finalType = Type.INT;
        else if (type1 == Type.STRING && type2 == Type.STRING)
            finalType = Type.STRING;
        else
            finalType = Type.BOOL;

        values.put(ctx, finalType);
        visitChildren(ctx);
        values.put(ctx, tempType);

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
        Ip++;
        TypeConverter(ctx);
        return null;
    }

    @Override public Void visitVar(SolParser.VarContext ctx) {
        int numAssign = ctx.assignInst().size();
        if (currentFunction != null) {
            emit(OpCode.lalloc, numAssign);
            for (int i = 0 ; i<numAssign; i++){
            localPointer++;
            localVarIndex.put(currentScope.resolve_local(ctx.assignInst(i).ID().getText()) ,localPointer);
            }
        }
        else
            emit(OpCode.galloc, numAssign);
        Ip++;
        visitChildren(ctx);
        return null;
    }

    @Override public Void visitAssignInst(SolParser.AssignInstContext ctx) {
        visitChildren(ctx);
        if (currentFunction == null){
        varIndex.put(ctx.ID().getText(), varIndex.size());
        if(ctx.inst() != null){
            emit(OpCode.gstore, varIndex.get(ctx.ID().getText()));
            Ip++;
        } } else {
            if (ctx.inst() != null){
                emit(OpCode.lstore,localVarIndex.get(currentScope.resolve_local(ctx.ID().getText())));
                Ip++;
            }
        }
        return null;
    }

    @Override public Void visitAssign(SolParser.AssignContext ctx) {
        visitChildren(ctx);
        if (currentScope.resolve_local(ctx.ID().getText()) != null) {
            Symbol s = currentScope.resolve_local(ctx.ID().getText());
            if (s.getType() == Type.REAL && values.get(ctx.inst()) == Type.INT) {
                emit(OpCode.itod);
                Ip++;
            }
            if (s.getType() != values.get(ctx.inst())) {
                throw new RuntimeException("Type mismatch");
            }

            if (currentScope.contains(ctx.ID().getText())){
                emit(OpCode.lstore, localPointer);
                Ip++;
                return null;
            }
            if (varIndex.containsKey(ctx.ID().getText())) {
                emit(OpCode.gstore, varIndex.get(ctx.ID().getText()));
                Ip++;
            }
        }

        return null;
    }

    @Override public Void visitWhile(SolParser.WhileContext ctx) {
        int startLine = Ip;
        visit(ctx.inst());
        int jumpfLine = Ip;
        emit(OpCode.jumpf, -1);
        Ip++;
        visit(ctx.line());
        emit(OpCode.jump, startLine);
        Ip++;
        instructions.set(jumpfLine, new IntInstruction(OpCode.jumpf, Ip));
        if (breakLine != -1)
            instructions.set(breakLine, new IntInstruction(OpCode.jump, Ip));
        breakLine = -1;
        return null;
    }

    @Override public Void visitFor(SolParser.ForContext ctx) {
        visit(ctx.ID());
        visit(ctx.inst(0));
        emit(OpCode.gstore, varIndex.get(ctx.ID().getText()));
        Ip++;
        emit(OpCode.gload, varIndex.get(ctx.ID().getText()));
        int startLine = Ip++;
        visit(ctx.inst(1));
        emit(OpCode.ileq);
        Ip++;
        emit(OpCode.jumpf, -1);
        int jumpfLine = Ip++;
        visit(ctx.line());
        emit(OpCode.gload, varIndex.get(ctx.ID().getText()));
        emit(OpCode.iconst, 1);
        emit(OpCode.iadd);
        emit(OpCode.gstore, varIndex.get(ctx.ID().getText()));
        emit(OpCode.jump, startLine);
        Ip += 5;
        instructions.set(jumpfLine, new IntInstruction(OpCode.jumpf, Ip));
        if (breakLine != -1)
            instructions.set(breakLine, new IntInstruction(OpCode.jump, Ip));
        breakLine = -1;
        return null;
    }

    @Override public Void visitAnd(SolParser.AndContext ctx) {
        visitChildren(ctx);
        emit(OpCode.and);
        Ip++;
        TypeConverter(ctx);
        return null;
    }

    @Override public Void visitLiteral(SolParser.LiteralContext ctx) {
        switch (ctx.op.getType()) {
            case SolParser.INT:
                emit(OpCode.iconst, Integer.parseInt(ctx.getText()));
                break;
            case SolParser.DOUBLE:
                emit(OpCode.dconst, Double.parseDouble(ctx.getText()));
                break;
            case SolParser.STRING:
                String noEscapes = ctx.getText().substring(1, ctx.STRING().getText().length()-1).replace("\\", "");
                emit(OpCode.sconst, noEscapes);
                break;
            case SolParser.TRUE:
                emit(OpCode.tconst);
                break;
            case SolParser.FALSE:
                emit(OpCode.fconst);
                break;
        }
        Ip++;
        if (!(ctx.getParent() instanceof SolParser.FunctionCallContext) && !(ctx.getParent() instanceof SolParser.FunctionCallExpressionContext)) {
            TypeConverter(ctx);
        } else if (values.get(ctx.getParent()) == Type.REAL && ctx.op.getType() == SolParser.INT) {
            emit(OpCode.itod);
            Ip++;
        }
        return null;
    }

    @Override public Void visitId(SolParser.IdContext ctx) {
        visitChildren(ctx);
        if (currentFunction != null) {
            for (Symbol s : currentFunction.get_arguments()) {
                if (s.getToken().getText().equals(ctx.ID().getText())) {
                    emit(OpCode.lload, -(currentFunction.get_arguments().size() - currentFunction.get_arguments().indexOf(s)));
                    Ip++;
                    TypeConverter(ctx);
                    return null;
                }
            }
            if (localPointer > 1){
                if (currentScope.contains(ctx.ID().getText())){
                    emit(OpCode.lload, localVarIndex.get(currentScope.resolve_local(ctx.ID().getText())));
                    Ip++;
                }
            }
        }
        if (varIndex.containsKey(ctx.ID().getText())) {
            emit(OpCode.gload, varIndex.get(ctx.ID().getText()));
            Ip++;
        }
        TypeConverter(ctx);
        return null;
    }


    @Override public Void visitRel(SolParser.RelContext ctx) {
        Type type1 = values.get(ctx.inst(0));
        Type type2 = values.get(ctx.inst(1));
        Type finalType;
        Type tempType = values.get(ctx);
        if (type1 == Type.REAL || type2 == Type.REAL)
            finalType = Type.REAL;
        else
            finalType = Type.INT;
        values.put(ctx, finalType);
        if (ctx.op.getType() == SolParser.GT || ctx.op.getType() == SolParser.GE) {
            visit(ctx.children.getLast());
            visit(ctx.children.getFirst());
        } else
            visitChildren(ctx);
        
        values.put(ctx, tempType);
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
        Ip++;
        TypeConverter(ctx);
        return null;
    }

    @Override public Void visitUnary(SolParser.UnaryContext ctx) {
        Type type = values.get(ctx.inst());
        visitChildren(ctx);
        if (ctx.op.getType() == SolParser.SUB)
            if (type == Type.INT)
                emit(OpCode.iuminus);
            else
                emit(OpCode.duminus);
        else if (ctx.op.getType() == SolParser.NOT)
            emit(OpCode.not);
        Ip++;
        TypeConverter(ctx);
        return null;
    }

    @Override public Void visitIf(SolParser.IfContext ctx) {
        hasIfReturn = false;
        visit(ctx.inst());
        emit(OpCode.jumpf, -1);
        int jumpfLine = Ip++;
        int jumpLine = -1;
        visit(ctx.line(0));
        if (ctx.ELSE() != null) {
            if (!hasIfReturn) {
                emit(OpCode.jump, -1);
                jumpLine = Ip++;
            }
            instructions.set(jumpfLine, new IntInstruction(OpCode.jumpf, Ip));
            visit(ctx.line(1));
            if (!hasIfReturn)
                instructions.set(jumpLine, new IntInstruction(OpCode.jump, Ip));
        } else {
            instructions.set(jumpfLine, new IntInstruction(OpCode.jumpf, Ip));
        }
        return null;
    }

    @Override public Void visitBreakStatement(SolParser.BreakStatementContext ctx) {
        visitChildren(ctx);
        emit(OpCode.jump, breakLine);
        breakLine = Ip++;
        return null;
    }


    @Override public Void visitParen(SolParser.ParenContext ctx) {
        visitChildren(ctx);
        TypeConverter(ctx);
        return null;
    }

    @Override public Void visitMultDiv(SolParser.MultDivContext ctx) {
        Type type = values.get(ctx);
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
        Ip++;
        TypeConverter(ctx);
        return null;
    }

    public void TypeConverter(SolParser.InstContext ctx) {
        Type type = values.get(ctx);
        Type Parenttype = values.get(ctx.getParent());
        if(Parenttype != type) {
            if (Parenttype == Type.REAL)
                switch (type) {
                    case Type.INT:
                        emit(OpCode.itod);
                        Ip++;
                        break;
                }
            else if (Parenttype == Type.STRING) {
                switch (type) {
                    case Type.INT:
                        emit(OpCode.itos);
                        break;
                    case Type.REAL:
                        emit(OpCode.dtos);
                        break;
                    case Type.BOOL:
                        emit(OpCode.btos);
                        break;
                }
                Ip++;
            }
        }
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

    public void writeTASM(String dos) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(dos);
            int i = 0;
            for (Instruction instr : instructions) {

                writer.write("L" + i++ + ": ");
                if (instr instanceof IntInstruction) {
                    if (instr.getOp() == OpCode.jump || instr.getOp() == OpCode.jumpf || instr.getOp() == OpCode.jumpt || instr.getOp() == OpCode.call)
                        writer.write(instr.getOp() + " " + ((IntInstruction) instr).getArg() + "\n");
                    else if (instr.getOp() == OpCode.dconst){
                        DoubleInstruction a = (DoubleInstruction) constantPool.get(((IntInstruction) instr).getArg());
                        writer.write(instr.getOp() + " "  + a.getArg() +  "\n");
                    }
                    else if (instr.getOp() == OpCode.sconst){
                        StringInstruction a = (StringInstruction) constantPool.get(((IntInstruction) instr).getArg());
                        writer.write(instr.getOp() + " " + "\"" + a.getArg() + "\"" + "\n");
                    }
                    else
                        writer.write(instr.getOp() + " " + ((IntInstruction) instr).getArg() + "\n");
                } else if (instr instanceof DoubleInstruction) {
                    writer.write(instr.getOp() + " " + ((DoubleInstruction) instr).getArg() + "\n");
                } else if (instr instanceof StringInstruction) {
                    writer.write(instr.getOp() + " " + ((StringInstruction) instr).getArg() + "\n");
                } else if (instr instanceof BooleanInstruction) {
                    writer.write(instr.getOp() + " " + ((BooleanInstruction) instr).getArg() + "\n");
                }
                else {
                    writer.write(instr.getOp() + "\n");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }   finally {
            if (writer != null) {
                writer.close(); // Close the writer in the finally block
            }
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
