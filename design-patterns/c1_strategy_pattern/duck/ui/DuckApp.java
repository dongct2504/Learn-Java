package duck.ui;

import duck.behavior.fly.FlyRocketPowered;
import duck.business.Duck;
import duck.business.MallardDuck;
import duck.business.ModelDuck;

public class DuckApp {
	
	public static void main(String[] args) {
		Duck duck = new MallardDuck();
		duck.display();
		duck.performQuack();
		duck.performFly();
		System.out.println();

		Duck model = new ModelDuck();
		model.display();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();
	}

}









