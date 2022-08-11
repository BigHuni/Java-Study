# 📌 Java Study

## 🔸 2022-08-11 목요일

## [상속과 다형성]

### 1. 상속에서 클래스 생성 과정과 형 변환

- 하위 클래스가 생성되는 과정

  - 하위 클래스가 생성될 때 상위 클래스가 먼저 생성됨

  - 상위 클래스의 생성자가 호출되고, 하위 클래스의 생성자가 호출됨
  - 하위 클래스의 생성자에서는 무조건 상위 클래스의 생성자가 호출되어야함

  - 하위 클래스에서 상위 클래스의 생성자를 호출하는 코드가 없는 경우 컴파일러는 상위 클래스 기본 생성자를 호출하기 위한 `super()`를 추가함

  - `super()`로 호출되는 생성자는 상위 클래스의 기본 생성자임

  - 만약, 상위 클래스의 기본 생성자가 없는 경우 (매개 변수가 있는 생성자만 존재하는 경우), 하위 클래스는 명시적으로 상위 클래스이 생성자를 호출해야함

- 원리를 파악하기 위해 코드에 로그를 확인할 수 있는 예제 활용

- Customer 클래스(상위 클래스)

```java
    public Customer() {
		customerGrade = "SILVER";
		bonusRatio = 0.01;

		System.out.println("Customer() 생성자 호출");
	}
```

<br>

- VIPCustomer 클래스(하위 클래스)

```java
    public VIPCustomer() {
			customerGrade = "VIP";
			bonusRatio = 0.05;
			salesRatio = 0.1;

	System.out.println("VIPCustomer() 생성자 호출");
		}
```

<br>

- CustomerTest 클래스(Main)

```java
    VIPCustomer customerYoo = new VIPCustomer();
		customerYoo.setCustomerName("유재석");
		customerYoo.setCustomerID(10020);
		customerYoo.bonusPoint = 10000;
		System.out.println(customerYoo.showCustomerInfo());
```

<br>

- 출력 결과

```
Customer() 생성자 호출
VIPCustomer() 생성자 호출
유재석님의 등급은 VIP이며, 적립된 보너스 포인트는 10000점 입니다.
```

- 하위 클래스인 VIPCustomer에서 상위 클래스를 호출하는 것이 아무것도 없음

- 이 때, 상위 클래스를 호출하는 `super()` 코드가 컴파일 단계에서 자동으로 들어가게됨

- `super()` => 상위 클래스의 기본 생성자가 호출

- 상위 클래스에 기본 생성자를 없애고, 다른 생성자가 있다고 가정하면 하위 클래스에서 오류 발생 => 상위 클래스에 기본 생성자가 없기 때문

- 상위 클래스에 생성자가 아무것도 없다고 하면 오류 발생하지 않음 => 하위 클래스에서 `super()`을 호출하고, 기본 생성자를 제공하기 때문

- 상위 클래스에서 매개변수가 있는 생성자가 있을 경우, 기본 생성자를 제공하지 않고, VIPCustomer 하위 클래스에서 `super()`가 없는 것

- 따라서 매개 변수가 있는 생성자가 상위 클래스에 있을경우 예로들어 super(0, null)로 하위 클래스에서 호출

- 또는 하위 클래스에서 아래 코드처럼 추가

```java
    public VIPCustomer(int customerID, String customerName) {
        super(customerID, customerName);

        custoemrGrade = "VIP";
        bonusRatio = 0.05;
        salesRatio = 0.1;
    }
```

<br>

- 정리 : 상위 클래스에서 기본 생성자가 있을 경우나 아예 아무런 생성자가 없을 경우에는 오류가 발생 하지 않으나, 매개 변수를 받는 생성자만 존재할 경우, 하위 클래스에서 `super(customerID, customerName)`으로 명시적으로 호출해야됨

<br>

- 상속에서의 메모리 상태

  - 상위 클래스의 인스턴스가 먼저 생성

  - 하위 클래스의 인스턴스가 생성

<br>

- 상위 클래스로의 묵시적 형 변환(업캐스팅)

- 상위 클래스 형으로 변수를 선언하고 하위 클래스 인스턴스를 생성할 수 있음

- 하위 클래스는 상위 클래스의 타입을 내포하고 있으므로 상위 클래스로 묵시적 형 변환이 가능

- 상속 관계에서 모든 하위 클래스는 상위 클래스로 묵시적 형 변환이 됨(그 역은 성립하지 않음)

<br>

```java
    VIPCustomer customerYoo = new VIPCustomer(10020, "유재석");

    Customer customerYoo = new VIPCustomer(10020, "유재석");
```

- 둘 다 오류를 발생하지 않은데, 이유는 VIPCustomer는 VIPCustomer임과 동시에 Customer을 상속받았기 때문에 Customer 타입을 내포하고 있음

- 상위 클래스의 타입으로 변수를 선언하고, 하위 클래스 인스턴스로 생성이 되면 묵시적으로 이루어짐

- customerYoo (상위 클래스), customerPark (하위 클래스)

```java
    customerYoo = customerPark;
```

- 하위 클래스의 타입은 상위 클래스의 변수 타입으로 자동 형 변환(묵시적 형 변환)

```java
    Customer vc = new VIPCustomer();
```

- VIPCustomer 하위 클래스의 확장으로 힙 메모리에 Customer 상위 클래스의 멤버 변수들을 포함한 채 생성

- 타입은 Customer 이기 때문에 vc 밑에 보이는 내용들은 모두 Customer인 것만 보이게 됨

- 정리 : VIPCustomer() 생성자의 호출로 인스턴스는 모두 생성 되었지만, 타입이 Customer 이므로 vc가 접근할 수 있는 변수간 메서드는 Customer의 변수와 메서드임

<br>

### 2. 메서드 오버라이딩

- 하위 클래스에서 메서드 재정의 하기

- 오버라이딩(overriding) : 상위 클래스에 정의된 메서드의 구현 내용이 하위 클래스에서 구현할 내용과 맞지 않는 경우 하위 클래스에서 동일한 이름의 메서드를 재정의 할 수 있음

- 예제의 Customer 클래스의 calsPrice()와 VIPCustomer의 calcPrice() 구현 내용은 할인율과 보너스 포인트 적립내용 부분의 구현이 다름

- 따라서 VIPCustomer 클래스는 calcPrice() 메서드를 재정의 해야함

<br>

- 오버로딩 : 같은 이름의 메서드지만, 매개 변수가 다름

- 오버라이딩 : 덮어씀, 이미 구현된 코드를 내가 다른 코드로 재구현

- @override 애노테이션(Annotation)

  - 재정의된 메서드라는 의미로 선언부가 기존의 메서드와 다른 경우 에러 발생

  - 애노테이션은 컴파일러에게 특정한 정보를 제공해주는 역할

  - 주로 사용되는 자바에서 제공되는 애노테이션

<br>

| 애노테이션              | 설명                                                                                                |
| :---------------------- | :-------------------------------------------------------------------------------------------------- |
| `@Override`             | 재정의된 메서드라는 정보 제공                                                                       |
| `@FunctionallInterface` | 함수형 인터페이스라는 정보 제공                                                                     |
| `@Deprecated`           | 이후 버전에서 사용되지 않을 수 있는 변수, 메서드에 사용됨                                           |
| `@SuppressWarnings`     | 특정 경고가 나타나지 않도록 함()@SuppressWarnings("deprecation")는 @Deprecated가 나타나지 않도록 함 |

<br>

- 형 변환과 오버라이딩 메서드 호출

```java
    Customer vc = new VIPCustomer();
    vc.calcPrice(10000);
```

- 위 코드에서 calcPrice() 메서드는 어느 메서드가 호출될 것인가?

- 자바에서 항상 인스턴스(여기서는 VIPCustomer)의 메서드가 호출됨

- 타입이 Customer 이기 때문에 Customer 메서드가 호출될 것처럼 생각하지만, 결과는 VIPCustomer의 메서드가 호출 => `가상함수`

- 자바에서는 기본적으로 모든 메서드가 `가상 메서드`

<br>

```java
    Customer customerNo = new VIPCustomer(10030, "정준하");
		customerNo.bonusPoint = 10000;

		System.out.println(customerNo.showCustomerInfo() + " 지불 금액은 " + customerNo.calcPrice(10000) + "원 입니다.");
	}
```

- `customerNo.calcPrice`는 인스턴스 메서드(VIPCustomer)를 호출

- 그런데, customerNo에 `.(점)`을 찍어보면 타입인 Customer 메서드만 보이게 됨

- 이를 `가상 함수`

<br>

- 가상 메서드(Virtual method)

  - 메서드의 이름과 메서드 주소를 가진 가상 메서드 테이블에서 호출될 메서드의 주소를 참조함

  - 메서드에 대한 맵핑되는 주소 값이 따로 있음

  - Customer 의 calcPrice 메서드의 주소는 재정의된 VIPCustomer 의 calcPrice 메서드의 주소 값과 다름

  - Customer 의 showCustomerInfo 메서드의 주소는 재정의 하지 않은 VIPCustomer 의 calcPrice 메서드의 주소와 동일

  - 이 때, 호출을 하게 되면 타입에 기반되는 것이 아니라 생성된 인스턴스에 기반하여 호출되는 것

<br>

## 🔖 Eclipse 실습

![day16](https://user-images.githubusercontent.com/79084294/184190658-ffaa4265-1dfa-4076-8df6-7b5b7cb12655.png)

<br>

## 🔖 Eclipse 출력 Console

![day16_console1](https://user-images.githubusercontent.com/79084294/184190664-d7363664-8b7b-4138-9f84-40466a60f3e7.png)

![day16_console2](https://user-images.githubusercontent.com/79084294/184190669-ba8e2044-aee8-412d-9919-c0e2e23fe6aa.png)
