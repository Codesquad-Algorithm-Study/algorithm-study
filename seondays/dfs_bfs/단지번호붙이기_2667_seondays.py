n = int(input())
result_list = []
graph = []

for i in range(n):
    graph.append(list(map(int,input())))

def bfs(x, y):
    direction = [(1,0),(0,1),(-1,0),(0,-1)]
    queue = [(x,y)]
    # 시작점을 미리 개수에 포함시키고 그와 동시에 시작점도 방문한 셈이므로 0으로 바꿔줘야 한다
    # 만약 0으로 바꿔주지 않을 경우 인접 단지들에서 탐색을 할 때 다시 시작점을 재방문하게 되어 결과에 문제가 생긴다
    graph[x][y] = 0
    result = 1

    while queue:
        x,y = queue.pop(0)
        for i in range(4):
            next_x = x + direction[i][0]
            next_y = y + direction[i][1]

            if 0 <= next_x < n and 0 <= next_y < n:
                if graph[next_x][next_y] == 1:
                    queue.append((next_x,next_y))
                    graph[next_x][next_y] = 0
                    result += 1
    return result

# 값이 1인 곳에서 시작해야 함
# 방문한 곳은 이미 값이 0으로 바뀌었기 때문에, 전체 그래프를 돌면서 1인 곳을 찾아 거기부터 시작한다
for i in range(n):
    for j in range(n):
        if graph[i][j] == 1:
            result_list.append(bfs(i,j))

print(len(result_list))
print("\n".join(map(str,sorted(result_list))))