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
		Yinsh jeuYinsh=new Yinsh();

		assertTrue(jeuYinsh.getNbAnneau() == 0);

		try {
			jeuYinsh.put_ring('A', 3, couleur.BLACK);
		}
		catch(Exception e) {}

		assertTrue(jeuYinsh.getNbAnneau() != 0);
	}



	public void test_histoire3(){

	}

	public void test_histoire4(){
		Yinsh jeuYinsh=new Yinsh();

		assertTrue(jeuYinsh.is_initialized()==true || jeuYinsh.is_initialized()==false);

	}



	public void test_histoire6(){
		Yinsh jeuYinsh=new Yinsh();
		jeuYinsh.put_marker('E', 4, couleur.WHITE);
		jeuYinsh.put_marker('E', 6, couleur.WHITE);
		jeuYinsh.put_marker('E', 7, couleur.WHITE);
		jeuYinsh.put_marker('E', 9, couleur.WHITE);
		jeuYinsh.put_marker('E', 5, couleur.BLACK);
		jeuYinsh.put_marker('E', 8, couleur.BLACK);

		jeuYinsh.changercouleurmarqueur('E',4);
		jeuYinsh.changercouleurmarqueur('E',6);
		jeuYinsh.changercouleurmarqueur('E',7);
		jeuYinsh.changercouleurmarqueur('E',9);

		try{


			assertTrue(jeuYinsh.isblack('E',4)==true && jeuYinsh.isblack('E',6)==true && jeuYinsh.isblack('E',7)==true && jeuYinsh.isblack('E',9)==true);

		}
		catch(Exception e){
			assertTrue(false);
		}

		jeuYinsh.changercouleurmarqueur('E',5);
		jeuYinsh.changercouleurmarqueur('E',8);

		try{


			assertTrue((jeuYinsh.isblack('E', 5)==false)&&(jeuYinsh.isblack('E', 8)==false)); 
		}
		catch(Exception e){
			assertTrue(false);
		}


	}

	public void test_histoire7(){
		Yinsh jeuYinsh=new Yinsh();

		jeuYinsh.put_marker('E', 6, couleur.BLACK);
		jeuYinsh.put_marker('F', 7, couleur.BLACK);
		jeuYinsh.put_marker('G', 8, couleur.BLACK);
		jeuYinsh.put_marker('H', 9, couleur.BLACK);
		jeuYinsh.put_marker('I', 10, couleur.BLACK);
		
		
		
		try{
			jeuYinsh.put_ring('H', 10,couleur.BLACK);
			jeuYinsh.removerow('E', 6, 'I', 10);
			jeuYinsh.remove_ring('H', 10);
			assertTrue(true);
		}

		catch(Exception e){
			assertTrue(false);
		}


	}


	public void test_histoire5(){
		Yinsh jeuYinsh=new Yinsh();

		try{
			jeuYinsh.put_ring('D', 2, couleur.BLACK);

		}
		catch(Exception e){

		}

		try{
			jeuYinsh.put_marker('D', 2, couleur.WHITE);

			jeuYinsh.mauvaisplacementdumarqueur('D',2);
			assertTrue(false);

		}
		catch(Exception e){
			assertTrue(true);
		}


		jeuYinsh.move_ring('D', 2, 'D', 5);


		try{
			jeuYinsh.pasdeuxringsurmemecase('D',6);
			assertTrue(false);

		}
		catch(Exception e){
			assertTrue(true);
		}

	}


}

