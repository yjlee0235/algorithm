str = list(map(int, input()))

answer = str[0]

for i in range(len(str) - 1):
    if str[i] <= 1 or str[i + 1] < 1:
        answer += str[i + 1]
    else:
        answer *= str[i + 1]

print(answer)
