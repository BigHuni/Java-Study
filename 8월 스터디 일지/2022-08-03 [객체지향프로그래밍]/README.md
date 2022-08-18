# 📌 Java Study

## 🔸 2022-08-03 수요일

## [클래스와 객체]

### 1. this

- 자신의 메모리를 가리킴

- 생성자에서 다른 생성자를 호출

- 인스턴스 자신의 주소를 반환

<br>

- 생성자에서 다른 생성자를 호출

```java
    public Person() {
        this("이름 없음", 1);
    }

    public Person(String naem, int age) {
        this.name = name;
        this.age = age;
    }
```

<br>

- 생성자의 역할 => 인스턴스의 값을 초기화

- 인스턴스가 모두 생성되지 않았는데, 무슨 일을 하려면 문제 발생 가능

- this 로 다른 객체를 생성할 때, 항상 first statement 이어야 함.

```java
    public Person() {
        age = 100;    // 다른 statement 오면 오류 발생
        this("이름 없음", 1);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
```

<br>

```java
    public static void main(String[] args) {

		Person personNoname = new Person();
		personNoname.showInfo();

		Person personHeo = new Person("Heo", 20);
		personHeo.showInfo();
		System.out.println(personHeo);     // exthis.Person@1a1d6a08

		Person p = personHeo.getSelf();
		System.out.println(p);    // exthis.Person@1a1d6a08
	}
```

```java
    public Person getSelf() {
		return this;
	}
```

- 참조 변수 `personHeo`와 참조 변수가 가져온 `getSelf()` 메서드를 찾아가보면 this 값 리턴

- 따라서 둘이 가리키는 메모리 값은 `exthis.Person@1a1d6a08` 으로 동일

<br>

### 2. 객체 간 협력

- 객체지향 프로그램은 객체를 정의하고 객체 간의 협력을 구현한 프로그램

- 정보 은닉 예제 직접 코딩해보기(ExMyDate)
  - day, month, year 변수는 private으로 선언
  - 각 변수의 getter, setter를 public 으로 구현
  - ExMyDate(int day, int month, int year) 생성자 만들기
  - public boolean isValid() 메서드를 만들어 날짜가 유효한지 확인
  - ExMyDateTest 클래스에서 생성한 ExMyDate 날짜가 유효한지 확인

<br>

- 모든 멤버 변수를 private로 설정(boolean 까지)

- 이 때, `isValid = true` 설정

- setYear, 연도 설정 시 정상 연도인지 구분하기 위해 `Calendar` import 후 getInstance() 메서드 사용

- setMonth, 1 ~ 12개월 정상 범위를 벗어난 값에 대하여 `isValid = false`설정

- setDay, switch 문으로 30일, 31일 있는 달을 구분하고, 윤년을 구분하기 위해 조건문 설정

- showDate 메서드로 `isValid = true`와 `isValid = false`로 각 헤당하는 구문 출력 가능토록 구현

- Menu 클래스에 `public static final int STARLATTE = 4500;`에서 `static fianal`을 추가하니 오류가 정정됨

- `static final` => 클래스 내부 도는 외부에서 참조의 용도로만 선언된 변수는 이 같이 선언

<br>

- static, final, static final 정리

- `static` => 객체 생성 없이 사용할 수 있는 필드와 메소드를 생성하고자 할 때 활용

- `final`=> 해당 변수는 값이 저장되면 최종 값이 되므로, 수정이 불가능하다는 의미

- `static final`=> 모든 영역에서 고정된 값으로 사용되는 상수

<br>

## 🔖 Eclipse 실습

![day8](https://user-images.githubusercontent.com/79084294/182657244-9c971bf4-1265-418a-b2e7-92ccddb85eaf.png)

<br>

## 🔖 Eclipse 출력 Console

![day8_console1](https://user-images.githubusercontent.com/79084294/182657334-8b3cfeee-24c1-42a0-822c-41d3e369a861.png)

![day8_console2](https://user-images.githubusercontent.com/79084294/182657351-cfa818f1-7ce0-48e1-9a8b-8582b7f31155.png)

![day8_console3](https://user-images.githubusercontent.com/79084294/182657734-f39f5a4b-ecf9-4f93-9084-28c0ea509337.png)

![day8_console4](https://user-images.githubusercontent.com/79084294/182657380-bd88b53a-189e-45f3-9d2e-dc51c6d2718a.png)
