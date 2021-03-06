/* This file was generated by SableCC (http://www.sablecc.org/). */

package nada.node;

import nada.analysis.*;

@SuppressWarnings("nls")
public final class AParamSpec extends PParamSpec
{
    private PIdentList _identList_;
    private TColon _colon_;
    private TOut _out_;
    private TIdent _ident_;

    public AParamSpec()
    {
        // Constructor
    }

    public AParamSpec(
        @SuppressWarnings("hiding") PIdentList _identList_,
        @SuppressWarnings("hiding") TColon _colon_,
        @SuppressWarnings("hiding") TOut _out_,
        @SuppressWarnings("hiding") TIdent _ident_)
    {
        // Constructor
        setIdentList(_identList_);

        setColon(_colon_);

        setOut(_out_);

        setIdent(_ident_);

    }

    @Override
    public Object clone()
    {
        return new AParamSpec(
            cloneNode(this._identList_),
            cloneNode(this._colon_),
            cloneNode(this._out_),
            cloneNode(this._ident_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAParamSpec(this);
    }

    public PIdentList getIdentList()
    {
        return this._identList_;
    }

    public void setIdentList(PIdentList node)
    {
        if(this._identList_ != null)
        {
            this._identList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identList_ = node;
    }

    public TColon getColon()
    {
        return this._colon_;
    }

    public void setColon(TColon node)
    {
        if(this._colon_ != null)
        {
            this._colon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._colon_ = node;
    }

    public TOut getOut()
    {
        return this._out_;
    }

    public void setOut(TOut node)
    {
        if(this._out_ != null)
        {
            this._out_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._out_ = node;
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

    @Override
    public String toString()
    {
        return ""
            + toString(this._identList_)
            + toString(this._colon_)
            + toString(this._out_)
            + toString(this._ident_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._identList_ == child)
        {
            this._identList_ = null;
            return;
        }

        if(this._colon_ == child)
        {
            this._colon_ = null;
            return;
        }

        if(this._out_ == child)
        {
            this._out_ = null;
            return;
        }

        if(this._ident_ == child)
        {
            this._ident_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._identList_ == oldChild)
        {
            setIdentList((PIdentList) newChild);
            return;
        }

        if(this._colon_ == oldChild)
        {
            setColon((TColon) newChild);
            return;
        }

        if(this._out_ == oldChild)
        {
            setOut((TOut) newChild);
            return;
        }

        if(this._ident_ == oldChild)
        {
            setIdent((TIdent) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
