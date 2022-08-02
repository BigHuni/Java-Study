# 📌 Java Study

## 🔸 2022-08-02 화요일

## [클래스와 객체]

### 1. 정보 은닉

- 접근 제어자(access modifier)
  - 변수, 메서드, 생성자에 대한 접근 권한 지정
  - 1.public, 2.private, 3.protected, 4.아무것도 안 쓰는 경우(기본 접근 제어자)
  - private 사용하면 클래스 외부에서 접근할 수 없음

<br>

- 정보 은닉(Information Hiding)
  - 외부에서 클래스 내부의 정보에 접근하지 못하도록 함
  - private 키워드 활용
  - private 변수를 외부에서 접근하게 하려면 public 메서드 제공함
  - 클래스 내부 데이터를 잘못 사용하는 오류를 방지

<br>

```java
  public calss MyDaye {

    private int day;

    public void setDay(int day) {
      this.day = day;
    }
  }
```

- `int day` => 매개 변수
- `this.day` => day = 멤버 변수
- 멤버 변수를 가리키려면 앞에 `this` 키워드 붙이기
- 넘어오는 변수는 `= day`
- this 생략 주의! this가 없다면 가장 가까운 로컬 day를 대입하게 됨

<br>

- 1.public 으로 class를 오픈한 것과 2. private 로 닫아 놓고, public 메서드를 제공하는 것의 차이점

  - get 메서드는 가능, set 메서드를 사용하지 못할 경우 존재 => 변하지 않아야 할 id 등(READ ONLY)

  - 위 방법 2가지가 정보 은닉이자, 오류를 방지

  - 모든 변수를 private로 하는 것은 아님

  - get, set 메서드도 천편일률적으로 사용하는 것은 아님

<br>

## 🔖 Eclipse 실습

![day7](https://user-images.githubusercontent.com/79084294/182443689-a46a68f0-d7f9-4237-9948-ceee07a9248f.png)

<br>

## 🔖 Eclipse 출력 Console

![day7_console](https://user-images.githubusercontent.com/79084294/182443760-69702ddc-68af-4f99-b672-2d69cb01279d.png)
