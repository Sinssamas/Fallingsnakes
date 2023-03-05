package F2;

public class SnakeObserver {//Dans notre system on à un seul observeur qui observe notre serpent 
	
	
	PAnel panel;//on affeceter le panel à l'observeur du snake pour qu'il fait appelle a la methode repaint de ce dérnier
	public SnakeObserver (PAnel panel)
	{
		this.panel=panel;
	}
	public void update()
	{
		panel.repaint();
	}

}
