package F2;

public class Normal_state extends State_Snake{

	public Normal_state(Snake snake)
	{
		super(snake);
		
	}
	public void Chek()
	{
		//on vérifier si l'obstacle est une corespand à une mirtille alors on change l'etat du serpent vers l'etat super!!
		if(getSnake().getTete().getEatenobstacle() instanceof Mirtille) {
			getSnake().changeState(new SuperSnake_state(super.getSnake()));
		}
	}
}
