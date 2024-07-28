elements = list(map(int,input().split()))

n = elements.pop(0)

while(n != len(elements)):
    elements.extend(list(map(int,input().split())))

# return 전에 int로 변환해서 0을 없애 준다
def reverse(n):
    result = ""
    while n > 0:
        result += str(n%10)
        n //= 10
    return int(result)

result = list(map(reverse,elements))

result.sort()

print(*result,sep="\n")