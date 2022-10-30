package tp4serpent;

public class Bullet {
	private static final int WIDTH=3;
	private static final int HEIGHT=5;
	private int x,y;

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

	public Bullet(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	 
}
