package com.xiaofan0408.v2.parser.preducate;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:53
 */
public class IsAlpha implements Predicate<Character> {
    public boolean satisfy(Character value) {
        char c = value;
        return (c>='a' && c<='z') || (c>='A' && c<='Z');
    }
}
