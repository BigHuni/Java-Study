# 📌 Java Study

## 🔸 2022-08-15 월요일

## [추상 클래스 응용]

### 1. 템플릿 메서드

- 템플릿 : 틀이나 견본을 의미

- 텔플릿 메서드 : 추상 메서드나 구현된 메서드를 활용하여 전체의 흐름(시나리오)를 정의해 놓은 메서드
  - `final`로 선언하여 재정의 할 수 없게 함

- 템플릿 메서드 패턴 : 디자인 패턴의 일종
  - 프레임 워크에서 많이 사용되는 설계 패턴
  - 추상 클래스로 선언된 상위 클래스에서 추상 메서드를 이용하여 전체 구현의 흐름을 정의하고 구체적인 각 메서드 구현은 하위 클래스에 위임함
  - 하위 클래스가 다른 구현을 했다고 해서 템플릿 메서드에 정의된 시나리오대로 수행됨

<br>

- 상위 클래스에서 메서드를 생성 시 `public abstract void washCar()` 라고 정의할 경우, 모든 하위 클래스에서 이 메서드를 재정의 해야됨

- `public void washCar()` 라고 정의할 경우, 내가 필요로 하는 하위 클래스에 재정의 할 수 있

<br>

- final 변수는 값이 변경될 수 없는 상수임

- `public static final double PI = 3.14;`

- 오직 한 번만 값을 할당할 수 있음

- final 메서드는 하위 클래스에서 재정의 할 수 없음

- final 클래스는 더 이상 상속되지 않음 (ex : java의 String 클래스)

- public static final 상수 값 정의하여 사용

- 자바는 전역변수를 외부에서 선언하고, 만들 수 없기 때문에 따로 Define 등의 이름으로 자바파일 하나 생성

- pulbic static final int OOO, String OOO 등

- static 이므로 메모리에 한 번만 잡히게 됨

- 다른 클래스에서 `new`를 생성하지 않고 바로 사용 가능

- `new` 생성하면 인스턴스를 생성하고, 힙 메모리에 오버 헤드가 있는데 이를 절약 가능 

<br>

## 🔖 Eclipse 실습

![day20](https://user-images.githubusercontent.com/79084294/184883295-396ff15f-d566-4238-9654-c7d62919dc80.png)

<br>

## 🔖 Eclipse 출력 Console

![day20_console1](https://user-images.githubusercontent.com/79084294/184883302-d7edca74-7096-4caa-bac0-b55bce42bff5.png)

