# 📌 Java Study

## 🔸 2022-08-23 화요일

## [스프링 부트 프로젝트 & 객체지향프로그래밍]

### 1. Spring 초기

### 🔖 [오류 발생] Cannot resolve symbol 'String'

- 인텔리제이 프로젝트를 닫고 종료 후 다시 Open 했더니 위와 같은 오류로 모든 코드 구문 `String` 에러 발생

- 해결 원인 : 인텔리제이에 현재 JDK가 설정되어 있지 않은 문제 혹은 JDK 폴더가 날아간 문제

- 해결 방법 : 인텔리제이 - File - Project Structure - SDK 설정(설치된 JDK 버전)

<br>

- 에러 발생
  ![Error](https://user-images.githubusercontent.com/79084294/186413185-3fde870a-d48e-4a3f-904c-83776dacf834.png)

<br>

- 원인 : SDK 미 설정
  ![No_SDK](https://user-images.githubusercontent.com/79084294/186413190-a4cd539c-eb6c-414c-982f-523557104427.png)

- 해결 : SDK 세팅
- ![SDK_Setting](https://user-images.githubusercontent.com/79084294/186413193-f7488000-29e8-472e-832e-75344aa500a9.png)

<br>

### 2. 인터페이스 요소들

- 상수 : 선언된 모든 변수는 상수로 처리됨
- 메서드 : 모든 메서드는 추상 메서드
- 디폴트 메서드 : 기본 구현을 가지는 메서드, 구현하는 클래스에서 재정의 할 수 있음(Java 8 이상)
- 정적 메서드 : 인스턴스 생성과 상관없이 인터페이스 타입으로 호출하는 메서드(Java 8 이상)
- private 메서드 : 인터페이스 내에서 사용하기 위해 구현한 메서드, 구현하는 클래스에서 재정의 할 수 없음(Java 9 이상)

<br>

- 여러 개의 인터페이스 구현하기
- 인터페이스는 구현 코드가 없으므로 하나의 클래스가 여러 인터페이스를 구현할 수 있음
- 디폴트 메서드의 이름이 중복되는 경우에는 재정의 함

<br>

- 인터페이스 간에도 상속이 가능함
- 구현이 없으므로 extends 뒤에 여러 인터페이스를 상속받을 수 있음
- 구현 내용이 없으므로 타입 상속(Type Inheritance)라고 함
