# 📌 Java Study

## 🔸 2022-07-31 일요일

## [자바의 정석 이론보충 및 정리]

### 1. 환경 설정

- Content Assist(자동 완성)
  - Eclise - Preferences - General - Keys - Content Assist - key 설정(Command + Space)
  - Eclise - Preferences - Java - Editor - content Assist - Auto Activation 설정
  - Eclise - Preferences - Java - Editor - content Assist - Templates - syso 추가(`System.out.println("${cursor}");`)

<br>

- Comment(주석)
  - 범위 주석 : `/* Code */`, (Key => `ctrl` + `Command` + `/`)
  - 한 줄 주석 : `//`, (Key => `Command` + `/`)

<br>

- Main 함수
  - 반드시 모든 클래스 파일에 Main 함수가 존재하지 않아도 됨
  - 각 클래스 파일을 생성한 후 실행할 메인 함수(출력)가 있는 파일 하나에서 불러올 수 있음

<br>

### 2. 변수

- `변수` : `하나의 값을 저장할 수 있는 저장공간`

```
    int x;
```

<br>

- 변수 타입
  - 숫자 : int[정수], long[정수] - 20억 넘을 때, float[실수] - 오차없이 7자리, double[실수] - 15자리
  - 문자 : char[문자], String[문자열, string]

<br>

### 3. 상수와 리터럴

- `상수` : 값을 저장할 수 있는 공간(변수) + 한 번 값 저장하면 다른 값으로 변경 불가
  - 대문자로 하는 것이 관례
  - 여러 단어 이어질 시 `_(언더바)`로 구분

<br>

- `리터럴` : `상수`의 다른 이름

<br>

- 정리(변수, 상수, 리터럴)

| 용어              | 설명                             |
| :---------------- | :------------------------------- |
| `변수(variable)`  | 하나의 값을 저장하기 위한 공간   |
| `상수(constant)`  | 값을 한 번만 저장할 수 있는 공간 |
| `리터럴(literal)` | 그 자체로 값을 의미하는 것       |

<br>

- 두 변수 값 바꾸기 예제

```java
    class tmp {
        public static void main(String args[]) {
            int x = 10, y = 5;
            System.out.println("x= " + x);
            System.out.println("y= " + y);

            int tmp = x;
            x = y;
            y = tmp;
            System.out.println("x= " + x);
            System.out.println("y= " + y);
        }
    }
```

<br>

### 4. 기본형과 참조형

- `기본형` : 논리형(boolean), 문자형(char), 정수형(byte, short, int, long), 실수형(float, double) => 계산을 위한 실제 값을 저장한다.(8개)

- `참조형` : 객체의 주소를 저장한다. 8개의 기본형을 제외한 나머지 타입

- 자료형과 타입의 차이 : 기본형은 저장할 값(data)에 따라 구분되므로 기본형의 종류를 예기할 때 보통 `자료형`, 참조형은 항상 `객체의 주소(4 byte 정수)`를 저장하므로 값(data)이 아닌 객체의 종류에 의해 구분되므로 참조형 변수의 종류 구분할 때는 `타입(type)`

<br>

### 5. 출력

- `%d` : 10진 정수 출력
- `%x` : 16진 정수 출력
- `%f` : 부동 소수점 출력
- `%c` : 문자 출력
- `%s` : 문자열 출력

<br>

### 6. 화면으로부터 입력받기

- `import java.util.Scanner;` 추가
- `Scanner scaner = new Scanner(System.in);` 객체 생성
- nextLine() 메서드를 호출하면, 입력대기 상태에 있다가 입력을 마치고 엔터키를 누르면 입력한 내용이 문자열로 반환
- `String input = scanner.nextLine();`
- `int num = Integer.parseInt(input);`
