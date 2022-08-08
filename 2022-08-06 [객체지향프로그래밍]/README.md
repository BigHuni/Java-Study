# 📌 Java Study

## 🔸 2022-08-06 토요일

## [배열과 ArrayList]

### 1. 배열이란

<br>

- 동일한 자료형의 순차적 자료 구조

- 배열 선언하기

```java
    int[] arr = new int[10];
    int arr[] = new int[10];
```

- 메모리 구조 => `int`는 4바이트, 배열의 길이를 10으로 설정

- 0 번째 한 공간에 4바이트 식으로 배열의 길이가 10이므로 총 40바이트

- 인덱스 번호는 0부터 시작하여 0 ~ 9 의 범위를 갖음

- `연속된 자료구조`, 중간에 값이 비어있으면 안 됨

- 첨자 연산이 빠르다(인덱스 번호 활용으로 값 계산)

<br>

```java
    public class ArrayTest {

	public static void main(String[] args) {

		int[] arr = new int[10];
		int total = 0;

		for(int i=0, num=1; i < arr.length; i++, num++) {
			arr[i] = num;
		}

		for(int i=0; i < arr.length; i++) {
			total += arr[i];
			System.out.println(total);
		}

		System.out.println(total);
	}
```

- for 문 안에 조건식으로 숫자(i < 10)보단 배열의 길이 `arr.length`처럼 표현하는게 좋음

- `i <= 9`처럼 표현하지 않는 이유는 `i < 10`으로 하여금 배열의 길이를 짐작케 할 수 있음

<br>

```java
    double[] dArr = new double[5];

	int count = 0;

	dArr[0] = 1.1; count++;
	dArr[1] = 2.1; count++;
	dArr[2] = 3.1; count++;

	double mtotal = 1;
	for( int i = 0; i < count; i++) {
		mtotal *= dArr[i];
	}

	System.out.println(mtotal);
```

- 배열의 길이가 5개, 3개의 유효값이 있다면 나머지는 0.0 으로 초기화

- 따라서 for 문 조건식에 `i < dArr.length` 으로 설정하면 결과가 0으로 나오는 오류 발생

- 따라서 count 변수를 만들어 유효한 값에 대한 것만 곱 연산을 할 수 있도록 함

<br>

### 2. 배열 문제 : 문자 배열을 생성하고 출력

### 대문자를 A - Z 까지 배열에 저장하고 이를 다시 출력하는 프로그램 출력

<br>

```java
    char[] alphabets = new char[26];
		char ch = 'A';

		for(int i = 0; i < alphabets.length; i++) {

			alphabets[i] = ch++;
		}

		for(int i = 0; i < alphabets.length; i++) {
			System.out.println(alphabets[i] + "," + (int) alphabets[i] );
		}
```

- 알파벳 A 부터 Z 까지 출력, 26 문자열 배열 공간 생성

- 출력은 각 26 개의 알파벳과, 각 해당 문자 아스키 코드와 같이 출력

<br>

## 🔖 Eclipse 실습

![day11](https://user-images.githubusercontent.com/79084294/183284410-26bc20c3-040f-4466-94f9-e16029637476.png)

<br>

## 🔖 Eclipse 출력 Console

![day11_console1](https://user-images.githubusercontent.com/79084294/183284413-87918fe9-3e6a-4053-b497-32905c303733.png)

![day11_console2](https://user-images.githubusercontent.com/79084294/183284416-2d0d3bec-e27f-4db5-8803-f4cf4117da25.png)
