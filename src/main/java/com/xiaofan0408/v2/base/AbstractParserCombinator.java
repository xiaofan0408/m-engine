package com.xiaofan0408.v2.base;

import com.xiaofan0408.v2.parser.*;
import com.xiaofan0408.v2.parser.preducate.Predicate;

/**
 * @author zefan.xzf
 * @date 2021/12/18 16:21
 */
public abstract class AbstractParserCombinator<T> implements Parser<T> {

    public Item item(){
        return new Item();
    }

    public OneOrMany oneOrMany(int count) {
        return new OneOrMany(count,this);
    }

    public OR or(Parser<T> b){
        return new OR(this,b);
    }

    public SAT sat(Parser<T> parser, Predicate pre){
        return new SAT(pre,parser);
    }

    public SEQ seq(Parser<T> b) {
        return new SEQ(this,b);
    }

    public Zero zero(){
        return new Zero();
    }




}
