n = int(input())

directions = input().split()

class Position:
    def __init__(self):
        self.x = 1
        self.y = 1

    def move(self, direction):
        if direction == 'L':
            if self.y > 1:
                self.y -= 1
        elif direction == 'R':
            if self.y < n:
                self.y += 1
        elif direction == 'U':
            if self.x > 1:
                self.x -= 1
        elif direction == 'D':
            if self.x < n:
                self.x += 1


def solution1():
    pos = Position()
    for direction in directions:
        pos.move(direction)
    return (pos.x, pos.y)

def solution2():
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    move_types = ['R', 'D', 'L', 'U']

    x = y = 1
    for direction in directions:
        for i in range(len(move_types)):
            if direction == move_types[i]:
                nx = x + dx[i]
                ny = y + dy[i]
                if nx < 1 or nx > n or ny < 1 or ny > n:
                    continue
                x, y = nx, ny
    return x, y

print(solution1())
print(solution2())