package com.sandeepkaul.tautologyverifiy;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
  
  private Tautology tautology;
  
  /**
   * Create the test case
   *
   * @param testName name of the test case
   */
  public AppTest(String testName) {
    
    super(testName);
    tautology = new Tautology();
  }

  
  public void testAllScenarios() {
    
    
    // Using Custom parser
    tautology = new Tautology();
    actualTest(tautology);
    
    
    
    //Using Script parser
    tautology = new Tautology(false);
    actualTest(tautology);
  }


  private void actualTest(Tautology tautology) {
    assertEquals(true, tautology.verify("(a|!a)"));
    assertEquals(false,tautology.verify("(!a | (b & !a))"));
    assertEquals(true,tautology.verify("(!a | (a & a))"));
    assertEquals(true,tautology.verify("((a & (!b | b)) | (!a & (!b | b)))"));
    assertEquals(true,tautology.verify("(a|b|c|!c)"));
    assertEquals(true,tautology.verify("(((a|b)|(c|!c))|((d|e)|(f|g)))"));
    assertEquals(true,tautology.verify("(((a|b)|(c|!c))|((d|e)|(f|!f)))"));
    assertEquals(false,tautology.verify("(((!a|b)|(c|!c))&((d|!e)|(f|g)))"));
    assertEquals(true,tautology.verify("(((!a|c)|(b|!c))|((d|!e)|(f|!h)))"));
    
  }
  
}
