from collections import deque
import copy

n = int(input())

indegree = [0] * (n + 1)
times = [0] * (n + 1)
graph = [[] for _ in range(n + 1)]

for i in range(1, n + 1):
    inputs = list(map(int, input().split()))
    times[i] = inputs[0]
    for bc in inputs[1:-1]:
        graph[bc].append(i)
        indegree[i] += 1


def topology_sort():
    result = copy.deepcopy(times)
    q = deque()

    for i in range(1, n + 1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        now = q.popleft()
        for i in graph[now]:
            indegree[i] -= 1
            result[i] = max(result[i], result[now] + times[i])
            if indegree[i] == 0:
                q.append(i)

    for r in result[1:]:
        print(r)


topology_sort()
