# 📌 Java Study

## 🔸 2022-08-18 목요일

## [인터페이스]

### 1. 인터페이스

    - 추상 메서드
    - 상수
    - 디폴트 메서드
    - 정적 메서드
    - private 메서드

<br>

- 인터페이스 : 어떠한 객체에 대한 명제, 어떠한 메서드들을 제공할 것인지 설명한 가이드 역할

- 인터페이스 선언과 구현

```java
    public interface Calc {            // 인터페이스에서 선언한 변수는
    doubl PI = 3.14;                   // 컴파일 과정에서 상수로 변환
    int ERROR = -999999;

    int add(int num1, int num2);       // 인터페이스에서 선언한 메서드는

    int substract(int num1, int num2); // 컴파일 과정에서 추상 메서드로 변환
}
```

- `PI`는 상수의 의미로 이탤릭체로 변경
- 컴파일 과정에서 public static final double 키워드가 붙음

<br>

- CalcTest 클래스

```java
    public class CalcTest {

    public static void main(String[] args) {

        CompleteCalc calc = new CompleteCalc();
        int n1 = 10;
        int n2 = 2;

        System.out.println(calc.add(n1, n2));
        System.out.println(calc.substract(n1, n2));
        System.out.println(calc.times(n1, n2));
        System.out.println(calc.divide(n1, n2));
        calc.showInfo();
    }

}
```

- CompleteCalc 클래스는 Calculator 클래스를 상속 받고, Calc 인터페이스가 구현
- 위 코드에서 CompleteCalc 타입 대신 `Calc` 인터페이스로 타입을 선언할 수 있고, `Caculator`도 가능
- 단, 이 과정에서 형 변환이 일어남
- 만약, 인터페이스 타입인 Calc으로 선언한 변수 calc는 인스턴스가 `CompleteCalc()`라 해도 타입이 Calc 이기 때문에 사용할 수 있는 메서드는 인터페이스 Calc에 있는 메서드만 사용가능(업
  캐스팅)
- `Calc calc = new CompleteCalc();`
- 인터페이스를 구현한 클래스는 인터페이스 타입으로 변수를 선언하여 인스턴스를 생성할 수 있음
- 인터페이스는 구현 코드가 없기 때문에 `타입 상속`이라고도 함

<br>

## 🔖 Eclipse 실습

![day23](https://user-images.githubusercontent.com/79084294/185450265-2683d465-5036-4728-8270-ac2deef06047.png)

<br>

## 🔖 Eclipse 출력 Console

![day23_console1](https://user-images.githubusercontent.com/79084294/185450267-bd8802f3-e0f6-4cb8-84fd-7ce1bd6cd9e6.png)
