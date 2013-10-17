import java.*;
import java.util.Random;

enum couleur {BLACK,WHITE};

enum Lettre {A,B,C,D,E,F,G,H,I,J,K}

public class Yinsh {

	couleur[][]plateauyinsh;
	couleur[][]plateaumarker;
	public int nbAnneau,nbmarker;
	public int nbAnneauBlanc;
	public int nbAnneauNoir;
	public int derniereCouleur;
	public int nbmarkerblanc;
	public int nbmarkernoir;




	public Yinsh() {

		plateauyinsh = new couleur[11][11];
		plateaumarker=new couleur[11][11];
		nbAnneau = 0;
		nbAnneauBlanc = 0;
		nbAnneauNoir = 0;
		derniereCouleur = 1;
	}

	couleur current_color(){
		Random random=new Random();
		int i=random.nextInt(1);

		if (i==0){
			return couleur.BLACK;}

		else{return couleur.WHITE;}

	}


	public void put_ring(char lettrecolumn, int line, couleur color) throws Exception {

		int column = Character.getNumericValue(lettrecolumn) - 10;
		int indiceCouleur=0;

		if(color==couleur.BLACK){
			indiceCouleur=0;}
		else if(color==couleur.WHITE){
			indiceCouleur=1;
		}

		if(verifierCoordonnees(column, line - 1)) {

			if(plateauyinsh[line - 1][column] == null) {

				if(indiceCouleur != derniereCouleur) {

					plateauyinsh[line - 1][column] = color;
					derniereCouleur = indiceCouleur;
					nbAnneau++;

					if(indiceCouleur == 0)
						nbAnneauBlanc++;

					else if(indiceCouleur == 1)
						nbAnneauNoir++;
				}

				else throw new Exception(" On ne peut pas placer deux anneaux de même couleur consécutivement.");
			}

			else throw new Exception(" On ne peut pas placer deux anneaux sur la même intersection.");
		}
	}


	public int getNbAnneau() {

		return nbAnneau;
	}

	private boolean verifierCoordonnees(int column, int line) throws Exception {

		if(column < 0 || column > 11 || line < 0 || line > 11)
			throw new Exception(" Coordonnees pas valide.");

		if(column == 0 && (line == 0 || line >= 5)) // Si A | 1, 6, 7, 8, 9, 10, 11
			throw new Exception(" Coordonnees pas valide.");

		if(column == 1 && line >= 7) // Si B | 8, 9, 10, 11
			throw new Exception(" Coordonnees pas valide.");

		if(column == 2 && line >= 8) // Si C | 9, 10, 11
			throw new Exception(" Coordonnees pas valide.");

		if(column == 3 && line >= 9) // Si D | 10, 11
			throw new Exception(" Coordonnees pas valide.");

		if(column == 4 && line == 10) // Si E | 10
			throw new Exception(" Coordonnees pas valide.");

		if(column == 5 && (line == 0 || line == 10)) // Si F | 10
			throw new Exception(" Coordonnees pas valide.");

		if(column == 6 && line == 0) // Si G | 1
			throw new Exception(" Coordonnees pas valide.");

		if(column == 7 && line < 2) // Si H | 1, 2
			throw new Exception(" Coordonnees pas valide.");

		if(column == 8 && line < 3) // Si I | 1, 2, 3
			throw new Exception(" Coordonnees pas valide.");

		if(column == 9 && line < 4) // Si J | 1, 2, 3, 4
			throw new Exception(" Coordonnees pas valide.");

		if(column == 10 && (line < 6 || line == 10)) // Si K | 1, 2, 3, 4, 5, 6, 11
			throw new Exception(" Coordonnees pas valide.");

		return true;
	}

	public int getNbAnneauBlanc() {

		return nbAnneauBlanc;
	}

	public int getNbAnneauNoir() {

		return nbAnneauNoir;
	}


	public boolean estunAnneau(char lettreColumn, int ligne) {

		return plateauyinsh[ligne - 1][Character.getNumericValue(lettreColumn)- 10] != null;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean is_initialized(){
		int nbAnneauxBlanc=0;
		int nbAnneauxNoir=0;

		for (int i=0;i<11;i++){

			for(int j=0;j<11;j++){
				if (plateauyinsh[i][j]==couleur.BLACK){
					nbAnneauxNoir++;}
				else if(plateauyinsh[i][j]==couleur.WHITE){
					nbAnneauxBlanc++;}
			}

		}
		if((nbAnneauxNoir==5) && (nbAnneauxBlanc==5)){
			return true;}
		else{
			return false;
		}


	}

	/////////////////////////////////////////////////////////////////////////////////////////////////	
	public void put_marker(char lettrecolumn, int line, couleur color){


		int column = Character.getNumericValue(lettrecolumn) - 10;
		int indicecouleur=0;

		if(color==couleur.BLACK){
			indicecouleur=0;}
		else if(color==couleur.WHITE){
			indicecouleur=1;
		}

		if(plateauyinsh[line - 1][column] != null){

			if(indicecouleur != derniereCouleur) {
				plateaumarker[line - 1][column] = color;
				derniereCouleur = indicecouleur;
				nbmarker++;

				if(indicecouleur == 1)
					nbmarkerblanc++;

				else if(indicecouleur == 0)
					nbmarkernoir++;

			}
		}

	}


	public void move_ring(char columnring, int linering, char newcolumnring,int newlinering){
		int oldcolumn = Character.getNumericValue(columnring) - 10;
		int newcolumn = Character.getNumericValue(newcolumnring) - 10;

		plateauyinsh[newlinering][newcolumn]=plateauyinsh[linering][oldcolumn];
		plateauyinsh[linering][oldcolumn]=null;



	}


	couleur couleurmarqueur(char columnmarker, int linemarker){
		int column = Character.getNumericValue(columnmarker) - 10;
		return plateaumarker[linemarker][column];
	}

	couleur couleurring(char columnring, int linering){
		int column = Character.getNumericValue(columnring) - 10;
		return plateaumarker[linering][column];
	}


	//	(jeuYinsh.couleurmarqueur('D', 2)!=couleur.WHITE && jeuYinsh.couleurmarqueur('D', 3)!=couleur.BLACK);


	public void mauvaisplacementdumarqueur(char columnmarker, int linemarker) throws Exception{
		int column = Character.getNumericValue(columnmarker) - 10;

		if (couleurmarqueur(columnmarker,linemarker)==couleur.WHITE){
			if (plateauyinsh[linemarker][column]!=couleurmarqueur(columnmarker,linemarker)){
				throw new Exception("Le marqueur ne peut pas etre placé à ces coordonnées.");}}

		if (couleurmarqueur(columnmarker,linemarker)==couleur.BLACK){
			if (plateauyinsh[linemarker - 1][column]!=couleurmarqueur(columnmarker,linemarker)){
				throw new Exception("Le marqueur ne peut pas etre placé à ces coordonnées.");}}

	}



	public void pasdeuxringsurmemecase(char columnring, int linering) throws Exception{
		int column = Character.getNumericValue(columnring) - 10;

		if(plateauyinsh[linering][column] != null){
			throw new Exception("Vous ne pouvez pas placer deux anneaux sur la meme case");}

	}


	public void passurlamemeligne(char columnring, int linering) throws Exception{

		//if(linering)
	}



	//histoire six///////////////////////////////////////////////////////////////////

	public void changercouleurmarqueur(char lettrecolumn, int line){
		int column = Character.getNumericValue(lettrecolumn) - 10;
		
		if(plateaumarker[line - 1][column]==couleur.BLACK){
			plateaumarker[line - 1][column]=couleur.WHITE;}
		else{
			plateaumarker[line - 1][column]=couleur.BLACK;}
	}


	boolean isblack(char lettrecolumn, int line){
		int column = Character.getNumericValue(lettrecolumn) - 10;

		if(plateaumarker[line][column]==couleur.BLACK){
			return true;}
		else{
			return false;
		}

	}

	//histoire sept////////////////////////////////////////////////////////////////

	boolean lignemarqueurnoir(char lettredepart, int linedepart,char lettrearrive, int linearrive,couleur color){
		int cpt=0;
		int columndepart = Character.getNumericValue(lettredepart) - 10;
		int columnarrive=Character.getNumericValue(lettrearrive) - 10;

		if((linedepart>linearrive)){
			outerloop1:while ((columndepart<columnarrive)||(cpt<5)){
				
				if(plateaumarker[linedepart][columndepart]==color.BLACK){
					cpt++;
					columndepart++;linedepart--;}
				else{
					cpt=0;
					break outerloop1;
				}
			}

		outerloop2:while ((columndepart>columnarrive)||(cpt<5)){
			
			if(plateaumarker[linedepart][columndepart]==color.BLACK){
				cpt++;
				columndepart--;linedepart--;}
			else{
				cpt=0;
				break outerloop2;
			}
		}
		}





		if((linedepart<linearrive)){
			outerloop1:while ((columndepart<columnarrive)||(cpt<5)){
				if(plateaumarker[linedepart][columndepart]==color.BLACK){
					cpt++;
					columndepart++;linedepart++;}
				else{
					cpt=0;
					break outerloop1;
				}
			}
		
		outerloop2:while ((columndepart>columnarrive)||(cpt<5)){
			
			if(plateaumarker[linedepart][columndepart]==color.BLACK){
				cpt++;
				columndepart--;linedepart++;}
			else{
				cpt=0;
				break outerloop2;
			}
		}
		
		}

		
	
		if(cpt==5){
			return true;}
		else{
			return false;}
		
	
	}



	boolean lignemarqueurblanc(char lettredepart, int linedepart,char lettrearrive, int linearrive,couleur color){
		int cpt=0;
		int columndepart = Character.getNumericValue(lettredepart) - 10;
		int columnarrive=Character.getNumericValue(lettrearrive) - 10;

		if((linedepart>linearrive)){
			outerloop1:while ((columndepart<columnarrive)||(cpt<5)){
				
				if(plateaumarker[linedepart][columndepart]==color.WHITE){
					cpt++;
					columndepart++;linedepart--;}
				else{
					cpt=0;
					break outerloop1;
				}
			}

		outerloop2:while ((columndepart>columnarrive)||(cpt<5)){
			
			if(plateaumarker[linedepart][columndepart]==color.WHITE){
				cpt++;
				columndepart--;linedepart--;}
			else{
				cpt=0;
				break outerloop2;
			}
		}
		}





		if((linedepart<linearrive)){
			outerloop1:while ((columndepart<columnarrive)||(cpt<5)){
				if(plateaumarker[linedepart][columndepart]==color.WHITE){
					cpt++;
					columndepart++;linedepart++;}
				else{
					cpt=0;
					break outerloop1;
				}
			}
		
		outerloop2:while ((columndepart>columnarrive)||(cpt<5)){
			
			if(plateaumarker[linedepart][columndepart]==color.WHITE){
				cpt++;
				columndepart--;linedepart++;}
			else{
				cpt=0;
				break outerloop2;
			}
		}
		
		}

		
	
		if(cpt==5){
			return true;}
		else{
			return false;}
		
	
	}




	boolean removerow(char lettredepart, int linedepart,char lettrearrive, int linearrive){
		int columndepart = Character.getNumericValue(lettredepart) - 10;
		int columnarrive=Character.getNumericValue(lettrearrive) - 10;
		int cpt=0;
		
		if(lignemarqueurnoir(lettredepart,linedepart,lettrearrive,linearrive,couleur.BLACK)){
			if((linedepart>linearrive)&&(cpt<5)){
				while ((columndepart<columnarrive)){
					plateaumarker[linedepart][columndepart]=null;
					columndepart++;linedepart--;
					cpt++;
				}

				while ((columndepart>columnarrive)&&(cpt<5)){

					plateaumarker[linedepart][columndepart]=null;
					columndepart--;linedepart--;
					cpt++;
				}
			}


			if((linedepart<linearrive)){
				while ((columndepart<columnarrive)&&(cpt<5)){
					plateaumarker[linedepart][columndepart]=null;
					columndepart++;linedepart++;
					cpt++;
				}

				while ((columndepart>columnarrive)&&(cpt<5)){

					plateaumarker[linedepart][columndepart]=null;
					columndepart--;linedepart++;
					cpt++;
				}

			}

		}
		
		
		

		/////////////////marqueur blanc///////////////////////////////////////////
		
		if(lignemarqueurblanc(lettredepart,linedepart,lettrearrive,linearrive,couleur.WHITE)){
			if((linedepart>linearrive)){
				while ((columndepart<columnarrive)&&(cpt<5)){
					plateaumarker[linedepart][columndepart]=null;
					columndepart++;linedepart--;
					cpt++;
				}

				while ((columndepart>columnarrive)&&(cpt<5)){

					plateaumarker[linedepart][columndepart]=null;
					columndepart--;linedepart--;
					cpt++;
				}
			}


			if((linedepart<linearrive)){
				while ((columndepart<columnarrive)&&(cpt<5)){
					plateaumarker[linedepart][columndepart]=null;
					columndepart++;linedepart++;
					cpt++;
				}

				while ((columndepart>columnarrive)&&(cpt<5)){

					plateaumarker[linedepart][columndepart]=null;
					columndepart--;linedepart++;
					cpt++;
				}

			}

		}
				
		
		if(cpt==5){
			return true;}
		else{
			return false;}

	}
	
	void remove_ring(char lettrecolumn, int line){
		int column = Character.getNumericValue(lettrecolumn) - 10;
		plateauyinsh[line][column]=null;
	}
	
		
		
	
	
	

	//////////////////////////////////////////////////////////////////////////////////////////////////////



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
