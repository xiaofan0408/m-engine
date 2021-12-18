package com.xiaofan0408.v2.parser.preducate;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:54
 */
public class IsUnderline implements Predicate {
    @Override
    public boolean satisfy(String value) {
        return value.equals("_");
    }
}