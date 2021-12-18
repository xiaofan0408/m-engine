package com.xiaofan0408.v1;

/**
 * @author zefan.xzf
 * @date 2021/12/18 11:17
 */
public class Token {

    private String tok;

    private TokenType type;

    private int offset;

    public Token() {

    }

    public Token(String tok, TokenType type) {
        this.tok = tok;
        this.type = type;
    }

    public String getTok() {
        return tok;
    }

    public void setTok(String tok) {
        this.tok = tok;
    }

    public TokenType getType() {
        return type;
    }

    public void setType(TokenType type) {
        this.type = type;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tok='" + tok + '\'' +
                ", type=" + type.name() +
                '}';
    }
}
