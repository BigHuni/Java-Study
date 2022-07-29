package classpart;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student studentHeo = new Student();
		studentHeo.studentName = "허준";
		studentHeo.address = "용인";
		
		studentHeo.showStudentInfo();
		
		Student studentKim = new Student();
		studentKim.studentName = "김유신";
		studentKim.address = "경주";
	
		studentKim.showStudentInfo();
		
		System.out.println(studentHeo);
		System.out.println(studentKim);
	}

}
