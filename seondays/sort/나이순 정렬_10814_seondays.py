# 동명이인 문제로 dict 대신 tuple 사용
n = int(input())
members = []

for i in range(n):
    member = input().split()
    members.append((int(member[0]),member[1]))

# sort는 안정 정렬이므로, 나이가 같은 경우 입력 순서가 유지됨 따라서 나이만 정렬
members.sort(key= lambda x: x[0])

# 리스트 컴프리핸션과 f 포매팅을 이용해서 출력 형식을 만들기
pretty_print = [f"{member[0]} {member[1]}" for member in members]

print(*pretty_print, sep="\n")