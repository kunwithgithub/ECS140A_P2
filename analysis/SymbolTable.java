package nada.analysis;

import java.util.*;
import java.io.*;
import nada.node.*;
import nada.analysis.*;
import nada.lexer.*;
import nada.parser.*;
import nada.visitor.*;

public class SymbolTable extends Object{

   private int level;
   private Stack<Map<String, SymbolEntry>> stack;

   private static final SymbolEntry EMPTY_SYMBOL = new SymbolEntry("");

   public SymbolTable(){
      reset();
   }

   public void reset(){
      level = -1;
      stack = new Stack<Map<String, SymbolEntry>>();
   }

   public void enterScope(){
      stack.push(new HashMap<String, SymbolEntry>());
      level++;
   }

   public void exitScope(){
      Map<String, SymbolEntry> table = stack.pop();
      //printTable(table);
      level--;
   }

   public SymbolEntry enterSymbol(String id){
      Map<String, SymbolEntry> table = stack.peek();
      if (table.containsKey(id)){
    	 System.out.println("identifier already declared in this block :"+id);
    	 System.exit(0);
       return EMPTY_SYMBOL;
      }
      else{
         SymbolEntry s = new SymbolEntry(id);
         table.put(id, s);
         return s;
      } 
   }

   public SymbolEntry findSymbol(String id){
      for (int i = stack.size() - 1; i >= 0; i--){
         Map<String, SymbolEntry> table = stack.get(i);
         SymbolEntry s = table.get(id);
         if (s != null)
             return s;
      }
      System.out.println("undeclared identifier: "+id);
     
      System.exit(0);
      return EMPTY_SYMBOL;
   }
         
   private void printTable(Map<String, SymbolEntry> table){
	  System.out.println("\nLevel " + level);
	  System.out.println("---------");
      for (SymbolEntry s : table.values())
    	 System.out.println(s.toString());
   }

}