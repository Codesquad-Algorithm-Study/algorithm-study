from collections import deque

m,n,h = map(int,input().split())
graph = []

for i in range(h):
    sub_graph = []
    for j in range(n):
        sub_graph.append(list(map(int,input().split())))
    graph.append(sub_graph)
    
direction = [(1,0,0),(-1,0,0),(0,1,0),(0,-1,0),(0,0,1),(0,0,-1)]
queue = deque()

# 토마토가 익은 위치에서부터 시작해야 하기 때문에 미리 큐에 익은 토마토 위치를 넣어 둔다
for i in range(h):
    for j in range(n):
        for k in range(m):
            if graph[i][j][k] == 1:
                queue.append((i,j,k,0))
                
def bfs():
    result_day = 0
    
    while queue:
        x,y,z,day = queue.popleft()
        if graph[x][y][z] == 1:
            for i in range(6):
                next_x = x + direction[i][0]
                next_y = y + direction[i][1]
                next_z = z + direction[i][2]
                
                if 0 <= next_x < h and 0 <= next_y < n and 0 <= next_z < m:
                    if graph[next_x][next_y][next_z] == 0:
                        graph[next_x][next_y][next_z] = 1
                        queue.append((next_x, next_y, next_z, day + 1))
                        result_day = max(result_day, day + 1)
    
    # 안익은 토마토가 있는지 확인
    for z in range(h):
        for y in range(n):
            for x in range(m):
                if graph[z][y][x] == 0:
                    return -1                
    return result_day               

print(bfs())