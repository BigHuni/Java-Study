package inheritance;

public class CustomerTest {

	public static void main(String[] args) {

		Customer customerPark = new Customer(10010, "박명수");
//		customerPark.setCustomerName("박명수");
//		customerPark.setCustomerID(10010);
		customerPark.bonusPoint = 1000;
		System.out.println(customerPark.showCustomerInfo());
		
		Customer customerYoo = new VIPCustomer(10020, "유재석");
//		customerYoo.setCustomerName("유재석");
//		customerYoo.setCustomerID(10020);
		customerYoo.bonusPoint = 10000;
		System.out.println(customerYoo.showCustomerInfo());
	}

} 
