# 📌 Java Study

## 🔸 2022-08-12 금요일

## [상속과 다형성]

### 1. 다형성(polymorphism)

- 하나의 코드가 여러 자료형으로 구현되어 실행되는 것

- 같은 코드에서 여러 실행 결과가 나옴

- 정보은닉, 상속과 더불어 객체지향 프로그래밍의 가장 큰 특징 중 하나

- 객체지향프로그래밍의 유연성, 재활용성, 유지보수성에 기본이 되는 특징

<br>

```java
    class Animal{
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Human extends Animal {
	public void move() {
		System.out.println("사람이 두 발로 걷습니다.");
	}
}

class Tiger extends Animal {
	public void move() {
		System.out.println("호랑이가 네 발로 뜁니다.");
	}
}

class Eagle extends Animal {
	public void move() {
		System.out.println("독수리가 하늘을 날아갑니다.");
	}
}

public class AnimalTest {

	public static void main(String[] args) {

		Animal hAnimal = new Human();
		Animal tAnimal = new Tiger();
		Animal eAnimal = new Eagle();

		AnimalTest test = new AnimalTest();
		test.moveAnimal(hAnimal);
		test.moveAnimal(tAnimal);
		test.moveAnimal(eAnimal);

	}

	public void moveAnimal(Animal animal) {
		animal.move();
	}
}
```

- 한 클래스 내에 main을 제외한 여러 개의 클래스가 올 수 있음

- `animal.move` 하나의 코드가 여러 자료형이 구현되서 각각 다른 실행이 수행 => polymorphism(다형성)

- 장점

```java
    public void moveAnimal(Human animal) {
		animal.move();
	}

    public void moveAnimal(Tiger animal) {
		animal.move();
	}

    public void moveAnimal(Eagle animal) {
		animal.move();
	}
```

- 메서드 3개를 일일이 만들지 않고, 아래 코드처럼 하나의 메서드로 다양한 구현이 가능

```java
    public void moveAnimal(Animal animal) {
		animal.move();
	}
```

<br>

- hAnimal, tAnimal, EAnimal 들이 각각의 클래스로 이루어졌지만, `Animal` 타입 하나로 이루어짐

- 동일한 메서드로 출력할 수 있음

<br>

```java
    ArrayList<Animal> animalList = new ArrayList<Animal>();
		animalList.add(hAnimal);
		animalList.add(tAnimal);
		animalList.add(eAnimal);

		for(Animal animal : animalList) {
			animal.move();
		}
```

- 위 코드도 polymorphism 으로서 같은 결과를 나타내는데, `animal.move()` 코드 하나지만 구현된 내용이 모두 다르게 나타남

- move() 가 호출이 되면, Animal 타입의 move()가 아니라 각 인스턴스의 move()가 호출되는 것(가상 메서드)

- 가상 메서드에 의해 맵핑되는 함수가 호출되면서 다양한 구현이 이루어짐

- 순서

  - 각 클래스에 상속을 받음 - 상속했을 때 어떻게 이루어지는지 관계가 이루어짐

  - Human, Tiger, Eagle 이 Aniaml 을 내포하게 됨 - 각각(Human, Tiger, Eagle) 재정의(오버라이딩)

  - 오버라이딩 되었을 때, 메서드의 호출은 인스턴스가 빌려짐

  - 상속 - 형 변환 - 오버라이딩 - 가상함수 - polymorphism

  - 다형성 사용 장점 : 다양한 여러 클래스를 하나의 자료형(상위 클래스)으로 선언하거나 형 변환하여 각 클래스가 동일한 메서드를 오버라이딩 한 경우, 하나의 코드가 다양한 구현을 실행할 수 있음, 유사한 클래스가 추가되는 경우 유지보수에 용이하고, 각 자료형마다 다른 메서드를 호출하지 않으므로 코드에서 많은 if 문이 사라짐

<br>

- IS-A 관계 : 일반적인(general)개념과 구체적인(specific)개념과의 관계
  - 상위 클래스 : 일반적인 개념(예 : 포유류)
  - 하위 클래스 : 구체적인 개념(예 : 사람, 원숭이, 고래 등)
  - 단순히 코드를 재사용하는 목적으로 사용하지 않음

<br>

- HAS-A 관계 : 한 클래스가 다른 클래스를 소유한 관계
  - 코드의 재사용의 한 방법
  - Student가 Subject를 포함한 관계

<br>

### 2. 다운 캐스팅과 instanceof

- 하위 클래스로 형 변환, 다운 캐스팅

  - 묵시적으로 상위 클래스 형 변환된 인스턴스가 원래 자료형(하위 클래스)으로 변환되어야 할 때 다운 캐스팅

  - 하위 클래스로의 형 변환은 명시적으로 되어야함

```java
    Customer vc = new VIPCustomer();        // 명시적
    VIPCustoemr vCustomer = (VIPCustomer)vc;        // 명시적
```

<br>

- instanceof => `true` or `false` 반환

```java
    if(hAnimal instanceof Human) {
        Human human (Human)hAnimal;
    }
```

- `hAnimal instanceof Human` => hAnimal이 Human 타입에 인스턴스인지 확인

- 다운 캐스팅은 명시적으로 일어남

- 상위 클래스에서 오버라이딩으로 해결할 수 있다면 그렇게 해결

- 오버라이딩이 정 안되는 경우에만 `다운 캐스팅`을 하면 되는데, 안정적으로 하기 위해 `instanceof` 활용

<br>

## 🔖 Eclipse 실습

![day17](https://user-images.githubusercontent.com/79084294/184421689-f1919f45-2423-4527-9215-5e49e7a3969e.png)

<br>

## 🔖 Eclipse 출력 Console

![day17_console1](https://user-images.githubusercontent.com/79084294/184421694-7b3fa174-4096-4e3f-b447-c29d974c8ce0.png)
