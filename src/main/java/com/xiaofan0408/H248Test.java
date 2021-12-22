package com.xiaofan0408;

import com.xiaofan0408.v2.base.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author zefan.xzf
 * @date 2021/12/18 17:55
 */
public class H248Test {

    public static void main(String[] args) {
        Parser<Pair<String, String>, Character> nameParser = H248Parsec.name();
        LinkedList<Character> list = new LinkedList<>();
        char[] chArr = "U123_".toCharArray();
        for (char ch : chArr) {
            list.addLast(ch);
        }

        Optional<ParseResult<Pair<String,String>>> parseResult = nameParser.parse(new ParserInput<>(list));
        System.out.println(parseResult.isPresent()? parseResult.get().getValue():"");
    }

}
