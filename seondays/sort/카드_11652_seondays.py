n = int(input())

num_count = dict()

for _ in range(n):
    number = int(input())
    if number in num_count:
        num_count[number] += 1
    else:
        num_count[number] = 0

result = []
min_value = max(num_count.values())

for k,v in num_count.items():
    if v == min_value:
        result.append(k)

result.sort()
print(result[0])