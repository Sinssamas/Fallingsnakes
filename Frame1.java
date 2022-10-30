package tp4serpent;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Frame1 extends JFrame{
	
	public Frame1() {
		super();
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Rectangle r =new Rectangle(500,500);
		this.setBounds(r);
		this.setLocationRelativeTo(null);
		r.setBounds(0, 0, 10, 10);
		this.setResizable(false);
	}
}
