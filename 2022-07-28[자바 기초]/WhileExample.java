package loopexample;

import java.util.Scanner;

public class WhileExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int num = 1;
		int sum = 0;
		
		 * while(num <= 10) { sum += num; num++; }
		 * 
		 * System.out.println(sum); System.out.println(num);
		 */
		
		int input;
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextInt();
		
		while(input != 0) {
			sum += input;
			input = scanner.nextInt();
		}
		
		System.out.println(sum);
	}
	

}
