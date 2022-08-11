package inheritance;

public class OverridingTest {

	public static void main(String[] args) {

		Customer customerPark = new Customer(10010, "박명수");
		customerPark.bonusPoint = 1000;
		
		VIPCustomer customerYoo = new VIPCustomer(10020, "유재석");
		customerYoo.bonusPoint = 10000;
		
		int pricePark = customerPark.calcPrice(10000);
		int priceYoo = customerYoo.calcPrice(10000);
		
		
		System.out.println(customerPark.showCustomerInfo() + " 지불 금액은 " + pricePark + "원 입니다.");
		System.out.println(customerYoo.showCustomerInfo() + " 지불 금액은 " + priceYoo + "원 입니다.");
		
		Customer customerNo = new VIPCustomer(10030, "정준하");
		customerNo.bonusPoint = 10000;
		
		System.out.println(customerNo.showCustomerInfo() + " 지불 금액은 " + customerNo.calcPrice(10000) + "원 입니다.");
	}

}
