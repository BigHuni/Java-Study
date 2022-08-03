package cooperation;

public class TakeTransTest {

	public static void main(String[] args) {

		Student studentH = new Student("Huni", 5000);
		Student studentS = new Student("Songhee", 10000);
		
		Bus bus100 = new Bus(100);
		Bus bus500 = new Bus(500);
		Subway subwayGreen = new Subway(2);
		Subway subwayBlue = new Subway(4);
		
		
		studentH.takeBus(bus100);
		studentS.takeSubway(subwayGreen);
		
		studentH.showInfo();
		studentS.showInfo();
		
		bus100.showBusInfo();
		bus500.showBusInfo();
		
		subwayGreen.showSubwayInfo();
		subwayBlue.showSubwayInfo();
		
	}

}
