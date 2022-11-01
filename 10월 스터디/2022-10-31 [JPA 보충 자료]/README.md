## 🔸 2022-10-31 월요일

## [JPA 보충 자료]

### 1. JPA

- 일반적인 스프링 기반 프로젝트에서 데이터 CRUD 처리는 MyBatis를 사용했었음
- 각 SQL 쿼리문을 모두 직접 손수 작성하는 것은 쉽지 않음
- 이에 따라 MyBatis와 일반적인 GET, POST 방식보다는 JPA와 Rest API를 이용한 비동기 방식이 대두됨

<br>

- `JPA`는 자바 객체와 DB 테이블 간 매핑을 처리하는 ORM(Object Relational Mapping) 기술의 표준
- `ORM`은 테이블 구조화 클래스인 VO(DTO) 클래스를 테이블과 매핑하는 개념
- JPA에서 테이블과 매핑되는 테이블 구조화 클래스를 `Entity(엔티티) 클래스`
- 즉, `Entity 클래스`가 `테이블`이라고 쉽게 생각하면 좋음

<br>

- `JPA Properties` => JPA 관련 설정으로 데이터베이스의 타입과 로드 등을 처리하는 설정
- 다시 한 번 강조하면, JPA는 테이블을 따로 생성하지 않아도, 앞서 Entity 클래스를 기준으로 테이블과 알맞은 타입의 컬럼을 자동으로 생성
- `generate-ddl`, `hibernate.ddl-auto` 는 안전을 위해 자동 생성 기능 배제
- `generate-ddl = false`, `hibernate.ddl-auto = none`

<br>

- 데이터베이스 관련 Configuration 클래스 생성
- com.study 패키지 아래 config 패키지와 DatabaseConfig 클래스 추가
- com.study 패키지 아래 board.entity 패키지와 Board 클래스 추가
- @Getter : 해당 클래스에 포함된 멤버 변수의 모든 getter 메서드 생성해주는 lombok의 강력한 기능
- @NoArgsConstructor : 해당 클래스의 기본 생성자를 생성해주는 어노테이션
- @Entity : 해당 클래스가 테이블과 매핑되는 JPA의 엔티티 클래스임을 의미, 기본적으로 클래스명을 테이블명으로 매핑
    - `user_password`라는 테이블은 `UserPassword`라는 이름의 클래스로 네이밍
    - 클래스명과 테이블명이 다를 수 밖에 없는 상황에서는 클래스 레벨에 @Table 선언, `@Table(name="user_password")`과 같이 name 속성 처리
- @Id : 해당 멤버가 엔티티의 PK임을 의미, 보통 MySQL은 PK를 big-int 타입으로, 엔티티에서는 Long 타입으로 선언
- @GeneratedValue(strategy = generationType.IDENTITY) : PK 생성 전략을 설정하는 어노테이션, AI(Auto Increment)를 지원하려면 해당 어노테이션 추가
- @builder : lombok에서 제공해주는 빌더라는 기능, 생성자 대신에 이용하는 패턴, 쉽게 말해 생성자를 대신함
- @Setter : 앞서 엔티티 클래스는 테이블 그 자체, 이는 각각 멤버 변수는 해당 테이블의 컬럼을 의미하고, 컬럼에 대한 setter를 마음대로 생성하는 경우, 객체의 값이 어느 시점에 변경되었는지 알 수
  없음. 따라서 엔티티 클래스에서는 절대로 Set 메서드가 존재해서는 안 됨.
