# 📌 Java Study

## 🔸 2022-08-29 월요일

## [스프링 부트 프로젝트]

### 1. Get Method

- 검색할 때 여러가지 파라미터를 받을 수 있음
- 예를 들면, 계정, 이메일, 키워드, 등 검색 파라미터 존재
- `@RequestParam`으로 account, email 등을 계속해서 받아올 수는 없음
- 패키지를 새로 생성 후 자바 클래스를 만든 뒤, account, email 등 받을 수 있는 개체들을 따로 만듬
- Eclipse 기능 처럼 `인텔리제이 - 코드 - 생성 - getter&setter`로 자동 생성 기능 사용

<br>

- SearchParam 클래스

```java
    package com.example.study.model;

public class SearchParam {

    private String account;
    private String email;
    private int page;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
```

<br>

### 🔖 getMultiParameter 코드

- 컨트롤러에 해당 값 맵핑

```
    // Localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public String getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return "OK";
    }
```

<br>

### 🔖 getMultiParameter 출력 확인

![getMultiParameter](https://user-images.githubusercontent.com/79084294/187440485-76d3deb6-2759-4797-9f4e-a67fbcd2615d.png)

![getMultiParameter1](https://user-images.githubusercontent.com/79084294/187440967-36be36aa-7c81-492b-8f33-330704e1c50e.png)

<br>

- 이처럼 3개 이상 다수의 RequestParameter가 있다면, 따로 클래스를 파서 직접 받는 방법도 있음
- `GetParameter`를 이용하여 문자열을 받아오는 것을 진행함
- 네트워크 통신을 할 때, JSON 형태로 하는 것으로 알고 있음
- `{"account" : "", "email" : "", "page" : 0}`

<br>

### 🔖 JSON 형태로 값 받아올 수 있도록 수정

```
    // Localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //  {"account" : "", "email" : "", "page" : 0}
        return searchParam;
    }
```

<br>

### 🔖 JSON 형태로 값 브라우저 확인

![JSONResult](https://user-images.githubusercontent.com/79084294/187443022-d9b039d1-c9f5-4401-8a05-51c30109e550.png)

- 기존에 Servlet 또는 스프링에서 개발할 때, JSON 라이브러리를 직접 Maven gradle을 통해서 가져온 뒤 변환
- 객체를 직접 JSON 라이브러리를 통해 JSON 형태로 변경후 리턴
- 요즘 http 통신 규격에서 JSON을 표준처럼 사용하기 때문에 스프링부트에서 기본적으로 JSON 라이브러리가 내장되어 있음
- Get 메서드를 매칭(Mapping) 시켜주고, Request에 대한 Parameter를 받아오고, 데이터를 처리한 뒤 JSON 형태로 내리는 것이 핵심
- Get 메서드의 쿼리 파라미터(검색 파라미터)에 대해 어떻게 처리할 것인지 학습
- 이후 get에 대해 학습할 것은 주소창에 파라미터 노출된다는 것
- 브라우저에서 주소에 대한 캐시가 이루어지므로 다음에 똑같은 요청을 할 때, 빠르게 캐시된 값을 가져올 수 있음
