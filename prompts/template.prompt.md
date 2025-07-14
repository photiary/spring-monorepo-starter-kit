다음 기능에 맞게 Entity를 설계해.

# Feature

-

# AI Agent 응답 형식

- Entity 간의 관계있다면, 1:N, N:N 으로 표시한다.
- Code로 응답하지 않는다.
- Sample 응답 형식으로 요구사항을 응답
- Sample 응답

```markdown
## 도메인: 사용자

### 기능

- 사용자를 관리한다.
- 주문을 여러번 한다.

### Entity

- id
- userId: 사용자 아이디
- userName: 사용자 이름
- Order: 1:N 주문

## 도메인: 주문

### 기능

- 주문을 관리한다.

### Entity

- id
- orderName
```
