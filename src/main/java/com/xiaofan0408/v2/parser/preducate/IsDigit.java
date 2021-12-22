package com.xiaofan0408.v2.parser.preducate;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:16
 */
public class IsDigit implements Predicate<Character>{

    public boolean satisfy(Character value) {
        char c = value;
        return c>='0' && c<='9';
    }
}
