n = int(input())
result = 0
list1 = sorted(list(map(int,input().split())))
list2 = sorted(list(map(int,input().split())),reverse=True)

for i in range(n):
    result += list1[i] * list2[i]

print(result)