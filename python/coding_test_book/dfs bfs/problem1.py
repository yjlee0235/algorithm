n, m = map(int, input().split())

ice = []
visited = [[False] * m for _ in range(n)]

dir = [(0, 1), (0, -1), (1, 0), (-1, 0)]

for _ in range(n):
    ice.append(list(map(int, input())))


def isValid(x, y):
    return 0 <= x and x < n and 0 <= y and y < m


def dfs(ice, vx, vy, visited):
    visited[vx][vy] = True
    for d in dir:
        nx = vx + d[0]
        ny = vy + d[1]
        if isValid(nx, ny) and not visited[nx][ny] and ice[nx][ny] == 0:
            dfs(ice, nx, ny, visited)


def solution1(ice, visited):
    count = 0
    for x in range(n):
        for y in range(m):
            if visited[x][y] or ice[x][y] == 1:
                continue
            dfs(ice, x, y, visited)
            count += 1
    print(count)


def dfs2(x, y):
    if not isValid(x, y):
        return False
    if ice[x][y] == 0:
        ice[x][y] = 1
        for d in dir:
            dfs2(x + d[0], y + d[1])
        return True
    return False


def solution2():
    count = 0
    for x in range(n):
        for y in range(m):
            if dfs2(x, y) == True:
                count += 1
    print(count)


solution1(ice, visited)
solution2()
