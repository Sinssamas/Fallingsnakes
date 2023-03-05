package F2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PAnel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4556322684586143076L;
	private final int HEIGHT = 498;
	private final int WIDTH = 506;
	/*
	 	le PAnel est l'espace de jeu qui contient donc tout les elements du jeu 
		celui ci contiendra naturellement le serpent , les obstacles , le canon etc..
	 */
	private Tireur tireur ; // le canon
	private Bullet bulletOut,bullethurting; 
	/*
	 bulletOut et bullethurting sont deux objet qui contiendront le projectile
	 sortant de l'espace de jeux et le projectile touchant le serpent ou un Obstacle 
	 */
	private SnakeObservable snakeObservable;
	private ArrayList<Bullet>bullets=new ArrayList<Bullet>();
	/*
	 bullets est la liste de projectiles present sur l'espace de jeux a un temps t
	 notre idee est que les projectiles ne vont pas trop vite 
	 */
	private ArrayList<Obstacle>obstacles=new ArrayList<Obstacle>();
	private Obstacle destroyObstacle;
	/* destroyObstacle permet de sauvgarder un obstacle mangé par le serpent 
		ou detruit par un projectile 
	*/
	
	public PAnel(){
		this.setSize(WIDTH, HEIGHT);
		this.tireur=new Tireur(this);
		this.snakeObservable=new SnakeObservable(this);
		this.addKeyListener(new KeyboardListener(this.tireur));
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		fillObstacles();//initialisation de la liste des obstacles
		snakeObservable.register(new SnakeObserver(this));
		}

	//paint est la fonction qui redessine tout le jeux
	public void paint(Graphics g) {
					super.paint(g);
					g.setColor(Color.black);
					g.fillRect(tireur.getX(), tireur.getY(), Tireur.getLongueur(), Tireur.getLargeur());
					for (ElementCorp element : snakeObservable.getSnake().getCorp()) {
						if (element instanceof Tete) {
							g.fillRoundRect(element.getPosX(), element.getPosY(), Snake.getTailleCase() - 1,Snake.getTailleCase() - 1,Snake.getTailleCase(),Snake.getTailleCase());
							
						}else {
							g.fillRoundRect(element.getPosX(), element.getPosY(), Snake.getTailleCase() - 1,
									Snake.getTailleCase() - 1,5,5);
						}
					}
					for(Bullet bullet : bullets) {
						g.fillRect(bullet.getX(), bullet.getY(), Bullet.getWidth(), Bullet.getHieght());
					}
					for(Obstacle obstacle : obstacles) {
						if(obstacle instanceof Mirtille) {
							g.setColor(Color.BLUE);
							g.fillOval(obstacle.getPosx(),obstacle.getPosy(), Snake.getTailleCase(), Snake.getTailleCase());
						}
						if(obstacle instanceof Bois) {
							g.setColor(Color.DARK_GRAY);
							g.fillRect(obstacle.getPosx(),obstacle.getPosy(), Snake.getTailleCase(), Snake.getTailleCase());
						}
						if(obstacle instanceof Coin) {
							g.setColor(Color.YELLOW);
							g.fillOval(obstacle.getPosx(),obstacle.getPosy(), Snake.getTailleCase(), Snake.getTailleCase());
						}
						if(obstacle instanceof Fraise) {
							g.setColor(Color.red);
							g.fillOval(obstacle.getPosx(),obstacle.getPosy(), Snake.getTailleCase(), Snake.getTailleCase());
						}
						
					}
					g.setColor(Color.RED);
					g.fillRect(0, HEIGHT-60, WIDTH, 3);
	}



	//cette methode parcoursla liste des projectiles et appelle move de chacun 
	//ainsi les position des projectiles sont mis a jours
	//puis recupere les projectiles sortie de l'espace de jeu ou blessant le serpent
	//afin d les supprimer des listes
	public void moveBullets() {
		for(Bullet bullet : bullets) {
			bullet.move_and_collision();
			
			if(bullet.isOut()) {
				bulletOut=bullet;
			}
			if(bullet.isDiminue()) {
				bullethurting=bullet;
				if(!(snakeObservable.getSnake().getStateSnake() instanceof SuperSnake_state)) snakeObservable.getSnake().diminue();
			}
			if(bullet.isDestroy()) {
				bullethurting=bullet;
			}
		}
		bullets.remove(bulletOut);
		bullets.remove(bullethurting);
		obstacles.remove(destroyObstacle);
	}


	//fillobstacles permet de creer aleatoirement des obstacles de tout types
	//et de les disposer dans l'air du jeu aleatoirement
	public void fillObstacles() {
		obstacles.removeAll(obstacles);
		int x,y;
		for(int i=0;i<20;i++) {
			do {
			x=(int)(Math.random()*(WIDTH-3*Snake.getTailleCase()));
			x=x-(x%Snake.getTailleCase())+(2*Snake.getTailleCase());
			if(x>WIDTH-(Snake.getTailleCase()*3)) x=x-Snake.getTailleCase()*2;
			y=(int)(Math.random()*((HEIGHT-60)));
			y=y-(y%Snake.getTailleCase())-Snake.getTailleCase();
			}while(this.existdeja(x,y));     
			if(i%4==0) {
				obstacles.add(new Bois(x,y));
			}
			if(i%4==1) {
				if(x==0) x=Snake.getTailleCase();
				if(x==WIDTH-Snake.getTailleCase()) x=WIDTH-Snake.getTailleCase()*2;
				obstacles.add(new Fraise(x,y));
			}
			if(i%4==2) {
				obstacles.add(new Mirtille(x,y));
			}
			if(i%4==3) {
				obstacles.add(new Coin(x,y));
			}
			
		}
	}




	//destroy obstacle verifie qu'un obstacle n'a pas ete detruit par le projectile
	// si un projectile touche en effet un obstacle l óbstacle sera sauvgardé dans
	//une variable global et supprimé plus tard
	public boolean destroyObstacle(Obstacle o , Bullet b) {
		if((b.getX()<o.getPosx()+Snake.getTailleCase())&&(b.getX()+Bullet.getWidth()>o.getPosx())) {
			if((b.getY()+Bullet.getHieght()>o.getPosy())&&(b.getY()<o.getPosy()+Snake.getTailleCase())) {
				destroyObstacle=o;
				return true;
			}
		}
		return false;
	}



	//resetObstacles est une fonction qui permet de redisposer les obstacles
	//existant dans l'air de jeu , cette methode est appelé lorsque le serpent
	// mange un coin
	public void reSetObstacles() {
		int x,y;
		for(Obstacle obstacle : obstacles ) {
			do {
			x=(int)(Math.random()*(WIDTH-3*Snake.getTailleCase()));//tirer un x aleatoirement 
			x=x-(x%Snake.getTailleCase())+(2*Snake.getTailleCase());//s'assurer que x soit dans l'aire de jeu
			if(x>WIDTH-(Snake.getTailleCase()*3)) x=x-Snake.getTailleCase()*3;//s'assurer que x soit dans l'aire de jeu
			y=(int)(Math.random()*(HEIGHT-60));//tirer un x aleatoirement 
			y=y-(y%Snake.getTailleCase())-Snake.getTailleCase();//s'assurer que y soit dans l'aire de jeu
		   }while(this.existdeja(x,y));//verifie si les positions x,y n'ecraseront pas un obstacle deja créé
			if(x==0) x=Snake.getTailleCase()*2;
			obstacle.setPosx(x);//mise a jour de position 
			obstacle.setPosy(y);//mise a jour de position
		}
	}
	

	//existedeja permet de verifier qu'un obstacle n'est pas sur la position donnee en argument
	public Boolean existdeja(int x,int y)
	{
		for(Obstacle obstacle : obstacles )
		{
			if(obstacle.getPosx()==x && obstacle.getPosy()==y) return true;
		}
		return false;
	}




	//addbullet permet de creer un nouveau projectile a partir des donnees
	//et de la position du canon et l'ajouter a la liste des projectile du panel
	public void addBullet() {
		bullets.add(new Bullet(tireur.getX()+(Tireur.getLargeur()/2)-1,getHeight()-Tireur.getLargeur(),this,snakeObservable.getSnake()));
	}

	//cette methode supprime un projectile du panel 
	//elle appelé quand un projectile sort de l'espace de jeu 
	//ou detruit un obstacle ou blesse le serpent
	public void removeBullet(Bullet bullet) {
		bullets.remove(bullet);
	}



	//getters and setters
	public Obstacle getDestroyObstacle() {
		return destroyObstacle;
	}
	public void setDestroyObstacle(Obstacle destroyObstacle) {
		this.destroyObstacle = destroyObstacle;
	}
	
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}
	public void setObstacles(ArrayList<Obstacle> obstacles) {
		this.obstacles = obstacles;
	}
	public Tireur getTireur() {
		return tireur;
	}
	public void setTireur(Tireur tireur) {
		this.tireur = tireur;
	}
	public SnakeObservable getSnakeObservable() {
		return snakeObservable;
	}
	public void setSnakeObservable(SnakeObservable snake) {
		this.snakeObservable = snake;
	}
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	public void setBullets(ArrayList<Bullet> bullets) {
		this.bullets = bullets;
	}
	public int getHEIGHT() {
		return HEIGHT;
	}
	public int getWIDTH() {
		return WIDTH;
	}
	
}
