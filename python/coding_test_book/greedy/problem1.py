coins = [500, 100, 50, 10]
# result = []
count = 0

amount = int(input())

for coin in coins:
    count += amount // coin
    amount %= coin

    # if coinNum > 0:
    #     amount = amount - (coin * coinNum)
    # result.append(coinNum)

# print(result)
print(count)