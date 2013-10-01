import junit.framework.*;

public class AllTests {
  public static TestSuite suite () {
    TestSuite suite = new TestSuite (" Mes tests " );
    suite.addTest(new TestSuite(Test.class));
    
    return suite;
  }  
  
  public static void main ( String args [])
  {
    junit.textui.TestRunner.run(AllTests.suite());
  }

}
