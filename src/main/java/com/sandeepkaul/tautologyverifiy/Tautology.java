package com.sandeepkaul.tautologyverifiy;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sandeepkaul.tautologyverifiy.evaluator.Evaluator;
import com.sandeepkaul.tautologyverifiy.parser.Parser;

public class Tautology {
  
  private Parser parser;
  private Evaluator evaluator;
  public Tautology() {
    parser = new Parser();
    evaluator = new Evaluator();
  }

  public boolean verify(String input) {
    
    boolean result = true;
    Set<Character> chars = parser.getuniqueStrings(input);
    List<Map<Character, Boolean>> list = parser.getAllCombinations(chars);
    for (Map<Character, Boolean> map : list) {
      boolean evalResult = evaluator.evaluate(input, map);
      if(evalResult ==  false) {
        System.out.println("Returning False for Input:"+input);
        return false;
      }
    }
    System.out.println("Returning True for Input:"+input);
    return result;
    
  }
}
