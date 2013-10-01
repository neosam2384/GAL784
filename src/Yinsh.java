import java.*;
import java.util.Random;

enum couleur {BLACK,WHITE};
enum Lettre {A,B,C,D,E,F,G,H,I,J,K}

public class Yinsh {
	
	couleur[][]plateauyinsh;
	public int nbAnneau;
    public int nbAnneauBlanc;
    public int nbAnneauNoir;
    public int derniereCouleur;
    
    
    public Yinsh() {

        plateauyinsh = new couleur[11][11];
        nbAnneau = 0;
        nbAnneauBlanc = 0;
        nbAnneauNoir = 0;
        derniereCouleur = 0;
    }
    
    couleur current_color(){
		Random random=new Random();
	int i=random.nextInt(1);
		
		if (i==0){
			return couleur.BLACK;}
		
		else{return couleur.WHITE;}
				
	}
	
	
	

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
