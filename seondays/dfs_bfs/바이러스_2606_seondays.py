# dfs
count = int(input())
pair = int(input())
graph = {i:[] for i in range(1,count+1)}

for i in range(pair):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

visit = []

def dfs(start):
    result = 0
    visit.append(start)
    for next in graph[start]:
        if next not in visit:
            result += 1
            result += dfs(next)
    return result

print(dfs(1))