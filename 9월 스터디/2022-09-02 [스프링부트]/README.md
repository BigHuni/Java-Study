# 📌 Java Study

## 🔸 2022-09-02 금요일

## [스프링 부트 프로젝트]

### 1. Entity 생성

- Entity

- `Camel Case` : 단어를 표기할 때, 첫 문자는 소문자로 시작하며 띄어쓰기 대신 대문자로 단어를 구분
    - Java의 변수를 선언할 때, Camel Case로 선언
    - ex) phoneNumber, createdAt, updatedAt

- `Snake Case` : 단어를 표기할 대, 모두 소문자로 표기하며 띄어쓰기 대신 `(_)`로 표기
    - DB 컬럼에 사용
    - ex) phone_number, created_at, updated_at

- API를 정의하기에 따라 다르지만, 주로 API 통신 규격에는 구간에서는 Snake Case를 많이 사용

<br>

- `Entity` : JPA에서는 테이블을 자동으로 생성해주는 기능 존재
- DB Table == JPA Entity

| Annotation       | 용도                     | 
|:-----------------|:-----------------------|
| `Entity`         | 해당 Class가 Entity임을 명시  | 
| `Table`          | 실제 DB 테이블의 이름을 명시 | 
| `Id`             | Index Primary Key를 명시  | 
| `Column`         | 실제 DB Column의 이름을 명시   | 
| `GeneratedValue` | Primary Key 식별키의 전략 설정 | 

<br>

- DB => 스네이크 케이스
- Java => 카멜 케이스

<br>

- main - model 하위에 entity 폴더를 생성 후 User 클래스 생성
- User 클래스는 DB의 테이블 이름과 동일

```
 package com.example.study.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

}
```

- `@Table(name = "user")`는 클래스의 이름과 DB Table의 이름이 동일하다면, @Table을 선언하지 않아도 자동 맵핑

<br>

- User 테이블
- id(BIGINT(20)) - PK 키, NOT NULL, AI
- account(VARCHAR(45)) - NN
- email(VARCHAR(45)) => `이메일을 입력하지 않을 수 있으니 NULL 허용`
- phone_number(VARCHAR(45)) => `전화번호를 입력하지 않을 수 있으니 NULL 허용`
- created_at(DATETIME) - NN => `DB에 데이터가 쌓이면, 생성일자, 수정일자를 남기는 것이 현업에서 필수`
- created_by(VARCHAR(45)) - NN
- updated_at(DATETIME)
- updated_by(VARCHAR(45))

<br>

```java

@Entity
public class User {
    private Long id;

    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
```

- `id`는 BIGINT이기 때문에 Long 타입
- `account, email` String 타입
- `phoneNumber`는 `자바`에서는 `카멜 케이스`로 사용하지만, 실제 `데이터베이스`에서는 `스네이크 케이스`
- 이런 점을 JPA에서 자동으로 매칭해주기 때문에 따로 변수를 선언하지 않아도 됨 (phone_Number 처럼)
- `createdAt, updatedAt`은 DateTime이므로 LocalDateTime 타입
- `createdBy, updatedBy`는 String 타입

<br>

- `@column(name = "account")`이라는 annotation은 account라는 이름이 DB 컬럼을 의미하는데, 만약 변수명과 동일하다면 기입하지 않아도 됨
- 식별자에 대해서 `@Id` 붙이기
- `@generatedValue`로 어떤 식으로 관리할 것인지 전략 설정
- `@GeneratedValue(strategy)` 전략으로 총 4가지 정도 있는데, MySQL을 사용하기 때문에 `GenerationType.IDENTITY` 사용
- `@Data` 선언하여 기본 생성자와 변수에 대하여 get / set 메서드 생성
- `@AllArgsConstructor` 선언하여 모든 매개변수를 갖는 생성자 생성
- 이 과정까지 기본적으로 Entity 설정하고, Table 연결 완료

```java
package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String account;

    private String email;

    private String phoneNumber;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;
}
```

- `DB Table`에 맞춰서 클래스를 선언하고, `Entity` 이름 설정, `DB 컬럼에 맞춰 각 변수`를 `Camel Case` 방식으로 선언
- 그렇게 되면, `JPA Entity`는 자동으로 Camel Case를 `DB의 Snake Case`로 매칭

<br>

### 2. Repository

- 따로 쿼리문을 작성하지 않아도 기본적인 인터페이스를 통해 `CRUD`를 사용
    - `CREATE` : 생성
    - `READ` : 읽기(SELECT)
    - `UPDATE` : 업데이트(갱신)
    - `DELETE` : 삭제

<br>

- `@Repository`를 추가하고, 이미 개발되어 있는 JpaRepository를 상속 받아주면 됨
- 인터페이스 네이밍할 때, 보통 `클래스 Entity명` + `Repository` = UserRepository
- public interface UserRepository extends JpaRepository<T, ID>
- JpaRepository의 `T` => 어떠한 타입의 object가 들어갈 것인지, `ID` => PK 기본키에 대해 어떤 타입이 들어갈 것인지
- `public interface UserRepository extends JpaRepository<User, Long>`
- `Long`은 User라는 Entity에 id 값으로 Long을 했기 때문에 UserRepository에 `User` 엔티티와 기본키 Id 인덱스 값으로 `Long`이라고 선언하는 것
- DB Table의 Entity 생성과 Repository 선언을 통해 기본적인 CRUD를 실행할 수 있음
