import junit.framework.*;

public class Test extends TestCase
{
  public Test ( String name ) { super ( name ); }
  
  public void test_histoire1()
  {
    Yinsh jeuYinsh=new Yinsh();
    assertTrue (jeuYinsh.current_color()==couleur.BLACK || jeuYinsh.current_color()==couleur.WHITE);
  }
  
  
  public void test_histoire2(){
	  
  }

  public void test_histoire3(){
	  
  }

  public void test_histoire4(){
	  
  }


}
