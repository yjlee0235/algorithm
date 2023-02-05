n = int(input())
nums = list(map(int, input().split()))


def solution(n, nums):
    answer = [0] * n
    stack = []
    for i in range(n - 1, -1, -1):
        while stack and stack[-1] <= nums[i]:
            stack.pop()
        answer[i] = -1 if not stack else stack[-1]
        stack.append(nums[i])

    for a in answer:
        print(a, end=' ')


solution(n, nums)