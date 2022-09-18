## 🔸 2022-09-18 일요일

## [객체지향프로그래밍]

### 1. Set 인터페이스

- Iterator로 순회하기
    - Collection의 개체를 순회하는 인터페이스
    - ArrayList 같은 경우, get(i)가 있어서 순회를 할 수 있는데,
    - Set 인터페이스 같은 경우, 내부적으로 순서대로 저장되지 않음 => get(i)처럼 몇 번째 요소를 꺼낼 수 없음
    - `Iterator` 객체 이용하기

- iterator() 메서드 호출

```
    Iterator ir = memberArrayList.iterator();
```

- Iterator에 선언된 메서드

| 메서드                  | 설명                                          |
|:---------------------|:--------------------------------------------|
| `boolean hashNext()` | 이후에 요소가 더 있는지를 체크하는 메서드이며, 요소가 있다면 true를 반환 |
| `E next()`   | 다음에 있는 요소를 반환                               |

<br>

```
    HashSet<String> set = new HashSet<String>();
		set.add("이순신");
		set.add("김유신");
		set.add("강감찬");
		set.add("이순신");
		
		System.out.println(set);      // [김유신, 강감찬, 이순신]
```

- 순서대로 출력되지 않음
- 내부적으로 관리(Hash) => 어떠한 값을 주면, 값이 저장되는 인덱스를 할당
- 만약 `HashSet`을 `ArrayList`로 바꾼다면, 이름 순서대로 출력, 중복도 가능 => `[이순신, 김유신, 강감찬, 이순신]`
- 아이디, 주민등록번호, 학번, 사번 관리할 때, `HashSet` 사용

<br>

- 하나씩 돌아가며 출력

```
  HashSet<String> set = new HashSet<String>();
		set.add("이순신");
		set.add("김유신");
		set.add("강감찬");
		set.add("이순신");
		
		Iterator<String> ir = set.iterator();
		
		while(ir.hasNext() ) {
			String str = ir.next();
			System.out.println(str);
```

- Iterator 이용, 모든 Collection에 대고 iterator() 호출 가능(list, set 계열 가능)
- 순회할 Element 지정 => `<String>`
- while문으로 hastNext boolean 반복 => 다음 Element가 있는지 확인, 있다면 가져옴
- 반환값은 String으로 지정했기 때문에 `String str = ir.next();`
- 출력하면 전체 Element를 모두 순회하는 코드 작성

<br>

## 🔖 Eclipse 실습

![hashset_list](https://user-images.githubusercontent.com/79084294/190912114-b49bff91-c2aa-4403-a68a-d6c6da3d0aed.png)

<br>

## 🔖 Eclipse 출력 Console

![hashset_console](https://user-images.githubusercontent.com/79084294/190912112-de1c0048-d196-49a0-a0cf-7d4a7c99fb3e.png)