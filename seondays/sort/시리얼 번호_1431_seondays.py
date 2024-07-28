n = int(input())
guitars = []

for _ in range(n) :
    guitars.append(input())

def sum(guitar):
    sum = 0
    for i in guitar:
        if i.isdigit():
            sum += int(i)
    return sum

guitars.sort(key= lambda x : (len(x), sum(x), x))

print(*guitars,sep="\n")