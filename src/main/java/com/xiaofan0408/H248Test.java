package com.xiaofan0408;

import com.xiaofan0408.v2.base.ParseResult;
import com.xiaofan0408.v2.base.Parser;
import com.xiaofan0408.v2.base.ParserInput;

import java.util.Optional;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:55
 */
public class H248Test {

    public static void main(String[] args) {
        Parser<String>  nameParser = H248Parsec.name();
        Optional<ParseResult<String>> parseResult = nameParser.parse(new ParserInput("U123_"));
        System.out.println(parseResult.isPresent()? parseResult.get().getValue():"");
    }

}
