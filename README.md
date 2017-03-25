## Test

**eureka**를 우선 실행할것

**zuul**(edge server)을 통해 api서버를 호출
```
 http://localhost:8000/{APPLICATION NAME}
 
 ex) 
   http://localhost:8000/eureka-client/
   http://localhost:8000/eureka-other-client/
``` 

`/one` API는 `api-one`에만 존재함
```
 http://localhost:8000/eureka-client/one
```
> 위를 API를 호출하면, api-one이 호출될때는 정상응답하지만 api-two가 호출될때 `404`를 볼 수 있음

`zuul`서버 코드 중에 `/api1`, `/api2` API를보면 `restTemplate`이 URL대신 `APPLICATION NAME`으로 호출함
