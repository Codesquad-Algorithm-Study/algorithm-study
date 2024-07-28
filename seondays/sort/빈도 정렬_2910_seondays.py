# sort의 key 정렬 람다에서 한꺼번에 파라미터를 적용해서 사용하기 위해 둘 다 딕셔너리로 선언한다.
# 하나를 리스트로 할 경우 한꺼번에 비교가 어려움
order = dict()
frequency = dict()

n, max_num = list(map(int,input().split()))

num_list = list(map(int,input().split()))

for i in range(n):
    if num_list[i] not in frequency:
        frequency[num_list[i]] = 1
        order[num_list[i]] = i
    else:
        frequency[num_list[i]] += 1

sort_list = list(frequency.keys())

sort_list.sort(key=lambda x: (-frequency[x], order[x]))

result = []

for i in sort_list:
    for j in range(frequency[i]):
        result.append(i)

print(*result)