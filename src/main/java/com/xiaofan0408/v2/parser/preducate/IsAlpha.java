package com.xiaofan0408.v2.parser.preducate;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:53
 */
public class IsAlpha implements Predicate {
    public boolean satisfy(String value) {
        char c = value.charAt(0);
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
}
