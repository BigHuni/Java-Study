# 📌 Java Study

## 🔸 2022-08-21 일요일

## [스프링 부트 프로젝트]

### 1. Spring 초기

- 사용자로부터 접속을 받아내기 위해 주소를 설정
- 주소의 묶음인 Cotroller package 생성
- 패키지 하위로 GetController 생성
- 스프링에게 이곳을 Cotroller로 활용한다는 것을 인지시키기 위해 지식자 Annotation(@) `RestController` 생성
- 이곳으로 들어올 api 주소를 맵핑하기 위해 `RequestMapping` 생성
- `@RequestMapping("/api")`
- api로 지정하게 되면 localhost:8080 포트에 api까지 주소가 매칭

<br>

- 사용자의 요청을 한 가지 메서드로 받아들일 수 있음
- `public String getRequest() { }`
- `@RequestMapping(method = RequestMethod.GET, path = "/getMethod")`을 통해 GET 타입으로 받아들이고, getMethod 주소로 받아들이겠다고 선언
- `localhost:8080/api/getMethod` 라는 주소로 호출하게 되면 사용자의 요청이 getRequest() 메서드로 들어오게 됨
- 위 요청이 들어오면, `Hi getMethod` 라는 문자를 출력하도록 함
- 개발한 코드에 대해 검증할 수 있는 방법은 여러가지 존재(JUnit 테스트, 웹 브라우저 방식, REST Client Tool 등)
- 웹 브라우저 방식으로 직접 호출해서 응답이 오는지 확인함

<br>

````java
    package com.example.study.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")   // Localhost:8080/api 까지 주소 매칭
public class GetController {
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")  // Localhost:8080/api/getMethod
    public String getRequest() {

        return "Hi getMethod";
    }
}
````

<br>

### 🔖 localhost:8080 호출

![hi_getMethod](https://user-images.githubusercontent.com/79084294/185871973-2682c533-b1d0-4f2a-bf61-475ad141ed4c.png)

<br>

### 🔖 빌드과정 오류 발생 & 해결

![오류](https://user-images.githubusercontent.com/79084294/185873489-ebea7dea-081c-4c2c-baac-a22277c00a18.png)

- Intellij에서 "o.s.b.d.LoggingFailureAnalysisReporter" 에러 발생
- 해결 방법 : `main - resources - application.properties`에 아래 코드 추가

```
    spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
```
