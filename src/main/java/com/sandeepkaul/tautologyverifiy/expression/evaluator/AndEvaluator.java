package com.sandeepkaul.tautologyverifiy.expression.evaluator;

public class AndEvaluator implements ExpressionEvaluator  {

  public boolean evaluate(boolean var1, boolean var2) {
    return var1&var2;
  }

}
