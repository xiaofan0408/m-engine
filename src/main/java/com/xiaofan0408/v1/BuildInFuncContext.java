package com.xiaofan0408.v1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author zefan.xzf
 * @date 2022/1/26 14:39
 */
public class BuildInFuncContext {

    public static Map<String, Function<List<Double>, Double>> buildInFunc = new HashMap<>();

    static {
        buildInFunc.put("sqrt", BuildInFuncContext::sqrt);
        buildInFunc.put("sin", BuildInFuncContext::sin);
        buildInFunc.put("pow",BuildInFuncContext::pow);
    }


    private static double sqrt(List<Double> args){
        double r = args.get(0);
        return Math.sqrt(r);
    }

    private static double sin(List<Double> args){
        double r = args.get(0);
        return Math.sin(r);
    }

    private static double pow(List<Double> args){
        double a = args.get(0);
        double b = args.get(1);
        return Math.pow(a,b);
    }

}
