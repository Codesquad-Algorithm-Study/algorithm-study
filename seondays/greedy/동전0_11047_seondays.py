n,k = list(map(int,input().split()))
coins = []
result = 0

for i in range(n):
    coins.append(int(input()))

for i in reversed(coins):
    result += k // i
    k %= i

print(result)