package com.xiaofan0408.v1.impl;

import com.xiaofan0408.v1.ExprAst;

/**
 * @author zefan.xzf
 * @date 2021/12/18 12:15
 */
public class BinaryExprAst implements ExprAst {

    public final static String TYPE = "binary";

    private String op;

    private ExprAst lhs;

    private ExprAst rhs;

    public BinaryExprAst() {
    }

    public BinaryExprAst(String op, ExprAst lhs, ExprAst rhs) {
        this.op = op;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public ExprAst getLhs() {
        return lhs;
    }

    public void setLhs(ExprAst lhs) {
        this.lhs = lhs;
    }

    public ExprAst getRhs() {
        return rhs;
    }

    public void setRhs(ExprAst rhs) {
        this.rhs = rhs;
    }

    @Override
    public String type() {
        return TYPE;
    }

    @Override
    public String toStr() {
        return String.format(
                "BinaryExprAST: (%s %s %s)",
                op,
                lhs.toStr(),
                rhs.toStr()
                );
    }
}
