package com.xiaofan0408.v1;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zefan.xzf
 * @date 2021/12/18 11:19
 */
public class Lexer {

    private String source;

    private char ch;

    private int offset;

    private StringBuffer error;

    private boolean hadNext;

    private List<Token> list;

    public Lexer(String s) throws Exception {
        this.source = s;
        ch = source.charAt(0);
        offset = 0;
        error = new StringBuffer();
        list = parse();
        if (error.length() > 0) {
            throw new Exception("lex error: " + error.toString());
        }
    }

    private List<Token> parse(){
        List<Token> tokens = new ArrayList<>();
        while (true) {
            Token tok = nextTok();
            if (tok == null) {
                break;
            }
            tokens.add(tok);
        }
        return tokens;
    }

    private Token nextTok() {
        if (offset >= source.length() || error.length() > 0) {
            return null;
        }
        while (isWhitespace(ch) && error.length() == 0) {

        }
        int start = offset;
        Token token = null;

        if (TokenConstant.op.contains(ch)) {
            token = new Token();
            token.setTok(Character.toString(ch));
            token.setType(TokenType.Operator);
            token.setOffset(start);
            hadNext = nextCh();

        } else if (TokenConstant.literal.contains(ch)) {
            while (isDigitNum(ch) && nextCh()){
            }
            token = new Token();
            token.setTok(source.substring(start,offset).replaceAll("_",""));
            token.setType(TokenType.Literal);
            token.setOffset(start);
        } else {
            if (ch != ' ') {
                error.append(String.format("symbol error: unkown '%s', pos [%d:]\n",ch,start));
            }
        }
        return token;
    }

    private boolean nextCh() {
        offset++;
        if (offset < source.length()) {
            ch = source.charAt(offset);
            return true;
        }
        return false;
    }


    private boolean isWhitespace(char ch) {
        return  ch == ' ' ||
                ch == '\t' ||
                ch == '\n' ||
                ch == '\f' ||
                ch == '\r';
    }

    private boolean isDigitNum(char c) {
        return '0' <= c && c <= '9' || c == '.' || c == '_' || c == 'e';
    }

    public List<Token> getTokens() {
        return list;
    }

    public String getSource() {
        return source;
    }
}
