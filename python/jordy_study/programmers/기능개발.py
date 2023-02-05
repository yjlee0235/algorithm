import math

progresses = [95, 90, 99, 99, 80, 99]
speeds = [1, 1, 1, 1, 1, 1]


def solution(progresses, speeds):
    answer = []
    finish_days = []
    for i in range(len(progresses) - 1, -1, -1):
        finish_days.append(math.ceil((100 - progresses[i]) / speeds[i]))

    while finish_days:
        count = 1
        curr = finish_days.pop()
        while finish_days and curr >= finish_days[-1]:
            finish_days.pop()
            count += 1
        answer.append(count)
    return answer


print(solution(progresses, speeds))
