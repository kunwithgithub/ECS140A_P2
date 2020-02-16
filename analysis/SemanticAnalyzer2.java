package nada.analysis;

import java.util.*;
import nada.node.*;
import nada.analysis.*;


public class SemanticAnalyzer extends DepthFirstAdapter{
	
	
	private SymbolTable table;

	public SemanticAnalyzer(){
		initTable();
	}
	
	private void initTable(){
		table = new SymbolTable();
		
		SymbolEntry entry = table.enterSymbol("INTEGER");
		entry.setRole(SymbolEntry.TYPE);
		      /*
		      //entry = table.enterSymbol("CHAR");
		     // entry.setRole(SymbolEntry.TYPE);
		     // entry = table.enterSymbol("INTEGER");
		     // entry.setRole(SymbolEntry.TYPE);
		     // entry = table.enterSymbol("TRUE");
		     // entry.setRole(SymbolEntry.CONST);
		     // entry = table.enterSymbol("FALSE");
		     // entry.setRole(SymbolEntry.CONST);
		      */
	   }


	   @Override
	   public void caseStart(Start node)
	   {
			table.enterScope();
		   	inStart(node);
		   	node.getPNada().apply(this);
		   	node.getEOF().apply(this);
			outStart(node);
			table.exitscope();
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
			   node.getIs().apply(this);
		   }
		   if(node.getDeclPart() != null)
		   {
			   node.getDeclPart().apply(this);
		   }
		   if(node.getBegin() != null)
		   {
			   node.getBegin().apply(this);
		   }
		   if(node.getStmtSeq() != null)
		   {
			   node.getStmtSeq().apply(this);
		   }
		   if(node.getEnd() != null)
		   {
			   node.getEnd().apply(this);
		   }
		   if(node.getIdent() != null)
		   {
			   TIdent id = node.getIdent();
			   String key = id.getText();
			   SymbolEntry entry = table.findSymbol(key);
			   node.getIdent().apply(this);
		   }
		   if(node.getSemi() != null)
		   {
			   node.getSemi().apply(this);
		   }
		   outASubprogramBody(node);
	   }
   
   
	   @Override
	   public void caseADeclPart(ADeclPart node)
	   {
		   inADeclPart(node);
		   if(node.getBasicDecl()!=null)
		   {
			   List<PBasicDecl> copy = new ArrayList<PBasicDecl>(node.getBasicDecl());
			   for(PBasicDecl e : copy)
			   {
				   e.apply(this);
			   }
		   }
		   outADeclPart(node);
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
   
   
	   @Override
	   public void caseAObjectDecl(AObjectDecl node)
	   {
		   inAObjectDecl(node);
		   if(node.getIdentList() != null)
		   {
				SymbolEntry list = null;
				List<TIdent> copy = new ArrayList<TIdent>(node.getIdentList());
				for(TIdent e : copy)
				{
				 	String key = e.getText();
					list.append(table.findSymbol(key));
				}
				list.setRole(SymbolEntry.VAR);		
			    node.getIdentList().apply(this);
		   }
		   if(node.getColon() != null)
		   {
			   node.getColon().apply(this);
		   }
		   if(node.getIdent() != null)
		   {
			   TIdent id = node.getIdent();
			   String key = id.getText();
			   SymbolEntry entry = table.enterSymbol(key);
			   node.getIdent().apply(this);
		   }
		   if(node.getSemi() != null)
		   {
			   node.getSemi().apply(this);
		   }
		   outAObjectDecl(node);
	   }
   
   
	   @Override
	   public void caseANumberDecl(ANumberDecl node)
	   {
		   inANumberDecl(node);
		   if(node.getIdentList() != null)
		   {
			    SymbolEntry list = null;
				List<TIdent> copy = new ArrayList<TIdent>(node.getIdentList());
				for(TIdent e : copy)
				{
				 	String key = e.getText();
					list.append(table.findSymbol(key));
				}
				list.setRole(SymbolEntry.CONST);
			   	node.getIdentList().apply(this);

		   }
		   if(node.getColon() != null)
		   {
			   node.getColon().apply(this);
		   }
		   if(node.getConst() != null)
		   {
			   node.getConst().apply(this);
		   }
		   if(node.getGets() != null)
		   {
			   node.getGets().apply(this);
		   }
		   if(node.getSimpleExpr() != null)
		   {
			   node.getSimpleExpr().apply(this);
		   }
		   if(node.getSemi() != null)
		   {
			   node.getSemi().apply(this);
		   }
		   outANumberDecl(node);
	   }
   
   
	   @Override
	   public void caseAIdentList(AIdentList node)
	   {
		   inAIdentList(node);
		   if(node.getIdent() != null)
		   {
				TIdent id = node.getIdent();
				String key = id.getText();
				table.enterSymbol(key);
			   	node.getIdent().apply(this);
		   }
		   if(node.getAnotherIdent()!=null)
		   {
			   List<PAnotherIdent> copy = new ArrayList<PAnotherIdent>(node.getAnotherIdent());
			   for(PAnotherIdent e : copy)
			   {
					String key = e.getText();
				   	table.enterSymbol(key);
				   	e.apply(this);
			   }
		   }
		   
		   outAIdentList(node);
	   }
   
   
	   @Override
	   public void caseAAnotherIdent(AAnotherIdent node)
	   {
		   inAAnotherIdent(node);
		   if(node.getComma() != null)
		   {
			   node.getComma().apply(this);
		   }
		   if(node.getIdent() != null)
		   {

			   	node.getIdent().apply(this);
		   }
		   outAAnotherIdent(node);
	   }
   
   
	   @Override
	   public void caseASubprogramSpec(ASubprogramSpec node)
	   {
		   inASubprogramSpec(node);
		   if(node.getProc() != null)
		   {
			   node.getProc().apply(this);
		   }
		   if(node.getIdent() != null)
		   {
				TIdent id = node.getIdent();
				String key = id.getText();
				SymbolEntry entry = table.findSymbol(key);
			   	node.getIdent().apply(this);
		   }
		   if(node.getFormalPart() != null)
		   {
			   node.getFormalPart().apply(this);
		   }
		   outASubprogramSpec(node);
	   }
   
   
	   @Override
	   public void caseAFormalPart(AFormalPart node)
	   {
		   inAFormalPart(node);
		   if(node.getLParen() != null)
		   {
			   node.getLParen().apply(this);
		   }
		   if(node.getParamSpec() != null)
		   {
			   node.getParamSpec().apply(this);
		   }
		   if(node.getAnotherParamSpec()!=null)
		   {
			   List<PAnotherParamSpec> copy = new ArrayList<PAnotherParamSpec>(node.getAnotherParamSpec());
			   for(PAnotherParamSpec e : copy)
			   {
				   e.apply(this);
			   }
		   }
		   if(node.getRParen() != null)
		   {
			   node.getRParen().apply(this);
		   }
		   outAFormalPart(node);
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
		   if(node.getOut() != null)
		   {
			   node.getOut().apply(this);
		   }
		   if(node.getIdent() != null)
		   {
				TIdent id = node.getIdent();
				String key = id.getText();
				SymbolEntry entry = table.findSymbol(key);
			   	node.getIdent().apply(this);
		   }
		   outAParamSpec(node);
	   }
   
   
	   @Override
	   public void caseAAnotherParamSpec(AAnotherParamSpec node)
	   {
		   inAAnotherParamSpec(node);
		   if(node.getSemi() != null)
		   {
			   node.getSemi().apply(this);
		   }
		   if(node.getParamSpec() != null)
		   {
			   node.getParamSpec().apply(this);
		   }
		   outAAnotherParamSpec(node);
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
   
   
	   @Override
	   public void caseAProcCallStmtSimpleStmt(AProcCallStmtSimpleStmt node)
	   {
		   inAProcCallStmtSimpleStmt(node);
		   if(node.getProcCallStmt() != null)
		   {
			   node.getProcCallStmt().apply(this);
		   }
		   outAProcCallStmtSimpleStmt(node);
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
   
	   @Override
	   public void caseANullStmt(ANullStmt node)
	   {
		   inANullStmt(node);
		   if(node.getNull() != null)
		   {
			   node.getNull().apply(this);
		   }
		   if(node.getSemi() != null)
		   {
			   node.getSemi().apply(this);
		   }
		   outANullStmt(node);
	   }
   
   
	   @Override
	   public void caseAAssignStmt(AAssignStmt node)
	   {
		   inAAssignStmt(node);
		   if(node.getIdent() != null)
		   {
				TIdent id = node.getIdent();
				String key = id.getText();
				SymbolEntry entry = table.findSymbol(key);
			   	node.getIdent().apply(this);
		   }
		   if(node.getGets() != null)
		   {
			   node.getGets().apply(this);
		   }
		   if(node.getSimpleExpr() != null)
		   {
			   node.getSimpleExpr().apply(this);
		   }
		   if(node.getSemi() != null)
		   {
			   node.getSemi().apply(this);
		   }
		   outAAssignStmt(node);
	   }
   
   
	   @Override
	   public void caseAWriteWriteStmt(AWriteWriteStmt node)
	   {
		   inAWriteWriteStmt(node);
		   if(node.getWrite() != null)
		   {
			   node.getWrite().apply(this);
		   }
		   if(node.getLParen() != null)
		   {
			   node.getLParen().apply(this);
		   }
		   if(node.getWriteExpr() != null)
		   {
			   node.getWriteExpr().apply(this);
		   }
		   if(node.getRParen() != null)
		   {
			   node.getRParen().apply(this);
		   }
		   if(node.getSemi() != null)
		   {
			   node.getSemi().apply(this);
		   }
		   outAWriteWriteStmt(node);
	   }
   
   
	   @Override
	   public void caseAWritelnWriteStmt(AWritelnWriteStmt node)
	   {
		   inAWritelnWriteStmt(node);
		   if(node.getWriteln() != null)
		   {
			   node.getWriteln().apply(this);
		   }
		   if(node.getLParen() != null)
		   {
			   node.getLParen().apply(this);
		   }
		   if(node.getWriteExpr() != null)
		   {
			   node.getWriteExpr().apply(this);
		   }
		   if(node.getRParen() != null)
		   {
			   node.getRParen().apply(this);
		   }
		   if(node.getSemi() != null)
		   {
			   node.getSemi().apply(this);
		   }
		   outAWritelnWriteStmt(node);
	   }
   
   
	   @Override
	   public void caseAIfStmt(AIfStmt node)
	   {
		   inAIfStmt(node);
		   if(node.getIf() != null)
		   {
			   node.getIf().apply(this);
		   }
		   if(node.getRelation() != null)
		   {
			   node.getRelation().apply(this);
		   }
		   if(node.getThen() != null)
		   {
			   node.getThen().apply(this);
		   }
		   if(node.getStmtSeq() != null)
		   {
			   node.getStmtSeq().apply(this);
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
			   node.getEndif().apply(this);
		   }
		   if(node.getSemi() != null)
		   {
			   node.getSemi().apply(this);
		   }
		   outAIfStmt(node);
	   }
   
   
	   @Override
	   public void caseAElseifClause(AElseifClause node)
	   {
		   inAElseifClause(node);
		   if(node.getElseif() != null)
		   {
			   node.getElseif().apply(this);
		   }
		   if(node.getRelation() != null)
		   {
			   node.getRelation().apply(this);
		   }
		   if(node.getThen() != null)
		   {
			   node.getThen().apply(this);
		   }
		   if(node.getStmtSeq() != null)
		   {
			   node.getStmtSeq().apply(this);
		   }
		   outAElseifClause(node);
	   }
   
	   @Override
	   public void caseAElseClause(AElseClause node)
	   {
		   inAElseClause(node);
		   if(node.getElse() != null)
		   {
			   node.getElse().apply(this);
		   }
		   if(node.getStmtSeq() != null)
		   {
			   node.getStmtSeq().apply(this);
		   }
		   outAElseClause(node);
	   }
   
   
	   @Override
	   public void caseALoopStmt(ALoopStmt node)
	   {
		   inALoopStmt(node);
		   if(node.getWhile() != null)
		   {
			   node.getWhile().apply(this);
		   }
		   if(node.getRelation() != null)
		   {
			   node.getRelation().apply(this);
		   }
		   if(node.getLoopStart() != null)
		   {
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
			   node.getLoopEnd().apply(this);
		   }
		   if(node.getSemi() != null)
		   {
			   node.getSemi().apply(this);
		   }
		   outALoopStmt(node);
	   }
   
   
	   @Override
	   public void caseAProcCallStmt(AProcCallStmt node)
	   {
		   inAProcCallStmt(node);
		   if(node.getIdent() != null)
		   {
				TIdent id = node.getIdent();
				String key = id.getText();
				SymbolEntry entry = table.findSymbol(key);
			   	node.getIdent().apply(this);
		   }
		   if(node.getActualParamPart() != null)
		   {
			   node.getActualParamPart().apply(this);
		   }
		   if(node.getSemi() != null)
		   {
			   node.getSemi().apply(this);
		   }
		   outAProcCallStmt(node);
	   }
   
   
	   @Override
	   public void caseAActualParamPart(AActualParamPart node)
	   {
		   inAActualParamPart(node);
		   if(node.getLParen() != null)
		   {
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
			   node.getRParen().apply(this);
		   }
		   outAActualParamPart(node);
	   }
   
   
	   @Override
	   public void caseAAnotherParam(AAnotherParam node)
	   {
		   inAAnotherParam(node);
		   if(node.getComma() != null)
		   {
			   node.getComma().apply(this);
		   }
		   if(node.getSimpleExpr() != null)
		   {
			   node.getSimpleExpr().apply(this);
		   }
		   outAAnotherParam(node);
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
   
   
	   @Override
	   public void caseARelationClause(ARelationClause node)
	   {
		   inARelationClause(node);
		   if(node.getRelOp() != null)
		   {
			   node.getRelOp().apply(this);
		   }
		   if(node.getSimpleExpr() != null)
		   {
			   node.getSimpleExpr().apply(this);
		   }
		   outARelationClause(node);
	   }
   
   
	   @Override
	   public void caseAStringLitWriteExpr(AStringLitWriteExpr node)
	   {
		   inAStringLitWriteExpr(node);
		   if(node.getStringLit() != null)
		   {
			   node.getStringLit().apply(this);
		   }
		   outAStringLitWriteExpr(node);
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
   
	   
	   @Override
	   public void caseANegPrimFactor(ANegPrimFactor node)
	   {
		   inANegPrimFactor(node);
		   if(node.getMinus() != null)
		   {
			   node.getMinus().apply(this);
		   }
		   if(node.getPrimary() != null)
		   {
			   node.getPrimary().apply(this);
		   }
		   outANegPrimFactor(node);
	   }
   
   
	   @Override
	   public void caseANumLitPrimary(ANumLitPrimary node)
	   {
		   inANumLitPrimary(node);
		   if(node.getNumberLit() != null)
		   {
			   node.getNumberLit().apply(this);
		   }
		   outANumLitPrimary(node);
	   }
   
   
	   @Override
	   public void caseANamePrimary(ANamePrimary node)
	   {
		   inANamePrimary(node);
		   if(node.getIdent() != null)
		   {
				TIdent id = node.getIdent();
				String key = id.getText();
				SymbolEntry entry = table.findSymbol(key);
			   	node.getIdent().apply(this);
		   }
		   outANamePrimary(node);
	   }
   
   
	   @Override
	   public void caseAExprPrimary(AExprPrimary node)
	   {
		   inAExprPrimary(node);
		   if(node.getLParen() != null)
		   {
			   node.getLParen().apply(this);
		   }
		   if(node.getSimpleExpr() != null)
		   {
			   node.getSimpleExpr().apply(this);
		   }
		   if(node.getRParen() != null)
		   {
			   node.getRParen().apply(this);
		   }
		   outAExprPrimary(node);
	   }
   
   
	   @Override
	   public void caseAEqRelOp(AEqRelOp node)
	   {
		   inAEqRelOp(node);
		   if(node.getEq() != null)
		   {
			   node.getEq().apply(this);
		   }
		   outAEqRelOp(node);
	   }
   
   
	   @Override
	   public void caseANeqRelOp(ANeqRelOp node)
	   {
		   inANeqRelOp(node);
		   if(node.getNeq() != null)
		   {
			   node.getNeq().apply(this);
		   }
		   outANeqRelOp(node);
	   }
   
   
	   @Override
	   public void caseALtRelOp(ALtRelOp node)
	   {
		   inALtRelOp(node);
		   if(node.getLt() != null)
		   {
			   node.getLt().apply(this);
		   }
		   outALtRelOp(node);
	   }
   
   
	   @Override
	   public void caseALeRelOp(ALeRelOp node)
	   {
		   inALeRelOp(node);
		   if(node.getLe() != null)
		   {
			   node.getLe().apply(this);
		   }
		   outALeRelOp(node);
	   }
   
   
	   @Override
	   public void caseAGtRelOp(AGtRelOp node)
	   {
		   inAGtRelOp(node);
		   if(node.getGt() != null)
		   {
			   node.getGt().apply(this);
		   }
		   outAGtRelOp(node);
	   }
   
   
	   @Override
	   public void caseAGeRelOp(AGeRelOp node)
	   {
		   inAGeRelOp(node);
		   if(node.getGe() != null)
		   {
			   node.getGe().apply(this);
		   }
		   outAGeRelOp(node);
	   }
   
   
	   @Override
	   public void caseAPlusAddOp(APlusAddOp node)
	   {
		   inAPlusAddOp(node);
		   if(node.getPlus() != null)
		   {
			   node.getPlus().apply(this);
		   }
		   outAPlusAddOp(node);
	   }
   
   
	   @Override
	   public void caseAMinusAddOp(AMinusAddOp node)
	   {
		   inAMinusAddOp(node);
		   if(node.getMinus() != null)
		   {
			   node.getMinus().apply(this);
		   }
		   outAMinusAddOp(node);
	   }
   
   
	   @Override
	   public void caseAMultMulOp(AMultMulOp node)
	   {
		   inAMultMulOp(node);
		   if(node.getMult() != null)
		   {
			   node.getMult().apply(this);
		   }
		   outAMultMulOp(node);
	   }
   
   
	   @Override
	   public void caseADivMulOp(ADivMulOp node)
	   {
		   inADivMulOp(node);
		   if(node.getDiv() != null)
		   {
			   node.getDiv().apply(this);
		   }
		   outADivMulOp(node);
	   }
   
   
	   @Override
	   public void caseAModMulOp(AModMulOp node)
	   {
		   inAModMulOp(node);
		   if(node.getMod() != null)
		   {
			   node.getMod().apply(this);
		   }
		   outAModMulOp(node);
	   }
}
