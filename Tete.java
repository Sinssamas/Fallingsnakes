package F2;

public class Tete extends ElementCorp{
	private Obstacle eatenobstacle;
	
	public Tete(int posX, int posY,Snake snake) {
		super(posX, posY,snake);
	}
	
	//mange est une fonction appelé a chaque move du serpent 
	//celle ci permet de verifier s'il y'a un obstacle a la nouvelle position du serpent 
	//et d'appeler donc l'effet de cet obstacle 
	public boolean mange(Obstacle obstacle) {
		if((obstacle.getPosx()==super.getPosX()+Snake.getTailleCase() || obstacle.getPosx()+Snake.getTailleCase()==super.getPosX())&&(obstacle.getPosy()==super.getPosY())) {
			obstacle.effet(this);
		}
		return false;
	}
	
	//tete heritant de element corp, nous avons redefinis move de cet element 
	// le move de la tete est celui qui verifie si on atteint la limite du panel 
	//et ainsi de descendre et de changer de direction le move de element corp 
	//ne fais que suivre les positions de la tete ou de l'element du corps le precedant 
	public void move()
	{
		if(!super.getSnake().getEfet()) {
		if ((getPosX()<=getSnake().getPanel().getWidth()-Snake.getTailleCase())&&(getPosX()>0)) {
			move_droit();
		}else {
				if(isDecendre()) {
					setPosY(getPosY()+Snake.getTailleCase());
					setDecendre(false);
					setDirection(getDirection()*-1);
				}else {
					move_droit();
				}
			}
		}
	}

	//cette fonction  a ete utilisé pour une meilleur lisibilité 
	//elle est appelé par move dans le cas normal ie: loin des bords du panel
	public void move_droit()
	{
		setPosX(getPosX()+Snake.getTailleCase()*getDirection());
		setDecendre(true);
	}
	
	//getter and setters
	public Obstacle getEatenobstacle() {
		return eatenobstacle;
	}
	public void setEatenobstacle(Obstacle eatenobstacle) {
		this.eatenobstacle = eatenobstacle;
	}

}
