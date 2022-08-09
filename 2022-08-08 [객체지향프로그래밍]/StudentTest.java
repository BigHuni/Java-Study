package array;

public class StudentTest {

	public static void main(String[] args) {

		Student studentHeo = new Student(1001, "Heo");
		
		studentHeo.addSubject("국어", 100);
		studentHeo.addSubject("수학", 100);
		
		Student studentKim = new Student(1002, "Kim");
		
		studentKim.addSubject("국어", 95);
		studentKim.addSubject("수학", 90);
		studentKim.addSubject("영어", 80);
		
		studentHeo.showStudentInfo();
		System.out.println("=================================");
		studentKim.showStudentInfo();
	
	}

}
