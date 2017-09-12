package com.sandeepkaul.tautologyverifiy;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sandeepkaul.tautologyverifiy.evaluator.CustomEvaluator;
import com.sandeepkaul.tautologyverifiy.evaluator.Evaluator;
import com.sandeepkaul.tautologyverifiy.evaluator.ScriptEngineEvaluator;
import com.sandeepkaul.tautologyverifiy.parser.Parser;

public class Tautology {
  
  private Parser parser;
  private Evaluator evaluator;
  public Tautology() {
    parser = new Parser();
//    evaluator = new ScriptEngineEvaluator();
    evaluator = new CustomEvaluator();
  }
  public Tautology(boolean isCustom) {
    parser = new Parser();
    evaluator = new ScriptEngineEvaluator();
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
