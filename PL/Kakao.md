### 카카오 로그인 구조
    - 흐름
        1. 프론트 -> 카카오 로그인 요청
        2. 카카오 로그인 페이지 이동
        3. 로그인 성공
        4. Redirect URL로 돌아옴(https://myapp.com/oauth/kakao/callback) 이런식으로 지정해둔곳
        5. 백엔드가 code
        6. 사용자 정보 가져옴
        ```
        {
            "id": 123456,
            "kakao_account": {
                "email": "...",
                "profile": {
                    "nickname": "...",
                    "profile_image_url": "..."
                }
            }
        }
        ```
        이런식으로
        7. 서비스 로그인 처리
        8. DB에 사용자 저장
        9. JWT 발급
        10. 프론트에 전달
        11. AsyncStorage/SecureStore 저장