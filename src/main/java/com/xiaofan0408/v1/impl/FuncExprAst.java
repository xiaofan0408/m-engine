package com.xiaofan0408.v1.impl;

import com.xiaofan0408.v1.ExprAst;

import java.util.List;

/**
 * @author zefan.xzf
 * @date 2022/1/26 14:30
 */
public class FuncExprAst implements ExprAst {

    public final static String TYPE = "func";

    private String funcName;

    private List<ExprAst> exprAstList;

    public FuncExprAst(String funcName, List<ExprAst> exprAstList) {
        this.funcName = funcName;
        this.exprAstList = exprAstList;
    }

    public String getFuncName() {
        return funcName;
    }

    public List<ExprAst> getExprAstList() {
        return exprAstList;
    }

    @Override
    public String type() {
        return TYPE;
    }

    @Override
    public String toStr() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FuncExprAst: ");
        stringBuffer.append(funcName);
        if (exprAstList.size() > 0) {
            stringBuffer.append(",arg:");
            for (ExprAst exprAst: exprAstList) {
                stringBuffer.append(exprAst.toStr());
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString();
    }
}
