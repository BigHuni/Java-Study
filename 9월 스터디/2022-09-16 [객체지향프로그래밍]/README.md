## 🔸 2022-09-16 금요일

## [객체지향프로그래밍]

### 1. List 인터페이스

- 하나의 자료를 위한 인터페이스
- Collection 하위 인터페이스
- 객체를 순서에 따라 저장하고, 관리하는데 필요한 메서드가 선언된 인터페이스
- 배열의 기능을 구현하기 위한 메서드가 선언됨
- ArrayList, Vector, LinkedList

<br>

- ArrayList와 Vector
    - 객체 배열 클래스
    - `Vector`는 자바 2부터 제공된 클래스
    - 일반적으로 `ArrayList`를 더 많이 사용
    - `Vector`는 멀티 쓰레드 프로그램에서 `동기화`를 지원
    - 동기화(Synchronization) : 두 개의 쓰레드가 동시에 하나의 리소스에 접근할 때 순서를 맞추어서 데이터의 오류가 방지하지 않도록 함
    - capacity(배열의 용량)와 size(배열 안의 요소 개수)는 다른 의미임

<br>

- ArrayList와 LinkedList
    - 둘 다 자료의 순차적 구조를 구현한 클래스
    - ArrayList는 배열을 구현한 클래스로 논리적 순서와 물리적 순서가 동일함
    - LinkedList는 논리적으로 순차적인 구조지만, 물리적으로는 순차적이지 않을 수 있음
    - LinkedList 구조 : `자료(data)/다음 요소의 주소` => `자료(data)/다음 요소의 주소` => `자료(data)/다음 요소의 주소`...
    - LinkedList에서 자료의 추가와 삭제 비용 효율적
    - ArrayList는 조금 더 빨리 [i] 번째 요소 검색 가능

<br>

- ArrayList에 커맨드 입력한 상태에서 누르면 ArrayList의 클래스 소스를 확인할 수 있음
- ArrayList는 AbstractList의 상속을 받고 있고, List 인터페이스 구현됨
- `DEFAULT_CAPACITY = 10` => 10개 용량을 만듬
- 내부적으로 Object[]로 구성됨, 타입이 알아서 바뀜
- ArrayList를 사용 시 Element를 지정해서 사용함 <E> => 제네릭 타입으로 구현

<br>

- Vector의 클래스 소스를 확인, ArrayList와 비슷
- Vector는 앞에 `synchronized`라는 키워드가 메서드에 포함되어 있음 => 나중에 멀티 쓰레드 환경에서 사용한다는 점 알아두기
- `synchronized(동기화)` => 역할 : 동기화, 여러 개의 쓰레드가 한꺼번에 리소스에 접근할 때, 순서를 맞춰주는 기능
- 동기화 기능을 지원해주니 Vector가 더 좋아보이지만, 단일 쓰레드 환경에서 동기화가 오버헤드 됨 => 쓸 일이 없음

<br>

- LinkedListTest
    - Element String 추가
    - Collection에서 제공되는 기본 메서드 활용 => `myList.add("")`
    - 대부분의 Collection에서 toString 제공
    - 기억해야 할 점 : ArrayList, LinkedList 둘 다 List 인터페이스를 구현한 것이고, 그 외에 myList.size(), i++ 조건으로 몇 번째 인덱스를 가져오는
      것은 `myList.get(i)`
    - 나중에 `set`을 학습할 때, `set`은 get(i) 메서드를 사용할 수 없음, get(i) 메서드는 `List에서만` 존재
    - set은 Collection 인터페이스이긴 하나, 중복을 허용하지 않고, 데이터를 관리하는 역할
    - 앞서 `List 인터페이스`는 순서에 따라 객체를 지정, `set 인터페이스`는 순서에 따라 객체를 지정하지 않음
    - `List 인터페이스`는 중복을 허용, `set 인터페이스`는 중복을 허용하지 않음

```java
  LinkedList<String> myList=new LinkedList<String>();

        myList.add("A");
        myList.add("B");
        myList.add("C");
        System.out.println(myList);         // [A, B, C]

        myList.add(1,"D");
        System.out.println(myList);         // [A, D, B, C]

        myList.removeLast();
        System.out.println(myList);         // [A, D, B]

        for(int i=0;i<myList.size();i++){
        String s=myList.get(i);
        System.out.println(s);
        }
```

<br>

## 🔖 Eclipse 실습

![Linked_list](https://user-images.githubusercontent.com/79084294/190658665-240c07b0-c486-4809-b3a2-fb5634a94d47.png)

<br>

## 🔖 Eclipse 출력 Console

![linked_console1](https://user-images.githubusercontent.com/79084294/190658675-8dc67458-7fdd-4cc2-9758-c3af55149e63.png)
