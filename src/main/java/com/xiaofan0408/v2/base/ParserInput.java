package com.xiaofan0408.v2.base;

import java.util.LinkedList;

/**
 * @author zefan.xzf
 * @date 2021/12/18 16:07
 */
public class ParserInput<E> {
    private final LinkedList<E> source;
    private final Position position;
    static class Position {
        int index;
    }
    public ParserInput(LinkedList<E> source) {
        this.source = source;
        this.position = new Position();
    }

    public ParserInput(LinkedList<E> source, Position position) {
        this.source = source;
        this.position = position;
    }

    public boolean empty() {
        return source.isEmpty();
    }

    public E current() {
        return source.peek();
    }

    public void advance() {
//        advance(1);
        source.removeFirst();
    }

    public void advance(int n) {
//        position.index += n;
    }

    public ParserInput<E> rest() {
        return new ParserInput<>(source,position);
    }
}
