package F2;

 abstract class  State_Snake {
	 private Snake snake;
	 public State_Snake(Snake snake)
	 {
		 this.snake=snake;
	 }
	 //la methode abstact chek qui sera implementé dans tous les states du snake 
	 public abstract void Chek();

	 //getters and setters
	 public void setSnake(Snake snake)
	 {
		 this.snake=snake;
	 }
	 public Snake getSnake()
	 {
		 return this.snake;
	 }
 
 }
 

 