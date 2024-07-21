n = int(input())
dates = []
for i in range(n):
    date = list(map(int, input().split()))
    dates.append((date[0] * 100 + date[1], date[2] * 100 + date[3]))

start_date = 301  # 3월 1일
end_date = 1201  # 12월 1일
result = 0
max_end = 0
index = 0
dates.sort()

while start_date < end_date:
    found = False
    # 현재 start_date 이전에 피는 모든 꽃을 확인하여 그 중 가장 늦게 지는 꽃을 선택
    while index < len(dates) and dates[index][0] <= start_date:
        max_end = max(max_end, dates[index][1])
        index += 1
        found = True

    # 만약 선택할 꽃이 없다면 (즉, 시작 날짜보다 늦게 피는 꽃만 있다면) 루프를 종료
    if not found:
        break

    # start_date를 가장 늦게 지는 꽃의 종료일로 갱신
    start_date = max_end
    result += 1

# 만약 start_date가 end_date 이전이라면, 필요한 기간을 다 덮지 못한 것이므로 0을 출력
if start_date < end_date:
    print(0)
else:
    print(result)