import CodeGen.*;
import Tasm.TasmLexer;
import Tasm.TasmParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.*;
import java.util.Map;

public class tAssembler {
    public static void main(String[] args) {
        String inputFile = args.length > 0 ? args[0] : null;
        boolean debug = args.length > 1 ? args[1].equals("-d") : false;
        try (InputStream is = (inputFile != null) ? new FileInputStream(inputFile) : System.in) {
            if (inputFile != null && !inputFile.endsWith(".tasm"))
                throw new IOException();
            CharStream input = CharStreams.fromStream(is);
            TasmLexer lexer = new TasmLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TasmParser parser = new TasmParser(tokens);
            ParseTree tree = parser.prog();
            LabelFinder labelfinder = new LabelFinder();
            labelfinder.visit(tree);
            Map labels = labelfinder.getLabels();
            CodeGenAssembler assembler = new CodeGenAssembler(labels);
            assembler.visit(tree);
            //Error handling
            labelfinder.isHaltFound();
            if (parser.getNumberOfSyntaxErrors() > 0)
                System.exit(1);
            //
            String outputFile = inputFile != null ? inputFile.substring(inputFile.lastIndexOf("/")+1, inputFile.lastIndexOf(".")).concat(".tbc") : "output.tbc";
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("inputs/" + outputFile));
            assembler.write(dos);
            if (debug){
                System.out.println(labels.toString());
                assembler.print();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
