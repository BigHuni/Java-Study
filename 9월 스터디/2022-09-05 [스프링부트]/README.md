## 🔸 2022-09-05 월요일

## [스프링 부트 프로젝트]

### 1. JPA를 통한 CRUD

- create() 메서드 작성

```
    @Test
public void create(){
        User user=new User();
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser=userRepository.save(user);
        System.out.println("newUser : "+newUser);
        }
```

- 결과 : `newUser : User(id=1, account=TestUser01, email=TestUser01@gmail.com, phoneNumber=010-1111-1111,
  createAt=2022-09-05T22:02:13.771, ~ )`
- 결과가 깔끔하게 출력되는 것은 `User.java`에 `@Data` 어노테이션 붙이면, Lombok으로 자동 toString()을 만들어 주어 어떤 값이 들어있는지 확인할 수 있음

<br>

- CRUD
    - 거의 대부분의 소프트웨어가 가지고 있는 기본적 데이터 처리 기능
    - `Create`(데이터를 생성 또는 저장하는 기능, `SQL의 insert`)
    - `Read`(저장된 데이터를 읽는 기능, `SQL의 select`)
    - `Update`(저장된 데이터의 값을 새롭게 갱신하는 기능, `SQL의 update`)
    - `Delete`(저장된 데이터를 삭제하는 기능, `SQL의 delete`)

<br>

- JPA를 사용하여 Data 이용하려면, `Model`과 `Entity`, `JpaRepository`를 알아야함
- MVC 디자인 패턴에서 모델은 데이터에 해당하는 부분, 서비스의 정보, 데이터
- 정보의 가공을 위한 컴포넌트
- 이 모델 안에서 JPA를 이용하여 데이터를 관리하고 처리
- JPA는 이 Entity라는 컴포넌트를 확인하여 해당 Entity를 토대로 데이터를 생성하고, 처리 및 가공
- Entity는 소위, 데이터베이스의 Table 명
- 엔티티를 사용하기 위해서 해당 클래스가 Entity라는 것임을 Spring에게 알려줘야 하는데 그 역할을 하는 것이 `@Entity`

<br>

- Entity 등록
  -
        1. DB 테이블 이름과 Entity 클래스 이름과 같은가?

        - 꼭 같아야만 하는 것은 아님, 만약 같다면 `@Entity(name="user")`에서 name 부분을 배고 사용이 가능(@Entity)
    -
        2. Primary Key가 존재하는가?

        - Primary Key가 있다면, 해당 필드에 `@Id`와 `GeneratedValue(strategy = generationType.IDENTIFY)` 두 어노테이션을 추가해서 MySQL 전략을
          사용할 것을 알려주기
    -
        3. DB 테이블의 필드명과 Entity 클래스의 필드명이 같은가?

        - 만약 다르다면, @Column(name = DB에 있는 필드명)` 어노테이션을 사용하여 맞춰주고, 없으면 생략
    -
        4. getter/setter 사용을 위해 Lombok 사용(`@Data`)

<br>

- 이전까지 `Model`, `Entity` 학습, 마지막 `JpaRepository`
- Repository의 정확한 사용은 DAO를 위해 사용하는 어노테이션인데 Jparepository는 JPA의 구현체
- JPA를 사용하는 궁극적인 이유는 데이터의 효율적인 저장, 처리 및 가공
- 데이터의 효율적인 처리를 위해 JPA는 기본적인 CRUD가 정의되어 있는 JpaRepository를 구현
- 사용자들은 그 구현체를 상속하여 사용하는 것
