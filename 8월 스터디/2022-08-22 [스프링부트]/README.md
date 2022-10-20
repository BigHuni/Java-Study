# 📌 Java Study

## 🔸 2022-08-22 월요일

## [스프링 부트 프로젝트]

### 1. Spring 초기

- 이전 `http://localhost:8080/api/getMethod`을 통해 나온 크롬 페이지에서 검사
- network - Disable cache - 새로 고침

<br>

### 🔖 http://localhost:8080/api/getMethod 검사 network

![network1](https://user-images.githubusercontent.com/79084294/185967690-4d261e03-34f9-44aa-a5af-a5af560d8b93.png)

![network2](https://user-images.githubusercontent.com/79084294/185967708-9fe97e49-03db-4e1b-9b14-c92a2a4b20e0.png)

- Request Method 방식으로 GET 방식
- Status Code 값으로 `정상 통신`을 의미하는 코드 200
- Response 탭에서 정상적으로 `Hi getMethod` 출력을 확인할 수 있음

<br>

- 사용자가 서버에 Http 통신을 통해 데이터를 요청하였고, 서버는 `Hi getMethod`라는 텍스트를 Http를 통해 Return
- 위 일련의 과정이 통신
- 앞으로 admin 프로젝트에서 사용자 또는 서버가 Http 통신을 통해서 특정한 데이터를 요청하면, 서버에서 DB 혹은 가지고 있는 자원을 통해서 데이터를 가공한 후에 사용자가 요청한 JSON, XML,
  HTML, CSS 등의 여러 자료 형태로 Response 하는 것이 개발 목표

<br>

- Http - GET Method에 대해서 더욱 구체화
- 요청한 주소 뒤에 파라미터가 붙어있음(http://localhost:8080/api/getMethod)
- 현재 개발한 코드에서는 파라미터를 전혀 읽어올 수 없음
- 즉, 사용자 요청에 대해서 어떠한 값이 들어왔는지 확인 불가능
- getParameter() 메서드를 생성 후 Annotation(@) `GetMapping` 작성
- `GetMapping`은 메소드를 지정하지 않아도 되고, 주소만 설정해도 됨
- 스프링에서 이 값을 받아내기 위해 `@RequestParam` 사용
- `public String getParameter(@RequestParam String id, @RequestParam String password)`

<br>

### 🔖 GetParameter 코드

```java
  package com.example.study.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")   // Localhost:8080/api 까지 주소 매칭
public class GetController {

    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")  // Localhost:8080/api/getMethod
    public String getRequest() {

        return "Hi getMethod";
    }

    @GetMapping("/getParameter")  // Localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam String password) {

        System.out.println("id : " + id);
        System.out.println("password : " + password);

        return id + password;
    }
}
```

<br>

### 🔖 GetParameter 출력 확인

![getParameter](https://user-images.githubusercontent.com/79084294/185971643-b1efc262-4a80-472d-b71c-e0b3135b4d0c.png)

<br>

- 작업하다보면, 지역 내 password 사용 가능(예 : `String password="aaaa";`)
- 하지만, 스프링에서 RequestParam으로 들어올 수 있는 값에 대해서는 로컬 변수를 사용하지 않는 것을 권장
- 어쩔 수 없다면, 파라미터 값으로 @RequestParam String password를 pwd로 변경하여 사용해야 됨
- 이렇게 되면, 스프링에서 웹에서 호출한 password와 파라미터 값으로 들어간 pwd 가 변수명이 같지 않아 해당 값을 맵핑 할 수 없음
- `@RequestParam(name = "password") String pwd` 가능
- @RequestParam은 password 라는 이름으로 들어올 것이다라고 알려줄 수 있음
- 따라서 password 값을 pwd에 넣어줄 수 있음
- 위 결과 값과 동일한데, pwd로 받았지만, name을 `password`라고 알려주었기 때문에 주소 창에 있는 password와 @RequestParam의 password가 매칭이 되어 해당 값이 세팅
