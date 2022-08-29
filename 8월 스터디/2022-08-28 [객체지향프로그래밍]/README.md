# 📌 Java Study

## 🔸 2022-08-28 일요일

## [Object 클래스]

### 1. toString() 메서드의 원형

```
    getClass( ).getName( ) + '@' + Integer.toHexString(hashCode( ))
```

- 객체의 정보를 String으로 바꾸어 사용할 때 유용함
- 자바 클래스 중에는 이미 정의된 클래스가 많음(예 : String, Integer, Calendar 등)
- 많은 클래스에서 재정의하여 사용

<br>

### 2. equals() 메서드

- 두 객체의 동일함을 논리적으로 재정의 할 수 있음
- 물리적 동일함 : 같은 주소를 가지는 객체(같은 메모리)
- 논리적 동일함 : 같은 학번의 학생, 같은 주문 번호의 주문
- 물리적으로 다른 메모리에 위차한 객체라도 논리적으로 동일함을 구현하기 위해 사용하는 메서드

<br>

```java
    public class EqualsTest {

    public static void main(String[] args) {

        String str1 = new String("abc");
        String str2 = new String("abc");

        System.out.println(str1 == str2);       // false
        System.out.println(str1.equals(str2));  // true
    }

}
```

- `str1 == str2`는 서로 다른 메모리 주소를 갖기 때문에 `false`
- `str1.equals(str2)`는 String의 경우 문자열이 같으면 같다고 재정의하여 `true` 반환

<br>

```java
    public class EqualsTest {

    public static void main(String[] args) {

        Student Lee = new Student(100, "이순신");
        Student Lee2 = Lee;
        Student Shin = new Student(100, "이순신");

        System.out.println(Lee == Shin);       // false
        System.out.println(Lee.equals(Shin));  // false
    }

}
```

- equals의 결과로 `false`를 `true`로 바꾸고 싶다면 재정의
- ``` 
  @Override
  public boolean equals(Object obj) {} ```
- Lee와 Shin이 equals의 Object 매개변수로 넘어감
- Object로 넘어가면 업 캐스팅(자동 형 변환)
- 이를 다시 다운 캐스팅 해야함

<br>

### 3. hashCode() 메서드

- hashCode() 메서드의 반환 값 : 인스턴스가 저장된 가상머신의 주소를 10진수로 반환
- 두 개의 서로 다른 메모리에 위치한 인스턴스가 동일하다는 것
    - 논리적으로 동일 : equals()의 반환값이 true
    - 동일한 hashCode 값을 가짐 : hashCode()의 반환 값이 동일

<br>

## 🔖 Eclipse 실습

![day29](https://user-images.githubusercontent.com/79084294/187220263-a4f3f44d-084d-4476-bfdb-ab51e698d5f4.png)

<br>

## 🔖 Eclipse 출력 Console

![day29_console1](https://user-images.githubusercontent.com/79084294/187220272-d8c6f0c9-c917-4fc7-8fef-50a146114153.png)
