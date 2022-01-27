package com.xiaofan0408.v1;

import com.xiaofan0408.v1.impl.BinaryExprAst;
import com.xiaofan0408.v1.impl.FuncExprAst;
import com.xiaofan0408.v1.impl.NumberExprAst;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author zefan.xzf
 * @date 2021/12/18 14:22
 */
public class Evaluator {

    public double eval(ExprAst expr) throws Exception {
        double l,r;

        switch (expr.type()){

            case BinaryExprAst.TYPE:{
                BinaryExprAst binAst = (BinaryExprAst)expr;
                l = eval(binAst.getLhs());
                r = eval(binAst.getRhs());
                switch (binAst.getOp()){
                    case "+":{
                        return l + r;
                    }
                    case "-":{
                        return l - r;
                    }
                    case "*":{
                        return l * r;
                    }
                    case "/":{
                        if(r == 0){
                            throw new Exception(String.format("violation of arithmetic specification: a division by zero in ExprASTResult: [%g/%g]",
                                    l,
                                    r));
                        }
                        return l / r;
                    }
                    case "%":{
                        return l % r;
                    }
                    case "^":{
                        return Math.pow(l,r);
                    }
                    default:{}
                }
            }
            case NumberExprAst.TYPE:{
                return ((NumberExprAst)expr).getVal();
            }
            case FuncExprAst.TYPE: {
                FuncExprAst funcExprAst = (FuncExprAst)expr;
                Function<List<Double>,Double> function = BuildInFuncContext.buildInFunc.get(funcExprAst.getFuncName());
                List<Double> doubles = new ArrayList<>();
                for (ExprAst e:funcExprAst.getExprAstList()) {
                    doubles.add(eval(e));
                }
                return function.apply(doubles);
            }
            default:{
                return 0.0;
            }
        }

    }

}
