n = 3
k = 5


def solution(n, k):
    answer = []

    count = []
    tmp = 1
    for i in range(1, n):
        tmp *= i
        count.append(tmp)
    count.reverse()

    order = []
    remain = k - 1
    for c in count:
        order.append(remain // c)
        remain = remain % c

    nums = [x for x in range(1, n + 1)]
    for o in order:
        answer.append(nums.pop(o))
    answer.append(nums.pop())

    return answer


print(solution(n, k))
