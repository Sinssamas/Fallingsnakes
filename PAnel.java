package tp4serpent;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PAnel extends JPanel{
	private final int HEIGHT = 498;
	private final int WIDTH = 500;
	
	private Tireur tireur ;
	private ArrayList<Bullet>bullets=new ArrayList();
	
	public PAnel(){
		this.setSize(WIDTH, HEIGHT);
		this.tireur=new Tireur(this);
		this.addKeyListener(new KeyboardListener(this.tireur));
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		//this.addMouseListener(new Mouse());
		}
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(tireur.getX(), tireur.getY(), tireur.getLongueur(), tireur.getLargeur());
	}
	
}
