# Prompt for Batch processor

# Feature

- Name: Example
- API는 Trigger API만 생성, Entity는 Batch 내부에서 사용하므로 Entity에 관련한 API는 생성하지 않는다.

## Trigger API

### Example Batch 실행 API

POST
/api/batch/example/run

## Trigger Scheduler

## Batch Job

```mermaid
flowchart TD
    A[Batch Job Trigger API] --> B[Step 시작]
    B --> C[Chunk 반복]
    C --> D[Reader<br/>DB에서 원본 데이터 조회]
    D --> E[Processor<br/>1. 비즈니스 로직]
    E --> F[Writer<br/>DB에 가공 데이터 저장]
    F --> G{다음 Chunk 존재?}
    G -- Yes --> C
    G -- No --> H[Step 완료]
    H --> I{다음 Step 존재?}
    I -- Yes --> B
    I -- No --> J[Job 완료<br/>로그 기록]
    J --> K[End]
```

### Business logic

1. 비즈니스 로직
    - 원본 데이터 * 100

## Entity

```markdown
## 도메인: Example Raw Data

### 기능

- 원본 데이터를 저장한다.

### Entity

- id
- rawAmount: 원본 데이터 내용 (Integer)
- createdAt: 생성 일시
- ProcessedData: 1:1 가공 데이터

## 도메인: Example Processed Data

### 기능

- 가공한 데이터를 저장한다.

### Entity

- id
- processedAmount: 가공된 데이터 내용 (Integer)
- createdAt: 생성 일시
- RawData: 1:1 원본 데이터
```