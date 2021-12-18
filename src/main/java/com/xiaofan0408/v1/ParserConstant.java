package com.xiaofan0408.v1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zefan.xzf
 * @date 2021/12/18 12:27
 */
public class ParserConstant {

    public static Map<String,Integer> precedence = new HashMap<>();

    static {
        precedence.put("+",20);
        precedence.put("-",20);
        precedence.put("*",40);
        precedence.put("/",40);
        precedence.put("%",40);
        precedence.put("^",60);
    }
}
