# Feature

- Raw Data 읽기 > Data 가공 > 가공 Data 쓰기
- Data 가공: Raw data * 100
- Batch를 Rest API로 실행한다.
    - Request body: jobName
    - Batch는 Async로 실행된다.

## 도메인: Batch Job

### 기능

- Batch 작업(Job)을 관리한다.
- 실행 시간, 종료 시간, 상태를 기록한다.
- 상태는 '대기', '진행', '완료', '실패'
- 여러 Step을 가진다.

### Entity

- id
- jobName: Job 이름
- startTime: 실행 시작 시간
- endTime: 실행 종료 시간
- status: 실행 상태
- BatchStep: 1:N Step

## 도메인: Batch Step

### 기능

- Batch Job의 개별 Step을 관리한다.
- Step별 상태, 실행 시간을 기록한다.
- 상태는 '대기', '진행', '완료', '실패'

### Entity

- id
- stepName: Step 이름
- startTime: Step 시작 시간
- endTime: Step 종료 시간
- status: Step 상태
- BatchJob: N:1 Batch Job

## 도메인: Raw Data

### 기능

- 원본 데이터를 저장한다.

### Entity

- id
- rawAmount: 원본 데이터 내용
- createdAt: 생성 일시
- ProcessedData: 1:1 가공 데이터

## 도메인: Processed Data

### 기능

- 가공된 데이터를 저장한다.

### Entity

- id
- processedAmount: 가공된 데이터 내용
- createdAt: 생성 일시
- RawData: 1:1 원본 데이터
