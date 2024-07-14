first_input = input().split()
vertex = int(first_input[0])
edge_count = int(first_input[1])
start_vertex = int(first_input[2])

# 정점 두개가 서로를 포함하도록 그래프 만드는게 KEY 오류로 어려울 땐, 미리 초기화를 시킨 후 저장한다
edge_list = {i: [] for i in range(1, vertex + 1)}
dfs_result = []

for i in range(edge_count):
    edge_input = input().split(" ")
    start = int(edge_input[0])
    end = int(edge_input[1])
    edge_list[start].append(end)
    edge_list[end].append(start)

def dfs(graph, start, result):
    if start not in result:
        result.append(start)
    for next_vertex in sorted(graph[start]):
        if next_vertex not in result:
            dfs(graph, next_vertex, result)
    return result

def bfs(graph, start) :
    queue = [start]
    visit = []
    
    while queue:
        vertex = queue.pop(0)
        if vertex not in visit:
            visit.append(vertex)
            queue.extend(sorted(graph[vertex]))
    return visit

print(*dfs(edge_list,start_vertex,dfs_result))
print(*bfs(edge_list,start_vertex))