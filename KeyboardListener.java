package F2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener{//pour gérer le deplacement de tereur avec le clavier
	private Tireur tireur;
	public KeyboardListener(Tireur tireur) {
		this.tireur=tireur;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==37) {//la touche fleche gauche 
			tireur.left();
		}
		if(e.getKeyCode()==39) {//la touche fleche droite
			tireur.right();
		}
		tireur.getPanel().repaint();//redessiner le panel
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
