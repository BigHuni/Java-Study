# 📌 Java Study

## 🔸 2022-07-29 금요일

## [객체지향 프로그래밍과 클래스]

### 1. 객체

- 객체(Object)
  - 의사나 행위가 미치는 대상(사전적 의미)
  - 구체적, 추상적 데이터의 단위
  - 사람, 자동차, 주문, 생산, 관리

<br>

- 객체지향 프로그래밍(Object Orientd Programming : OOP)
  - 객체를 기반으로 하는 프로그래밍
  - 객체를 정의하고, 객체의 기능을 구현하며 객체 간의 협력(Cooperation)을 구현

<br>

- 절차지향 프로그래밍(Procedural Programming)
  - 시간이나 사건의 흐름에 따른 구현
  - C 언어

<br>

- 클래스(Class)
  - 객체를 코드로 구현한 것
  - 객체지향 프로그래밍의 가장 기본 요소
  - 객체의 청사진(BluePrint)

<br>

- 멤버 변수
  - 객체가 가지는 속성을 변수로 표현
  - 클래스의 멤버변수
  - member variable, property, attribute

<br>

- 메서드
  - 객체의 기능을 구현
  - method, member function

<br>

- 클래스 파일 안에 또 다른 클래스가 들어갈 수 있지만, public 클래스는 하나만 해당되어야 함

- public 키워드를 가진 클래스 명은 클래스 파일 명과 동일해야 함

- 클래스의 속성 즉, 멤버 변수 예시

```java
    public class Student {

	int studentID;
	String studentName;
	String address;
}
```

<br>

- 기능은 메서드로 구현

```java
    public void showStudentInfo() {
		System.out.println(studentName + "," + address);
	}
```

<br>

- 값을 직접 대입하여 사용하려면 객체를 생성해서 사용해야 함
  - 1. `public static void main` 함수 사용
  - 2. 클래스 파일을 따로 생성하여 활용
    - 이유 : 객체를 다른 클래스에서 사용되는 경우가 많기 때문에 main 들어가있는 클래스를 따로 생성하여 활용

<br>

- 클래스를 생성 후 그 클래스를 가져다 쓰는 예제

```java
    public class Student {

	public int studentID;
	public String studentName;
	public String address;

	public void showStudentInfo() {
		System.out.println(studentName + "," + address);
	}
}
```

```java
    public class StudentTest {

	public static void main(String[] args) {

		Student studentHeo = new Student();
		studentHeo.studentName = "허준";
		studentHeo.address = "용인";

		studentHeo.showStudentInfo();
	}

}
```

<br>

- 클래스 생성하기 : new 키워드를 사용하여 생성자로 생성

```
    Student studentHeo = new Student();
```

<br>

- 클래스의 속성, 메서드 참조하기 : 생성에 사용한 변수(참조변수)로 클래스의 속성, 메서드 참조

```
    studentHeo.studentName = "Heo";
    StudentHeo.showStudentInfo();
```

<br>

- public 클래스 : 자바 파일 하나에 여러 개의 클래스가 존재할 수도 있음
  (단, public 클래스는 하나, public 클래스와 자바 파일 명은 동일해야 함)

<br>

- 함수(function)

  - 하나의 기능을 수행하는 일련의 코드
  - 함수는 호출하여 사용하고, 기능이 수행된 후 값을 반환할 수 있음
  - 함수로 구현된 기능은 여러 곳에서 호출되어 사용될 수 있음

<br>

- 함수 정의 : 이름, 매개변수, 반환 값, 함수 몸체(body)로 구성

```java
    int add(int num1, int num2)
    {
        int result;
        result = num1 + num2;
        return result;
    }
```

<br>

- 메서드(method)
  - 객체의 기능을 구현하기 위해 클래스 내부에 구현되는 함수
  - 메서드를 구현함으로써 객체의 기능이 구현됨
  - 메서드의 이름은 사용하는 쪽에 맞게 명명하는 것이 좋음
  - 예시) `getStudentName()`, 카멜 케이스 명명

<br>

- `Stack 메모리`의 특징 : `함수의 호출이 끝나면 자동으로 메모리가 반환`

<br>

- 인스턴스 : 클래스로부터 생성된 객체
  - 힙 메모리에 멤버 변수의 크기에 따라 메모리가 생성
  - 클래스를 기반으로 new 키워드를 이용하여 여러 개의 인스턴스를 생성

<br>

- 어떠한 변수 이름으로 객체를 생성 시 Heap 메모리에 객체가 생성
- new 생성자로 생성하면 Heap 메모리를 가리키고, 이것이 `인스턴스`
- 지역 변수는 함수가 끝나면 소멸 = Stack 메모리가 소멸
- Heap은 가비지 콜렉터(사용하지 않는 메모리 수거)가 소멸

<br>

- 각각 `참조변수`인 `studentHeo, studentKim`을 출력해보면
  - `classpart.Student` 처럼 패키지를 포함한 이름이 클래스 풀 네임
  - @ 뒤의 주소(address)가 Heap 상의 메모리 주소를 가리킴
  - 실제 값은 아니고, JVM이 준 해시값 = `참조값`

```java
    public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student studentHeo = new Student();
		studentHeo.studentName = "허준";
		studentHeo.address = "용인";

		studentHeo.showStudentInfo();

		Student studentKim = new Student();
		studentKim.studentName = "김유신";
		studentKim.address = "경주";

		studentKim.showStudentInfo();

		System.out.println(studentHeo);    // classpart.Student@1a1d6a08
		System.out.println(studentKim);    // classpart.Student@37d31475
	}

}
```

<br>

- 용어 정리

| 용어        | 설명                                         |
| :---------- | :------------------------------------------- |
| `객체`      | 객체지향 프로그램의 대상, 생성된 인스턴스    |
| `클래스`    | 객체를 프로그래밍 하기 위해 코드로 만든 상태 |
| `인스턴스`  | 클래스가 메모리에 생성된 상태                |
| `멤버 변수` | 클래스의 속성, 특성                          |
| `메서드`    | 멤버 변수를 이용하여 클래스의 기능을 구현    |
| `참조 변수` | 메모리에 생성된 인스턴스를 가리키는 변수     |
| `참조 값`   | 생성된 인스턴스의 메모리 주소 값             |

<br>

## 🔖 Eclipse 실습

![day3](https://user-images.githubusercontent.com/79084294/181801872-48f002ae-de04-4347-9cd3-0c3a13f14e5a.png)
