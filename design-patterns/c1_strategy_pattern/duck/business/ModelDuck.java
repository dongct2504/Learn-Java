package duck.business;

import duck.behavior.fly.FlyNoWay;
import duck.behavior.quack.Quack;

public class ModelDuck extends Duck {
	
	public ModelDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}

	@Override
	public void display() {
		System.out.println("Model duck");
	}

}







