package object;

public class MyDateTest {

	public static void main(String[] args) {

		MyDate date1 = new MyDate(12, 9, 2022);
		MyDate date2 = new MyDate(12, 9, 2022);
		
		System.out.println(date1.equals(date2));
	}
}
