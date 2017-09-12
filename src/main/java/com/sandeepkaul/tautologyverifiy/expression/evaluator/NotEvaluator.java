package com.sandeepkaul.tautologyverifiy.expression.evaluator;

public class NotEvaluator implements ExpressionEvaluator {

  public boolean evaluate(boolean var1, boolean var2) {
    return !var1;
  }
}
