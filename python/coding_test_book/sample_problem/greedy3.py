str = input()

answer = 0

zero_count = 0
one_count = 0
now = str[0]
for i in range(len(str)):
    if now == '0' and now != str[i]:
        zero_count += 1
        now = '1'
    elif now == '1' and now != str[i]:
        one_count += 1
        now = '0'

answer = min(zero_count, one_count)

print(answer)
