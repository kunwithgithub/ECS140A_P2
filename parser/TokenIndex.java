/* This file was generated by SableCC (http://www.sablecc.org/). */

package nada.parser;

import nada.node.*;
import nada.analysis.*;

class TokenIndex extends AnalysisAdapter
{
    int index;

    @Override
    public void caseTProc(@SuppressWarnings("unused") TProc node)
    {
        this.index = 0;
    }

    @Override
    public void caseTNull(@SuppressWarnings("unused") TNull node)
    {
        this.index = 1;
    }

    @Override
    public void caseTIf(@SuppressWarnings("unused") TIf node)
    {
        this.index = 2;
    }

    @Override
    public void caseTThen(@SuppressWarnings("unused") TThen node)
    {
        this.index = 3;
    }

    @Override
    public void caseTElse(@SuppressWarnings("unused") TElse node)
    {
        this.index = 4;
    }

    @Override
    public void caseTElseif(@SuppressWarnings("unused") TElseif node)
    {
        this.index = 5;
    }

    @Override
    public void caseTLoop(@SuppressWarnings("unused") TLoop node)
    {
        this.index = 6;
    }

    @Override
    public void caseTWhile(@SuppressWarnings("unused") TWhile node)
    {
        this.index = 7;
    }

    @Override
    public void caseTBegin(@SuppressWarnings("unused") TBegin node)
    {
        this.index = 8;
    }

    @Override
    public void caseTEnd(@SuppressWarnings("unused") TEnd node)
    {
        this.index = 9;
    }

    @Override
    public void caseTEndif(@SuppressWarnings("unused") TEndif node)
    {
        this.index = 10;
    }

    @Override
    public void caseTConst(@SuppressWarnings("unused") TConst node)
    {
        this.index = 11;
    }

    @Override
    public void caseTOut(@SuppressWarnings("unused") TOut node)
    {
        this.index = 12;
    }

    @Override
    public void caseTIs(@SuppressWarnings("unused") TIs node)
    {
        this.index = 13;
    }

    @Override
    public void caseTWrite(@SuppressWarnings("unused") TWrite node)
    {
        this.index = 14;
    }

    @Override
    public void caseTWriteln(@SuppressWarnings("unused") TWriteln node)
    {
        this.index = 15;
    }

    @Override
    public void caseTLParen(@SuppressWarnings("unused") TLParen node)
    {
        this.index = 16;
    }

    @Override
    public void caseTRParen(@SuppressWarnings("unused") TRParen node)
    {
        this.index = 17;
    }

    @Override
    public void caseTDot(@SuppressWarnings("unused") TDot node)
    {
        this.index = 18;
    }

    @Override
    public void caseTSemi(@SuppressWarnings("unused") TSemi node)
    {
        this.index = 19;
    }

    @Override
    public void caseTColon(@SuppressWarnings("unused") TColon node)
    {
        this.index = 20;
    }

    @Override
    public void caseTComma(@SuppressWarnings("unused") TComma node)
    {
        this.index = 21;
    }

    @Override
    public void caseTPlus(@SuppressWarnings("unused") TPlus node)
    {
        this.index = 22;
    }

    @Override
    public void caseTMinus(@SuppressWarnings("unused") TMinus node)
    {
        this.index = 23;
    }

    @Override
    public void caseTMult(@SuppressWarnings("unused") TMult node)
    {
        this.index = 24;
    }

    @Override
    public void caseTDiv(@SuppressWarnings("unused") TDiv node)
    {
        this.index = 25;
    }

    @Override
    public void caseTMod(@SuppressWarnings("unused") TMod node)
    {
        this.index = 26;
    }

    @Override
    public void caseTLt(@SuppressWarnings("unused") TLt node)
    {
        this.index = 27;
    }

    @Override
    public void caseTGt(@SuppressWarnings("unused") TGt node)
    {
        this.index = 28;
    }

    @Override
    public void caseTLe(@SuppressWarnings("unused") TLe node)
    {
        this.index = 29;
    }

    @Override
    public void caseTGe(@SuppressWarnings("unused") TGe node)
    {
        this.index = 30;
    }

    @Override
    public void caseTEq(@SuppressWarnings("unused") TEq node)
    {
        this.index = 31;
    }

    @Override
    public void caseTNeq(@SuppressWarnings("unused") TNeq node)
    {
        this.index = 32;
    }

    @Override
    public void caseTGets(@SuppressWarnings("unused") TGets node)
    {
        this.index = 33;
    }

    @Override
    public void caseTIdent(@SuppressWarnings("unused") TIdent node)
    {
        this.index = 34;
    }

    @Override
    public void caseTNumberLit(@SuppressWarnings("unused") TNumberLit node)
    {
        this.index = 35;
    }

    @Override
    public void caseTStringLit(@SuppressWarnings("unused") TStringLit node)
    {
        this.index = 36;
    }

    @Override
    public void caseEOF(@SuppressWarnings("unused") EOF node)
    {
        this.index = 37;
    }
}
