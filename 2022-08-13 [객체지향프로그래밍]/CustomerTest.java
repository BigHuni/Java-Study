package witharraylist;

import java.util.ArrayList;

public class CustomerTest {

	public static void main(String[] args) {

		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		Customer customerYoo = new VIPCustomer(10010, "유재석", 12345);
		Customer customerPark = new GoldCustomer(10020, "박명수");
		Customer customerJeong = new GoldCustomer(10030, "정준하");
		Customer customerHa = new Customer(10040, "하동훈");
		Customer customerNo = new Customer(10050, "노홍철");
		
		customerList.add(customerYoo);
		customerList.add(customerPark);
		customerList.add(customerJeong);
		customerList.add(customerHa);
		customerList.add(customerNo);
		
		System.out.println("====== 고객정보 출력 ======");
		
		for(Customer customer : customerList) {
			System.out.println(customer.showCustomerInfo());
		}
		
		System.out.println("====== 할인율과 보너스 포인트 계산 ======");
		
		int price = 10000;
		
		for(Customer customer : customerList) {
			int cost = customer.calcPrice(price);
			
			System.out.println(customer.getCustomerName() + " 님이 " + cost + " 원을 지불하셨습니다.");
			System.out.println(customer.getCustomerName() + " 님의 현재 보너스 포인트는  " + customer.bonusPoint + " 점입니다.");
		}
	} 

}
