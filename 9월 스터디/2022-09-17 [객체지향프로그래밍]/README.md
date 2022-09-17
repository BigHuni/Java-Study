## 🔸 2022-09-17 토요일

## [객체지향프로그래밍]

### 1. Stack과 Queue 구현하기

- Stack은 이미 기본 제공
- Queue는 ArrayList 이용해서 많이 사용

<br>

- Stack 구현하기
    - LIFO(Last In First Out) : 맨 마지막에 추가된 요소가 가장 먼저 꺼내지는 자료 구조
    - 이미 구현된 클래스가 제공됨
    - ArrayList나 LinkedList로 구현할 수 있음
    - 게임에서 무르기, 최근 자료 가져오기 등에 구현
    - 스택에서 요소 추가(push), 요소 꺼내어(pop) 삭제하기

<br>

- Queue 구현하기
    - FIFO(First In First Out) : 먼저 저장된 자료가 먼저 꺼내지는 자료 구조
    - 선착순, 대기열 등을 구현할 때 가장 많이 사용되는 자료 구조
    - ArrayList나 LinkedList로 구현할 수 있음
    - 큐에서 요소 추가(enqueue), 요소 삭제(dequeue)

<br>

- 클래스 MyStack을 ArrayList로 구현

```java
  class MyStack {

    private ArrayList<String> arrayStack = new ArrayList<String>();

    public void push(String data) {         // push()로 object 하나가 들어와야 함
        arrayStack.add(data);               // arrayStack의 맨 마지막에 data를 넣어야 함 
    }

    public String pop() {
        int len = arrayStack.size();
        if (len == 0) {
            System.out.println("스택이 비었습니다.");
            return null;
        }

        arrayStack.remove(len - 1);
    }

}

public class StackTest {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println(stack.pop());        // C
        System.out.println(stack.pop());        // B
        System.out.println(stack.pop());        // A
        System.out.println(stack.pop());        // 스택이 비었습니다. + null 반환
    }
}

```

<br>

- 자바에 이미 Stack이 구현
- Stack 소스의 `peek()` => 해당 요소가 무엇인지 확인, 꺼내지는 않음
- Queue 소스의 `priorityQueue` => 우선순위를 갖는 Queue, 요소를 하나씩 꺼낼 때마다 제일 큰 값, 작은 값을 꺼낼 때 사용
- 일반적으로 `ArrayList`를 이용해 `Queue`를 많이 사용

<br>

## 🔖 Eclipse 실습

![stack_list](https://user-images.githubusercontent.com/79084294/190859693-d7ba870f-a0bc-4b21-944a-8f4144282830.png)

<br>

## 🔖 Eclipse 출력 Console

![stack_console](https://user-images.githubusercontent.com/79084294/190859695-53954b79-e522-4860-814b-659869b4a036.png)
