package com.sandeepkaul.tautologyverifiy.evaluator;

import java.util.Map;

public interface Evaluator {

  public   boolean evaluate(String input, Map<Character, Boolean> keys);
}
