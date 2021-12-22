package com.xiaofan0408.v2.base;

/**
 * @author zefan.xzf
 * @date 2021/12/20 18:36
 */
public class Pair<T,U> {

    private T t1;

    private U u1;

    public Pair(T t1, U u1) {
        this.t1 = t1;
        this.u1 = u1;
    }

    public T getT1() {
        return t1;
    }

    public U getU1() {
        return u1;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "t1=" + t1 +
                ", u1=" + u1 +
                '}';
    }
}
