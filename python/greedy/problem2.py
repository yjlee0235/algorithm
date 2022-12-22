N, M, K = map(int, input().split(' '))
data = list(map(int, input().split(' ')))

data.sort(reverse=True)
first = data[0]
second = data[1]

def solution1(M, K):
    result = 0
    while M > 0:
        tmp = K if M >= K else M
        result += first * tmp
        M -= tmp
        if M > 0:
            result += second
            M -= 1
    return result

def solution2(M, K):
    result = 0
    count = int(M / (K + 1)) * K
    count += M % (K + 1)

    result += count * first
    result += (M - count) * second
    return result

print(solution1(M, K))
print(solution2(M, K))
