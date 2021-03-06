/* This file was generated by SableCC (http://www.sablecc.org/). */

package nada.node;

import nada.analysis.*;

@SuppressWarnings("nls")
public final class AAssignStmt extends PAssignStmt
{
    private TIdent _ident_;
    private TGets _gets_;
    private PSimpleExpr _simpleExpr_;
    private TSemi _semi_;

    public AAssignStmt()
    {
        // Constructor
    }

    public AAssignStmt(
        @SuppressWarnings("hiding") TIdent _ident_,
        @SuppressWarnings("hiding") TGets _gets_,
        @SuppressWarnings("hiding") PSimpleExpr _simpleExpr_,
        @SuppressWarnings("hiding") TSemi _semi_)
    {
        // Constructor
        setIdent(_ident_);

        setGets(_gets_);

        setSimpleExpr(_simpleExpr_);

        setSemi(_semi_);

    }

    @Override
    public Object clone()
    {
        return new AAssignStmt(
            cloneNode(this._ident_),
            cloneNode(this._gets_),
            cloneNode(this._simpleExpr_),
            cloneNode(this._semi_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAssignStmt(this);
    }

    public TIdent getIdent()
    {
        return this._ident_;
    }

    public void setIdent(TIdent node)
    {
        if(this._ident_ != null)
        {
            this._ident_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ident_ = node;
    }

    public TGets getGets()
    {
        return this._gets_;
    }

    public void setGets(TGets node)
    {
        if(this._gets_ != null)
        {
            this._gets_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._gets_ = node;
    }

    public PSimpleExpr getSimpleExpr()
    {
        return this._simpleExpr_;
    }

    public void setSimpleExpr(PSimpleExpr node)
    {
        if(this._simpleExpr_ != null)
        {
            this._simpleExpr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._simpleExpr_ = node;
    }

    public TSemi getSemi()
    {
        return this._semi_;
    }

    public void setSemi(TSemi node)
    {
        if(this._semi_ != null)
        {
            this._semi_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._semi_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ident_)
            + toString(this._gets_)
            + toString(this._simpleExpr_)
            + toString(this._semi_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ident_ == child)
        {
            this._ident_ = null;
            return;
        }

        if(this._gets_ == child)
        {
            this._gets_ = null;
            return;
        }

        if(this._simpleExpr_ == child)
        {
            this._simpleExpr_ = null;
            return;
        }

        if(this._semi_ == child)
        {
            this._semi_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._ident_ == oldChild)
        {
            setIdent((TIdent) newChild);
            return;
        }

        if(this._gets_ == oldChild)
        {
            setGets((TGets) newChild);
            return;
        }

        if(this._simpleExpr_ == oldChild)
        {
            setSimpleExpr((PSimpleExpr) newChild);
            return;
        }

        if(this._semi_ == oldChild)
        {
            setSemi((TSemi) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
