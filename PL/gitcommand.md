# 깃 명렁어 모음
평소에 미루다가 드디어 적게되었다. 내 파일을 날려먹어서 이전 상황으로 코드를 돌려야하는 그런 상황이 나에게 갑자기 찾아왔기 때문이다.
$^*#@$^&*%^*@#^%&(&#)
그럼 알아보자

- pwd : 현재 위치 경로 확인
- ls : 현재 디렉터리에 있는 파일 확인
```
-l : 파일과 디렉터리의 상세 정보까지 표시
-a : 숨긴 파일과 디렉터리를 표시
-r : 파일의 정렬 순서를 반대로 표시
-t : 파일 작성 시간 순으로 표시
```
- cd : 디렉터리 사이를 이동
```
~ : 현재 접속중인 사용자의 홈 디렉터리
./ : 현재 사용자가 작업중인 디렉터리
../ : 현재 디렉터리의 상위 디렉터리
```
mkdir : 현재 디렉터리 안에 하위 디렉터리를 만듦
rm -r : 디렉터리 삭제, -r을 붙이면 하위 디렉터리와 파일까지 함께 삭제
git init : 초기화
git status : 깃 상태를 확인
git add : 스테이징
```
On branch master : 현재 master 브랜치에 있다.
No commits yet : 아직 커밋한 파일이 없다.
nothing to commit : 현재 커밋할 파일이 없다.
```
git commit -m '커밋 메시지' : 커밋
git log : 저장소에 저장된 버전 확인
git commit -am '커밋 메시지' : 스테이지에 올리고 커밋하는 과정을 한 번에 처리, 한 번이라도 커밋한 적 있어야 사용 가능

---

git log : 현재까지 커밋했던 기록 살펴보기
git log --stat : 커밋에 관련된 파일 확인
git log --online : 커밋을 간략히 확인할 때
git diff : 변경사항 확인
git commit --amend : 방금 커밋한 메시지 수정

---

git checkout : 작업트리에서 수정한 파일 되돌리기
git reset HEAD 파일이름 : 스테이징 되돌리기
git reset HEAD^ : 최신 커밋 되돌리기, 취소한 파일은 작업 트리에 남음
git --soft HEAD^ : 최근 커밋을 하기 전 상태로 작업 트리를 되돌림
git --mixed HEAD^ : 최근 커밋과 스테이징을 하기 전 상태로 작업 트리를 되돌림
git --hard HEAD^ : 최근 커밋과 스테이징, 파일 수정을 하기 전 상태로 작업을 되돌림
git reset 커밋 해시 : 특정 커밋으로 되돌리기 -> 이후에 만들어진 커밋을 삭제하고 특정 커밋으로 이동함
git revert 커밋 해시 : 커밋 삭제하지 않고 되돌리기

---

git branch : 브랜치를 만들거나 확인하는 명령
git branch <만들 브랜치 이름> : 새로운 브랜치를 만듦
git checkout : 브랜치 사이 이동하기
git checkout <만들 브랜치 이름> : 새로운 브랜치 만들고 해당 브랜치로 이동

---

git log --online --branches : 각 브랜치의 커밋을 함께 확인
git log --online --branches --graph : 브랜치와 커밋의 관계를 그래프로 형채로 표시
git log master ..<브랜치 이름> : 브랜치 사이의 차이점 확인

---

git merge <브랜치 이름> : 브랜치 병합
git merge <브랜치 이름> --no-edit : 깃에서 지정하는 커밋메세지를 그대로 사용
git merge <브랜치 이름> --edit : 커밋 메세지를 추가하거나 수정할 때 사용

---
### 병합이 끝난 브랜치 삭제

git branch : 현재 저장소에 어떤 브랜치가 있는지 확인
git checout master : master로 이동
git branch -d <삭제할 브랜치 이름>

---

git remote add origin <깃허브 저장소 주소> : 지역 저장소를 원격 저장소에 연결
git remote -v : 원격 저장소 연결 여부 확인
push : 지역 저장소의 소스를 원격 저장소로 올리는 것
pull : 원격 저장소에서 지역 저장소로 내려받는 것
git push -u origin master : -u 옵션은 지역 저장소의 브랜치를 원격 저장소의 master 브랜치에 연결하기 위한 것으로 처음 한 번만 사용됨
git commit -am <커밋할 메시지> : 스테이징과 커밋을 한꺼번에 실행한다. 스테이징 : a, 메시지 -m
git pull origin master : 기본 저장소가 origin 이고 지역 저장소의 기본 브랜치가 master이기 때문에 git pull만 입력해도 됨

---

git clone : 복제
git clone <복사본 주소><작업할 디렉터리>
git pull : 원격 저장소의 최신 커밋을 지역 저장소에 합쳐줌
git fech : 원격 저장소의 정보를 가져오는 기능

