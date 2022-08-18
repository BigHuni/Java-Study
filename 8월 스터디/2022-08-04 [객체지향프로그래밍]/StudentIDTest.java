package staticex;

public class StudentIDTest {

	public static void main(String[] args) {

		Student studentHeo = new Student("Heo");
		System.out.println(Student.getSerialNum());		// 1001
		
		Student studentKim = new Student("Kim");
		System.out.println(Student.getSerialNum());		// 1002
		System.out.println(Student.getSerialNum());		// 1002
		
		System.out.println(studentHeo.getStudentID());	// 1001
		System.out.println(studentKim.getStudentID());	// 1002
	}
}
