n = int(input())
target1, target2 = map(int,input().split())
m = int(input())
graph = {i : [] for i in range(1,n+1)}

for i in range(m):
    x,y = map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)

visit = []
result = 0

def dfs(start,end):
    # 거리를 계속 추적해야 하기 때문에 함께 기록해야 함
    queue = [(start,0)]
    
    while queue:
        now, distance = queue.pop(0)
        if now == end:
            return distance
        
        if now not in visit:
            visit.append(now)
            for i in graph[now]:
                queue.append((i,distance + 1))
    
    return -1

print(dfs(target1, target2))