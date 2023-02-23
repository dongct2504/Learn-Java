package duck.business;

import duck.behavior.fly.FlyWithWings;
import duck.behavior.quack.Quack;

public class MallardDuck extends Duck {
	
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
	
	@Override
	public void display() {
		System.out.println("I am a mallard duck!!");
	}
	
}









