package F2;

public class SuperSnake_state extends State_Snake {

	public SuperSnake_state(Snake snake)
	{
		super(snake);
	}
	//la methode chek qui corespend à l'etat du super snake 
	public void Chek()
	{
		//on vérifier si le step egale à 25 donc le serpent revient à l'etat normale
		if(getSnake().getStep()==25) {
			getSnake().changeState(new Normal_state(super.getSnake()));
		}
	}
}
