package F2;

public class Tireur {
	private static final int LONGUEUR = 21;
	private static final int LARGEUR = 15;
	
	private int x,y;//ici y ne change jamais mais gardé comme variable pour un possible
					//modification et permettre au canon de monter et de decendre
	private PAnel panel;

	 public Tireur( PAnel panel){
	        this.panel=panel;
	        this.x=(panel.getWidth()/2)-10;
	        this.y=panel.getHeight()-50;
	    }

	//deplace le canon a gauche
	public void left() {
		x=x-10;
		if(x<10) x=0;
		panel.repaint();
		
	}

	//deplace le canon a droite
	public void right() {
		x=x+10;
		if(x>panel.getWidth()-LONGUEUR)x=panel.getWidth()-LONGUEUR;
		panel.repaint();
		
	}

	//getters and setters
	public static int getLongueur() {
		return LONGUEUR;
	}
	public static int getLargeur() {
		return LARGEUR;
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
