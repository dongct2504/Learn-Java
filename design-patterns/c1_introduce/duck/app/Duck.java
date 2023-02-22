package duck.app;

import duck.behaviors.FlyBehavior;
import duck.behaviors.QuackBehavior;

public abstract class Duck {

	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
	public void performFly() {
		flyBehavior.fly();
	}
	
	public void performQuack() {
		quackBehavior.quack();
	}
}










