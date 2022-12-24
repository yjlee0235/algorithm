n = int(input())


def check_contain_three(hour):
    count = 0
    for h in range(hour + 1):
        for m in range(60):
            for s in range(60):
                if '3' in str(h) + str(m) + str(s):
                    count += 1
    return count


print(check_contain_three(n))
