# 📌 Java Study

## 🔸 2022-08-10 수요일

## [상속]

### 1. 상속

- 클래스에서 상속의 의미

  - 새로운 클래스를 정의할 때 이미 구현된 클래스를 상속받아서 속성이나 기능이 확장되는 클래스를 구현함

  - 상속하는 클래스 : 상위 클래스, parent class, base class, super class

  - 상속받는 클래스 : 하위 클래스, child class, derived class, subclass

  - 좀 더 일반적인 클래스와 좀 더 구체적인 클래스가 있을 때 기능이 유사하되, 기존의 클래스의 기능을 가져와 조금 더 확장시킬 때 사용

- B 클래스가 A 클래스로부터 상속받음

- `extends` 키워드 뒤에는 하나의 클래스만 올 수 있음

- C++에 비해 자바는 single inheritance(단독 상속)만 지원

```java
    class B extends A {

    }
```

- 상속을 사용하는 경우

  - 상위 클래스는 하위 클래스보다 일반적인 개념과 기능

  - 하위 클래스는 상위 클래스보다 구체적인 개념과 기능

<br>

- 상속을 사용하여 고객관리 프로그램 구현하기

  - 고객의 등급에 따른 차별화된 서비스를 제공

  - 고객의 등급에 따라 할인율, 적립금이 다르게 적용

<br>

| 멤버 변수       | 설명                                                                                                                                                                                                                             |
| :-------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `customerID`    | 고객 아이디                                                                                                                                                                                                                      |
| `customerName`  | 고객 이름                                                                                                                                                                                                                        |
| `customerGrade` | 고객 등급, 기본 생성자에서 지정되는 기본등급은 SILVER 입니다.                                                                                                                                                                    |
| `bonusPoint`    | 고객의 보너스 포인트, 고객이 제품을 구매할 경우 누적되는 보너스 포인트입니다.                                                                                                                                                    |
| `bonusRatio`    | 보너스 포인트 적립 비율, 고객이 제품을 구매할 때 구매 금액의 일정 비율이 보너스 포인트로 적립됩니다. 이 때, 계산되는 적립 비율입니다. 기본 생성자에서 지정되는 적립 비율은 1%입니다. 즉 10,000원 짜리를 사면 100원이 적립됩니다. |

<br>

- Customer를 상속받아 구현하는 VIPCustomer 클래스

  - 단골고객으로 혜택이 더 다양해짐

  - 제품 구매시 10% 할인

  - 보너스 포인트 5% 적립

  - 담당 상담원 배정

  - Customer 클래스와 유사하지만, 더 많은 속성과 기능 필요

  - Customer에서 `private`로 `String customerGrade` 선언했기 때문에 접근 불가

  - 따라서 상속하는 클래스의 접근 제어자 `protected`로 선언해야함

  - `protected` => 외부 클래스에는 private으로 하위 클래스에서 public 기능을 구현한 키워드

  - 상위 클래스에 protected로 선언된 변수나 메서드는 다른 외부 클래스에서는 사용할 수 없지만 하위 클래스에서는 사용가능

<br>

| 접근 제한자              | 외부 클래스 | 하위 클래스 | 동일 패키지 | 내부 클래스 |
| :----------------------- | :---------- | :---------- | :---------- | :---------- |
| `public`                 | O           | O           | O           | O           |
| `protected`              | X           | O           | O           | O           |
| `선언되지 않음(default)` | X           | X           | O           | O           |
| `private`                | X           | X           | X           | O           |

<br>

- 테스트 시나리오

  - 일반 고객 1명과 VIP 고객 1명이 있습니다. 일반 고객의 이름은 박명수, 아이디는 10010, 보너스 포인트는 1000점 입니다. VIP 고객의 이름은 유재석, 아이디는 10020, 보너스 포인트는 10000점 입니다. 두 고객을 생성하고 이에 대한 고객 정보를 출력해 보세요.

<br>

- Customer 클래스

```java
package inheritance;

public class Customer {

	protected int customerID;
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;

	public Customer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;
	}

	public int calsPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price;
	}

	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade + "이며, 적립된 보너스 포인트는 " + bonusPoint + "점 입니다.";
	}
```

- customerID, customerName, customerGrade 변수를 `protected`로 선언

- bonusPoint, bonusRatio 변수 선언

-
