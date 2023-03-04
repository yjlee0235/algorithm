import heapq

n = 7
k = 3
enemy = [5, 5, 5, 5, 2, 3, 1]


def solution(n, k, enemy):
    answer = 0
    pq = []

    if len(enemy) <= k:
        return len(enemy)

    pass_count = 0
    tmp = 0
    for i in range(len(enemy)):
        heapq.heappush(pq, -enemy[i])
        if tmp + enemy[i] <= n:
            tmp += enemy[i]
            answer += 1
        else:
            if k > pass_count:
                pass_count += 1
                max_minus_value = heapq.heappop(pq)
                tmp += max_minus_value + enemy[i]
                if tmp <= n:
                    answer += 1
            else:
                break
    return answer


print(solution(n, k, enemy))
