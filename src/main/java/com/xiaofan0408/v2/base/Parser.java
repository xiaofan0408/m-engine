package com.xiaofan0408.v2.base;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 16:06
 */
public interface Parser <T,E> {
    Optional<ParseResult<T>> parse(ParserInput<E> input);
}

