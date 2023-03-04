from collections import deque


def operate(left, mid, right, operation):
    if operation == "Rotate":
        left_first = left.popleft()
        mid[0].appendleft(left_first)
        mid_last = mid[0].pop()
        right.appendleft(mid_last)
        right_last = right.pop()
        mid[-1].append(right_last)
        mid_first = mid[-1].popleft()
        left.append(mid_first)
    elif operation == "ShiftRow":
        left.appendleft(left.pop())
        mid.appendleft(mid.pop())
        right.appendleft(right.pop())


def assemble(left, mid, right):
    answer = []

    for i in range(len(left)):
        tmp = []
        tmp.append(left.popleft())
        for e in mid.popleft():
            tmp.append(e)
        tmp.append(right.popleft())
        answer.append(tmp)

    return answer


def solution(rc, operations):
    left = deque()
    mid = deque()
    right = deque()

    for r in rc:
        left.append(r[0])
        mid.append(deque(r[1:-1]))
        right.append(r[-1])

    for op in operations:
        operate(left, mid, right, op)

    return assemble(left, mid, right)
