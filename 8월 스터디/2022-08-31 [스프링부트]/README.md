# 📌 Java Study

## 🔸 2022-08-31 수요일

## [스프링 부트 프로젝트]

### 1. spring과 spring boot

- `spring` => 자바 오픈 소스 프레임워크
- 옛날에는 스프링 설정 이전에 여러 라이브러리, 설정 등을 직접 진행해야 했음
- 이 과정에서 버전 충돌, 에러 등 학습자와 현업에서 어려움을 느낌
- 이러한 이유로 자바는 생산성이 떨어진다는 이야기가 나옴
- `spring boot` => spring 개발에 있어서 기본적으로 설정해야하는 라이브러리들을 미리 내장
- 간단한 `annotation`을 통해 설정할 수 있도록 개발된 경량화 프레임워크
- 따라서, `spring boot`안에 `spring`을 기본적으로 내장하고 있으며 톰캣도 내장하고 있음

<br>

### 2. Lombok

- 앞서 `SearchParam` 개발할 때, 변수를 선언하고, 생성자, 모든 매개변수가 들어가는 생성자 또는 각 변수마다 `get/set` 코드를 생성함
- 하지만, 생성자에 한하여 인텔리제이가 생성해주지 않음
- 이를 간단하게 `annotation`으로 한 번에 해결해주는 것이 `Lombok`
- `Lombok` 플러그인 설치 후 `@Data`를 붙여주면 기본 생성자부터 `get/set` 메서드까지 생성해주고, 코드의 간략화까지 해줌

<br>

- Lombok 코드 달기

```java
import lombok.Data;

@Data
public class SearchParam {
    private String account;
    private String email;
    private int page;
}
```

- 자동으로 기본 생성자, get/set 메서드, equals, hash code, toString에 대해서 Lombok이 재정의
- `@AllArgsConstructor`을 추가해주면, 모든 매개변수를 가지는 생성자가 추가됨
- 이처럼 일일이 코드를 작성하는 것이 아니라 Lombok을 활용해 생산성을 높임

<br>

### 🔖 Lombok 인텔리제이 코드

![Lombok 코드](https://user-images.githubusercontent.com/79084294/187903537-c6b64ece-a5e1-4407-b087-1020520c9def.png)

<br>

### 🔖 Lombok 스프링 실행(톰캣 8080 포트 정상)

![Lombok 실행](https://user-images.githubusercontent.com/79084294/187903547-68c302ad-3202-4548-bf72-8a5d9d8ab467.png)

<br>

### 3. JPA

- ORM(Object Relational Mapping)으로 RDB 데이터 베이스의 정보를 객체지향으로 손쉽게 활용할 수 있도록 도와주는 도구(라이브러리)
- Object(자바 객체)와 Relation(관계형 데이터베이스) 둘 간의 맵핑을 통해서 보다 손쉽게 적용할 수 있는 기술을 제공
- 또한, 쿼리에 집중하기 보다는 객체 집중함으로써, 조금 더 프로그래밍적으로 많이 활용할 수 있음
