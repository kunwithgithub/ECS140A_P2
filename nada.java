package nada;

import java.util.*;
import java.io.*;
import nada.node.*;
import nada.analysis.*;
import nada.lexer.*;
import nada.parser.*;
import nada.visitor.*;

public class nada {
     public static void main(String[] args) {
          long start_time, stop_time; // times compilation

          if (args.length < 1) {
               System.out.println("Usage:");
               System.out.println("java nada.nada <filename>");
          }

          try {
               start_time = System.currentTimeMillis();

               //create lexer
               Lexer lexer = new Lexer (new PushbackReader(new BufferedReader(new FileReader(args[0])),1024));

               //parser program
               Parser parser = new Parser(lexer);

               Start ast = parser.parse();

               //check program semantics
               ast.apply(new SemanticAnalyzer());

               //generate class file
               ast.apply(new CodeGeneration(args[0]));

          }
          catch (Exception e) {
               System.out.println(e);
          }
     }
}