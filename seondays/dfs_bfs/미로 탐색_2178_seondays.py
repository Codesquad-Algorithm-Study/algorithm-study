# queue에 시작 좌표를 넣는다
# 시작 좌표에서 상하좌우의 위치 값을 확인해서 갈 수 있는지 없는지 확인한다
# next 값이.. 
#       총 미로의 크기를 벗어나서는 안 된다 (0보다는 작으면 안 되고, 미로 크기보다 커도 안 된다)
#       미로의 벽이 아니어아 햔다 (값이 1이어야 한다)
# 갈 수 있는 길인 경우, queue에 추가하고, 몇번째만에 도착한 곳인지 숫자를 업데이트 한다.
# queue(방문할 수 있는 좌표)가 비어있지 않는 한 계속 반복한다

m,n = map(int, input().split())
graph = []

for i in range(m):
    graph.append(list(map(int, input())))

def bsf(x,y):
    # 이동하기 위한 좌표 미리 설정
    direction = [(1,0),(0,1),(-1,0),(0,-1)]
    queue = [(x,y)]

    while queue:
        x,y = queue.pop(0)
        for i in range(4):
            next_x = x + direction[i][0]
            next_y = y + direction[i][1]

            # 현재 위치에 따라 -1이 나올 수 있으므로 0 <= next 조건도 필요하다.
            if not (0 <= next_x < m and 0 <= next_y < n):
                continue

            if graph[next_x][next_y] == 1:
                queue.append((next_x, next_y))
                graph[next_x][next_y] = graph[x][y] + 1

bsf(0,0)
print(graph[m-1][n-1])