## 🔸 2022-10-31 월요일

## [스프링 부트 프로젝트]

### 1. JPA CRUD

- 보통 자바 코딩 시 new 키워드를 사용해 직접 객체를 생성하여 아래 `userRepository`로 안에 포함된 save(), count() 등의 메서드를 사용하였음

```java
    private UserRepository userRepsitory = new UserRepository();

    public void create() {
        userRepository.save();
        userRepository.count();
    }
```

<br>

- `@Autowired`란 Spring의 가장 큰 장점
- 대표적인 디자인 패턴
- DI(의존성 주입), Dependency Injection
- 직접 객체를 만들지 않고, 이러한 객체들을 Spring이 직접 관리하고, 의존성을 주입시키도록 함

<br>

- 과거 혹은 다른 프레임워크에서 데이터베이스 Insert 하는 경우
- String sql = insert into user (%s, %s, %d) value (account, email, age);
- 쿼리문을 갖고 값 들을 매칭시켜 실행하였음
- JPA의 장점은 Object들을 갖고 데이터베이스를 관리할 수 있음
- User라는 값 들을 DB에 매칭시키기 위해 User라는 객체 생성
- `User user = new User();`
- User는 DI가 관리하지 않는지 의문이 들 수 있는데 `DI`의 기본 핵심은 `Singleton` 패턴

<br>

- 이전에 작성한 DB 컬럼을 살펴보면, id는 Not Null, Auto Increment로 설정하였음
- 자동으로 데이터베이스에서 순차적으로 번호를 부여하기 때문에 번호를 임의로 넣지 않아도 됨
