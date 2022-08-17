# 📌 Java Study

## 🔸 2022-08-16 화요일

## [추상 클래스 응용]

### 1. 템플릿 메서드 활용하기

- 예제 : Player 가 있고, 이 Player가 게임을 합니다. 게임에서 Player가 가지는 레벨에 따라 run(), jump(), turn() 세가지 기능을 할 수 있습니다. 각 레벨에 따라 기능 가능
  여부가 다음과 같습니다.

    - 초보자 레벨 : 천천히 달립니다. {run()} 가능
    - 중급자 레벨 : 빠르게 달리고 {run()} 가능, 점프{jump()} 가능
    - 고급자 레벨 : 천천히 달립니다. {run()} 가능, 점프{jump()} 가능, 한 바퀴 돌 수 있습니다. {turn()} 가능

    - 플레이어는 go() 명령어를 받으면 이 세가지 기능을 수행합니다. 이 중 할 수 없는 것은 할 수 없다는 메시지를 보냅니다.

  <br>

- PlayerLevel 클래스(추상) - 상위 클래스

```java
  public abstract class PlayerLevel {

    public abstract void run();

    public abstract void jump();

    public abstract void turn();

    public abstract void showLevelMessage();

    final public void go(int count) {
        run();

        for (int i = 0; i < count; i++) {
            jump();
        }

        turn();
    }
}
```

<br>

- 그 밑에 상속 받아 BeginnerLevel, AdvancedLevel, SuperLevel 클래스 생성

```java
  public class BeginnerLevel extends PlayerLevel {

    @Override
    public void run() {
        System.out.println("천천히 달립니다.");
    }

    @Override
    public void jump() {
        System.out.println("jump 못하지롱");
    }

    @Override
    public void turn() {
        System.out.println("turn 못하지롱");
    }

    @Override
    public void showLevelMessage() {
        System.out.println("****** 초급자 레벨입니다. ******");
    }
}
```

<br>

- Player 클래스에 아래처럼 변수 선언을 하면 객체지향프로그래밍(OOP)이 아님
- `BeginnerLevel blevel;`
- `AdvancedLevel alevel;`
- `SuperLevel slevel;`

<br>

- Player가 PlayerLevel의 go()를 불렀을 때, run(), jump()를 어떻게 부를지 난감
- 그 때마다 따로 코딩해야 함

<br>

- `PlayerLevel level;`
- 이렇게 선언하게 되면 이 level 변수에 BeginnerLevel, AdvancedLevel, SuperLevel도 들어올 수 있게 됨
- PlayerLevel을 상속받게 된 모든 클래스를 `level` 변수에 대입이 가능하게 됨
- if 문을 여러 개 만드는 것이 아니라 각 메서드들은 `다형성`에 의해 인스턴스의 것이 호출하게 됨
- 만약, 여기서 다른 레벨의 등급을 생성하고 싶다면 클래스 추가해서 상속받으면 됨

<br>

- UltraSuperLevel 클래스 생성

```java
  public class UltraSuperLevel extends PlayerLevel {

    @Override
    public void run() {
    }

    @Override
    public void jump() {
    }

    @Override
    public void turn() {
    }

    @Override
    public void showLevelMessage() {
    }
}
```

<br>

## 🔖 Eclipse 실습

![day21](https://user-images.githubusercontent.com/79084294/185158352-e68b2671-5f74-488e-a2c8-d56710443002.png)

<br>

## 🔖 Eclipse 출력 Console

![day21_console1](https://user-images.githubusercontent.com/79084294/185158363-a07ec723-9895-4e7f-ad91-9e42298018e3.png)
