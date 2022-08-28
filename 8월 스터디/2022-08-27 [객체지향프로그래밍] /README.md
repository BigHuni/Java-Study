# 📌 Java Study

## 🔸 2022-08-27 토요일

## [Object 클래스]

### 1. Object 클래스

- 모든 클래스의 최상위 클래스
- java.lang.Object 클래스
- 모든 클래스는 Object 클래스에서 상속 받음
- 모든 클래스는 Object 클래스의 메서드를 사용할 수 있음
- 모든 클래스는 Object 클래스의 일부 메서드를 재정하여 사용할 수 있음
    - `final`로 정의된 메서드 같은 경우, 하위 클래스에서 재정의할 수 없기 때문 이외 다른 메서드 같은 경우에 재정의하여 사용할 수 있음

<br>

- 자바가 설치된 폴더로 들어가 jdk를 보면, lib(라이브러리) 폴더에 src.zip이 있음
- 이 압축파일을 풀면 자바관련 소스 등을 볼 수 있음
- java.base - java - lang 패키지 안에 기본적으로 많이 사용하는 자바파일 등이 있음
- java.lang은 import 하지 않아도 자바 컴파일러가 자동으로 import 해주기 때문

<br>

- ToStringTest 클래스

```java
    package object;

class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class ToStringTest {

    public static void main(String[] args) {

        Book book = new Book("토지", "박경리");
        System.out.println(book);

        String str = new String("토지");
        System.out.println(str);  // System.out.println(str.toString());
    }

}
```

<br>

- 출력

```
    object.Book@fad74ee
    토지
```

- `Book book = new Book("토지", "박경리");`의 출력은 메모리 주소
- `String str = new String("토지");`의 출력은 토지가 출력됨
- 이유는 String 클래스는 jdk 클래스이므로 이 클래스 안에 `toString`이라는 메서드가 이미 정의되어 있음
- toString() 메서드는 어떤 객체의 정보를 string 형태로 정보를 표현하려고 할 때, 호출되는 메서드
- toString() 메서드는 Object의 메서드로 Object 메서드를 재정의해서 String 클래스 안에 가지고 있는 character의 배열을 출력
- 만약, Book을 메모리 주소가 아닌 위에 정의된 title과 author로 표현하고 싶다면 toString을 재정의 하면 됨
    - Source - override - toString 체크
- 정리 : Object 클래스가 모든 클래스의 최상위 클래스(Super Class)

## 🔖 Eclipse 실습

![day28_console1](https://user-images.githubusercontent.com/79084294/187075802-225953b5-56c0-44f1-ab62-747bcec700c6.png)

<br>

## 🔖 Eclipse 출력 Console

![day28](https://user-images.githubusercontent.com/79084294/187075803-8a839ead-827e-4541-a9a9-d203fcf34206.png)
