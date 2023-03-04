n, h = map(int, input().split())

top = []
bottom = []

for i in range(n // 2):
    bottom.append(int(input()))
    top.append(int(input()))

bottom.sort()
top.sort()

height = [0] * h
tmp1 = 0
tmp2 = h - 1
for i in range(n // 2):
    while tmp1 < bottom[i]:
        height[tmp1] += (n // 2) - i
        tmp1 += 1
    tmp1 = bottom[i]

    while tmp2 > h - 1 - top[i]:
        height[tmp2] += (n // 2) - i
        tmp2 -= 1
    tmp2 = h - 1 - top[i]

min_value = 123456789
count = 1
for h in height:
    if min_value > h:
        min_value = h
        count = 1
    elif min_value == h:
        count += 1

print(min_value, count)
