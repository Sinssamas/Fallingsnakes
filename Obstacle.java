package F2;


public abstract class Obstacle {
	//positions de l'obstacle 
	private int posx,posy;
	
	public Obstacle( int posx, int posy) {
		super();
		this.posx = posx;
		this.posy = posy;
	}
	/*
		la  methoed suivante nous permet de definir l'effet d'un obstacle 
		sur le jeu ou le serpent
		l'utilisant cette methode et cette class abstraite rend
		le code plus lisible et comprehensible mais plus important encore
		ceci permet de le rendre plus facile en cas de mise à jour et de maintenance
		ou d'ajout de nouvelle fonctionnalitées 
		ainsi dans le cas ou l'enoncé ajoute un nouveau type d'obstacle 
		il suffit de créer la classe de cet obstacle de l'hériter de Obstacle puis
		d'implementer la methode effet . c'est tout !
	 */
	abstract void effet(Tete Snake_tete);
	


	//getters and setters
	public int getPosx() {
		return posx;
	}
	public void setPosx(int posx) {
		this.posx = posx;
	}
	public int getPosy() {
		return posy;
	}
	public void setPosy(int posy) {
		this.posy = posy;
	}
	
}

