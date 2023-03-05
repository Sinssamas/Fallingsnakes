package F2;


public class Bois extends Obstacle{

	
	public Bois(int posx, int posy) {
		super(posx, posy);
	 		}

	@Override
	void effet(Tete tete) {
		/*on va modifier en quelque sort le move du serpent en déregent le tete 
		 * vers le bas, et les autres elements du cors suivent la driction de la tete
		 */
		ElementCorp el;
		if(tete.isDecendre()) {
				for(int x=tete.getSnake().getCorp().size()-1;x>=0;x=x-1)
				{
					el = tete.getSnake().getCorp().get(x);
					if(!(el instanceof Tete)) el.move();
				}
			tete.setPosY(tete.getPosY()+Snake.getTailleCase());
			tete.setDecendre(false);
			tete.getSnake().setEfet(true);
			tete.setDirection(tete.getDirection()*-1);//changer la direction du serpent 
		}
	


	}
}
