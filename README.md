# JD-Collector

JD 채용 공고 URL을 입력하면  
공고 텍스트를 추출해 CSV 파일로 변환하는 자동화 도구입니다.

취업 준비 과정에서 여러 채용 공고를 직접 확인하고  
엑셀이나 노션에 정리하는 과정을 **더 효율적으로 개선하고자**  
**분석 이전 단계의 전처리 자동화**를 목표로 제작했습니다.

---

## 🎯 Goal

- JD 정리 과정의 반복 작업 자동화
- 공고 비교·분석이 가능한 CSV 데이터 생성

---

## ❓ Problem

- 채용 공고는 플랫폼마다 형식이 달라 수작업 정리가 필요함
- 여러 공고를 비교하려면 내용을 복사해 직접 정리해야 함
- 분석 이전 단계(복사 → 정리 → 열 맞추기)에 시간이 많이 소요됨

이 프로젝트는  
**JD 분석 자체가 아니라, 분석을 위한 데이터 준비 과정 자동화**에 집중합니다.

---

## 💡 Solution

1. 채용 공고 URL 목록을 입력으로 받음
2. 공고 페이지 내 JSON-LD(JobPosting) 구조를 우선 활용
3. JD 정보를 아래 필드로 정규화
    - title
    - company
    - content
    - sourceUrl
4. 결과를 CSV 파일로 생성하여 반환

### JSON-LD 기반 파싱을 선택한 이유
- HTML 전체 파싱 대비 구조가 명확함
- 플랫폼 UI 변경에 비교적 안정적
- 채용 공고 핵심 정보가 이미 구조화되어 제공됨

---

### 설계 포인트
- 파싱 책임을 `JdParser` 인터페이스로 분리
- 플랫폼별 파서 확장 가능 구조
- CSV escape 처리 로직을 유틸 클래스로 분리

---

## 📄 CSV Output Example

> 실제 채용 공고를 기반으로 생성한 결과를  
> README에서는 익명화하여 예시로 표현했습니다.

| title | company | content | sourceUrl |
|------|--------|---------|-----------|
| Backend Engineer (Intern) | A사 | • 서비스 UX 설계 및 개발<br>• SOLID 기반 아키텍처 설계 | example.com/jd/1 |
| Backend Developer (Junior) | B사 | • API 개발 및 운영<br>• 데이터 연동 및 유지보수 | example.com/jd/2 |

---

## 🚀 How to Use

```bash
curl.exe -X POST http://localhost:8080/api/jd/collect \
  -H "Content-Type: application/json" \
  -d "{\"urls\":[\"https://example.com/jd1\",\"https://example.com/jd2\"]}" \
  -o jd.csv
```

## 🔮 Future Improvements

- 플랫폼별 파서 추가 (사람인, 잡코리아 등)
- 필수 스택 / 우대 스택 키워드 자동 분리
- JD 간 공통 기술 스택 비교 기능
- Web / App UI 기반 JD 관리 도구로 확장

## 📝 Note
이 프로젝트는 완성된 서비스 구현보다, 문제 정의와 구조적 해결 방식을 중심으로 설계되었습니다.