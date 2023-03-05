package F2;

public class Bullet {
	private static final int WIDTH=3;
	private static final int HEIGHT=5;
    private int x,y;
	private PAnel panel;
	private Snake snake;
	private boolean out =false,diminue=false,destroy=false;
	

	public Bullet(int x,int y,PAnel panel,Snake snake) {
		super();
		this.x = x;
		this.y = y;
		this.panel=panel;
		this.snake=snake;
	}

	//cette methode est appelle depuis le panel en iterant sur la liste des projectiles
	public void move_and_collision() {
		y=y-2;
		for(ElementCorp element : snake.getCorp()) {
			if(snake.chevauchebullet(element, this)) {
				diminue=true;
			}
		}
		//itere sur les element du corp afin de determiner si le projectile 
		//blesse le serpent dans un element de son corp
		for (Obstacle obstacle : panel.getObstacles()) {
			if (panel.destroyObstacle(obstacle, this)) {
				destroy = true;
			} 
		}
		//verifie si le projectile est toujour dans l'espace de jeu (panel)
		//dans le cas contraire il sera supprimer plus tard
		if(y<0) {
			out=true;
		}
	}
	


	//getters ans setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isDiminue() {
		return diminue;
	}
	public void setDiminue(boolean diminue) {
		this.diminue = diminue;
	}
	
	public void setDestroy(boolean destroy) {
		this.destroy = destroy;
	}
	public boolean isDestroy()
	{
		return this.destroy;
	}
	 

	
	public boolean isOut() {
		return out;
	}
	public void setOut(boolean out) {
		this.out = out;
	}
	public static int getWidth() {
		return WIDTH;
	}
	public static int getHieght() {
		return HEIGHT;
	}
}
