package com.sandeepkaul.tautologyverifiy.util;

import java.util.Map;

import com.sandeepkaul.tautologyverifiy.model.TokenType;

public class TokenUtils {

  public static TokenType getTokenType(Character c, Map<Character, Boolean> keys) {

    if (c == '(') {
      return TokenType.OPEN_PARANTHESIS;
    }
    if (c == ')') {
      return TokenType.CLOSED_PARANTHESIS;
    }
    if (c == '!') {
      return TokenType.UNARY_NOT;
    }
    if (c == '|') {
      return TokenType.BINARY_OR;
    }
    if (c == '&') {
      return TokenType.BINARY_AND;
    }
    if (keys.containsKey(c)) {
      return TokenType.KEYWORD;
    }
    throw new RuntimeException("Unknown Character:" + c);

  }
}
