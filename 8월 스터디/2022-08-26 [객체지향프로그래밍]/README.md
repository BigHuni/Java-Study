# 📌 Java Study

## 🔸 2022-08-26 금요일

## [인터페이스 응용 문제풀이]

### 1. 인터페이스 응용 문제풀이

- 정렬 알고리즘 구현하기
- Sort(ascending(int[]), descending(int[]), description()) 3개의 메서드 구현
- 하위로 QuickSort, HeaSort, BubbleSort 3개의 종류 구현

<br>

- Sort 클래스

```java
    package sorting;

public interface Sort {

    void ascending(int[] arr);

    void descending(int[] arr);

    default void description() {
        System.out.println("숫자를 정렬하는 알고리즘 입니다.");
    }
}
```

- 먼저, 상속할 인터페이스 Sort 구현
- 매개변수로 정렬할 배열을 받음(ascending, descending)
- default 메서드 description 구현

<br>

- BubbleSort 클래스

```java
    package sorting;

public class BubbleSort implements Sort {

    @Override
    public void ascending(int[] arr) {
        System.out.println("BubbleSort ascending");
    }

    @Override
    public void descending(int[] arr) {
        System.out.println("BubbleSort descending");
    }

    @Override
    public void description() {
        Sort.super.description();
        System.out.println("BubbleSort 입니다.");
    }
}
```

- 상위 인터페이스 Sort를 상속받음
- Sort의 ascending, descending, description 3개 Override
- 위 코드 구성 형식으로 BubbleSort, HeapSort, QuickSort 구현

<br>

- SortTest(main) 클래스

```java
    package sorting;

import java.io.IOException;

public class SortTest {

    public static void main(String[] args) throws IOException {

        System.out.println("정렬방식을 선택하세요.");
        System.out.println("B : BubbleSort ");
        System.out.println("H : HeapSort ");
        System.out.println("Q : QuickSort ");

        int ch = System.in.read();
        Sort sort = null;

        if (ch == 'B' || ch == 'b') {
            sort = new BubbleSort();
        } else if (ch == 'H' || ch == 'h') {
            sort = new HeapSort();
        } else if (ch == 'Q' || ch == 'q') {
            sort = new QuickSort();
        } else {
            System.out.println("지원되지 않는 기능입니다.");
            return;
        }

        int[] arr = new int[10];
        sort.ascending(arr);
        sort.descending(arr);
        sort.description();
    }
}
```

- throw 예외 처리 방법으로 if ~else 문을 통해 코드를 실행 시키고, 조건에 맞는 예외 발생 시 해당 조건식으로 처리
- 기본적으로 자바가 아스키코드 값이 입력되기 때문에 int 타입으로 받음
- `System.in.read()` => 숫자 하나를 입력받아 그대로 출력
- 사용자가 입력 시 대소문자 오류 발생하지 않도록 구분 조건문 포함
- 해당 조건식에 포함되지 않을 시 지원되지 않는 기능 명시
- `int[] arr = new int[10];` => 배열 선언과 동시에 생성

<br>

## 🔖 Eclipse 실습

![day27](https://user-images.githubusercontent.com/79084294/187034664-c6e2d82c-e0fd-4907-b692-1e4af9c2af3c.png)

<br>

## 🔖 Eclipse 출력 Console

![day27_console1](https://user-images.githubusercontent.com/79084294/187034668-a64772ca-6490-474a-b4be-e87f20ed945c.png)

![day27_console2](https://user-images.githubusercontent.com/79084294/187034669-a5f34ce3-ecbf-4a6e-9d79-11fda0838d23.png)

![day27_console3](https://user-images.githubusercontent.com/79084294/187034670-b001524c-f8c1-4a53-9650-d97182655e36.png)
