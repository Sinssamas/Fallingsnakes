package tp4serpent;

public class Tireur {
	private static final int LONGUEUR = 21;
	private static final int LARGEUR = 15;
	public static int getLongueur() {
		return LONGUEUR;
	}

	public static int getLargeur() {
		return LARGEUR;
	}

	private int x,y;
	private PAnel panel;

	 public Tireur(PAnel panel){
	        this.panel=panel;
	        this.x=(panel.getWidth()/2)-10;
	        this.y=panel.getHeight()-50;
	    }

	public void left() {
		x=x-10;
		if(x<10) x=0;
		panel.repaint();
		
	}

	public void right() {
		x=x+10;
		if(x>panel.getWidth()-LONGUEUR)x=panel.getWidth()-LONGUEUR;
		panel.repaint();
		
	}

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

	public PAnel getPanel() {
		return panel;
	}

	public void setPanel(PAnel panel) {
		this.panel = panel;
	}
}
