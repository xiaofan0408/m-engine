package com.xiaofan0408.v1;

import com.xiaofan0408.v1.impl.BinaryExprAst;
import com.xiaofan0408.v1.impl.FuncExprAst;
import com.xiaofan0408.v1.impl.NumberExprAst;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zefan.xzf
 * @date 2021/12/18 12:25
 */
public class Parser {

    private List<Token> tokens;

    private String source;

    private Token currTok;

    private int currIndex;

    private StringBuffer error;


    public Parser(List<Token> tokens, String source){
        this.tokens = tokens;
        this.source = source;
        currTok = tokens.get(0);
        currIndex = 0;
    }


    public ExprAst parseExpression() {
        ExprAst lhs = parsePrimary();
        return parseBinOpRHS(0,lhs);
    }

    private ExprAst parseBinOpRHS(int execPrec, ExprAst lhs) {
        while (true){
            int tokPrec = getTokPrecedence();
            if (tokPrec < execPrec) {
                return lhs;
            }
            String binOp = currTok.getTok();
            if (getNextToken() == null) {
                return lhs;
            }
            ExprAst rhs = parsePrimary();
            if (rhs == null) {
                return null;
            }
            int nextPrec = getTokPrecedence();
            if (tokPrec < nextPrec) {
                rhs = parseBinOpRHS(tokPrec + 1,rhs);
                if (rhs == null) {
                    return null;
                }
            }
            lhs = new BinaryExprAst(binOp,lhs,rhs);
        }
    }

    private int getTokPrecedence(){
        if (ParserConstant.precedence.containsKey(currTok.getTok())) {
            return ParserConstant.precedence.get(currTok.getTok());
        }
        return -1;
    }

    private NumberExprAst parseNumber(){
       try {
           double val = Double.parseDouble(currTok.getTok());
           NumberExprAst numberExprAst = new NumberExprAst();
           numberExprAst.setVal(val);
           getNextToken();
           return numberExprAst;
       }catch (Exception e){
           error.append(String.format("\nwant '(' or '0-9' but get '%s'\n", currTok.getTok()))
;       }
       return new NumberExprAst();
    }

    private Token getNextToken() {
        currIndex++;
        if (currIndex < tokens.size()) {
            currTok = tokens.get(currIndex);
            return currTok;
        }
        return null;
    }

    private ExprAst parsePrimary(){
        switch (currTok.getType()){
            case Literal:{
                return parseNumber();
            }
            case Operator:{
                if (currTok.getTok().equals("(")) {
                    getNextToken();
                    ExprAst e = parseExpression();
                    if (e == null) {
                        return null;
                    }
                    if (!currTok.getTok().equals(")")) {
                        error.append(String.format("want ')' but get %s\n",currTok.getTok()));
                    }
                    getNextToken();
                    return e;
                } else {
                    return parseNumber();
                }
            }
            case Variable: {
                if (BuildInFuncContext.buildInFunc.containsKey(currTok.getTok())) {
                    return parseFunction(currTok.getTok());
                } else {
                    error.append(String.format("unkown variable: %s, pos[%d]", currTok.getTok(),currTok.getOffset()));
                }
            }
            default:{
                return null;
            }
        }
    }

    private ExprAst parseFunction(String token) {
        getNextToken();
       List<ExprAst> argList = new ArrayList<>();
        if (currTok.getTok().equals("(")) {
            while (getNextToken() != null){
                if (currTok.getTok().equals(")")) {
                    break;
                }
                if (currTok.getTok().equals(",")) {
                    continue;
                }
                ExprAst e = parseExpression();
                argList.add(e);
            }
        }
        return new FuncExprAst(token,argList);
    }
}
