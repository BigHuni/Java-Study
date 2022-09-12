## 🔸 2022-09-12 월요일

## [객체지향프로그래밍]

### 1. Object 클래스 응용

- 날짜를 구현한 클래스 MyDate
- 날짜가 같으면 equals() 메서드의 결과가 true가 되도록 구현하기
- hashCode() 메서드도 구현

<br>

- MyDate 클래스

````java
    package object;

public class MyDate {

    int day;
    int month;
    int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
````

<br>

- MyDateTest 클래스

```java
    package object;

public class MyDateTest {

    public static void main(String[] args) {

        MyDate date1 = new MyDate(12, 9, 2022);
        MyDate date2 = new MyDate(12, 9, 2022);

        System.out.println(date1.equals(date2));
    }
}
```

- 결과는 `false`
- 아무것도 오버라이딩을 하지 않았기 때문
- equals()와 hashCode() 작성

<br>

- `@Override` 추가
- equals() 정의 => if 조건문으로 true 값 설정
- hashCode() 정의

```java
    @Override
public boolean equals(Object obj){
        if(obj instanceof MyDate){
        MyDate date=(MyDate)obj;

        if(this.day==date.day&&this.month==this.month&&this.year==this.year)
        return true;

        return false;
        }

        return false;
        }
```

```java
    @Override
public int hashCode(){
        return day*11+month*101+year*1001;
        }
```

<br>

## 🔖 Eclipse 실습

![object_list](https://user-images.githubusercontent.com/79084294/189676029-90d77149-a33a-4a16-9940-56c83dbe1a7c.png)

<br>

## 🔖 Eclipse 출력 Console

![object_console1](https://user-images.githubusercontent.com/79084294/189676036-a48b41d1-0acf-4452-aaf8-9cf5965d3e92.png)
