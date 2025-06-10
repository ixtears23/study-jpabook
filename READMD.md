# JPABOOK 예제 프로젝트

로컬 개발 환경에서 **Docker + H2 DB**로 바로 구동할 수 있는 스프링 부트 예제입니다.  
`docker-compose`로 데이터베이스를 띄운 뒤 애플리케이션을 실행하면 됩니다.

---

## 준비 사항
- Docker / Docker Compose
- JDK 8 이상
- Gradle (Wrapper 포함)

---

## 1. H2 데이터베이스 컨테이너 기동

```bash
# 백그라운드(-d) 모드 권장
docker-compose up -d h2db
```
> docker-compose.yml은 H2 2.2.224 이미지를 사용하며  
기본 경로 /opt/h2-data에 볼륨을 마운트합니다.

## 2. 애플리케이션 설정 확인
`src/main/resources/application.yml`
- 왜 ./jpashop인가?  
  H2 2.x부터는 보안 강화를 위해 -baseDir(= /opt/h2-data) 바깥 파일 접근이 금지됩니다.   
  / 대신 ./를 써서 같은 디렉터리에서 DB 파일(jpashop.h2.db)을 생성하도록 합니다.

## 3. 애플리케이션 실행

**Gradle CLI**  
```bash
./gradlew bootRun
```
**IDE 실행**  
`junseok.snr.study.jpabook.JpabookApplication`  
(Main 메서드에서 우클릭 → Run)

4. H2 웹 콘솔 접속 (선택)

