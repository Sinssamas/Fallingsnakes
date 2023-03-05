package F2;


public class Fraise extends Obstacle{

	
	public Fraise(int posx, int posy) {
		super(posx, posy);
		
	}

	@Override
	void effet(Tete tete) {
		tete.getSnake().grandir();
		tete.setEatenobstacle(this);
		//variable permettant de stocker cet obstacle car il viens d'etre
		//mangé dans le but de le supprimer du jeux plus tard

	}
	
}
