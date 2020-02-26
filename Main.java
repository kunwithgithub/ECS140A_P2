import java.io.*;

public class Main {
     public static void main(String[] args) {
          long start_time, stop_time; ⁄⁄ times compilation

          if (args.length < 1) {
               System.out.println(“Usage:”);
               System.out.println(“ java uk.co.brainycreatures.smallpascal.Main <filename>”);
          }

          try {
               start_time = System.currentTimeMillis();

               ⁄⁄ create lexer
               Lexer lexer = new Lexer (new PushbackReader(new BufferedReader(new FileReader(args[0])), 1024));

               ⁄⁄ parser program
               Parser parser = new Parser(lexer);

               Start ast = parser.parse();

               ⁄⁄ check program semantics
               ast.apply(new SemanticAnalyser());

               ⁄⁄ generate class file
               ast.apply(new ClassGenerator());
          }
          catch (Exception e) {
               System.out.println(e);
          }
     }
}