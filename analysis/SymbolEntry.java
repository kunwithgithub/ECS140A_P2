package nada.analysis;

import java.util.*;
import java.io.*;
import nada.node.*;
import nada.analysis.*;
import nada.lexer.*;
import nada.parser.*;
import nada.visitor.*;

public class SymbolEntry extends Object{

   public static final int NONE = 0;
   public static final int CONST = 1;
   public static final int PARAM = 2;
   public static final int PROC = 3;
   public static final int TYPE = 4;
   public static final int VAR = 5;

   private String name;
   public int role;
   public SymbolEntry next=null;

   public SymbolEntry(String id){
      name = id;
      role = NONE;
      next = null;
   }
   
   public String getName(){
      return name;
   }

   public String toString(){
		return "Name: " + name + "\n" + "Role: " + roleToString();
	  
   }

   public void setRole(int r){
      role = r;
	  if(this.name.equals("")){// detecting emptySymbolEntry
		  return;
	  }
      if (next != null){
         next.setRole(r);
	  }
   }

   public void append(SymbolEntry entry){
	 if(this.name.equals("")){// detecting emptySymbolEntry
		 return;
	 }
	 if(next==null){
		 next = entry;
	 }else{
		 next.append(entry);
	 }

   }  

   private String roleToString(){
      String s = "";
      switch (role){
         case NONE:  s = "None";      break;
         case CONST: s = "CONSTANT";  break;
         case PARAM: s = "PARAMETER"; break;
         case PROC:  s = "PROCEDURE"; break;
         case TYPE:  s = "TYPE";      break;
         case VAR:   s = "VARIABLE";  break;
         default:    s = "None";
      }
      return s;
   }

}
