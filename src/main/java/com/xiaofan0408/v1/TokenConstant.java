package com.xiaofan0408.v1;

import java.util.*;
import java.util.function.Function;

/**
 * @author zefan.xzf
 * @date 2021/12/18 11:35
 */
public class TokenConstant {

    public static Set<Character> op = new HashSet<>();

    public static Set<Character> literal = new HashSet<>();

    static {
        op.add('(') ;
        op.add(')') ;
        op.add('+') ;
        op.add('-') ;
        op.add('*') ;
        op.add('/') ;
        op.add('^') ;
        op.add('%') ;
        op.add(',') ;

        literal.add('0');
        literal.add('1');
        literal.add('2');
        literal.add('3');
        literal.add('4');
        literal.add('5');
        literal.add('6');
        literal.add('7');
        literal.add('8');
        literal.add('9');

    }

}
