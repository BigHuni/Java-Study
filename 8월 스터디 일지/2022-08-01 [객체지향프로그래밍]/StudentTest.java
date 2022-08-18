package reference;

public class StudentTest {

	public static void main(String[] args) {

		Student studentHeo = new Student(100, "Heo");
		studentHeo.setkoreaSubject("국어", 100);
		studentHeo.setMathSubject("수학", 100);
		
		Student studentKim = new Student(101, "Kim");
		studentKim.setkoreaSubject("국어", 95);
		studentKim.setMathSubject("수학", 80);
		
		studentHeo.showStudentScore();
		studentKim.showStudentScore();
	}

}
