## 🔸 2022-09-07 수요일

## [객체지향프로그래밍]

### 1. Object 클래스

- reflection 프로그래밍
    - Class 클래스로부터 객체의 정보를 가져와 프로그래밍하는 방식 => 로컬에 데이터 타입이 있다면, 굳이 이렇게 사용하지는 않음, 로컬에 객체가 없거나 자료형을 알 수 없는 자료형이 있을 경우 위 방식
      사용
    - 로컬에 객체가 없고, 자료형을 알 수 없는 경우 유용한 프로그래밍
    - `java.lang.reflect` 패키지에 있는 클래스 활용

<br>

- newInstance() 메서드
    - Class 클래스 메서드
    - new 키워드를 사용하지 않고 인스턴스를 생성

<br>

- `Class c3 = Class.forName("java.lang.String");` => 클래스 정보를 가져옴
- Constructor로 어떤 것을 가지고 있는지 확인

```
  Constructor[] cons = c3.getConstructors();
    for(Constructor con: cons) {
      System.out.println(con);
    }
```

- `getConstructors()`로 array 반환
- for 문으로 전체 범위 설정
- array 안에 있는 모든 Constructor 출력

## 🔖 모든 Constructor 반환 출력

![constructor_print](https://user-images.githubusercontent.com/79084294/189108047-583237bb-4f81-4614-8fb7-5b0589b00b67.png)

<br>

- 자바 String과 관련된 모든 Constructor 출력
- 하지만, String을 알고 있어서 `String str = new String();`로 찍어 사용할 메서드가 모두 보이는데 위 방식처럼 굳이 가져오지 않음
- 따라서 데이터 타입에 대한 정보를 잘 모르거나 로컬에 있지 않을 경우에 사용

<br>

- Methods 확인 => `Method[] methods = c3.getMethods();` - reflect 패키지 안

```
  Method[] methods = c3.getMethods();
    for(Method method : methods) {
		System.out.println(method);
	}
```

## 🔖 모든 Method 반환 출력

![method_print](https://user-images.githubusercontent.com/79084294/189119401-26aaa918-f6cb-4062-8f53-28c6379d38aa.png)

<br>

- Class 클래스에서 유심히 봐둬야하는 부분은 `Class.forName()`으로 동적 로딩하는 부분
- 다른 언어들마다 동적 로딩하는 방식이 존재
- Static으로 컴파일 때 바인딩되는 방법, 런타임 시 선택해서 사용하는 방법이 언어들마다 존재

<br>

```
  Person person = new Person("James");
		System.out.println(person);		
  Class c1 = Class.forName("classex.Person");
```

- `Class.forName`으로 갖고 왔는데, 이 Class로부터 Constructor를 가져올 수 있음
- `Person person1 = c1.newInstance();` => newInstance()는 인스턴스를 생성해주는데, person의 default Constructor를 호출함
- `person의 default Constructor` => Person.java의 `public Person() {};`
- 리턴 타입이 Object이므로 `Person person1 = (Person)c1.newInstance();` 다운 캐스팅을 해주고, 생성이 되지 않는다면 Exception 발생할 것임

```
  Person person = new Person("James");
        System.out.println(person);          // James
		
  Class c1 = Class.forName("classex.Person");
  Person person1 = (Person)c1.newInstance();
        System.out.println(person1);         // null  => toString()에서 return name; 인데 이름을 적어주지 않아 null
```

```
  public Person(String name, int age) {
        this.name = name;
        this.age = age;
  }
```

- 이름을 넣는 Constructor 생성하기
- newInstance()로 그냥 호출하는 것이 아니라 Constructor를 일단 가져와야함
- Constructor의 String 하나를 가져옴
- 예외처리 추가

```
  Class[] parameterTypes = {String.class};
  Constructor cons = c1.getConstructor(parameterTypes);
```

<br>

- 이 Constructor로부터 newInstance()에서 객체를 생성할 수 있게 됨

```
  Object[] initargs = {"김유신"};
  Person personLee = (Person)cons.newInstance(initargs);
  System.out.println(personLee);             // 김유신
```

- 만약, 매개 변수로 두 개를 가져왔다면, 두 개 값을 넣어야함
- `Person personLee = (Person)cons.newInstance(initargs);`로 생성
- 반환 값이 Object이므로 Person으로 다운 캐스팅
- 예외처리 추가

<br>

- default Constructor

```
  Class c1 = Class.forName("classex.Person");
  Person person1 = (Person)c1.newInstance();
  System.out.println(person1);
```

- 매개 변수가 있는 Constructor

```
  Class[] parameterTypes = {String.class};
  Constructor cons = c1.getConstructor(parameterTypes);
		
  Object[] initargs = {"김유신"};
  Person personLee = (Person)cons.newInstance(initargs);
  System.out.println(personLee);
```

- 상식적으로 매개 변수가 있는 Constructor를 `Person person = new Person("James")` 한 줄로 생성할 수 있는데,
- 위 코드처럼 길게 작성해서 사용할 필요는 없음
- 로컬에 Person 타입이 있다면, 간편하게 new 키워드 방식으로 생성하고, 로컬에서 Person 타입을 사용할 수 없는 경에는 위 방식 사용

<br>

- forName() 메서드와 동적 로딩
    - Class 클래스 static 메서드
    - 동적 로딩 => 컴파일 시에 데이터 타입이 모두 binding 되어 자료형이 로딩되는 것, static loding이 아니라 실행 중에 데이터 타입을 알고 binding 되는 방식
    - 실행 시에 로딩되므로 경우에 따라 다른 클래스가 사용될 수 있어 유용함
    - 컴파일 타임에 체크할 수 없으므로 해당 문자열에 대한 클래스가 없는 경우 예외(CLassNotFoundException)이 발생할 수 있음

<br>

## 🔖 Eclipse 실습

![class_ex](https://user-images.githubusercontent.com/79084294/189127345-bcf1491e-35ad-46de-8f55-647f5dbb55fa.png)
