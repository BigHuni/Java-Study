# 📌 Java Study

## 🔸 2022-08-14 일요일

## [추상 클래스]

### 1. 추상 클래스

- 추상 클래스 : 추상 메서드를 포함한 클래스

  - 추상 메서드 : 구현 코드가 없이 선언부만 있는 메서드

  - `abstract` 예약어 사용 : 추상 클래스는 new(인스턴스화) 할 수 없음

  - 메서드에 body가 없음

<br>

```java
    public abstract void display();
	public abstract void typing();
```

- 일반적으로 클래스를 생성하였다면, 오류 발생 => `abstract`키워드를 붙여 `public abstract class 클래스명` 으로 지어야 함

- 위 코드는 구현코드가 없음, 언제 구현이 되는지? => `하위 클래스`에서 구현

- 추상 클래스는 단독 사용으로 만들어지는 것이 아니라 상위 클래스용으로 주로 사용

- 하나라도 추상 메서드를 포함하면, `abstract class`가 되어야 함

- 즉, 추상 메서드가 포함된 클래스는 추상 클래스로 선언

- 모든 메서드가 구현되었다고 해도 클래스에 `abstract` 키워드를 사용하면 추상 클래스

- 추상 클래스는 주로 상속의 상위 클래스로 사용

- 추상 메서드 : 하위 클래스가 구현해야 하는 메서드

- 구현된 메서드 : 하위 클래스가 공통으로 사용하는 기능의 메서드, 하위 클래스에 따라 재정의 할 수 있음

<br>

### 2. Eclipse 오류(Cannot instantiate the type OOO)

- DeskTop 클래스

```
    public class DeskTop extends Computer {

    public void display() {
        System.out.println("DestTop display");
    }

    public void typing() {
        System.out.println("DeskTop typing");
    }
}
```

- Computer 클래스

```
    public abstract class Computer {

    public abstract void display();
    public abstract void typing();

    public void turnOn() {
        System.out.println("전원을 켭니다.");
    }

    public void turnOff() {
        System.out.println("전원을 끕니다.");
    }
}
```

- ComputerTest 클래스

```
    public class ComputerTest {

    public static void main(String[] args) {

        Computer computer = new DeskTop();
        computer.display();
    }

}
```

```
    Computer computer = new Computer();
```

\=> ComputerTest 클래스에서 위 코드 입력 시 오류 발생, computer 클래스는 추상 클래스이기 때문

- `computer.display();` 찍었을 때 불러올 메서드가 없음(구현이 안 되어 있기 때문)
- 따라서 Computer는 인스턴스화 될 수 없음
- DeskTop은 인스턴스화 될 수 있는 이유는 상속에서 상위 클래스 타입의 변수로 하위 클래스의 인스턴스가 생성되어 대입될 수 있기 때문
- 묵시적 형 변환
- 추상 클래스 하나를 상속받은 여러 클래스를 동일한 타입으로 상위 클래스 타입으로 핸들링해서 많이 사용
- 위 오류는 OOO 클래스가 인스턴스를 만들 수 없는 Abstract(추상) 클래스이기 때문에 발생
- 따라서 슈퍼 생성자를 호출하거나 해당 클래스의 추상화를 제거하면 됨
- 추상 클래스는 new() 객체 생성이 불가능
- stack overflow 참조 : [https://stackoverflow.com/questions/30317070/java-returns-error-cannot-instantiate-the-type](https://stackoverflow.com/questions/30317070/java-returns-error-cannot-instantiate-the-type)

<br>

## 🔖 Eclipse 실습

![day19](https://user-images.githubusercontent.com/79084294/184638586-07030b46-c423-4e54-a1f8-e991429509a8.png)

<br>

## 🔖 Eclipse 출력 Console

![day19_console1](https://user-images.githubusercontent.com/79084294/184638592-b831c4a1-e74b-45b8-a5a6-7fd4c8fee5b5.png)
