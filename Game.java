package F2;

import javax.swing.JLabel;

public class Game {
	public void Start()
	{
		int cpt=0;
		JLabel j;
		Frame1 f=new Frame1();//on créer notre Frame qui va contenir le panel
		PAnel p = new PAnel();
		f.add(p);//on ajoute le panel à notre frame 
		f.setVisible(true);
		while((!p.getSnakeObservable().getSnake().haslost())&&(!p.getSnakeObservable().getSnake().isWon())) {
			cpt++;//ce cpt est incrementé toutes les 5 mili secondes grace au sleep qui suit
			//cpt sera la clé pour controler les vitesse des elements du jeux
			try {
				Thread.sleep(5);//ici le thread sleep , donc les projectiles bougent toutes les 5 milisecondes
				p.moveBullets();
				p.repaint();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			if(cpt%12==0) {//tester cpt%12 pour move le serpent revient a dire que le serpent bouge 
							//toute les 60 milisecondes (5*12)
				try {
					Thread.sleep(10);//ce sleep permet de voir un peu mieux le mouvement du serpent 
									//et n'est pas necessaire
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				p.getSnakeObservable().getSnake().move();
			}
			if(cpt==72) {//tester cpt==72 afin d'ajouter un projectile revient a dire que le canon tire 
						//un nouveau projectile toutes les 360 milisecondes (72*5)
				cpt=0;
				p.addBullet();
			}
		}
		if(p.getSnakeObservable().getSnake().haslost()) {
			 j = new JLabel("Game Over , You Lost");
		}else {
			 j = new JLabel("Congratulation , You WON");
		}
		//la variable j contient le message qui sera afficher a la fin du jeu
		p.add(j);
		j.setBounds(150, (p.getHEIGHT()/2)-25, p.getWIDTH()-100, 50);
		p.repaint();
		
	}

}
