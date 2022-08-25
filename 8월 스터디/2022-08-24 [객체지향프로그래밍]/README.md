# 📌 Java Study

## 🔸 2022-08-24 수요일

## [인터페이스 응용]

### 1. 인터페이스 응용

```
    default void description() {
        System.out.println("정수 계산기를 구현합니다.");
        }
```

```
    @Override
	public void description() {
		System.out.println("재정의 한 description");
	}
```

- 한 클래스에 description() 메서드를 구현하고, 다른 클래스에서 오버라이드 한 즉, 재정의 한 description() 메서드 구현
- `calc.description();` 찍어보면, `재정의 한 description`이 출력

<br>

- 인스턴스 생성과 상관없이 static으로 int total을 선언해놓으면, 인터페이스 타입으로 바로 가져다 사용가능
- `int[] arr = {1, 2, 3, 4, 5};`
- `int sum = Calc.total(arr);`

<br>

- `private static void mystaticMethod() {}`라고 선언하면, static 메서드에서 호출할 수 있음
- static 메서드에서 일반 메서드를 호출할 수 없음(불가능)
- 그냥 일반 메서드(private void ~)는 인스턴스 생성을 하지 않고, 호출하는 메서드이기 때문
- private 메서드 부분은 자바 9 버전 이상부터 지원

<br>

```java
    package interfaceex;

public class Customer implements Buy, Sell {

    @Override
    public void sell() {
        System.out.println("customer sell");
    }

    @Override
    public void buy() {
        System.out.println("customer buy");
    }

    @Override
    public void order() {
        System.out.println("customer order");
    }

    public void sayHello() {
        System.out.println("hello");
    }
}
```

- Customer 클래스에서 sell(), buy() 메서드 구현
- 각 Buy, Sell 클래스의 order()가 duplicate(중복)하고 있으니 Customer 클래스에서 order() 재정의

<br>

```java
    package interfaceex;

public class CustomerTest {

    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.buy();
        customer.sell();
        customer.order();
        customer.sayHello();

        Buy buyer = customer;
        buyer.buy();
        buyer.order();

        Sell seller = customer;
        seller.sell();
        seller.order();
    }
}
```

- `Buy buyer = customer;` 형 변환되면, buyer가 호출할 수 있는 것은 buy()만 가능
- `Sell seller = customer` 형 변환되면, seller가 호출할 수 있는 것은 sell()만 가능
- 각 buyer와 seller는 각 order()를 호출할 수 있는데, `다형성`으로 인해 여기서 호출되는 order()는 상단의 `customer customer = new Customer();` 인스턴스의
  order 이다.
- `다운 캐스팅`도 가능

```
    if(seller instanceof Customer) {}
```

- 위 조건문이 true이면, 다시 Customer로 형 변환 가능

<br>

## 🔖 Eclipse 실습

![day25](https://user-images.githubusercontent.com/79084294/186693423-ef9e01b9-43d3-4d30-9f33-b9d8d3f044a2.png)

<br>

## 🔖 Eclipse 출력 Console

![day25_console1](https://user-images.githubusercontent.com/79084294/186693434-0cbd941c-eab7-400a-9603-a04d50f02739.png)

![day25_console2](https://user-images.githubusercontent.com/79084294/186693439-93a3e6d6-1140-435e-aec8-318a59ebdf6d.png)
