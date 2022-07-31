package ifexample;

import java.util.Scanner;

public class IfExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		
		int age = scanner.nextInt();
		
		int charge = 0;
		
		if( age < 8) {
			charge = 1000;
		}
		else if( age < 14) {
			charge = 1500;
			System.out.println("초등학생");
		}
		else if(age < 20) {
			charge = 2000;
			System.out.println("중고등학생");
		}
		else {
			charge = 3000;
		}
		
		System.out.println("나이 : " + age);
		System.out.println("요금 : " + charge);  
	}

}
