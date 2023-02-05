from collections import deque

n, m = map(int, input().split())

visited = [[False] * m for _ in range(n)]
graph = []

dir = [(0, 1), (0, -1), (1, 0), (-1, 0)]

for _ in range(n):
    graph.append(list(map(int, input())))


def isValid(x, y):
    return 0 <= x and x < n and 0 <= y and y < m


def bfs(graph, visited, x, y):
    queue = deque([(x, y)])
    visited[x][y] = True
    level = 0
    while queue:
        level += 1
        size = len(queue)
        for _ in range(size):
            x, y = queue.popleft()
            for d in dir:
                nx = x + d[0]
                ny = y + d[1]
                if isValid(nx, ny) and not visited[nx][ny] and graph[nx][ny] == 1:
                    if nx == n - 1 and ny == m - 1:
                        return level + 1
                    queue.append((nx, ny))
                    visited[nx][ny] = True
    return level


def bfs2(graph, x, y):
    queue = deque([(x, y)])
    while queue:
        x, y = queue.popleft()
        for d in dir:
            nx = x + d[0]
            ny = y + d[1]
            if not isValid(nx, ny):
                continue
            if graph[nx][ny] == 1:
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))
    return graph[n - 1][m - 1]


print(bfs(graph, visited, 0, 0))
print(bfs2(graph, 0, 0))
