/* This file was generated by SableCC (http://www.sablecc.org/). */

package nada.node;

import nada.analysis.*;

@SuppressWarnings("nls")
public final class ALoopStmt extends PLoopStmt
{
    private TWhile _while_;
    private PRelation _relation_;
    private TLoop _loopStart_;
    private PStmtSeq _stmtSeq_;
    private TEnd _end_;
    private TLoop _loopEnd_;
    private TSemi _semi_;

    public ALoopStmt()
    {
        // Constructor
    }

    public ALoopStmt(
        @SuppressWarnings("hiding") TWhile _while_,
        @SuppressWarnings("hiding") PRelation _relation_,
        @SuppressWarnings("hiding") TLoop _loopStart_,
        @SuppressWarnings("hiding") PStmtSeq _stmtSeq_,
        @SuppressWarnings("hiding") TEnd _end_,
        @SuppressWarnings("hiding") TLoop _loopEnd_,
        @SuppressWarnings("hiding") TSemi _semi_)
    {
        // Constructor
        setWhile(_while_);

        setRelation(_relation_);

        setLoopStart(_loopStart_);

        setStmtSeq(_stmtSeq_);

        setEnd(_end_);

        setLoopEnd(_loopEnd_);

        setSemi(_semi_);

    }

    @Override
    public Object clone()
    {
        return new ALoopStmt(
            cloneNode(this._while_),
            cloneNode(this._relation_),
            cloneNode(this._loopStart_),
            cloneNode(this._stmtSeq_),
            cloneNode(this._end_),
            cloneNode(this._loopEnd_),
            cloneNode(this._semi_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALoopStmt(this);
    }

    public TWhile getWhile()
    {
        return this._while_;
    }

    public void setWhile(TWhile node)
    {
        if(this._while_ != null)
        {
            this._while_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._while_ = node;
    }

    public PRelation getRelation()
    {
        return this._relation_;
    }

    public void setRelation(PRelation node)
    {
        if(this._relation_ != null)
        {
            this._relation_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._relation_ = node;
    }

    public TLoop getLoopStart()
    {
        return this._loopStart_;
    }

    public void setLoopStart(TLoop node)
    {
        if(this._loopStart_ != null)
        {
            this._loopStart_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._loopStart_ = node;
    }

    public PStmtSeq getStmtSeq()
    {
        return this._stmtSeq_;
    }

    public void setStmtSeq(PStmtSeq node)
    {
        if(this._stmtSeq_ != null)
        {
            this._stmtSeq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._stmtSeq_ = node;
    }

    public TEnd getEnd()
    {
        return this._end_;
    }

    public void setEnd(TEnd node)
    {
        if(this._end_ != null)
        {
            this._end_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._end_ = node;
    }

    public TLoop getLoopEnd()
    {
        return this._loopEnd_;
    }

    public void setLoopEnd(TLoop node)
    {
        if(this._loopEnd_ != null)
        {
            this._loopEnd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._loopEnd_ = node;
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
            + toString(this._while_)
            + toString(this._relation_)
            + toString(this._loopStart_)
            + toString(this._stmtSeq_)
            + toString(this._end_)
            + toString(this._loopEnd_)
            + toString(this._semi_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._while_ == child)
        {
            this._while_ = null;
            return;
        }

        if(this._relation_ == child)
        {
            this._relation_ = null;
            return;
        }

        if(this._loopStart_ == child)
        {
            this._loopStart_ = null;
            return;
        }

        if(this._stmtSeq_ == child)
        {
            this._stmtSeq_ = null;
            return;
        }

        if(this._end_ == child)
        {
            this._end_ = null;
            return;
        }

        if(this._loopEnd_ == child)
        {
            this._loopEnd_ = null;
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
        if(this._while_ == oldChild)
        {
            setWhile((TWhile) newChild);
            return;
        }

        if(this._relation_ == oldChild)
        {
            setRelation((PRelation) newChild);
            return;
        }

        if(this._loopStart_ == oldChild)
        {
            setLoopStart((TLoop) newChild);
            return;
        }

        if(this._stmtSeq_ == oldChild)
        {
            setStmtSeq((PStmtSeq) newChild);
            return;
        }

        if(this._end_ == oldChild)
        {
            setEnd((TEnd) newChild);
            return;
        }

        if(this._loopEnd_ == oldChild)
        {
            setLoopEnd((TLoop) newChild);
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
