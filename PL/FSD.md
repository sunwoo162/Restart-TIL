### FSD 아키텍쳐
```
구성 요소
    - Layers
        - slices
            - segments
    
Layers
- 상위레벨은 하위레벨을 의존성 가지기 ㄱㄴ
- 아래로 갈수록 추상화가 깊어지고 위로 올라갈수록 비즈니스로직이 커짐

    - app
        - 앱 설정을 맡는 레이어, 여러 모듈에서 재사용 x, 앱에 고루 영향을 미침
        - 즉 여기서만 쓰는거 모아두는거임
    - processes
        - deprecated 되어 이제 사용 안됨
        - deprecated : 가치가 떨어지다
    - pages
        - 하위 레이어들을 조합하여 완전한 기능을 제공하는 레이어로 앱에서 각 라우터에 해당하는 페이지들을 작성하는 곳
        - 각 페이지에서 사용하는 스타일 파일로 동일한 폴더에 위치 시킴
        - index.tsx에서 사용할 페이지들을 노출시킴
    - widgets
        - 하위의 레이어들을 이용해 특정 피쳐에서 사용할 수 있는 UI 블록을 만드는 곳
        - 불필요하다면 생략 ㄱㄴ
        - 특정 의존성과 강결합 되있음 -> 재사용 불가할수도
    - features
        - 버튼 클릭과 같은 유저의 인터렉션과 관련된 로직, 특정 비즈니스 레이어 ex) sendComment, AddTocart
    - entities
        - 특정 도메인과 연관된 api의 호출 함수가 정의 되있음
        - 특정 도메인의 모델을 정의하고 그와 연관된 api를 ghcnfgksms api 어뎁터를 작성함
    - shared
        - socket에서 소켓 연결이 되었는지를 참조할 수 있는 코드를 context로 만들고 entities/ chat-query.ts 내부에서 해당 shared/api/socket.ts의 소캣정보를 참조할 수 있게 함

slices
- 특별한 규칙 X, 비즈니스 도메인으로 이름 정해짐, 비즈니스와 연관된 로직 작성 O
- app, shared 레이어 : 앱의 전체적인 부분과 연관된 코드
- shared : 깊은 추상화, 비즈니스 로직 작성 X, slice X
- 여러 그룹의 세그먼트 가지기 O, 특정코드를 만들지 않고 배치자히 않음
- public api 정의 필요

    - user
    - post
    - comment

segments
- 한 도메인 안에서 기술적인 결과를 달성하기 위해 작성

    - ui
    - model
    - api
```