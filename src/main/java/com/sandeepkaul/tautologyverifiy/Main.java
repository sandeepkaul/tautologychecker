package com.sandeepkaul.tautologyverifiy;

import java.util.ArrayList;
import java.util.List;

public class Main {

  
  public static void main(String[] args) {
    
    List<String> inputs = new ArrayList<String>();
    inputs.add("(a|!a)");
    inputs.add("(!a | (b & !a))");
    inputs.add("(!a | (a & a))");
    inputs.add("((a & (!b | b)) | (!a & (!b | b)))");
    inputs.add("a|b|c|!c");
    inputs.add("a|b|c|!c|d|e|f|g|!h");
    inputs.add("(!a|b|c|!c)&(d|!e|f|g|!h)");
    inputs.add("(!a|b|c|!c)&(d|!e|f|g|!g)");
    inputs.add("(!a|b|c|!c)|(d|!e|f|g|!h)");
    
//    inputs.add("(a|b)");
//    inputs.add("(a|!a)");
//    inputs.add("(!a | (a & a))");
//    inputs.add("(!a | (b & !a))");
//      inputs.add("(!a | a)");
    inputs.add("((a & (!b | b)) | (!a & (!b | b)))");
    
    Tautology tautology = new Tautology();
    
    for (String str : inputs) {
      tautology.verify(str);
    }
    
  }
}
