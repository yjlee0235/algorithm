n, k = map(int, input().split())

def solution1(n, k):
    count = 0
    while n > 1:
        if n % k == 0:
            n /= k
        else:
            n -= 1
        count += 1
    return count


def solution2(n, k):
    result = 0
    while True:
        tmp = (n // k) * k
        result += n - tmp
        n = tmp
        if n < k:
            break
        result += 1
        n //= k
    return result + n - 1

print(solution1(n, k))
print(solution2(n, k))
