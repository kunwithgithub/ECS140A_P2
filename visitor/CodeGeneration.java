/* This file was generated by SableCC (http://www.sablecc.org/). */

package nada.visitor;

import java.util.*;
import nada.node.*;
import java.io.*;
import nada.analysis.*;
import nada.lexer.*;
import nada.parser.*;


public class CodeGeneration extends DepthFirstAdapter
{
    private String filename = "";
    private BufferedWriter writer;
    private ArrayList<String> identList;
    private int time;
    private String hold_constrcutor;
    private int hold_bracket;
    private boolean outExists;

    public CodeGeneration(String filename){
        
    	
        this.filename = filename.replace(".ada",".java"); 
        outExists = false;
        hold_constrcutor = "";
        hold_bracket = 1;
        time = 1;
        identList = new ArrayList<String>();
        try { 
            writer = new BufferedWriter(new FileWriter(this.filename)); 
            keepWriting("");
            writer.close();
        }catch (IOException e) { 
            System.out.println("Exception Occurred" + e); 
        } 

    	
      }
    
    public void keepWriting(String input){
        try { 
            writer = new BufferedWriter(new FileWriter(this.filename,true)); 
            writer.write(input);

            writer.close(); 
        }catch (IOException e) { 
            System.out.println("Exception Occurred" + e); 
        }

    }
    

    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {

        inStart(node);
        node.getPNada().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inANada(ANada node)
    {
        defaultIn(node);
    }

    public void outANada(ANada node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANada(ANada node)
    {
        inANada(node);
        if(node.getSubprogramBody() != null)
        {
            node.getSubprogramBody().apply(this);
        }
        outANada(node);
    }

    public void inASubprogramBody(ASubprogramBody node)
    {
        defaultIn(node);
    }

    public void outASubprogramBody(ASubprogramBody node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASubprogramBody(ASubprogramBody node)
    {
        inASubprogramBody(node);
        if(node.getSubprogramSpec() != null)
        {
            node.getSubprogramSpec().apply(this);
        }
        if(node.getIs() != null)
        {   
            //keepWriting("\n{\n");
            node.getIs().apply(this);
        }
        if(node.getDeclPart() != null)
        {
            node.getDeclPart().apply(this);
        }
        if(node.getBegin() != null)
        {
            //keepWriting("\n{\n");
        	
            node.getBegin().apply(this);
        }
        if(node.getStmtSeq() != null)
        {
            node.getStmtSeq().apply(this);
        }
        
        if(node.getEnd() != null)
        {   
        	if(hold_bracket > 1)
        	{
        		keepWriting("\n}\n");
        		hold_bracket--;
        	}
            
        	keepWriting("\n}\n");
            time--;
            node.getEnd().apply(this);
        }
        
        if(node.getIdent() != null)
        {   
            node.getIdent().apply(this);
        }
        if(node.getSemi() != null)
        {

            node.getSemi().apply(this);
        }
        outASubprogramBody(node);
    }

    public void inADeclPart(ADeclPart node)
    {
        defaultIn(node);
    }

    public void outADeclPart(ADeclPart node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADeclPart(ADeclPart node)
    {
        inADeclPart(node);
        {
            List<PBasicDecl> copy = new ArrayList<PBasicDecl>(node.getBasicDecl());
            for(PBasicDecl e : copy)
            {
                e.apply(this);
            }
        }
        outADeclPart(node);
    }

    public void inAObjDeclBasicDecl(AObjDeclBasicDecl node)
    {
        defaultIn(node);
    }

    public void outAObjDeclBasicDecl(AObjDeclBasicDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAObjDeclBasicDecl(AObjDeclBasicDecl node)
    {
        inAObjDeclBasicDecl(node);
        if(node.getObjectDecl() != null)
        {
            node.getObjectDecl().apply(this);
        }
        outAObjDeclBasicDecl(node);
    }

    public void inANumDeclBasicDecl(ANumDeclBasicDecl node)
    {
        defaultIn(node);
    }

    public void outANumDeclBasicDecl(ANumDeclBasicDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumDeclBasicDecl(ANumDeclBasicDecl node)
    {
        inANumDeclBasicDecl(node);
        if(node.getNumberDecl() != null)
        {
            node.getNumberDecl().apply(this);
        }
        outANumDeclBasicDecl(node);
    }

    public void inASpbDeclBasicDecl(ASpbDeclBasicDecl node)
    {
        defaultIn(node);
    }

    public void outASpbDeclBasicDecl(ASpbDeclBasicDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASpbDeclBasicDecl(ASpbDeclBasicDecl node)
    {
        inASpbDeclBasicDecl(node);
        if(node.getSubprogramBody() != null)
        {
            node.getSubprogramBody().apply(this);
        }
        outASpbDeclBasicDecl(node);
    }

    public void inAObjectDecl(AObjectDecl node)
    {
        defaultIn(node);
    }

    public void outAObjectDecl(AObjectDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAObjectDecl(AObjectDecl node)
    {
        inAObjectDecl(node);
        if(node.getIdentList() != null)
        {   
            
            node.getIdentList().apply(this);
        }
        if(node.getColon() != null)
        {
            node.getColon().apply(this);
        }

        if(node.getIdent() != null)
        {
            keepWriting(" int ");
        	//identifier list

            node.getIdent().apply(this);
        }
        keepWriting(" ");
        for (int i = 0; i < identList.size(); i++) {
            keepWriting(identList.get(i));
        }
        identList.clear();
        if(node.getSemi() != null)
        {
            keepWriting(";\n");
            node.getSemi().apply(this);
        }
        outAObjectDecl(node);
    }

    public void inANumberDecl(ANumberDecl node)
    {
        defaultIn(node);
    }

    public void outANumberDecl(ANumberDecl node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumberDecl(ANumberDecl node)
    {
        inANumberDecl(node);
        if(node.getIdentList() != null)
        {   

            node.getIdentList().apply(this);
        }
        if(node.getColon() != null)
        {
        
            node.getColon().apply(this);
        }
        if(node.getConst() != null)
        {
            keepWriting(" final int ");
        	//call identifierlist
            node.getConst().apply(this);
        }
        for (int i = 0; i < identList.size(); i++) {
            keepWriting(identList.get(i));
        }
        identList.clear();

        if(node.getGets() != null)
        {
            keepWriting("=");
            node.getGets().apply(this);
        }
        
        if(node.getSimpleExpr() != null)
        {
            node.getSimpleExpr().apply(this);
        }
        
        if(node.getSemi() != null)
        {
            keepWriting(";\n");
            node.getSemi().apply(this);
        }
        outANumberDecl(node);
    }

    public void inAIdentList(AIdentList node)
    {
        defaultIn(node);
    }

    public void outAIdentList(AIdentList node)
    {
        defaultOut(node);
    }
    
    

    @Override
    public void caseAIdentList(AIdentList node)
    {
        inAIdentList(node);
        if(node.getIdent() != null)
        {
            identList.add(node.getIdent().getText());
            node.getIdent().apply(this);
        }
        if(node.getAnotherIdent()!=null)
        {
            List<PAnotherIdent> copy = new ArrayList<PAnotherIdent>(node.getAnotherIdent());
            for(PAnotherIdent e : copy)
            {   
                e.apply(this);
            }
        }
        outAIdentList(node);
    }

    public void inAAnotherIdent(AAnotherIdent node)
    {
        defaultIn(node);
    }

    public void outAAnotherIdent(AAnotherIdent node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAnotherIdent(AAnotherIdent node)
    {
        inAAnotherIdent(node);
        if(node.getComma() != null)
        {
            identList.add(",");
            node.getComma().apply(this);
        }
        if(node.getIdent() != null)
        {
            identList.add(node.getIdent().getText());
            node.getIdent().apply(this);
        }
        outAAnotherIdent(node);
    }

    public void inASubprogramSpec(ASubprogramSpec node)
    {
        defaultIn(node);
    }

    public void outASubprogramSpec(ASubprogramSpec node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASubprogramSpec(ASubprogramSpec node)
    {
        inASubprogramSpec(node);
        if(node.getProc() != null)
        {   
        	if(time == 1)
          {
            keepWriting(" class ");
            time++;
            node.getProc().apply(this);
          } 
            
        	else if(time > 1)
            {
            	keepWriting(" static class ");
            	time++;
            	node.getProc().apply(this);
            }
          }
          
          
        if(node.getIdent() != null)
        {
            keepWriting(node.getIdent().getText());
            hold_constrcutor = node.getIdent().getText();
            keepWriting("{\n");
            //keepWriting(node.getIdent().getText());
            node.getIdent().apply(this);
        }
        
        if(node.getFormalPart() != null)
        {
            node.getFormalPart().apply(this);
            keepWriting("{\n");
            hold_bracket++;

        }
        outASubprogramSpec(node);
    }

    public void inAFormalPart(AFormalPart node)
    {
        defaultIn(node);
    }

    public void outAFormalPart(AFormalPart node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFormalPart(AFormalPart node)
    {
        inAFormalPart(node);
        if(node.getLParen() != null)
        {
            keepWriting(hold_constrcutor);
            hold_constrcutor = "";
            keepWriting("(");
            node.getLParen().apply(this);
        }
        
        if(node.getParamSpec() != null)
        {
            
            node.getParamSpec().apply(this);
        }
        
        if(node.getAnotherParamSpec() != null)
        {
            List<PAnotherParamSpec> copy = new ArrayList<PAnotherParamSpec>(node.getAnotherParamSpec());
            for(PAnotherParamSpec e : copy)
            {
                e.apply(this);
            }
        }
        if(node.getRParen() != null)
        {
            keepWriting(")");
            node.getRParen().apply(this);
        }
        outAFormalPart(node);
    }

    public void inAParamSpec(AParamSpec node)
    {
        defaultIn(node);
    }

    public void outAParamSpec(AParamSpec node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParamSpec(AParamSpec node)
    {
        inAParamSpec(node);
        if(node.getIdentList() != null)
        {   
            node.getIdentList().apply(this);
        }
        if(node.getColon() != null)
        {
            node.getColon().apply(this);
        }
         outExists = false;
        if(node.getOut() != null)
        {   //No out parameters in java, but
        	//there are reference type
            node.getOut().apply(this);
            outExists = true;
        }
        if(node.getIdent() != null)
        {   
            if(outExists==false){
                keepWriting("int ");
            
            for (int i = 0; i < identList.size(); i++) {
                keepWriting(identList.get(i));
            }
            
            //call identifier list
        }
            node.getIdent().apply(this);
        }
        identList.clear();
        outExists = false;
        outAParamSpec(node);
    }

    public void inAAnotherParamSpec(AAnotherParamSpec node)
    {
        defaultIn(node);
    }

    public void outAAnotherParamSpec(AAnotherParamSpec node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAnotherParamSpec(AAnotherParamSpec node)
    {
        inAAnotherParamSpec(node);
        if(node.getSemi() != null)
        {
            //keepWriting(";\n");

        	identList.add(",");
            node.getSemi().apply(this);
        }
        
        if(node.getParamSpec() != null)
        {
            node.getParamSpec().apply(this);
        }
        outAAnotherParamSpec(node);
    }

    public void inAStmtSeq(AStmtSeq node)
    {
        defaultIn(node);
    }

    public void outAStmtSeq(AStmtSeq node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStmtSeq(AStmtSeq node)
    {
        inAStmtSeq(node);
        if(node.getStatement() != null)
        {
            node.getStatement().apply(this);
        }
        
        if(node.getStatements()!=null)
        {
            List<PStatement> copy = new ArrayList<PStatement>(node.getStatements());
            for(PStatement e : copy)
            {
                e.apply(this);
            }
        }
        outAStmtSeq(node);
    }

    public void inASimpleStmtStatement(ASimpleStmtStatement node)
    {
        defaultIn(node);
    }

    public void outASimpleStmtStatement(ASimpleStmtStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASimpleStmtStatement(ASimpleStmtStatement node)
    {
        inASimpleStmtStatement(node);
        if(node.getSimpleStmt() != null)
        {
            node.getSimpleStmt().apply(this);
        }
        outASimpleStmtStatement(node);
    }

    public void inACompoundStmtStatement(ACompoundStmtStatement node)
    {
        defaultIn(node);
    }

    public void outACompoundStmtStatement(ACompoundStmtStatement node)
    {
        defaultOut(node);
    }

    @Override
    public void caseACompoundStmtStatement(ACompoundStmtStatement node)
    {
        inACompoundStmtStatement(node);
        if(node.getCompoundStmt() != null)
        {
            node.getCompoundStmt().apply(this);
        }
        outACompoundStmtStatement(node);
    }

    public void inANullStmtSimpleStmt(ANullStmtSimpleStmt node)
    {
        defaultIn(node);
    }

    public void outANullStmtSimpleStmt(ANullStmtSimpleStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANullStmtSimpleStmt(ANullStmtSimpleStmt node)
    {
        inANullStmtSimpleStmt(node);
        if(node.getNullStmt() != null)
        {
            node.getNullStmt().apply(this);
        }
        outANullStmtSimpleStmt(node);
    }

    public void inAAssignStmtSimpleStmt(AAssignStmtSimpleStmt node)
    {
        defaultIn(node);
    }

    public void outAAssignStmtSimpleStmt(AAssignStmtSimpleStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssignStmtSimpleStmt(AAssignStmtSimpleStmt node)
    {
        inAAssignStmtSimpleStmt(node);
        if(node.getAssignStmt() != null)
        {
            node.getAssignStmt().apply(this);
        }
        outAAssignStmtSimpleStmt(node);
    }

    public void inAProcCallStmtSimpleStmt(AProcCallStmtSimpleStmt node)
    {
        defaultIn(node);
    }

    public void outAProcCallStmtSimpleStmt(AProcCallStmtSimpleStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAProcCallStmtSimpleStmt(AProcCallStmtSimpleStmt node)
    {
        inAProcCallStmtSimpleStmt(node);
        if(node.getProcCallStmt() != null)
        {   
            String mainFunction = "\n public static void main(String[] args)";
            keepWriting(mainFunction);
            keepWriting("\n{\n");
            node.getProcCallStmt().apply(this);
            keepWriting("\n}\n");
        }
        outAProcCallStmtSimpleStmt(node);
    }

    public void inAWriteSimpleStmt(AWriteSimpleStmt node)
    {
        defaultIn(node);
    }

    public void outAWriteSimpleStmt(AWriteSimpleStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWriteSimpleStmt(AWriteSimpleStmt node)
    {
        inAWriteSimpleStmt(node);
        if(node.getWriteStmt() != null)
        {
            node.getWriteStmt().apply(this);
            
        }
        outAWriteSimpleStmt(node);
    }

    public void inAIfCompoundCompoundStmt(AIfCompoundCompoundStmt node)
    {
        defaultIn(node);
    }

    public void outAIfCompoundCompoundStmt(AIfCompoundCompoundStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfCompoundCompoundStmt(AIfCompoundCompoundStmt node)
    {
        inAIfCompoundCompoundStmt(node);
        if(node.getIfStmt() != null)
        {
            node.getIfStmt().apply(this);
        }
        outAIfCompoundCompoundStmt(node);
    }

    public void inALoopCompoundCompoundStmt(ALoopCompoundCompoundStmt node)
    {
        defaultIn(node);
    }

    public void outALoopCompoundCompoundStmt(ALoopCompoundCompoundStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALoopCompoundCompoundStmt(ALoopCompoundCompoundStmt node)
    {
        inALoopCompoundCompoundStmt(node);
        if(node.getLoopStmt() != null)
        {
            node.getLoopStmt().apply(this);
        }
        outALoopCompoundCompoundStmt(node);
    }

    public void inANullStmt(ANullStmt node)
    {
        defaultIn(node);
    }

    public void outANullStmt(ANullStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANullStmt(ANullStmt node)
    {
        inANullStmt(node);
        if(node.getNull() != null)
        {
           // keepWriting("null");
            node.getNull().apply(this);
        }
        if(node.getSemi() != null)
        {
            keepWriting(";\n");
            node.getSemi().apply(this);
        }
        outANullStmt(node);
    }

    public void inAAssignStmt(AAssignStmt node)
    {
        defaultIn(node);
    }

    public void outAAssignStmt(AAssignStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAssignStmt(AAssignStmt node)
    {
        inAAssignStmt(node);
        if(node.getIdent() != null)
        {
            keepWriting(node.getIdent().getText());
            node.getIdent().apply(this);
        }
        if(node.getGets() != null)
        {
            keepWriting("=");
            node.getGets().apply(this);
        }
        if(node.getSimpleExpr() != null)
        {
            node.getSimpleExpr().apply(this);
        }
        if(node.getSemi() != null)
        {
            keepWriting(";\n");
            node.getSemi().apply(this);
        }
        outAAssignStmt(node);
    }

    public void inAWriteWriteStmt(AWriteWriteStmt node)
    {
        defaultIn(node);
    }

    public void outAWriteWriteStmt(AWriteWriteStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWriteWriteStmt(AWriteWriteStmt node)
    {
        inAWriteWriteStmt(node);
        if(node.getWrite() != null)
        {
            keepWriting("System.out.print");
            node.getWrite().apply(this);
        }
        if(node.getLParen() != null)
        {
            keepWriting("(");
            node.getLParen().apply(this);
        }
        if(node.getWriteExpr() != null)
        {
            node.getWriteExpr().apply(this);
        }
        if(node.getRParen() != null)
        {
            keepWriting(")");
            node.getRParen().apply(this);
        }
        if(node.getSemi() != null)
        {
            keepWriting(";\n");
            node.getSemi().apply(this);
        }
        outAWriteWriteStmt(node);
    }

    public void inAWritelnWriteStmt(AWritelnWriteStmt node)
    {
        defaultIn(node);
    }

    public void outAWritelnWriteStmt(AWritelnWriteStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAWritelnWriteStmt(AWritelnWriteStmt node)
    {
        inAWritelnWriteStmt(node);
        if(node.getWriteln() != null)
        {
            keepWriting("System.out.println");
            node.getWriteln().apply(this);
        }
        if(node.getLParen() != null)
        {
            keepWriting("(");
            node.getLParen().apply(this);
        }
        if(node.getWriteExpr() != null)
        {
            node.getWriteExpr().apply(this);
        }
        if(node.getRParen() != null)
        {
            keepWriting(")");
            node.getRParen().apply(this);
        }
        if(node.getSemi() != null)
        {
            keepWriting(";\n");
            node.getSemi().apply(this);
        }
        outAWritelnWriteStmt(node);
    }

    public void inAIfStmt(AIfStmt node)
    {
        defaultIn(node);
    }

    public void outAIfStmt(AIfStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAIfStmt(AIfStmt node)
    {
        inAIfStmt(node);
        if(node.getIf() != null)
        {
            keepWriting("if ");
            node.getIf().apply(this);
        }
        if(node.getRelation() != null)
        {   
        	keepWriting("(");
            node.getRelation().apply(this);
            keepWriting(")");
        }
        if(node.getThen() != null)
        {   
        	keepWriting("{");
            node.getThen().apply(this);
        }
        if(node.getStmtSeq() != null)
        {
            node.getStmtSeq().apply(this);
            keepWriting("}");
        }
        
        if(node.getElseifClause()!=null)
        {
            List<PElseifClause> copy = new ArrayList<PElseifClause>(node.getElseifClause());
            for(PElseifClause e : copy)
            {
                e.apply(this);
            }
        }
        
        if(node.getElseClause() != null)
        {   
        	
            node.getElseClause().apply(this);
        }
        if(node.getEndif() != null)
        {   
        	//keepWriting("}");
            node.getEndif().apply(this);
        }
        if(node.getSemi() != null)
        {
            //keepWriting(";\n");
            node.getSemi().apply(this);
        }
        outAIfStmt(node);
    }

    public void inAElseifClause(AElseifClause node)
    {
        defaultIn(node);
    }

    public void outAElseifClause(AElseifClause node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElseifClause(AElseifClause node)
    {
        inAElseifClause(node);
        if(node.getElseif() != null)
        {
            keepWriting("else if");
            node.getElseif().apply(this);
        }
        if(node.getRelation() != null)
        {   
        	keepWriting("(");
            node.getRelation().apply(this);
            keepWriting(")");
        }
        if(node.getThen() != null)
        {
        	keepWriting("{");
            node.getThen().apply(this);
        }
        if(node.getStmtSeq() != null)
        {
            node.getStmtSeq().apply(this);
            keepWriting("}");
        }
        
        outAElseifClause(node);
    }

    public void inAElseClause(AElseClause node)
    {
        defaultIn(node);
    }

    public void outAElseClause(AElseClause node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAElseClause(AElseClause node)
    {
        inAElseClause(node);
        if(node.getElse() != null)
        {
            keepWriting("else");
            node.getElse().apply(this);
        }
        if(node.getStmtSeq() != null)
        {   
        	keepWriting("{");
            node.getStmtSeq().apply(this);
            keepWriting("}");
        }
        outAElseClause(node);
    }

    public void inALoopStmt(ALoopStmt node)
    {
        defaultIn(node);
    }

    public void outALoopStmt(ALoopStmt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALoopStmt(ALoopStmt node)
    {
        inALoopStmt(node);
        if(node.getWhile() != null)
        {
            keepWriting("while");
            node.getWhile().apply(this);
        }
        if(node.getRelation() != null)
        {
            keepWriting("(");
            node.getRelation().apply(this);
            
            keepWriting(")");
        }
        if(node.getLoopStart() != null)
        {   
            keepWriting("{\n");
            node.getLoopStart().apply(this);
        }
        if(node.getStmtSeq() != null)
        {   
            node.getStmtSeq().apply(this);
        }
        if(node.getEnd() != null)
        {
            node.getEnd().apply(this);
        }
        if(node.getLoopEnd() != null)
        {
            keepWriting("}");
            node.getLoopEnd().apply(this);
        }
        if(node.getSemi() != null)
        {   
        	/*
            try{
                keepWriting(";");
            }catch(Exception e){
                System.out.print(e);
            }
            */
            node.getSemi().apply(this);
        }
        outALoopStmt(node);
    }

    public void inAProcCallStmt(AProcCallStmt node)
    {
        defaultIn(node);
    }

    public void outAProcCallStmt(AProcCallStmt node)
    {
        defaultOut(node);
    }

    @Override //Show_Birthday_Song("Ada", "Lovelace"); 
    public void caseAProcCallStmt(AProcCallStmt node)
    {
        inAProcCallStmt(node);
        if(node.getIdent() != null)
        {
            keepWriting(" new ");
            keepWriting(node.getIdent().getText());
            node.getIdent().apply(this);
        }
        if(node.getActualParamPart() != null)
        {
            node.getActualParamPart().apply(this);
        }
        if(node.getSemi() != null)
        {
            keepWriting(";\n");
            node.getSemi().apply(this);
        }
        outAProcCallStmt(node);
    }

    public void inAActualParamPart(AActualParamPart node)
    {
        defaultIn(node);
    }

    public void outAActualParamPart(AActualParamPart node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAActualParamPart(AActualParamPart node)
    {
        inAActualParamPart(node);
        if(node.getLParen() != null)
        {
            keepWriting("(");
            node.getLParen().apply(this);
        }
        
        if(node.getSimpleExpr() != null)
        {
            node.getSimpleExpr().apply(this);
        }
        
        if(node.getAnotherParam()!=null)
        {
            List<PAnotherParam> copy = new ArrayList<PAnotherParam>(node.getAnotherParam());
            for(PAnotherParam e : copy)
            {
                e.apply(this);
            }
        }
        
        
        if(node.getRParen() != null)
        {
            keepWriting(")");
            node.getRParen().apply(this);
        }
        outAActualParamPart(node);
    }

    public void inAAnotherParam(AAnotherParam node)
    {
        defaultIn(node);
    }

    public void outAAnotherParam(AAnotherParam node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAnotherParam(AAnotherParam node)
    {
        inAAnotherParam(node);
        if(node.getComma() != null)
        {
            identList.add(",");
            node.getComma().apply(this);
        }
        if(node.getSimpleExpr() != null)
        {
            node.getSimpleExpr().apply(this);
        }
        outAAnotherParam(node);
    }

    public void inARelation(ARelation node)
    {
        defaultIn(node);
    }

    public void outARelation(ARelation node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARelation(ARelation node)
    {
        inARelation(node);
        if(node.getSimpleExpr() != null)
        {
            node.getSimpleExpr().apply(this);
        }
        if(node.getRelationClause() != null)
        {
            node.getRelationClause().apply(this);
        }
        outARelation(node);
    }

    public void inARelationClause(ARelationClause node)
    {
        defaultIn(node);
    }

    public void outARelationClause(ARelationClause node)
    {
        defaultOut(node);
    }

    @Override
    public void caseARelationClause(ARelationClause node)
    {
        inARelationClause(node);
        if(node.getRelOp() != null)
        {   //relation operater
            node.getRelOp().apply(this);
        }
        if(node.getSimpleExpr() != null)
        {
            node.getSimpleExpr().apply(this);
        }
        outARelationClause(node);
    }

    public void inAStringLitWriteExpr(AStringLitWriteExpr node)
    {
        defaultIn(node);
    }

    public void outAStringLitWriteExpr(AStringLitWriteExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAStringLitWriteExpr(AStringLitWriteExpr node)
    {
        inAStringLitWriteExpr(node);
        if(node.getStringLit() != null)
        {
            keepWriting(node.getStringLit().getText());
            node.getStringLit().apply(this);
        }
        outAStringLitWriteExpr(node);
    }

    public void inASimpleExprWriteExpr(ASimpleExprWriteExpr node)
    {
        defaultIn(node);
    }

    public void outASimpleExprWriteExpr(ASimpleExprWriteExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASimpleExprWriteExpr(ASimpleExprWriteExpr node)
    {
        inASimpleExprWriteExpr(node);
        if(node.getSimpleExpr() != null)
        {
            node.getSimpleExpr().apply(this);
        }
        outASimpleExprWriteExpr(node);
    }

    public void inASimpleExpr(ASimpleExpr node)
    {
        defaultIn(node);
    }

    public void outASimpleExpr(ASimpleExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASimpleExpr(ASimpleExpr node)
    {
        inASimpleExpr(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getAddOp() != null)
        {
            node.getAddOp().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outASimpleExpr(node);
    }

    public void inATermSimpleExpr(ATermSimpleExpr node)
    {
        defaultIn(node);
    }

    public void outATermSimpleExpr(ATermSimpleExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATermSimpleExpr(ATermSimpleExpr node)
    {
        inATermSimpleExpr(node);
        if(node.getTerm() != null)
        {
            node.getTerm().apply(this);
        }
        outATermSimpleExpr(node);
    }

    public void inATerm(ATerm node)
    {
        defaultIn(node);
    }

    public void outATerm(ATerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATerm(ATerm node)
    {
        inATerm(node);
        if(node.getLeft() != null)
        {
            node.getLeft().apply(this);
        }
        if(node.getMulOp() != null)
        {
            node.getMulOp().apply(this);
        }
        if(node.getRight() != null)
        {
            node.getRight().apply(this);
        }
        outATerm(node);
    }

    public void inAFactorTerm(AFactorTerm node)
    {
        defaultIn(node);
    }

    public void outAFactorTerm(AFactorTerm node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFactorTerm(AFactorTerm node)
    {
        inAFactorTerm(node);
        if(node.getFactor() != null)
        {
            node.getFactor().apply(this);
        }
        outAFactorTerm(node);
    }

    public void inAFactorFactor(AFactorFactor node)
    {
        defaultIn(node);
    }

    public void outAFactorFactor(AFactorFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAFactorFactor(AFactorFactor node)
    {
        inAFactorFactor(node);
        if(node.getPrimary() != null)
        {

            node.getPrimary().apply(this);
        }
        outAFactorFactor(node);
    }

    public void inANegPrimFactor(ANegPrimFactor node)
    {
        defaultIn(node);
    }

    public void outANegPrimFactor(ANegPrimFactor node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANegPrimFactor(ANegPrimFactor node)
    {
        inANegPrimFactor(node);
        if(node.getMinus() != null)
        {
            keepWriting("-");
            node.getMinus().apply(this);
        }
        if(node.getPrimary() != null)
        {
            node.getPrimary().apply(this);
        }
        outANegPrimFactor(node);
    }

    public void inANumLitPrimary(ANumLitPrimary node)
    {
        defaultIn(node);
    }

    public void outANumLitPrimary(ANumLitPrimary node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANumLitPrimary(ANumLitPrimary node)
    {
        inANumLitPrimary(node);
        if(node.getNumberLit() != null)
        {
            keepWriting(node.getNumberLit().getText());
            node.getNumberLit().apply(this);
        }
        outANumLitPrimary(node);
    }

    public void inANamePrimary(ANamePrimary node)
    {
        defaultIn(node);
    }

    public void outANamePrimary(ANamePrimary node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANamePrimary(ANamePrimary node)
    {
        inANamePrimary(node);
        if(node.getIdent() != null)
        {
            keepWriting(node.getIdent().getText());
            node.getIdent().apply(this);
        }
        outANamePrimary(node);
    }

    public void inAExprPrimary(AExprPrimary node)
    {
        defaultIn(node);
    }

    public void outAExprPrimary(AExprPrimary node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprPrimary(AExprPrimary node)
    {
        inAExprPrimary(node);
        if(node.getLParen() != null)
        {
            keepWriting("(");
            node.getLParen().apply(this);
        }
        if(node.getSimpleExpr() != null)
        {
            node.getSimpleExpr().apply(this);
        }
        if(node.getRParen() != null)
        {
            keepWriting(")");
            node.getRParen().apply(this);
        }
        outAExprPrimary(node);
    }

    public void inAEqRelOp(AEqRelOp node)
    {
        defaultIn(node);
    }

    public void outAEqRelOp(AEqRelOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEqRelOp(AEqRelOp node)
    {
        inAEqRelOp(node);
        if(node.getEq() != null)
        {
            keepWriting("==");
            node.getEq().apply(this);
        }
        outAEqRelOp(node);
    }

    public void inANeqRelOp(ANeqRelOp node)
    {
        defaultIn(node);
    }

    public void outANeqRelOp(ANeqRelOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANeqRelOp(ANeqRelOp node)
    {
        inANeqRelOp(node);
        if(node.getNeq() != null)
        {
            keepWriting("!=");
            node.getNeq().apply(this);
        }
        outANeqRelOp(node);
    }

    public void inALtRelOp(ALtRelOp node)
    {
        defaultIn(node);
    }

    public void outALtRelOp(ALtRelOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALtRelOp(ALtRelOp node)
    {
        inALtRelOp(node);
        if(node.getLt() != null)
        {
            keepWriting("<");
            node.getLt().apply(this);
        }
        outALtRelOp(node);
    }

    public void inALeRelOp(ALeRelOp node)
    {
        defaultIn(node);
    }

    public void outALeRelOp(ALeRelOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALeRelOp(ALeRelOp node)
    {
        inALeRelOp(node);
        if(node.getLe() != null)
        {
            keepWriting("<=");
            node.getLe().apply(this);
        }
        outALeRelOp(node);
    }

    public void inAGtRelOp(AGtRelOp node)
    {
        defaultIn(node);
    }

    public void outAGtRelOp(AGtRelOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGtRelOp(AGtRelOp node)
    {
        inAGtRelOp(node);
        if(node.getGt() != null)
        {
            keepWriting(">");
            node.getGt().apply(this);
        }
        outAGtRelOp(node);
    }

    public void inAGeRelOp(AGeRelOp node)
    {
        defaultIn(node);
    }

    public void outAGeRelOp(AGeRelOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAGeRelOp(AGeRelOp node)
    {
        inAGeRelOp(node);
        if(node.getGe() != null)
        {
            keepWriting(">=");
            node.getGe().apply(this);
        }
        outAGeRelOp(node);
    }

    public void inAPlusAddOp(APlusAddOp node)
    {
        defaultIn(node);
    }

    public void outAPlusAddOp(APlusAddOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusAddOp(APlusAddOp node)
    {
        inAPlusAddOp(node);
        if(node.getPlus() != null)
        {
            keepWriting("+");
            node.getPlus().apply(this);
        }
        outAPlusAddOp(node);
    }

    public void inAMinusAddOp(AMinusAddOp node)
    {
        defaultIn(node);
    }

    public void outAMinusAddOp(AMinusAddOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMinusAddOp(AMinusAddOp node)
    {
        inAMinusAddOp(node);
        if(node.getMinus() != null)
        {
            keepWriting("-");
            node.getMinus().apply(this);
        }
        outAMinusAddOp(node);
    }

    public void inAMultMulOp(AMultMulOp node)
    {
        defaultIn(node);
    }

    public void outAMultMulOp(AMultMulOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultMulOp(AMultMulOp node)
    {
        inAMultMulOp(node);
        if(node.getMult() != null)
        {
            keepWriting("*");
            node.getMult().apply(this);
        }
        outAMultMulOp(node);
    }

    public void inADivMulOp(ADivMulOp node)
    {
        defaultIn(node);
    }

    public void outADivMulOp(ADivMulOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADivMulOp(ADivMulOp node)
    {
        inADivMulOp(node);
        if(node.getDiv() != null)
        {
            keepWriting("/");
            node.getDiv().apply(this);
        }
        outADivMulOp(node);
    }

    public void inAModMulOp(AModMulOp node)
    {
        defaultIn(node);
    }

    public void outAModMulOp(AModMulOp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAModMulOp(AModMulOp node)
    {
        inAModMulOp(node);
        if(node.getMod() != null)
        {
            keepWriting("%");
            node.getMod().apply(this);
        }
        outAModMulOp(node);
    }
}


