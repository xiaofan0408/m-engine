package com.xiaofan0408.v2.util;

import com.xiaofan0408.v2.base.ParserInput;
import com.xiaofan0408.v2.base.ParseResult;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 16:53
 */
public class CommonUtils {

    public static <R> Optional<ParseResult<R>> makeResult(R value, ParserInput s) {
        return Optional.of(new ParseResult<>(value, s));
    }

}
