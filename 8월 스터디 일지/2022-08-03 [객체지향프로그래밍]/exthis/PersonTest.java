package exthis;

public class PersonTest {

	public static void main(String[] args) {
		
		Person personNoname = new Person();
		personNoname.showInfo();
		
		Person personHeo = new Person("Heo", 20);
		personHeo.showInfo();
		System.out.println(personHeo);
		
		Person p = personHeo.getSelf();
		System.out.println(p);
	}

}
