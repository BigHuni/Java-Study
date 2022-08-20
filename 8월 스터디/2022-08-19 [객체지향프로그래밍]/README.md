# 📌 Java Study

## 🔸 2022-08-19 금요일

## [인터페이스를 활용한 다형성 구현]

### 1. 인터페이스의 역할

- 클라이언트 프로그램에 어떤 메서드를 제공하는지 알려주는 명세(Specification) 또는 약속
- 한 객체가 어떤 인터페이스의 타입이라 함은 그 인터페이스의 메서드를 구현했다는 의미
- 클라이언트 프로그램은 실제 구현 내용을 몰라도 인터페이스의 정의만 알면 그 객체를 사용할 수 있음
- 인터페이스를 구현해 놓은 다양한 객체를 사용함 - 다형성
    - JDBC를 구현한 오라클, MSSQL 라이브러리 등
- 쉽게 말해, `ABC` 라는 인터페이스에 구현되어 있는 a(), b(), c() 메서드가 있다는 명세를 확인할 수 있음
- 추상 클래스와의 차이점은 공통되는 모듈이 있을 수도, 없을 수도 있고, 클래스이기에 하나만 상속받음
- 인터페이스는 순수하게 명세만 되어 있기에 여러 개를 상속받을 수 있음
- Connetion의 여러 메서드 등을 구현하라고 선언되어 있음, 이를 상속(implements)하는 것은 오라클 MySQL, MSSQL 등 DB 사
- 이 들이 구현해서 우리에게 라이브러리를 제공(.jar 파일)
- 우리는 오라클로 연결해서 쿼리문을 수행하기 위해 .jar 파일을 import 해서 자료를 Connection에 연결하는데, 인터페이스 명세를 보면서 함

<br>

### 2. 인터페이스와 다형성 구현하기

- 고객 센터에는 전화 상담을 하는 상담원들이 있다. 일단 고객 센터로 전화가 오면 대기열에 저장된다. 상담원이 지정되기 전까지 대기 상태가 된다. 각 전화가 상담원에게 배분되는 정책은 다음과 같이 구현될 수 있음
    - 상담원 순서대로 배분하기
    - 대기가 짧은 상담원 먼저 배분하기
    - 우선순위가 높은(숙련도가 높은) 상담원에게 먼저 배분하기

- 위와 같은 다양한 정책이 사용되는 경우, interface를 정의하고 다양한 정책을 구하여 실행하기

<br>

- interface 구현 (Scheduler)

```java
public interface Scheduler {
    public void getNextCall();

    public void sendCallToAgent();
}
```

<br>

- priorityAllocation 클래스(인터페이스 상속)

```java
  public class PriorityAllocation implements Scheduler {

    @Override
    public void getNextCall() {
        System.out.println("고객 등급이 높은 고객의 call을 먼저 가져옵니다.");
    }

    @Override
    public void sendCallToAgent() {
        System.out.println("업무 숙련도가 높은 상담원에게 먼저 배분합니다.");
    }

}
```

<br>

- SchedulerTest 클래스(main)

```java
  package scheduler;

import java.io.IOException;

public class SchedulerTest {

    public static void main(String[] args) throws IOException {

        System.out.println("전화 상담원 할당 방식을 선택하세요.");
        System.out.println("R : 한명씩 차례대로");
        System.out.println("L : 대기가 적은 상담원 우선");
        System.out.println("P : 우선순위가 높은 고객 우선 숙련도 높은 상담원");

        int ch = System.in.read();
        Scheduler scheduler = null;

        if (ch == 'R' || ch == 'r') {
            scheduler = new RoundRobin();
        } else if (ch == 'L' || ch == 'l') {
            scheduler = new LeastJob();
        } else if (ch == 'P' || ch == 'p') {
            scheduler = new PriorityAllocation();
        } else {
            System.out.println("지원되지 않는 기능입니다.");
            return;
        }

        scheduler.getNextCall();
        scheduler.sendCallToAgent();

    }
}
```

- println 구문이 나오고 P 혹은 p 입력 시 `PriorityAllocation` 클래스에 해당하는 println 메서드 호출
- interface의 메서드들을 구현하는 것이 중요
- 이를 구현하는 것은 각 클래스를 생성하여 Override
- JDBC 같은 경우에는 각 DB 사에서 그 역할 수행
- 정책이 바뀌었다면, 해당 하는 클래스의 출력과 main에서 조건문을 조작하면 됨
- 프로젝트 수행 시 사전 정의된 인터페이스를 갖고 수행하는 경우가 있음
- 예로 들면, 안드로이드, 스프링 프레임워크를 사용 시 굉장히 많은 인터페이스가 이미 선언되어 있음
- 인터페이스의 역할을 정리해보면, 모듈이 해야할 일을 정리해놓은 것

<br>

- 인터페이스와 strategy pattern
    - 여러 개의 정책이 존재할 수 있음(Bubble Sort, Quick Sort, Heap Sort...)
    - 이는 하나의 정책을 구현(Sorting)
    - 인터페이스를 활용하면 다양한 정책이나 알고리즘을 프로그램의 큰 수정 없이 적용, 확장할 수 있음
    - 원래 IUserInfoDao 등을 구현
    - 그 후 implements 해서 정책에 따라 그 인터페이스에 맞는 oracleDao, mysqlDao, mssqlDao 등을 구현하여 포팅

<br>

## 🔖 Eclipse 실습

![day24](https://user-images.githubusercontent.com/79084294/185746311-13fc76bd-0656-4bbc-87d6-8e8be788f72e.png)

<br>

## 🔖 Eclipse 출력 Console

![day24_console1](https://user-images.githubusercontent.com/79084294/185746315-f1f62757-97ef-46bb-a0b6-15ccc2d823b5.png)
