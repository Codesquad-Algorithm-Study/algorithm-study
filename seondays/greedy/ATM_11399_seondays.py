n = int(input())
list = sorted(list(map(int,input().split())))
result = 0
turn = 0

for i in range(n):
    turn += list[i]
    result += turn

print(result)