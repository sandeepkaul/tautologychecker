package com.sandeepkaul.tautologyverifiy.evaluator;

import java.util.Map;
import java.util.Map.Entry;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class ScriptEngineEvaluator implements Evaluator {

  public   boolean evaluate(String input, Map<Character, Boolean> keys)  {
    try {
//      System.out.println("Evaluating Input:"+input + " For Keys:"+keys);
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

    for (Entry<Character, Boolean> entry : keys.entrySet()) {
      String s = entry.getKey() + " = " + entry.getValue().toString();
      engine.eval(s);
    }

    String expr = input;
    Integer result = (Integer)engine.eval(expr);
    if(result == 1) {
      return true;
    }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
  
}
