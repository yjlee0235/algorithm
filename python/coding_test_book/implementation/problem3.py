y, x = list(input())

dx = [-2, -2, 1, -1, -1, 1, 2, 2]
dy = [1, -1, -2, -2, 2, 2, -1, 1]


def translate_index(char):
    return ord(char) - ord('a') + 1


def isValid(x, y):
    return not (x < 1 or x > 8 or y < 1 or y > 8)


def count_moveable(x, y):
    count = 0
    for idx in range(len(dx)):
        nx = x + dx[idx]
        ny = y + dy[idx]
        if (isValid(nx, ny)):
            count += 1
    return count


def solution1(x, y):
    x = int(x)
    y = translate_index(y)
    return count_moveable(x, y)


def solution2(x, y):
    # dx = [-2, -2, 1, -1, -1, 1, 2, 2]
    # dy = [1, -1, -2, -2, 2, 2, -1, 1]

    steps = [(-2, 1), (-2, -1), (1, -2), (-1, -2), (-1, 2), (1, 2), (2, -1), (2, 1)]

    x = int(x)
    y = translate_index(y)

    count = 0
    for step in steps:
        nx = x + step[0]
        ny = y + step[1]
        if isValid(nx, ny):
            count += 1
    return count


print(solution1(x, y))
print(solution2(x, y))
