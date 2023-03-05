package F2;

import java.util.ArrayList;

public class SnakeObservable {

	private Snake snake;
	private ArrayList<SnakeObserver> observers;	


	//le snake observable nous permet d'avoir une vu plus global sur le serpent 
	//et ainsi d'ecouter le mouvement du serpent avec l'observer
	public SnakeObservable(PAnel panel) {
		snake = new Snake(panel);
		observers = new ArrayList<>();
	}
	
	void notifyObservers() {
		for (SnakeObserver snakeObserver : observers) {
			snakeObserver.update();
		}
	}

	//move du serpent observable fait appelle à move du snake
	public void move() {
		snake.move();
		notifyObservers();		
	}
	
	//getters and setters
	public Snake getSnake()
	{
		return this.snake;
	}
	public void register(SnakeObserver o) {
		observers.add(o);
	}

	public void unregister(SnakeObserver o) {
		observers.remove(o);
	}


}

