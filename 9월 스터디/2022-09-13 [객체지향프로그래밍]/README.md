## 🔸 2022-09-13 화요일

## [객체지향프로그래밍]

### 1. String, Wrapper 클래스

- String 클래스 선언하기
    - 1번, `String str1 = new String("abc");` => 인스턴스로 생성됨
    - 2번, `String str2 = "abc";` => 상수풀에 있는 문자열을 가리킴
    - 1번의 `new` 키워드를 사용한다는 것은 힙 메모리에 `Allocation`을 받겠다는 의미
    - 2번은 상수풀에 문자열이 있다면, new 사용하지 않고, 바로 사용 가능(상수풀 공유)

<br>

```
    // 1번 Test
    String str1=new String("abc");
    String str2=new String("abc");

    System.out.println(str1==str2);
    
    // 2번 Test
    String str3 = "abc";
    String str4 = "abc";
		
    System.out.println(str3 == str4);
```

- [1번 Test] : 메모리 위치가 다르기 때문에 `false`
- [2번 Test] : 상수 풀에서 가져왔기 때문에 `true`

<br>

- String은 immutable
    - 한 번 선언되거나 생성된 문자열을 변경할 수 없음
    - String 클래스의 concat() 메서드 혹은 "+"를 이용하여 String을 연결하는 경우 문자열은 새로 생성됨
    - javaStr로 "java", androidStr로 "android"를 생성하여 위 방식으로 붙여서 "javaandroid"
    - "javaandroid"이 눈으로는 그저 붙인 것으로 보이지만, 실제 새로운 메모리가 생성
    - 한 번 생성된 String은 불변하기 때문에 String을 계속 생성할 때마다 새로운 메모리에 할당

<br>

```
    String java = new String("java");
	String android = new String("android");
		
	java = java.concat(android);
		
	System.out.println(java);    // javaandroid
```

- 출력은 `javaandroid`라고 나오지만, 실제 메모리는 어떻게 되는지 확인해보기
- hashCode 값으로는 확인할 수 없음 => hashCode는 String에서 Override 했기 때문

```
    String java = new String("java");
	String android = new String("android");
	System.out.println(System.identityHashCode(java));  // 205962452
		
	java = java.concat(android);
		
	System.out.println(java);
	System.out.println(System.identityHashCode(java));  // 1032986144

```

- 서로 메모리 상 주소가 다름
- 따라서 연결이 되면 새로운 메모리를 가리킴
- 고로 String을 계속 연겷해서 사용할 일이 있다면, `StringBuider`와 `StringBuffer`를 사용하면 됨
- `StringBuffer` 클래스를 살펴보면, 안에 `AbstractStringBuilder`를 가보면 `value`가 `String`에서는 `final`이었음
- 하지만, 여기서는 `final`이 아니고, 가변적인 배열을 갖게 됨
- 따라서 연결한다고 해서 계속 메모리를 사용하는 것이 아니라 새로운 연결을 하게 됨
- `StringBuider`와 `StringBuffer`의 가장 큰 차이점은 `StringBuilder`는 멀티 쓰레드 환경에서 동기화를 지원하지 않음
- `StringBuffer`은 멀티 쓰레드 환경에서 동기화를 지원 가능

<br>

- `StringBuider`와 `StringBuffer`
    - 가변적인 char[] 배열을 멤버 변수라 가지고 있는 클래스
    - 문자열을 변경하거나 연결하는 경우 사용하면 편리한 클래스
    - `StringBuffer`는 멀티 쓰레드 프로그래밍에서 동기화(Synchronization)이 보장됨
    - 단일 쓰레드 프로그래밍에서는 `StringBuilder`를 사용하는 것이 더 좋음
    - toString()메서드로 String 반환

<br>

```
    String java = new String("java");
	String android = new String("android");
		
	StringBuilder buffer = new StringBuilder(java);
	System.out.println(System.identityHashCode(buffer));       // 205962452
	
	buffer.append("android");
	System.out.println(System.identityHashCode(buffer));       // 205962452
		
	java = buffer.toString();
```

- `StringBuilder buffer = new StringBuilder(java);` => java의 String 기반으로 StringBuilder가 생김
- 두 출력으로 메모리 값이 `205962452`로 동일함
- 이는 불변이 아니고, append, insert, reverse 등 변동이 있은 뒤 나중에 필요하다면 toString() 하여 다시 String 값을 얻어오게 됨

<br>

- Wrapper 클래스

| 기본형       | Wrapper 클래스 |
|:----------|:------------|
| `boolean` | Boolean     |
| `byte`    | Byte        |
| `char`    | Character   |
| `short`   | Short       |
| `int`     | Integer     |
| `long`    | Long        |
| `float`   | Float       |
| `double`  | Double      |

<br>

## 🔖 Eclipse 실습

![String_list](https://user-images.githubusercontent.com/79084294/189909378-1129eef9-91b3-4ccf-aeaf-c27e9302f701.png)

<br>

## 🔖 Eclipse 출력 Console

![String_console1](https://user-images.githubusercontent.com/79084294/189909364-6f3b34a3-03b7-4fa5-a3f3-0de867f7306b.png)

![String_console2](https://user-images.githubusercontent.com/79084294/189909371-9a055fa1-43cc-43dd-aa80-9b1b2580c687.png)

![String_console3](https://user-images.githubusercontent.com/79084294/189909375-6ffbd512-efa4-4f67-884f-80a34795c7ee.png)
