package com.sandeepkaul.tautologyverifiy.expression.evaluator;

import com.sandeepkaul.tautologyverifiy.model.TokenType;

public class ExpressionEvaluatorFactory {

  private static ExpressionEvaluator notEvaluator = new NotEvaluator();
  private static ExpressionEvaluator andEvaluator = new AndEvaluator();
  private static ExpressionEvaluator orEvaluator = new OrEvaluator();

  public static ExpressionEvaluator getExpressionEvaluator(TokenType tt) {

    switch (tt) {
      case UNARY_NOT:
        return notEvaluator;
      case BINARY_AND:
        return andEvaluator;
      case BINARY_OR:
        return orEvaluator;

      default:
        return null;
    }
  }
}
