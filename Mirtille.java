package F2;


public class Mirtille extends Obstacle{
	
	public Mirtille(int posx, int posy) {
		super(posx, posy);
		
	}

	//Définition de la methode effet qui corespond à l'effet d'obstacle sur le serpent
	@Override
	void effet(Tete tete) {
		tete.setEatenobstacle(this);//variable permettant de stocker cet obstacle car il viens d'etre
		//mangé dans le but de le supprimer du jeux plus tard
		tete.getSnake().Chek();
		tete.getSnake().setStep(0);		
	}

}
