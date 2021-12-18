package com.xiaofan0408.v2.base;

/**
 * @author zefan.xzf
 * @date 2021/12/18 16:07
 */
public class ParserInput {
    private final String source;
    private final Position position;
    static class Position {
        int index;
    }
    public ParserInput(String source) {
        this.source = source;
        this.position = new Position();
    }

    public ParserInput(String source, Position position) {
        this.source = source;
        this.position = position;
    }

    public char current() {
        return source.charAt(position.index);
    }

    public boolean empty(){
        return source.length() == position.index;
    }

    public void advance() {
        advance(1);
    }

    public void advance(int n) {
        position.index += n;
    }

    public ParserInput rest() {
        return new ParserInput(source,position);
    }
}
