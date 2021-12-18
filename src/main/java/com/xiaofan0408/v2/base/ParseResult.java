package com.xiaofan0408.v2.base;


/**
 * @author zefan.xzf
 * @date 2021/12/18 16:07
 */
public class ParseResult<R> {
    private final R value;
    private final ParserInput input;

    public ParseResult(R value, ParserInput input) {
        this.value = value;
        this.input = input;
    }

    public R getValue() {
        return value;
    }

    public ParserInput getInput() {
        return input;
    }
}
