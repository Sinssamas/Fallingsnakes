package F2;

public class ElementCorp {
	private int posX,posY;
	private Snake snake;
	private int direction=1;
	private boolean decendre=false;

	public ElementCorp(int posX, int posY,Snake snake) {
		
		super();
		this.posX = posX;
		this.posY = posY;
		this.snake= snake;
	}

	public void move() {
		if(!snake.getEfet()) {
		int i  =snake.getCorp().indexOf(this);//recuperons l'index de l'element courant dans le orp du snake	
		ElementCorp e = snake.getCorp().get(i-1);//recuperons lélement precedant celui ci dans le corps du snake
		posX=e.getPosX();//mettre a jour les position 
		posY=e.getPosY();
		//le principe est que chaque element du corp mis a part la tete 
		//recoit les coordonnees de l'element le precedant un peu comme un vrai serpent 
		}
		
		
	}
	
	//getters ans setters
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isDecendre() {
		return decendre;
	}

	public void setDecendre(boolean decendre) {
		this.decendre = decendre;
	}
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}
}
