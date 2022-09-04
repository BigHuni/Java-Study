# 📌 Java Study

## 🔸 2022-09-03 토요일

## [객체지향프로그래밍]

### 1. Object 클래스

- 여러 객체들에 대한 `equals()`와 `hashcode()` 메서드 구현 시
- 먼저 작성한 `equals()`의 멤버를 활용하기
- 단, 멤버가 여러 개 있을 경우 재정의 해야 하는 경우도 있음
- `equals()` => 두 개의 객체가 같다고 했을 때, 두 개의 객체가 반환하는 hashCode 값도 동일하게끔 오버라이딩 함

````
    Integer i1 = new Integer(100);
    Integer i2 = new Integer(100);

    System.out.println(i1.equals(i2));
    System.out.println(i1.hashCode());
    System.out.println(i2.hashCode());
````

<br>

- 실제 hashCode 값의 메모리 주소 알기
- `System.out.println(System.identityHashCode(i1));`
- `System.out.println(System.identityHashCode(i2));`

<br>

- clone() 메서드
    - 객체의 복사본을 만듦
    - 기본 틀(prototype)으로부터 같은 속성 값을 가진 객체의 복사본을 생성할 수 있음
    - 객체지향프로그래밍의 정보은닉에 위배되는 가능성이 있으므로 복제할 객체는 `cloneable` 인터페이스를 명시해야 함
    - 오버라이딩으로 clone 메서드를 선택하면, 메모리 복제로 인스터스의 값을 그대로 복제

```
    @Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
```

<br>

- `Book book2 = (Book)book.clone();`
- clone() 메서드의 원형이 object로 반환
- `(Book)`으로 명시적으로 캐스팅
- 이 때, exception 발생
- 해당 클래스가 clone() 메서드를 사용하려면, `class Book implements Cloneable` 처럼 명시해야 함

<br>

## 🔖 Eclipse 실습

![day30](https://user-images.githubusercontent.com/79084294/188318544-b1a86d09-f9d7-4953-b4f4-35f1e0a85a15.png)

<br>

## 🔖 Eclipse 출력 Console

![day30_console1](https://user-images.githubusercontent.com/79084294/188318546-682e1ca9-e702-4d51-a564-b65bb8eaaf50.png)
