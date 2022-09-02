# 📌 Java Study

## 🔸 2022-09-01 목요일

## [스프링 부트 프로젝트]

### 1. JPA

- MySQL Workbench DB 생성
- 스키마 생성 후 테이블 생성
- 테이블 컬럼 설정

![MySQL_study](https://user-images.githubusercontent.com/79084294/188127095-f2305b80-23f4-4ad3-8dcb-67a63ecd7856.png)

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

- 처음 생성 시 없을 수 있으니 NULL 허용이 맞지만
- `created_at`와 `created_by`는 생성이 되면 반드시 생성한 사람과 시간이 존재하기 때문에 NOT NULL

<br>

### 2. MySQL Workbench 테이블 세팅 시 열 플래그 의미

- `PK(Primary Key)` - 테이블에서 특정 row 하나를 식별하는 역할, 특정 row를 고유하게 나타낼 수 있는 값
- `NN(NOT NULL)` - NULL이 아님, PK와 함께 반드시 하나의 값을 가지고 있어야 하고, 빈 값을 가지면 안됨
- `BIN(이진)` - 데이터를 이진 문자열로 저장. 문자 집합이 없으므로 정렬 및 비교는 값에 있는 바이트의 숫자 값을 기반으로 함
- `UN(부호 없음)` - 음수가 아닌 숫자 만 해당. 범위가 -500 ~ 500 인 경우 대신, 0 ~ 1000 인 경우 범위는 동일하지만 0에서 시작
- `UQ` - 고유 키 생성 / 제거
- `ZF` - 0으로 채워짐. 길이가 INT(5)와 같이 5인 경우, 모든 필드는 5번째 자리까지 0으로 채워짐. (12 = 00012, 400 = 00400 등)
- `AI(Auto Increment)` - 해당 컬럼에 대해서 DBMS가 `자동으로 증가`하는 값을 넣어줌
- PK가 Surrogate Key인 경우에는 보통 이런 식으로 Auto Increment 속성이 설정되어 있을 때가 많음
- `G` - 생성 된 열. 즉, 다른 열을 기반으로하는 수식에 의해 생성 된 값

<br>

### 3. MySQL Workbench 세팅 후 IntelliJ 설정

- build gradle에 dependency 추가
- `implementation 'org.springframework.boot:spring-boot-starter-data-jpa'`
- `implementation 'org.springframework.boot:spring-boot-starter-web'`
- `testImplementation 'org.springframework.boot:spring-boot-starter-test'`
- `runtimeOnly 'mysql:mysql-connector-java'`
- resources - application.properties에 스프링 프로젝트의 추가된 라이브러리 설정 관리

<br>

### 🔖 Spring의 application.properties 설정

```
# db source url
spring.datasource.url=jdbc:mysql://localhost:3306/study?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true

# db response name
spring.datasource.username=root

# db response password
spring.datasource.password=********

spring.jpa.show-sql=true

spring.jackson.property-naming-strategy=SNAKE_CASE
```

- `spring.datasource.url` => DB와 어떠한 주소로 연결할 것인지 설정
- 로컬로 DB-MySQL을 설치했기 때문에 localhost이고, 기본 MySQL 포트 3306 사용
- 그 뒤 `study`는 스키마를 의미
- mysql username은 `root`
- mysql password는 mysql 8버전 이상부터 password의 더 강력한 규칙이 적용되면서 LOW로 설정하더라도 8자 이상 password 설정해야 함

<br>

### 🔖 DB MySQL - Spring 간 커넥션 정상 확인

![DB-Spring 정상 커넥션](https://user-images.githubusercontent.com/79084294/188153528-262b532b-6dca-49ef-bc66-139c10590dc9.png)
