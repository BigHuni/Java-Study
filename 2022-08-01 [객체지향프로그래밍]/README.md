# 📌 Java Study

## 🔸 2022-08-01 월요일

## [클래스와 객체]

### 1. 생성자(Constructor)

- 객체를 생성할 때 `new` 키워드와 함께 호출(객체 생성 외에는 호출할 수 없음)

- 인스턴스를 초기화 하는 코드가 구현됨(주로 멤버 변수 초기화)

- 반환 값이 없음, 상속되지 않음

- 생성자는 클래스 이름과 동일

<br>

- 기본 생성자 : 하나의 클래스에느 반드시 하나 이상의 생성자가 존재해야 함

- 프로그래머가 생성자를 구현하지 않으면 컴파일러가 생성자 코드 넣어줌

- 매개 변수가 없고 구현부가 없음

- 만약, 클래스가 다른 생성자가 있는 경우 디폴트 생성자는 제공되지 않음(디폴트 생성자 => 매개 변수, 구현부가 없는 생성자)

<br>

- 생성자 구현 예제(`public` 자리에 다른 것이 오거나 없을 수 있음)

```java
    public Student(int id, String name) {
        studentID = id;
        studentName = name;
    }
```

- 두 개의 매개 변수를 받는데, 첫번째 매개 변수는 `studentID`에 초기화

- 두번째 매개 변수는 `studentName`에 초기화

- 이렇게 작성하면 Test 즉, main 함수가 있는 곳의 생성자 함수가 있기 때문에 오류 발생

- 이를 해결하는 방법은 2가지, 1.디폴트 생성자를 직접 작성

- 위 생성자 있는 코드 자리 위에 디폴트 생성자 작성 `public Student() {}`

- 2.Test 클래스 쪽에 `Student studentHeo = new student();`

<br>

- 오버 로딩 : 메서드(생성자 등)를 여러 개 삽입할 수 있다.

- 같은 이름의 메서드에 다른 매개 변수

- 생성자 오버로딩 : 생성자를 두 개 이상 구현하는 경우

- 사용하는 코드에서 여러 생성자 중 선택하여 사용할 수 있음

- private 변수도 생성자를 이용하여 초기화 할 수 있음

- private : 해당 클래스 내부에서만 사용할 수 있는 변수, 외부 클래스 참조 불가능

<br>

### 2. 참조 자료형

- 변수의 자료형
  - 기본 자료형 : int, long, float, double 등
  - 참조 자료형 : String, Date, Student 등

<br>

- 클래스형으로 변수를 선언함

```
    String name;
```

<br>

- 기본 자료형은 사용하는 메모리가 정해져 있지만, 참조 자료형은 클래스에 따라 다름

- 참조 자료형 직접 만들어서 사용하기
  - 학생 클래스(Student)에 있는 과목 이름, 과목 성적 속성을 과목 클래스(Subject)로 분리
  - Subject 참조 자료형 멤버 변수를 Student에 정의하여 사용함

<br>

```java
    public Student() {
		korea = new Subject();
		math = new Subject();
	}
```

- 참조 자료형 타입으로 변수 선언 후에 생성자에서 초기화 하면, 그 안에 korea와 math가 생성

<br>

### 3. 해당 Eclipse 실습정리

<br>

- 원래 Student에 여러 속성이 있었는데, 그 속성들은 개별적인 객체가 될 수 있다.

- 그 개별적인 객체를 뽑아서 클래스로 생성한다.(Subject 클래스)

- 다시 Student 클래스에다가는 참조 자료형 선언하기
  (`Student korea;`, `Student math;`)

- 생성자 함수 생성

```java
    public Student(int id, String name) {

		studentID = id;
		studentName = name;

		korea = new Subject();
		math = new Subject();
	}
```

- 생성자 함수를 생성하지 않고 값을 넣지 않게 되면, Null 값이 들어가 오류 발생

<br>

## 🔖 Eclipse 실습

![day6](https://user-images.githubusercontent.com/79084294/182210167-f521a736-512c-41dd-abda-18717581ccd3.png)

<br>

## 🔖 Eclipse 출력 Console

![day6_console](https://user-images.githubusercontent.com/79084294/182210424-1576b224-e3ba-4abc-bd71-48603381f7c9.png)
