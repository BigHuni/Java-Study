# 📌 Java Study

## 🔸 2022-08-17 수요일

## [추상 클래스 응용]

### 1. 코딩해보기

- 예제 : 자동차 주행 과정 구현하기
    - Car 추상 클래스를 상속받는 Sonata, Avante, Grandeur, Genesis 클래스가 있다.
    - 각 차는 주행하기 위해 다음 메서드의 순서로 움직임
  ```java
  run() {
    start();
    drive();
    stop();
    turnoff();
  }
    ```
    - run() 메서드를 템플릿 메서드로 구현하고, CarTest 클래스를 참고하여 프로그램을 완성

<br>

- Car 클래스

```java
  public abstract class Car {
    public abstract void start();

    public abstract void drive();

    public abstract void stop();

    public abstract void turnoff();

    public void washCar() {
        System.out.println("세차를 합니다.");
    }

    public void run() {
        start();
        drive();
        stop();
        turnoff();
    }
}
```

- 추상 클래스로 Car 클래스 생성
- 추상 메서드 start(), drive(), stop(), turnoff() 생성
- run() 메서드로 각 추상 메서드 실행하도록 구현

<br>

- Avante 클래스

```java
  public class Avante extends Car {

    @Override
    public void start() {
        System.out.println("Avante 시동을 켭니다.");
    }

    @Override
    public void drive() {
        System.out.println("Avante 달립니다.");
    }

    @Override
    public void stop() {
        System.out.println("Avante 멈춥니다.");
    }

    @Override
    public void turnoff() {
        System.out.println("Avante 시동을 끕니다.");
    }
}
```

- Car 클래스로부터 상속받아 Avante 클래스 생성(나머지 Genesis, Grandeur, Sonata도 생성)
- Override로 각 추상 메서드 구현
- 출력문으로 각 해당하는 구문 기재

<br>

CarTest 클래스

```java
  import java.util.ArrayList;

public class CarTest {

    public static void main(String[] args) {

        ArrayList<Car> carList = new ArrayList<Car>();

        carList.add(new Avante());
        carList.add(new Genesis());
        carList.add(new Grandeur());
        carList.add(new Sonata());

        for (Car car : carList) {
            car.run();

            System.out.println("====================");
        }
    }

}
```

- ArrayList 사용을 위해 util.ArrayList import 추가
- main 함수 적용
- 배열 생성하여 각 차종의 자바 파일 add
- carList에 있는 모든 차종 run() 메서드 동작

<br>

## 🔖 Eclipse 실습

![day22](https://user-images.githubusercontent.com/79084294/185276339-caf803f9-6c75-4e98-9fbb-0a81dcdca000.png)

<br>

## 🔖 Eclipse 출력 Console

![day22_console1](https://user-images.githubusercontent.com/79084294/185276343-9ccd761c-7ba0-4b99-ac41-f982ad273cff.png)
