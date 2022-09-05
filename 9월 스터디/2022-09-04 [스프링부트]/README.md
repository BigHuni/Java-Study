# 📌 Java Study

## 🔸 2022-09-04 일요일

## [스프링 부트 프로젝트]

### 1. JPA를 통한 CRUD

- 이전까지 학습을 통해 `@Repository` 생성
- 스프링 프로젝트 `src`에서 `main`은 핵심
- `test`는 `main` 패키지가 동일하고, `main`에서 작성한 코드를 테스트하는 패키지
- 보통 자바 코딩 시, `private UserRepository userRepository = new UserRepository();`
- `new`를 붙여 직접 객체를 만들어서 userRepository를 가지고, 그 안에 속한 메서드를 사용했음
- `@Autowired` => Dependency Injection(DI) - 스프링의 장점
- 사용자가 직접 객체를 만들지 않고, 스프링에서 직접 관리
- 따라서 `new`를 사용하지 않고, `@Autowired` 선언 후 `private UserReposioty userRepository`
- 메서드로 직접 쿼리문으로 `String sql = insert into user (%s, %d) value (account, age);` 식으로 넣었지만,
- JPA의 장점은 Object로 데이터베이스를 관리할 수 있게끔 도와주는 Tool
- DI의 기본 핵심 singleton 패턴, 따라서 메서드에서는 `new` 키워드 사용해서 작성

<br>

![mysql_id](https://user-images.githubusercontent.com/79084294/188468822-d281d42e-900d-4bbc-9bce-c326fb3ab97a.png)

- 주의해야할 점 : DB MySQL의 컬럼 속성들을 살펴보면, id 경우 NOT NULL과 Auto Increment 타입
- Auto Increment 타입에 해당하는 컬럼은 Id 지정을 하면 안 됨(DB에서 자동 순차적으로 번호를 올릴 것이기 때문)

<br>

- `userRepository.save(user);`, save() 메서드는 save 앞을 상속받아서 리턴
- `User newUser = userRepository.save(user);`
- user을 넘기고, DB에 저장된 newUser 객체가 리턴됨
- `User newUser` 객체는 이전에 지정하지 않았던 id까지 달고 나옴
