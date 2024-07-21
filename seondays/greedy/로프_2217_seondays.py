n = int(input())

ropes = []

for i in range(n):
    ropes.append(int(input()))

ropes = sorted(ropes, reverse=True);

result = ropes[0]

# 내림차순으로 정렬된 리스트를 순회하면서
# 현재 보고 있는 로프의 무게와 현재까지 선택한 로프의 개수를 곱하고
# 기존 result와 비교했을 때 더 큰 중량을 구한다

for i in range(len(ropes)):
    result = max(result,ropes[i] * (i+1))

print(result)