package F2;


 import java.util.ArrayList;



public class Snake {
	private static final int TAILLE_CASE=19;
	private int longueur=1,direction=1;
	private PAnel panel;
	private ArrayList<ElementCorp> corp;
	private boolean won =false;
	private int step=0;
	private Boolean efet=false;
	private State_Snake state;

	

	public Snake(PAnel panel) {
		this.panel=panel;
		this.CreateSnake();//initialisation snake avec une taille de 4 elements
		this.state= new Normal_state(this);//on intiallise l'etat du serpent avec l'etat normale
	}
	
	public void move(){
		/*
		parcourir les elements du corp du serpent en sens inverse puis 
		affecter a l'element du corps courant les positions de l'element du 
		corp le precedant
	*/
		Collision();//on test les colission du snake avec les elements du panel 
		
		for(int x=corp.size()-1;x>=0;x=x-1)
		{
			corp.get(x).move();
		}
	}
	
	public void Collision()
	{
		/*collision permet de verifier que lorsque la tete avance 
		le serpent mange le fruit qui se trouvait devant lui avant d'avancer
		aussi cette methode permet au serpent de gerer l'obstacle se trouvant devant lui
	    lorsqu'il bouge et de supprimer l'obstacle si celui est consommable*/
		Tete tete=(Tete)corp.get(0);
		efet=false;
		for(Obstacle obstacle : panel.getObstacles()) {
			tete.mange(obstacle);
		}
		Obstacle o = tete.getEatenobstacle();
		tete.setEatenobstacle(null);
		if (o!=null) {
					panel.getObstacles().remove(o);
		    		}
		step++;
		Chek();//on fait appelle a chek qui coréspend à l'état actuelle du serpent 
	}

	public void Chek()
	{
		//chek permet de vérifier si il faut changer l'etat du serpent ou non 
		state.Chek();
	}
	
	//methode verifiant si le serpent a atteint la fin du panel
	public boolean haslost() {
		if(corp.get(0).getPosY()>=panel.getHeight()-50) {
			return true;
		}
		return false;
	}
	
	/*cette methode retourne un booleen qui verfie si un element du corps 
		a ete touché par un projectile et ce en verifiant les position avec 
		un petit calcul sur les taille des elements(projectile et corps)*/
	public boolean chevauchebullet(ElementCorp e,Bullet b) {
		if((b.getX()<e.getPosX()+TAILLE_CASE)&&(b.getX()+Bullet.getWidth()>e.getPosX())) {
			if((b.getY()+Bullet.getHieght()>e.getPosY())&&(b.getY()<e.getPosY()+TAILLE_CASE)) {
				return true;
			}
		}
		return false;
	}
	
	/*lorsqu'un la methode chevauche retourne vrai pour un certain elem du corp
	et un projectile cette methode est appelé afin de reduire la taille du sepent
	d'un element de son corp*/
	public void diminue() {
		if(corp.size()>1) {
			corp.remove(corp.size()-1);
		}else {
				won = true;
		}
	}
	
	/*cette methode permet d'ajouter a d'agrandire le serpent dans le cas ou celui ci 
	a consomé une fraise 
	cette methode cree un  nouvel element du corpdu sepent a partir du dernier element 
	de celui-ci*/ 
	public void grandir() {
		ElementCorp elem = corp.get(corp.size()-1);
		int direction = elem.getDirection();
		ElementCorp element=new ElementCorp(elem.getPosX()-(Snake.getTailleCase()*direction),elem.getPosY(), this);
		element.setDirection(direction);
		corp.add(element);
	}
	
	//initialization du serpent
	public void CreateSnake()
	{
		this.corp=new ArrayList<>();
		corp.add(new Tete(TAILLE_CASE*3,0,this));
		corp.add(new ElementCorp(TAILLE_CASE*2,0,this));
		corp.add(new ElementCorp(TAILLE_CASE,0,this));
		corp.add(new ElementCorp(0,0,this));
	}
	
	//getters and setters
	public Tete getTete()
	{
		for(ElementCorp el:corp)
		{
			if(el instanceof Tete) return (Tete) el;
		}
		return null;
	}
	public boolean isWon() {
		return won;
	}
	public void setWon(boolean won) {
		this.won = won;
	}
	
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
	
	public ArrayList<ElementCorp> getCorp() {
		return corp;
	}

	public void setCorp(ArrayList<ElementCorp> corp) {
		this.corp = corp;
	}

	public int getDirection() {
		return direction;
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}


	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public PAnel getPanel() {
		return panel;
	}

	public void setPanel(PAnel panel) {
		this.panel = panel;
	}
	public static int getTailleCase() {
		return TAILLE_CASE;
	}

	public Boolean getEfet() {
		return efet;
	}

	public void setEfet(Boolean efet) {
		this.efet = efet;
	}
	
	public void changeState(State_Snake state)
	{
		this.state=state;
	}
	public State_Snake getStateSnake()
	{
		return this.state;
	}
}
