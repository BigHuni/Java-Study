# 📌 Java Study

## 🔸 2022-08-30 화요일

## [스프링 부트 프로젝트]

### 1. Post

- 주소 창에 파라미터가 노출되지 않음
- Get 방식과 다르게 보안이 존재
- Post는 HTML에서 `<Form>` 태그 사용, Ajax에서 비동기로 검색할 때 사용
- 즉,검색 파라미터가 많다는 것을 의미
- 이전 학습에서 `GetMethod`의 `SearchParam`의 값으로 account, email, page로 지정하였음
- Post 메서드에다가 `searchParam`으로 파라미터를 받으면 될 것 같지만, 그렇게 하는 것이 아니라 `@RequestBody`로 받게끔 설정
- http 통신을 할 때, post body에다가 data를 집어넣어서 보내겠다고 선언
- 즉, `@RequestBody`에 `SearchParam` 값을 매칭시킴
- 여러 가지 타입(`json`, `xml`, `multipart-form / text-plain`)으로 올릴 수 있음
- 형식을 `@PostMapping(value = "/postMethod", produces = {application-Json})` 처럼 지정할 수 있음
- 기본적으로 json을 사용하기 때문에 `@PostMapping(value = "/postMethod")` 이렇게 사용

<br>

- Rest Client Tool 크롬 확장프로그램 설치(Talend API Tester)
- 이미 개발한 Get 방식의 `http://localhost:8080/api/getMethod`을 기입하면, 아래와 같이 정상 통신 Response 상태(200)와 상세한 헤더 등의 정보를 확인할 수 있음

![getMethod](https://user-images.githubusercontent.com/79084294/187621959-0b7cd127-13ac-466f-9411-a2635561e8ed.png)

<br>

- PostMethod

````
    @PostMapping(value = "/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam) {
        return searchParam;
    }
````

- PostMethod에 `@RequestBody`로 들어온 `searchParam`을 받아서 그대로 리턴
- Body에 요청한 내용이 정상적으로 리턴되는 것을 확인할 수 있음

![postMethod](https://user-images.githubusercontent.com/79084294/187622844-5b9c687b-b690-469f-97cf-b84b447aa600.png)

- 하나하나 분석해보면, Tool의 Post Method는 코드의 `@PostMapping`
- 주소는 `/api`의 `/postMethod`
- Header는 데이터를 보낼 때, Content-Type을 `application/json`
- `@RequestBody`에는 Body의 json으로 기입한 내용이 전달
- 요청이 들어왔을 때, 스프링에서는 헤더 값을 보고 `application/json`을 확인하고,
- `@RequestBody`의 json 값들을 SearchParam의 객체(account, email, page)에 가서
- {"account" : "", "email" : "", "page" : 50} 이러한 양식으로 값이 들어올텐데
- 각 객체(account, email, page)에 맵핑시켜줌
- 해당 맵핑된 객체(searchParam)를 리턴할 때도 SearchParam 객체에 가서 json 형태로 바꿔준 다음에 리턴

<br>

- 그 이외에 PUT / PATCH Method 존재
- POST와 마찬가지로 Body에 데이터가 들어 있으며, 주로 업데이트에 사용함
- `업데이트` => DB의 특정 자원을 업데이트 시킬 때, POST Body에 해당 데이터 내용을 넣어서 업데이트 요청
- DELETE Method는 Get 과 마찬가지로 주소에 파라미터가 들어가며, 데이터를 삭제할 때 사용

<br>

### 2. REST

- HTTP 프로토콜에 있는 Method를 활용한 아키텍처 스타일
- HTTP Method를 통해서 Resource를 처리
- CRUD를 통한 Resource 조작할 때 사용

| HTTP Method   | 동작  | URL 형태 |   
|:--------------|:--------------------|:----------------------------------------------------| 
| `GET`         | 조회(SELECT * READ)   | /user/{id} |
| `POST`        | 생성(CREATE)          | /user |
| `PUT / PATCH` | 수정(UPDATE) * CREATE | /user |
| `DELETE`      | 삭제(DELETE)          | /user/{1} |
