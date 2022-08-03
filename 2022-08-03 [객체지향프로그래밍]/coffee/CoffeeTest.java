package coffee;

public class CoffeeTest {

	public static void main(String[] args) {

		Person Heo = new Person("Heo", 10000);
		Person Kim = new Person("Kim", 8000);
		StarCoffee starCoffee = new StarCoffee();
		BeanCoffee beanCoffee = new BeanCoffee();
	
		Heo.buyBeanCoffee(beanCoffee, Menu.BEANAMERICANO);
		Kim.buyStarCoffee(starCoffee, Menu.STARLATTE);
	}

}
