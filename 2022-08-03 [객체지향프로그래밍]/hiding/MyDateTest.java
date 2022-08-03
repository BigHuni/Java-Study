package hiding;

public class MyDateTest {

	public static void main(String[] args) {
		
		MyDate date = new MyDate();
		
		date.setYear(2022);
		date.setMonth(8);
		date.setDay(2);
		
		date.showDate();
		
		MyDate date2 = new MyDate();
		date2.setYear(2002);
	}

}
