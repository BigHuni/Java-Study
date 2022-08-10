package inheritance;

public class CustomerTest {

	public static void main(String[] args) {

		Customer customerPark = new Customer();
		customerPark.setCustomerName("박명수");
		customerPark.setCustomerID(10010);
		customerPark.bonusPoint = 1000;
		System.out.println(customerPark.showCustomerInfo());
		
		VIPCustomer customerYoo = new VIPCustomer();
		customerYoo.setCustomerName("유재석");
		customerYoo.setCustomerID(10020);
		customerYoo.bonusPoint = 10000;
		System.out.println(customerYoo.showCustomerInfo());
	}

}
