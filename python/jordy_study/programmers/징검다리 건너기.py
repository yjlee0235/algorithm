from collections import deque

stones = [2, 4, 5, 3, 2, 1, 4, 2, 5, 1]
k = 1


def solution(stones, k):
    if k == 1:
        return min(stones)
    if len(stones) == k:
        return max(stones)

    min_value = 987654321
    dq = deque()
    for i, s in enumerate(stones):
        if dq and i - dq[0][0] == k:
            dq.popleft()

        while dq and dq[-1][1] < s:
            dq.pop()

        dq.append((i, s))
        if i >= k - 1:
            min_value = min(min_value, dq[0][1])

    return min_value


print(solution(stones, k))
