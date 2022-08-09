# 📌 Java Study

## 🔸 2022-08-08 월요일

## [배열과 ArrayList]

### 1. 다차원 배열

- 2차원 이상의 배열

- 지도, 게임, 평면이나 공간을 구현할 때 사용

- `int [][] arr = new int [2][3]`

  - int : 자료형
  - arr : 배열 이름
  - [2] : 행 개수
  - [3] : 열 개수

<br>

```java
    int [][] arr = {{1, 2, 3}, {4, 5, 6}};

	System.out.println(arr.length);		    // 2
	System.out.println(arr[0].length);      // 3
	System.out.println(arr[1].length);      // 3
```

<br>

```java
    int [][] arr = {{1, 2, 3}, {4, 5, 6}};

	for(int i = 0; i < arr.length; i++) {
		for(int j = 0; j < arr[i].length; j++) {
			System.out.print(arr[i][j] + " ");
		}

		System.out.println();
```

```java
    1 2 3
    4 5 6
```

<br>

- 2차원 배열을 이용할 때, for 문 중첩으로 사용하는 경우가 많음

- 3차원은 for 문이 3개(면 - 행 - 열)

- 가장 바깥이 가장 큰 공간을 의미

<br>

### 2. ArrayList 클래스

- 자바에서 제공되는 객체 배열이 구현된 클래스

- 객체 배열을 사용하는데 필요한 여러 메서드들이 구현되어 있음

- 주요 메서드

| 메서드               | 설명                                                            |
| :------------------- | :-------------------------------------------------------------- |
| `boolean add(E e)`   | 요소 하나를 배열에 추가합니다. E는 요소의 자료형을 의미합니다.  |
| `int size()`         | 배열에 추가된 요소 전체 개수를 반환합니다.                      |
| `E get(int index)`   | 배열의 index 위치에 있는 요소 값을 반환합니다.                  |
| `E remove(int index` | 배열의 index 위치에 있는 요소 값을 제거하고 그 값을 반환합니다. |
| `boolean isEmpty()`  | 배열이 비어 있는지 확인합니다.                                  |

<br>

```java
    ArrayList<String> list = new ArrayList<String>();
```

- `<String>`에 어떠한 클래스를 배열의 요소로 사용할 지 지정

<br>

```java
    ArrayList<String> list = new ArrayList<String>();

    list.add("aaa");
	list.add("bbb");
	list.add("ccc");

	for(int i = 0; i < list.size(); i++) {
		String str = list.get(i);
		System.out.println(str);
	}

	for( String s : list) {
		System.out.println(s);
	}
```

<br>

```java
    ArrayList list = new ArrayList();
```

- 무엇을 쓸 것인지 정해야됨, for 문에 오류 발생

```java
    ArrayList list = new ArrayList();

    list.add("aaa");
	list.add("bbb");
	list.add("ccc");

	for(int i = 0; i < list.size(); i++) {
		String str = (String)list.get(i);
		System.out.println(str);
	}

	for( Object s : list) {
		System.out.println(s);
	}
```

- ArrayList의 생성자에서 String을 지정하지 않으면 오류 발생

- `String str = (String)list.get(i);` => String 타입 적어줘야함

- `for( Object s : list)` => 반환이 object로 되는데, object는 모든 클래스의 최상위 클래스이자, String을 지정하지 않으면 object 형태로 들어감

- 따라서, ArrayList 사용 시 어떤 타입의 객체로 배열을 만들 것인지 지정하는 것이 바람직

<br>

### 3. 학생의 수강과목 학점 출력하기

- Heo 학생은 두 과목을 수강하고, Kim 학생은 세 과목을 수강합니다. 각 학생의 학점과 총점을 다음과 같이 출력해봅시다. Student 클래스에 ArrayList 멤버변수를 하나 가지고 각 학생이 수강하는 과목을 관리하도록 합니다.

<br>

- 과목이 되는 `Subject`클래스를 만들고, `Student` 클래스 내에 `subjectList`를 배열로 유지, Subject가 추가 될 수 있도록 addSubject 메서드 제공

- 전체 정보를 볼 수 있는 showStudentInfo() 제공

<br>

```java
	Student studentHeo = new Student(1001, "Heo");

	studentHeo.addSubject("국어", 100);
	studentHeo.addSubject("수학", 100);

	Student studentKim = new Student(1002, "Kim");

	studentKim.addSubject("국어", 95);
	studentKim.addSubject("수학", 90);
	studentKim.addSubject("영어", 80);

	studentHeo.showStudentInfo();
	System.out.println("=================================");
	studentKim.showStudentInfo();
```

<br>

## 🔖 Eclipse 실습

![day13](https://user-images.githubusercontent.com/79084294/183613243-d2a14a90-390e-4db9-bb48-4f500f0232f3.png)

<br>

## 🔖 Eclipse 출력 Console

![day13_console1](https://user-images.githubusercontent.com/79084294/183613259-25d24557-0298-4df7-a600-738618bafd8e.png)

![day13_console2](https://user-images.githubusercontent.com/79084294/183613297-03259e22-7a66-4385-80e0-fa064513d6e6.png)

![day13_console3](https://user-images.githubusercontent.com/79084294/183613303-48e5a647-e8b0-4f76-9983-4ed4903c0935.png)
