package com.xiaofan0408.v2.parser.preducate;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:10
 */
public interface Predicate<T> {
     boolean satisfy(T value);
}