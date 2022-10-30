package tp4serpent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener{
	private Tireur tireur;
	public KeyboardListener(Tireur tireur) {
		this.tireur=tireur;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==37) {
			tireur.left();
		}
		if(e.getKeyCode()==39) {
			tireur.right();
		}
		tireur.getPanel().repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
