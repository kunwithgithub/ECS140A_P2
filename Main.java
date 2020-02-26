package nada;

import java.util.*;
import java.io.*;
import nada.node.*;
import nada.analysis.*;
import nada.lexer.*;
import nada.parser.*;
import nada.visitor.*;

public class Main{
    public static void main(String[] args){
        // create lexer
        final int pushBackBufferSize = 1024;
        Lexer lexer = new Lexer(new PushbackReader(new BufferedReader(new FileReader(args[0])), pushBackBufferSize));

        Parser parser = new Parser(lexer);
        Start abstractSyntaxTree = parser.parse();
        //abstractSyntaxTree.apply(new SemanticAnalyzer());
        abstractSyntaxTree.apply(new CodeGeneration(args[0]));
    }
}
