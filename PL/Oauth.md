### OAuth
    -정의
        - 다른 서비스 계정으로 로그인하게 해주는 기술
        - ex: 카카오 로그인
    - Authorization Code Flow
        - 흐름
        1. 사용자가 카카오 로그인을 클릭
        2. 카카오 로그인 페이지로 이동
        3. 로그인 성공
        4. 인가 코드 받음
        5. 서버가 code로 Aceess 토큰 요청
        6. 토큰으로 사용자 정보 요청
    - 인가 코드
        - 역할
            - 로그인 성공 후, 잠깐 쓰는 임시 인증 티켓
            - 즉 사용자가 로그인했다는 걸 증명해주는 1회용 코드
            - 바로 토큰을 줘서 탈취당하면 위험하기 때문에 필요한거임
        - 작동 방식
            - https://your-app.com/callback?code=abc123 이렇게 해서 로그인 했다는걸 알려줌
            - 서버가 POST /oauth/token 이런식으로 Access 토큰을 요청
            - 토큰 발급
    - 요약
        - 인가 코드 → 토큰 → 사용자 정보 

---
OAuth2.0 인증
        - 신뢰할 수 없는 네트워크 환경에서 제 3자 서비스에게 인증정보를 넘기지 않고 하나의 아이디로 여러 서비스에서 사용가능하게 하는 sso 인증 프레임 워크
        - 흐름
            1. client가 resource owner에게 보호된 자원에 접근하기 위해 인증 요청을 전달한다.
            2. Resource Owner는 권한 부여 동의서를 발급한다(RFC의거 4가지 유형)
            3. 권한 부여 방식에 따라 Authorization server측에 인증 및 접근 토큰을 요청함
            4. Resource owner에게 접근 할 수 있는 범위 및 기간등의 정보가 담긴 접근 토큰을 제공
            5. client는 토큰을 통해 resource server에 보호된 자원을 요청
            6. resource server는 접근 토큰에 담긴 자원 접근 범위 및 유효기간을 확인하며 자원을 제공함
        
        - 용어정리
            1. resource owner - 보호자원에 대해 액세스 권한을 부여할 수 있는 소유자(사용자)
            2. client - resource owner의 보호된 자원에 대한 접근을 요청하는 응용 프로그램 혹은 서비스
            3. resource server - 보호된 자원을 관리하는 서버, authorization server를 통해 부여받는 access token을 통해 보호된 자원을 요청
            4. authorization server - client 에서 resource owner에 대한 인증과 권한 부여하는 서버 access token 발급

        - 4가지 Grant Type
            - Authorization Code(승인 코드 유형)
                - 주로 신뢰할 수 있는 서버사이트 서비스가 존재하는 웹 혹은 모바일에서 사용됨
                - Authorization server 통해 인증 -> code를 callback URL로 전달 받음 -> Access Token 요청
                - 장점 : 인증 토큰을 User - Agent에 노출하지 않고 Client에 직접 전송 (보안적 이점)
            - lmplicit (암묵적 유형)
                - Authorization 방식과 동일하게 사용자에게 로그인 및 권한 동의를 요구하는 방식
                - code가 아닌 인증 토큰을 바로 전달함(모바일 앱이나 SPA 기반 웹 형태에 적합하도록 설계된 방식)
                - 인증 토큰 획득 왕복 횟수 줄어듦 -> 효율 좋아짐 but 인증토큰 User-Agent에 그대로 노출  -> 토큰 만료기간 줄이거나 신뢰 높은곳에서 해야함
            - Resource owner password credentials (사용자 비밀번호 인증)
                - Resource owner 가 Authorization Server에 위임하지 않고 직접적으로 인증토큰을 요청하는 방식(기존 웹 로그인 방식)(client -> 운영체제거나 신뢰하는 곳에서 사용)
            - Cilent Credentials(클라이언트 자격증명)
                - client가 Authorization server에게 부여받은 서비스 정보를 통해 직접적으로 인증 토큰을 발급받는 형식
                - client = 애플리케이션 = Resource Owner 즉 서버 간의 인증 때 사용 -> 외부 노출 X
            - Refresh Token(인증 토큰 재발급)
                - 기간이 만료된 인증토큰을 재발급 받기 위한 인증 방식
---

<<<<<<< HEAD
```
=======
```
>>>>>>> 34918ee (error)
