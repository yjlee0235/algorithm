n, m = map(int, input().split())
nums = list(map(int, input().split()))

rg = []

for _ in range(m):
    rg.append(tuple(map(int, input().split())))

for i in range(1, n):
    nums[i] += nums[i - 1]

for s, e in rg:
    if s <= 1:
        result = nums[e - 1]
    else:
        result = nums[e - 1] - nums[s - 2]

    print(result)
