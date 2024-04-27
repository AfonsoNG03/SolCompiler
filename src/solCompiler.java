import CodeGen.*;
import Sol.SolLexer;
import Sol.SolParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.io.*;
import java.util.Map;


public class solCompiler {
    public static void main(String[] args) {
        String inputFile = args.length > 0 ? args[0] : null;
        boolean debug = args.length > 1 ? args[1].equals("-d") : false;
        try (InputStream is = (inputFile != null) ? new FileInputStream(inputFile) : System.in) {
            if (inputFile != null && !inputFile.endsWith(".sol"))
                throw new IOException();
            CharStream input = CharStreams.fromStream(is);
            SolLexer lexer = new SolLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            SolParser parser = new SolParser(tokens);
            ParseTree tree = parser.prog();
            Annotator annotator = new Annotator();
            annotator.visit(tree);
            ParseTreeProperty<Type> values = annotator.getValues();
            Map<String, Object> vars = annotator.getVars();
            CodeGenVisitor assembler = new CodeGenVisitor(values, vars);
            assembler.visit(tree);
            //Error handling
            if (parser.getNumberOfSyntaxErrors() > 0)
                System.exit(1);
            //
            String outputFile = inputFile != null ? inputFile.substring(0, inputFile.lastIndexOf(".")).concat(".tbc") : "output.tbc";
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(outputFile));
            assembler.write(dos);
            if (debug){
                //System.out.println(labels.toString());
                assembler.print();
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
