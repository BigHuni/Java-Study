# 📌 Java Study

## 🔸 2022-07-27 수요일

## [Java 기초]

### 1. 특징

- 객체 지향 프로그램으로 유지보수와 확장성 용이

- 안정적

- 풍부한 라이브러리 제공, 오픈소스 연동

<br>

### 2. 개발환경 구축

- 자바(Oracle)

- 이클립스(SE, JRE)

<br>

### 3. 이클립스 사용

- 프로젝트 생성 후 소스에 패키지 생성

- 패키지 = `소스의 묶음`, 대체로 패키지 명은 `소문자`

- 클래스 명은 `파스칼 케이스`, 멤버 변수와 메서드 명은 `카멜 케이스`

- main 함수는 로컬에서 실행해서 결과를 필요로 할 뿐, 서버 프로그램일 시 없을 수도 있음

<br>

- 출력 문법

```java
System.out.println("Hello, Java");
```

<br>

- bin 폴더 안에 실행 파일 생성됨
  (Huni_JAVA/First/bin/hello)

- Build Auto 설정 시 저장하면 클래스 파일에 반영됨

- 저장 후 Run(구동)하면 하단 Console에 출력 결과 확인

<br>

### 4. 자료 표현(변수)

- 비트 : 컴퓨터 자료 표현 최소 단위 0 또는 1

- 2진수, 8진수, 10진수, 16진수 표현 변환 및 표현 확인

- 음수 표현 : 2의 보수로 표현

- 2의 보수란, A값과 B값을 더했을 때 이 값이 2진수로 0

```
예시) 1의 보수 => 0이 주어지면 1, 1이 주어지면 0
00001010(2) = 10, 1의 보수는 11110101(2)
1의 보수에 1을 더하면 11110110(2) 즉, 2의 보수
00001010(2)와 11110110(을) 더하면 10 + (-10) = 0
```

<br>

- 정리하면, 2의 보수를 만드는 방법은 주어진 값에 1의 보수를 만든 후 그 값에 1을 더하는 것

- 변수 선언 시 변수에 맞는 자료형 사용

- 코드 작성 시 `int age` 에서 변수명 `age`에 `이클립스 노란색으로 표시되는 이유` = `자바 파일에서 해당 변수가 사용되지 않았음을 의미`

<br>

- age가 30이라는 의미가 아니라, 30이란 정수 값이 age 변수에 대입

```java
    int age;

    age = 30;
```

<br>

- 선언 동시에 값 대입도 가능

```java
    int age = 30;
    int count;

    count = 1;
```

<br>

- 변수 선언 => `해당 자료형의 크기 만큼 메모리를 사용하겠다는 것`

- 변수 명은 영문자나 숫자 사용, 단 숫자로 `시작 불가`
  (특수문자 : `_`, `$`만 사용 가능, 예약어 사용 불가, 쓰임에 맞는 이름으로 명명하는 것이 가독성에 좋음)

<br>

### 5. 자료형(정수)

- 기본형 : 자바 언어에서 기본으로 제공하는 자료형

- 메모리가 정해져 있음(정수형, 문자형, 실수형, 논리형)

<br>

- 참조형 : 클래스 자료형

- JDK에서 제공되는 클래스와 프로그래머가 정의하는 클래스

- 클래스에 따라 사용하는 크기가 다름(String, Student)

<br>

### <기본 자료형>

- 정수형

  byte(1byte) - short(2byte) - int(4byte) - long(8byte)

- 문자형 : char(2byte)

- 실수형 : float(4byte) - double(8byte)

- 논리형 : boolean(1byte)

<br>

- 32bit 경우, -2^31 ~ 2^31 -1 까지 표현 가능

- byte 크기 = 1, 수의 범위 : -2^7 ~ 2^7 -1

- short 크기 = 2, 수의 범위 : -2^15 ~ 2^15 -1

- int 크기 = 4, 수의 범위 : -2^31 ~ 2^31 -1

- long 크기 = 8, 수의 범위 : -2^63 ~ 2^63 -1

<br>

```java
    byte bs = 128;

    // 입력 시 오류(int 형 변환 요구)
```

```java
    long lVal = 12345678900;

    // 입력 시 range를 벗어나 오류 발생
    // 자바는 기본적으로 숫자는 4byte에 집어 넣는데,
    // 값이 너무 크니 8byte 처리하기 위해 값 뒤에 L대입

    long lVal = 12345678900L;
```

<br>

### 6. 자료형(문자)

- 내부적으로는 비트의 조합으로 표현

- 인코딩 : 각 문자에 따른 특정한 코드(숫자) 값 부여

- 디코딩 : 코드(숫자) 값을 원래의 문자로 변환

- 아스키(ASCII) : 1 byte로 영문자, 숫자, 특수문자 등을 표현

- 유니코드(Unicode) : 한글과 같은 복잡한 언어를 표현하기 위한 표준 인코딩 UTF-8, UTF-16 이 대표적

- 문자를 변수에 저장 => `문자에 해당하는 코드 값이 저장`

```java
    char ch = 'A';

	System.out.println(ch);  // A
	System.out.println((int)ch); // 65
```

```java
    int iCh = 66;

	System.out.println(iCh);  // 66
	System.out.println((char)iCh);  // B
```

```java
    char hangul = '\uAC00';
	System.out.println(hangul);  // 가
```

<br>

- 음수 값은 들어가지 못함(불가)

<br>

### 7. 자료형(실수, 논리)

- 실수는 double 자료형이 기본

- float 사용할 때는 f, F 식별자 사용

- 부동 소수점 방식 : 실수를 지수부와 가수부로 표현
  (지수와 가수로 표현되는 부동 소수점은 0을 표현하지 못함, 따라서 약간의 오차 발생)

- 논리 자료형 : boolean으로 선언

- 논리값 true(참), false(거짓) 표현

```java
    double dNum = 3.14;
	float fNum = 3.14F;  // 'F' 식별자 사용

	System.out.println(dNum);  // 3.14
	System.out.println(fNum);  // 3.14
```

<br>

- 부동 소수점의 오차 오류 예시

```java
    double dNum = 1;
		for(int i = 0; i < 10000; i++) {
			dNum = dNum + 0.1;
		}

    System.out.println(dNum);

    // 1001.000000000159
    // 1001 이 아니라 약간의 오차가 발생
```

<br>

- boolean 표현

```java
    boolean isMarried = false;

	System.out.println(isMarried); // false
```

<br>

- 자료형 없이 변수 사용하기(지역 변수에 대입되는 값을 보고 컴파일러가 추론)

```java
    var i = 10;

	System.out.println(i); // 10
```

<br>

### 8. 자료형(상수와 리터럴, 형 변환)

- 상수 : 변하지 않는 수

- 리터럴 : 프로그램에서 사용하는 모든 숫자, 값, 논리 값
  (10, 3.14, 'A', true)

- 모든 리터럴은 상수 풀(pool)에 저장되어 있음

- 상수 풀에 저장될 때 정수는 int, 실수는 double로 저장됨

<br>

- `형 변환` : 서로 다른 자료형의 값이 대입되는 경우 형 변환 발생

- `묵시적 형 변환` : 작은 수에서 큰 수로 덜 정밀한 수에서 더 정밀한 수로 대입 되는 경우

- `명시적 형 변환` : 변환되는 자료 형을 명시, 자료의 손실이 발생할 수 있음

```java
    double dNum;
	dNum = fNum + iNum;

    // 두 번의 형 변환 => iNum정수가 fNum실수로 형 변환(1)
    // fNum플롯이 double로 형 변환(2)
```

<br>

- `명시적 형 변환` 예시

- 단점 : `데이터 유실 발생 가능`

```java
    int i = 1000;
	byte bNum = (byte)i;

    System.out.println(bNum);  // -24
```

<br>

```java
    double dNum1 = 1.2;
	float fNum = 0.9F;

    int iNum1 = (int)dNum1 + (int)fNum;
	int iNum2 = (int)(dNum1 + fNum);

	System.out.println(iNum1);  // 1
	System.out.println(iNum2);  // 2
```

- (int)dNum1이 형 변환을 먼저 하는데 실수가 정수로 형 변환이 되면, 1.2 소수점 이하가 `TRUNCATE`

- 따라서, (int)dNum1 이 `1`, (int)fNum은 `0`이 됨

- (int)(dNum1 + fNum) 에서는 먼저 1.2와 0.9를 더해, 소수점이 빠진 `2`가 출력

- 2진수, 8진수, 16진수에서 10 표현

```java
    int num = 10;
	int bNum = 0B1010;
	int oNum = 012;
	int xNum = 0XA;

	System.out.println(num);   // 10
	System.out.println(bNum);  // 10
	System.out.println(oNum);  // 10
	System.out.println(xNum);  // 10
```

<br>

## 🔖 Eclipse 실습

![day1](https://user-images.githubusercontent.com/79084294/181397834-5796830d-02df-48ed-80d7-9caf606521ee.png)

---
