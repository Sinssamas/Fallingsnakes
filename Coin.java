package F2;


public class Coin extends Obstacle{

	public Coin(int posx, int posy) {
		super(posx, posy);
	  }

	@Override
	void effet(Tete tete) {
		     tete.setEatenobstacle(null);
             tete.getSnake().getPanel().reSetObstacles();//on fait appelle à la methode resetObstacle pour changer les positions des obstacles aléatoirement		
	}

}
