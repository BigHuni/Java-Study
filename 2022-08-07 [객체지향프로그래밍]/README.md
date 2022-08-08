# 📌 Java Study

## 🔸 2022-08-07 일요일

## [배열과 ArrayList]

### 1. 객체 배열

<br>

```java
    Book[] library = new Book[5];
```

- 책 5개가 생기는 것은 아님, 배열이 5개가 생기는 것

- 책 5개를 생성하려면 각각 new 생성자 활용

<br>

- 위 코드 식으로 각각 책을 생성

```java
    library[0] = new Book("태백산맥1", "조정래");
	library[1] = new Book("태백산맥2", "조정래");
	library[2] = new Book("태백산맥3", "조정래");
	library[3] = new Book("태백산맥4", "조정래");
	library[4] = new Book("태백산맥5", "조정래");
```

<br>

- 주소가 출력됨

- `@` 이전이 클래스의 풀 네임이고, 뒤 값이 인스턴스의 주소 값

- 하나의 자리가 4바이트씩이므로, 32bit Address 값

- 객체 배열 사용 시 주의해야할 점

  - `Book[] library = new Book[5];` => 완전히 배열이 생성된 것이 아님

  - 각 인스턴스를 생성해서 각 요소에 값을 할당해야 함

  - 안하면 각각 null 값이 들어감

<br>

```
    array.Book@fad74ee
    array.Book@37d31475
    array.Book@27808f31
    array.Book@436e852b
    array.Book@32d2fa64
```

<br>

### 2. 객체 복사

```java
    int[] arr1 = {10, 20, 30, 40, 50};
	int[] arr2 = {1, 2, 3, 4, 5};

	System.arraycopy(arr1, 0, arr2, 1, 3);

	for(int i = 0; i < arr2.length; i++) {
		System.out.println(arr2[i]);
	}
```

- 객체 배열 복사 시 `System.arraycopy` 사용

- arr1의 값을 arr2 값에 복사

- arr1의 몇 번째 인덱스 요소부터 복사할 것인지 => `0 번째`

- arr2의 몇 번째 인덱스 요소부터 붙여넣을 것인지 => `1 번째`

- arr1의 복사할 인덱스 요소들의 개수 => `3개`

<br>

- `얕은 복사` : 실제로 인스턴스가 생성되서 복사되는 것이 아니라 주소만 복사(system.arraycopy)

- `깊은 복사` : 일일이 객체를 새로 만들어서 복사하려는 배열을 복사하는 배열쪽으로 대입

- 깊은 복사일 때, 각각 인스턴스가 다르고 구별이 되기 때문에 한 객체의 하나의 인스턴스를 변경한다고 해서 다른 객체의 인스턴스 값이 변경되지 않음(영향 x)

<br>

- 향상된 for 문(enhanced for)
  - 배열 요소의 처음부터 끝까지 모든 요소를 참조할 때 편리한 반복문

```java
    for(변수 : 배열) {
        반복 실행문;
    }
```

```java
    for( Book book : library) {
		book.showBookInfo();
	}
```

<br>

- 얕은 복사

```java
    library[0] = new Book("태백산맥1", "조정래");
	library[1] = new Book("태백산맥2", "조정래");
	library[2] = new Book("태백산맥3", "조정래");
	library[3] = new Book("태백산맥4", "조정래");
	library[4] = new Book("태백산맥5", "조정래");

	System.arraycopy(library, 0, copyLibrary, 0, 5);
	library[0].setTitle("나목");
	library[0].setAuthor("박완서");

	for( Book book : library) {
		book.showBookInfo();
	}

	System.out.println("============");

	for ( Book book : copyLibrary) {
		book.showBookInfo();
```

```java
    나목,박완서
    태백산맥2,조정래
    태백산맥3,조정래
    태백산맥4,조정래
    태백산맥5,조정래
    ============
    나목,박완서
    태백산맥2,조정래
    태백산맥3,조정래
    태백산맥4,조정래
    태백산맥5,조정래
```

<br>

- 깊은 복사

```java
    library[0] = new Book("태백산맥1", "조정래");
	library[1] = new Book("태백산맥2", "조정래");
	library[2] = new Book("태백산맥3", "조정래");
	library[3] = new Book("태백산맥4", "조정래");
	library[4] = new Book("태백산맥5", "조정래");

	copyLibrary[0] = new Book();
	copyLibrary[1] = new Book();
	copyLibrary[2] = new Book();
	copyLibrary[3] = new Book();
	copyLibrary[4] = new Book();

	for( int i = 0; i < library.length; i++) {
		copyLibrary[i].setTitle(library[i].getTitle());
		copyLibrary[i].setAuthor(library[i].getAuthor());
	}

	library[0].setTitle("나목");
	library[0].setAuthor("박완서");

	for( Book book : library) {
		book.showBookInfo();
	}

	System.out.println("============");

	for ( Book book : copyLibrary) {
		book.showBookInfo();
```

```java
    나목,박완서
    태백산맥2,조정래
    태백산맥3,조정래
    태백산맥4,조정래
    태백산맥5,조정래
    ============
    태백산맥1,조정래
    태백산맥2,조정래
    태백산맥3,조정래
    태백산맥4,조정래
    태백산맥5,조정래
```

<br>

- `얕은 복사`는 실제 인스턴스가 아닌 주소값을 복사하기 때문에 같은 값을 가리킴

- `깊은 복사`는 library 인스턴스들과 copyLibrary 인스턴스들이 각각 다른 인스턴스이기 때문에 복사하더라도 각각의 값에 영향을 미치지 않음(독립적)

<br>

## 🔖 Eclipse 실습

![day12](https://user-images.githubusercontent.com/79084294/183403715-2af8737a-6a63-4041-ad3f-5b0f13e1b122.png)

<br>

## 🔖 Eclipse 출력 Console

![day12_console1](https://user-images.githubusercontent.com/79084294/183403726-d6057dd7-9e7b-4696-a719-f1ad8eacd036.png)

![day12_console2](https://user-images.githubusercontent.com/79084294/183403733-95f2f189-770c-4451-9dd7-299c2908dfe6.png)
