package operator;

public class OperatorEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int score = 100;
		
		System.out.println(++score);
		System.out.println(score++);
		System.out.println(score);
		System.out.println(--score);
		System.out.println(score--);
		System.out.println(score);
	
		int num1 = 10;
		int i = 2;
		
		boolean value = ( (num1 = num1 + 10) < 10) && ( (i = i + 2) < 10);
		System.out.println(value);
		
		int num2 = 10;
		int num3 = 20;
		
		int max = (num2 > num3) ? num2 : num3;
		System.out.println(max);
		
	}

}
