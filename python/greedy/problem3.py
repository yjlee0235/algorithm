n, m = map(int, input().split())

arr = []

for x in range(n):
    arr.append(list(map(int, input().split())))

def solution1():
    mins = []
    for row in arr:
        mins.append(min(row))
    return max(mins)

print(solution1())