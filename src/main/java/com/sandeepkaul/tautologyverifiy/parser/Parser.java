package com.sandeepkaul.tautologyverifiy.parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Parser {

  public Set<Character> getuniqueStrings(String input) {
    
    String mainInput = input;
    input = input.replaceAll(" ", "");
    input = input.replaceAll("\\(", "");
    input = input.replaceAll("\\)", "");
    input = input.replaceAll("!", "");
    input = input.replaceAll("\\|", "");
    input = input.replaceAll("&", "");
    Set<Character> chars = new HashSet<Character>();
    for (int i = 0 ; i< input.length(); i++) {
      char c = input.charAt(i);
      chars.add(c);
    }
//    System.out.println("For Input:"+mainInput +", returning:"+chars);
    return chars;
  }

  public List<Map<Character, Boolean>> getAllCombinations(Set<Character> chars) {
    List<Character> charsList = new ArrayList<Character>(chars);
    int count = chars.size();
    int total = (int)Math.pow(2, count) ;
    ArrayList<Map<Character, Boolean>> result = new ArrayList<Map<Character,Boolean>>();
    for (int i = 0; i < total; i++) {
      String binary = Integer.toBinaryString(i);
      binary = pad(binary, count);
      
      Map<Character, Boolean> localMap = new HashMap<Character, Boolean>();
      for (int j = 0; j < count;j++) {
        if(binary.charAt(j) == '0') {
          localMap.put(charsList.get(j),  Boolean.FALSE);
        } else {
          localMap.put(charsList.get(j),  Boolean.TRUE);
        }
      }
      result.add(localMap);
    }
    
    return result;
  }
  
  private String pad(String s, int numDigits)
  {
      StringBuffer sb = new StringBuffer(s);
      int numZeros = numDigits - s.length();
      while(numZeros-- > 0) { 
          sb.insert(0, "0");
      }
      return sb.toString();
  }
}
