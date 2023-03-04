n = int(input())
explorer = list(map(int, input().split()))

explorer.sort(reverse=True)

length = len(explorer)
answer = 1
max_value = explorer[0]
tmp = 0

while length > tmp + max_value:
    answer += 1
    tmp += max_value
    max_value = explorer[tmp]

print(answer)