n, m = map(int, input().split())

visit = [[0] * m for _ in range(n)]

x, y, direction = map(int, input().split())
visit[x][y] = 1

maps = []
for _ in range(n):
    maps.append(list(map(int, input().split())))

dxy = [(-1, 0), (0, 1), (1, 0), (0, -1)]


def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3


count = 1
turn_time = 0
while True:
    turn_left()
    nx = x + dxy[direction][0]
    ny = y + dxy[direction][1]
    if visit[nx][ny] == 0 and maps[nx][ny] == 0:
        visit[nx][ny] = 1
        x, y = nx, ny
        count += 1
        turn_time = 0
        continue
    else:
        turn_time += 1
    if turn_time == 4:
        nx = x - dxy[direction][0]
        ny = y - dxy[direction][1]
        if maps[nx][ny] == 0:
            x, y = nx, ny
        else:
            break
        turn_time = 0

print(count)
