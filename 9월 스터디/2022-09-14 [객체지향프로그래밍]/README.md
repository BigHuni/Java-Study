## 🔸 2022-09-14 수요일

## [객체지향프로그래밍]

### 1. 제네릭 프로그래밍

- 변수의 선언이나 메서드의 매개 변수를 하나의 참조 자료형이 아닌여러 자료형을 반환될 수 있도록 프로그래밍 하는 방식
- 실제 사용되는 참조 자료형으로서의 변환은 컴파일러가 검증하므로 안정적인 프로그래밍 방식

<br>

- 자료형 매개 변수 T
    - 여러 참조 자료형으로 대체될 수 있는 부분을 하나의 문자로 표현
    - type의 의미로 T 사용

```java
    public class GenericPrinter<T> {             // GenericPrinter<T> => 제네릭 클래스
    private T material;                          // T => type의 약자. 자료형 매개 변수

    public void setMaterial(T material) {
        this.material = material;
    }

    public T getMaterial() {
        retrun material;
    }
}
```

<br>

 ```
  GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();
  Powder powder = new Powder();
  powderPrinter.setMaterial(powder);
  System.out.println(powderPrinter);
  
  GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();
  Plastic plastic = new Plastic();
  plasticPrinter.setMaterial(plastic);
  System.out.println(plasticPrinter);
 ```

- `new GenericPrinter<Powder>();` => <Powder>를 안 쓰고, <>를 사용하면 앞에 <Powder>로 유추를 하게 됨
- `Powder powder = new Powder();` => Powder에 대한 재료 넣기
- `powderPrinter.setMaterial(powder);` => `powder`가 Printer의 재료가 됨
- 앞서 그냥 `GenericPrinter<T>` 타입만 선언했다고 해서 생성되는 것은 아님
- main Test에서 new 생성하여 setMaterial로 값을 할당해야 함
- 위 코드를 보고, 각각 다른 타입에 대한 Printer를 생성할 때, `자료형<>`을 대입해서 사용할 수 있음 => `Generic 프로그래밍`

<br>

- 만약, 3D 프린터에 Water 재료를 넣는다고 가정
- 물은 3D 프린터 재료가 될 수 없기에 `GenericPrinter<Water> waterPrinter = new GenericPrinter<Water>();`를 넣고, 상위 클래스(Material) 생성
- 그 다음 모든 GenericPrinter의 사용하는 키를 `<T extends Material>` 해야함 => 여기서 상속받은 재료만 GenericPrinter로 사용 가능
- 이렇게 되면, Main Test에서 사전에 입력한 Powder와 Plastic에 오류 발생 => 현재 상속받고 있지 않기 때문
- 상속을 받을 수 있도록 각 재료 클래스에 `extends Material` 추가 => 이번에는 Water를 사용할 수 없게 됨(Water를 제외한 나머지 재료만 상속받았기 때문)
- 사용할 수 있는 재료에 대한 제한을 두고 싶을 때, `상위 클래스` 사용 방법 이용
- 또 다른 방법, 추상 클래스 선언

```
  public abstract class Material {
	public abstract void doPrinting();
}
```

- Material 클래스에서 abstract 클래스로 변환 후 doPrinting() 추상 메서드 추가
- Powder와 Plastic 두 재료 클래스 모두 `@Override`로 doPrinting() 추가
- GenericPrinter에서 T의 역할은 extends Material이 아니면 material에 `.(점)`을 찍어보면 Object 메서드들(toString, getClass, hashCode...) 밖에
  없음, 여기다가 doPrinting()이 추가됨 => Material 클래스는 doPrinting() 메서드를 호출할 수 있음

<br>

- <T extends 클래스>
    - T 대신에 사용될 자료형을 제한하기 위해 사용
    - Material에 정의된 메서드를 공유할 수 있

<br>

- 자료형 매개 변수가 두 개 이상일 때

```java
  public class Point<T, V> {
    T x;
    V y;

    Point(T x, V y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {       // public T getX(), V getY() => 제너릭 메서드
        return x;
    }

    public V getY() {
        return y;
    }
}
```

- 제너릭 메서드
    - 메서드의 매개 변수를 자료형 매개 변수로 사용하는 메서드
    - 메서드 내에서의 자료형 매개 변수는 메서드 내에서만 유효함 (지역 변수와 같은 개념)

```
  class Shape<T> {
    public static<T,V> double makeRectangle(Point<T,V>p1, Point<T,V>p2) {
      .....
     }
  }
```

- Shape의 T와 makeRectangle의 T는 전혀 다른 의미

<br>

## 🔖 Eclipse 실습

![generic_list](https://user-images.githubusercontent.com/79084294/190173228-9e18f865-2c07-4650-8b31-0e92a1ebba09.png)

<br>

## 🔖 Eclipse 출력 Console

![generic_console1](https://user-images.githubusercontent.com/79084294/190173217-2035c66c-273c-4f1a-ba5b-a259934abad0.png)
