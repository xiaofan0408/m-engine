package com.xiaofan0408.v2.parser.preducate;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:16
 */
public class IsDigit implements Predicate{

    public boolean satisfy(String value) {
        char c = value.charAt(0);
        return c>='0' && c<='9';
    }
}
