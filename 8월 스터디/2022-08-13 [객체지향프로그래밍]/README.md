# 📌 Java Study

## 🔸 2022-08-13 토요일

## [상속과 다형성]

### 1. 1번 문제풀기(직접 코딩)

- 문제 : 일반 고객과 VIP 고객의 중간 등급 만들기, 고객이 늘어 VIP 고객만큼 물건을 많이 구입하지 않지만, 단골인 분들을 GOLD 등급으로 관리하고 싶다. 혜택은 다음과 같다.

  - 제품을 살 때는 항상 10%를 할인

  - 보너스 포인트는 2%를 적립

  - 담당 전문 상담원은 없음

- Customer 클래스에서 상속을 받아 GoldCustomer를 구현해보기

<br>

- Customer 클래스

```java
  package witharraylist;

public class Customer {

	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;

	public Customer() {
		initCustomer();
	}

	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;

		initCustomer();
	}

	private void initCustomer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;
	}

	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}

	public String showCustomerInfo() {
		return customerName + " 님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
}
```

- GoldCustomer 클래스

```java
  package witharraylist;

public class GoldCustomer extends Customer{

	double saleRatio;

	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);

		customerGrade = "GOLD";
		bonusRatio = 0.02;
		saleRatio = 0.1;

	}

	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio);
	}
}
```

- VIPCustomer 클래스

```java
  package witharraylist;

public class VIPCustomer extends Customer {

	private int agentID;
	double saleRatio;

	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);

		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		this.agentID = agentID;
	}

	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio);
	}

	public String showCustomerInfo() {
		return super.showCustomerInfo() + " 담당 상담원 번호는 " + agentID + "입니다.";
	}

	public int getAgentID() {
		return agentID;
	}
}
```

<br>

### 2. 2번 문제풀기(직접 코딩)

- 문제 : 배열을 활용하여 구현하기, 고객은 현재 5명, VIP 1명, GOLD 2명, SILVER 2명일 때, 각 고객이 10,000원 짜리 제품을 구매한 경우 지불한 금액과 적립된 보너스 포인트를 출력

  - ArrayList 활용하여 구현

<br>

- CustomerTest 클래스

```java
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
```

<br>

## 🔖 Eclipse 실습

![day18](https://user-images.githubusercontent.com/79084294/184533909-c4005f6a-f191-45a5-a9d0-1403d983bca7.png)

<br>

## 🔖 Eclipse 출력 Console

![day18_console1](https://user-images.githubusercontent.com/79084294/184533911-a6d25dcc-f0ee-4dd1-818a-582a2b2a8d98.png)
