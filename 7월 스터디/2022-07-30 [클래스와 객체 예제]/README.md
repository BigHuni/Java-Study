# 📌 Java Study

## 🔸 2022-07-30 토요일

## [클래스와 객체 예제]

### 1. 다음 객체에 대한 설명에 맞는 클래스를 만들고 값을 출력

- 나이가 40살, 이름이 Davis 라는 남자가 있습니다. 이 남자는 결혼을 했고, 자식이 셋 있습니다.

<br>

- 출력 결과

```
    나이 : 40
    이름 : Davis
    결혼여부 : true
    자녀 수 : 3
```

<br>

## 🔖 1번 예제 코드

<br>

- Person 클래스

```java
    package classpart;

    public class Person {
    	int age;
    	String name;
    	Boolean isMarried;
    	int numberOfChildren;

    }
```

<br>

- PersonTest 클래스(main 함수 포함)

```java
    package classpart;

    public class PersonTest {

	public static void main(String[] args) {

		Person person = new Person();
		person.age = 40;
		person.name = "Davis";
		person.isMarried = true;
		person.numberOfChildren = 3;

		System.out.println("나이 : " + person.age);
		System.out.println("이름 : " + person.name);
		System.out.println("결혼여부 : " + person.isMarried);
		System.out.println("자녀 수 : " + person.numberOfChildren);
	}
}
```

<br>

- Eclipse Console 출력

![1번 결과](https://user-images.githubusercontent.com/79084294/181904052-d85857a0-cb44-424c-a627-dac5ead5cd17.png)

<br>

### 2. 다음 객체에 대한 설명에 맞는 클래스를 만들고 값을 출력

- 쇼핑몰에 주문이 들어왔습니다. 주문 내용 결과를 출력하시오.

<br>

- 출력 결과

```
    주문번호 : 2022073001
    주문자 아이디 : abc123
    주문 날짜 : 2022년 7월 30일
    주문자 이름 : 허대훈
    주문 상품 번호 : PD0327-12
    배송 주소 : 경기도 용인시 처인구 포곡읍 에버랜드로 199
```

<br>

## 🔖 2번 예제 코드

<br>

- ShopOrder 클래스

```java
    package classpart;

    public class ShopOrder {
	int orderNumber;
	String orderId;
	String orderDate;
	String orderName;
	String orderGoodsNum;
	String orderAddress;

}
```

<br>

- ShopOrderTest 클래스(main 함수 포함)

```java
    package classpart;

    public class ShopOrderTest {

	public static void main(String[] args) {

		ShopOrder shoporder = new ShopOrder();
		shoporder.orderNumber = 2022073001;
		shoporder.orderId = "abc123";
		shoporder.orderDate = "2022년 7월 30일";
		shoporder.orderName = "허대훈";
		shoporder.orderGoodsNum = "PD0327-12";
		shoporder.orderAddress = "경기도 용인시 처인구 포곡읍 에버랜드로 199";

		System.out.println("주문번호 : " + shoporder.orderNumber);
		System.out.println("주문자 아이디 : " + shoporder.orderId);
		System.out.println("주문 날짜 : " + shoporder.orderDate);
		System.out.println("주문자 이름 : " + shoporder.orderName);
		System.out.println("주문 상품 번호 : " + shoporder.orderGoodsNum);
		System.out.println("배송 주소 : " + shoporder.orderAddress);
	}

}
```

<br>

- Eclipse Console 출력

![2번 결과](https://user-images.githubusercontent.com/79084294/181904065-2bc09f10-adde-4ab4-8543-b6ec99174b5a.png)
