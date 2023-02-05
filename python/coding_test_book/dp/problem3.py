n = int(input())

dp = [0] * 1001

dp[0] = 1
dp[1] = 3

for x in range(2, n):
    dp[x] = dp[x - 1] + dp[x - 2] * 2

print(dp[n - 1] % 796_796)
