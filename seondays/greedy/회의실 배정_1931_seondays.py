# 회의가 일찍 끝나는 순서대로 정렬한 후에 시간을 맞춰서 배정하면 가장 많은 회의실 배정을 할 수 있게 된다.
# 시작 시간도 정렬을 해주어야 하는 이유는 정렬이 (5,5) (3,5) 이렇게 되어 있다면 회의실 배정이 일어나지 않지만 반대로 (3,5) (5,5) 일 경우 배정이 가능하기 때문이다.

count = int(input())
times = []

for i in range(count):
    times.append(tuple(map(int,input().split())))

times = sorted(times,key=lambda x: (x[1],x[0]))

result = 0
end = 0

for s,e in times:
    if s >= end:
        result += 1
        end = e

print(result)