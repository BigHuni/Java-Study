# 📌 Java Study

## 🔸 2022-08-25 목요일

## [인터페이스 응용]

### 1. 인터페이스 응용

- 하나의 구현 클래스가 여러 개의 인터페이스를 상속받을 수 있음
- 인터페이스가 여러 개 있을 시 모두 상속받아 하나의 인터페이스를 만들 수 있음

<br>

- X, Y interface

```
    public interface X {
	void x();
    }
```

```
    public interface Y {
	void y();
    }
```

<br>

- MyInterface 인터페이스(상속)

```
    public interface MyInterface extends X, Y {
	void myMethod();
    }
```

<br>

- MyClass 클래스

```
    public class MyClass implements MyInterface {
    
	@Override
	public void x() {
	}
	
	@Override
	public void y() {
	}

	@Override
	public void myMethod() {
	}
}
```

- MyClass는 MyInteface 타입이기도 하지만, X, Y 타입이기도 함
- 이를 `타입 상속(type inheritance)`라고 함
- 이미 라이브러리에서 이를 제공하는 경우도 있음

<br>

- BookShelf를 만들려고 하는데, 기존의 Shelf에 Queue를 더하려고 함
- 앞에 것부터 순서대로 가져감(큐 자료구조)
- 이를 implements 해서 사용

<br>

- Shelf 클래스

```java
    public class Shelf {

    protected ArrayList<String> shelf;

    public Shelf() {
        shelf = new ArrayList<String>();
    }

    public ArrayList<String> getShelf() {
        return shelf;
    }

    public int getCount() {
        return shelf.size();
    }
}
```

- ArrayList의 String 타입으로 생성
- 하위 클래스에서 상속받아 사용할 수 있도록 `protected`로 선언
- ArrayList 생성은 주로 Constructor에서 많이 함 => `shelf = new ArrayList<String>();`
- protected 이므로 일단 get만 생성 => `public ArrayList<String> getShelf()`
- 해당 선반에 개수가 몇 개인지 확인하기 위한 메서드로 `getCount()` 생성

<br>

- Queue 인터페이스

```java
    public interface Queue {

    void enQueue(String title);

    String deQueue();

    int getSize();
}
```

- Queue에 집어넣는 enQueue 메서드
- String을 반환해주는 deQueue 메서드
- Queue 안에 몇 개가 들어있는지 확인하기 위한 getSize 메서드

<br>

- BookShelf 클래스(Shelf 상속받고, 구현하려는 interface Queue)

```java
    public class BookShelf extends Shelf implements Queue {

    @Override
    public void enQueue(String title) {
        shelf.add(title);
    }

    @Override
    public String deQueue() {
        return shelf.remove(0);
    }

    @Override
    public int getSize() {
        return getCount();
    }
}
```

- enQueue는 Shelf에 집어 넣음 => `shlelf.add(title);`
- deQueue는 책 한 권이 빠져나가 get이 아니고, Shelf에서 없어지는 것
- Queue 형식에서 deQueue는 맨 앞에 것이 없어짐 => remove() 사용, String 반환해주는 index 활용(0 번째)
- size는 Shelf의 getCount() 호출

<br>

## 🔖 Eclipse 실습

![day26](https://user-images.githubusercontent.com/79084294/186909107-b3a024a6-f3fb-4fb9-bad9-d6a5eda425b7.png)

<br>

## 🔖 Eclipse 출력 Console

![day26_console1](https://user-images.githubusercontent.com/79084294/186909121-3bedfcb4-e7ce-4dcd-a9f7-90752dc48672.png)
