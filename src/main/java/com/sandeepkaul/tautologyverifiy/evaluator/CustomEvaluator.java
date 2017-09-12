package com.sandeepkaul.tautologyverifiy.evaluator;

import java.util.Map;
import java.util.Stack;

import com.sandeepkaul.tautologyverifiy.expression.evaluator.ExpressionEvaluator;
import com.sandeepkaul.tautologyverifiy.expression.evaluator.ExpressionEvaluatorFactory;
import com.sandeepkaul.tautologyverifiy.expression.evaluator.NotEvaluator;
import com.sandeepkaul.tautologyverifiy.model.TokenType;
import com.sandeepkaul.tautologyverifiy.util.TokenUtils;

public class CustomEvaluator implements Evaluator {

 public boolean evaluate(String input, Map<Character, Boolean> keys) {
    
    input = input.replaceAll(" ","");
    Stack<Object> stack = new Stack<Object>();
    for (int i = 0; i < input.length();i++) {
      Character c = input.charAt(i);
      TokenType tokenType = TokenUtils.getTokenType(c,keys);
      if(tokenType == TokenType.OPEN_PARANTHESIS) {
        stack.push(c);
      } else if(tokenType == TokenType.KEYWORD) {
        boolean value = getValue(c, keys);
        stack.push(value);
      } else if(tokenType == TokenType.UNARY_NOT) {
        Character c1 = input.charAt(i+1);
        i++;
        boolean value = getValue(c1, keys);
        value = !value;
        stack.push(value);
      } else if(tokenType != TokenType.CLOSED_PARANTHESIS){
        // OR NOT type of operators
        stack.push(c);
      } else if(tokenType == TokenType.CLOSED_PARANTHESIS) {
        // Start Popping till open paren, then calculate result and push again
        boolean bool1;
        boolean bool2;
        Object obj1 = stack.pop();
        if(obj1 instanceof Boolean){
          bool1 =(Boolean)obj1;
        } else {
          bool1 = getValue((Character)obj1, keys);
        }
        Character operand = (Character)stack.pop();
        Object obj2 = stack.pop();
        if(obj2 instanceof Boolean){
          bool2 =(Boolean)obj2;
        } else {
          bool2 = getValue((Character)obj2, keys);
        }
        Object possibleOpenParen = stack.pop();
        if(!possibleOpenParen.equals(new Character('('))) {
          // Not an open parenthesis. Push it back.
          stack.push(possibleOpenParen);
        }
      
        TokenType operandType = TokenUtils.getTokenType(operand, keys);
        ExpressionEvaluator evaluator = ExpressionEvaluatorFactory.getExpressionEvaluator(operandType);
        boolean result  = evaluator.evaluate(bool1, bool2);
        stack.push(result);
      }
     
      
    }
    boolean finalResult = (Boolean)stack.pop();
    return finalResult;
  }
 
  public boolean evaluate1(String input, Map<Character, Boolean> keys) {
    
    input = input.replaceAll(" ","");
    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < input.length();i++) {
      Character c = input.charAt(i);
      TokenType tokenType = TokenUtils.getTokenType(c,keys);
      
      if(tokenType == TokenType.KEYWORD) {
        boolean value  = getValue(c,keys);
        stack.push(c);
      } else if(tokenType != TokenType.CLOSED_PARANTHESIS) {
        stack.push(c);
      } else if(tokenType == TokenType.CLOSED_PARANTHESIS) {
        Character keyword1  = stack.pop();
        Character operator  = stack.pop();
        TokenType operatorTokenType = TokenUtils.getTokenType(operator,keys);
        if(operatorTokenType ==  TokenType.UNARY_NOT) {
          evaluate(operatorTokenType, keys.get(keyword1));
        } else {
          Character keyword2  = stack.pop();
          Character prevChar = stack.pop();
          if(prevChar == '!') {
            
          }
          
        }
      }
    }
    return false;
  }

  private boolean getValue(Character c, Map<Character, Boolean> keys) {
//    System.out.println("getValue for:"+c+" and keys:"+keys);
   return  keys.get(c);
  }

  private boolean evaluate(TokenType operatorTokenType, Boolean boolean1) {
    ExpressionEvaluator evaluator = ExpressionEvaluatorFactory.getExpressionEvaluator(operatorTokenType);
    return evaluator.evaluate(boolean1, boolean1);
  }

  private boolean evaluate(TokenType operatorTokenType, Boolean boolean1 , Boolean boolean2) {
    ExpressionEvaluator evaluator = ExpressionEvaluatorFactory.getExpressionEvaluator(operatorTokenType);
    return evaluator.evaluate(boolean1, boolean2);
  }
  
}
