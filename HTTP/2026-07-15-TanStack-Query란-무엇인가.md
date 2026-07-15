# TanStack Query란 무엇인가

- 과목: 프론트
- 날짜: 2026-07-15
- 생성: 2026-07-15T02:17:45.841Z
- 수정: 2026-07-15T14:38:57.851Z

## 세부 내용

### TanStack Query란 무엇인가
사용자 목록을 가져옴 -> 시간이 지나고 프로젝트가 커짐 -> 구현해야될게 증가함
ex)같은 API를 여러 컴포넌트에서 호출, 로딩 상태관리, 에러 처리, 데이터 다시 불러오기, 캐시 관리, 새로고침 시 최신 데이터 유지
이걸 대신 해주는 라이브러리

### 개념
---
1. Query
- Query란?
 - 서버에서 데이터를 조회하는 작업
- 사용방법
```
const { data } = useQuery({
  queryKey: ["users"],
  queryFn: getUsers,
});
```
---
2. QueryKey
- QueryKey란?
 - 캐시 이름
 - ex) queryKey: ["users"] users라는 이름으로 저장하는거
- 왜 사용?
 - API를 다시 호출 X 이미 저장된 데이터 가져옴
 - 서버 -> 한 번만 요청 -> 캐시(여기서는 이름이 users겠죠) -> 컴포넌트 이런 식으로 진행됨
---
3.  캐시(Cache)
- 캐시란?
 - 잠깐 저장해두는 공간
 - ex) 홈 화면에서 GET /users를 호출 -> 데이터가 배순우라고 가정하면 TanStack Query는 users에 배순우라는 데이터를 넣고 이걸 메모리에 저장함 ->다른 페이지에서
```
useQuery({
    queryKey:["users"]
})
```
이렇게 호출하면 API를 다시 호출하지 않고 캐시를 꺼내서 바로 보여주는거임
---
4. staleTime
- staleTime이란?
 - 데이터 유통기한
 - ex)  staleTime: 10000이면 10초 동안 이 데이터는 최신이야 라고 생각함
 - 10초가 지나면 데이터가 오래됬다고 판별하고 필요하면 다시 서버 호출함
5. queryFn
- queryFn이란?
 - 실제로 API를 호출하는 함수
 - ex)
```
const getUsers = async () => {
  const res = await fetch("/api/users");
  return res.json();
};
```
```
 useQuery({
  queryKey: ["users"],
  queryFn: getUsers,
});
```
이런 식으로 사용함
6. refetch()
- refetch()란?
 - 강제로 다시 가져오기
 - 새로운 데이터를 가져오고 싶을 때 사용함
 - ex) 
```
const { refetch } = useQuery(...)
```
이런 버튼을 누르면
```
<button onClick={() => refetch()}>
```
이런 식으로 API를 다시 호출함
7. select
- select란?
 - API에서 받은 데이터를 원하는 형태로 바꿔줌
 - ex)
```
[
  {
    "name":"배순우",
    "age":18
  }
]
```
라는 데이터가 있을때 
```
select: data => data.map(user => user.name)
```
이렇게 가공해서 
```
[
 "배순우"
]
```
이런식으로 원하는 형태만 사용하게 해주는 기능이다
8. Mutation
- Mutation이란?
 - POST, PUT, PATCH, DELETE처럼 데이터를 변경하는 작업임
 - ex)회원가입, 게시글 작성, 좋아요, 댓글 삭제, 프로필 수정
