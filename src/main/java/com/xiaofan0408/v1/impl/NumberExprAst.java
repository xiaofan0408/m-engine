package com.xiaofan0408.v1.impl;

import com.xiaofan0408.v1.ExprAst;

/**
 * @author zefan.xzf
 * @date 2021/12/18 12:15
 */
public class NumberExprAst implements ExprAst {

    public final static String TYPE = "number";

    private double val;

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    @Override
    public String type() {
        return TYPE;
    }

    @Override
    public String toStr() {
        return  "NumberExprAST:" + val;
    }


}
