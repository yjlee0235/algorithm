n, m = map(int, input().split())

dp = [123123] * 10001

arr = []
for _ in range(n):
    coin = int(input())
    dp[coin] = 1
    arr.append(coin)
arr.sort()

# for x in range(arr[0], m + 1):
#     for a in arr:
#         if a > x:
#             break
#         dp[x] = min(dp[x - a] + 1, dp[x])

dp[0] = 0
for i in range(n):
    for j in range(arr[i], m + 1):
        dp[j] = min(dp[j], dp[j - arr[i]] + 1)

print(dp[m] if dp[m] != 123123 else -1)
