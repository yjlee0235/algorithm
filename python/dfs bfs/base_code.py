from collections import deque


def dfs(graph, v, visited):
    visited[v] = True
    print(f'{v}')
    for i in graph[v]:
        if not visited[v]:
            dfs(graph, i, visited)


def bfs(graph, start, visited):
    queue = deque([start])
    visited[start] = True
    while queue:
        v = deque.popleft()
        print(f'{v}')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True
