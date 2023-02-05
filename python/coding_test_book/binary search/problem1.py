def binary_search(arr, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None


# 이진 탐색 사용
def solution1():
    n = int(input())
    n_arr = list(map(int, input().split()))
    m = int(input())
    m_arr = list(map(int, input().split()))

    n_arr.sort()

    for target in m_arr:
        if binary_search(n_arr, target, 0, n - 1) is None:
            print("no", end=' ')
        else:
            print("yes", end=' ')


# 계수 정렬 사용
def solution2():
    n = int(input())
    n_arr = [0] * 1_000_001

    for i in input().split():
        n_arr[int(i)] = 1

    m = int(input())
    x = list(map(int, input().split()))
    for i in x:
        if n_arr[i] == 0:
            print("no", end=' ')
        else:
            print("yes", end=' ')


# 집합 자료 구조 사용
def solution3():
    n = int(input())
    n_set = set(map(int, input().split()))
    m = int(input())
    m_arr = list(map(int, input().split()))

    for x in m_arr:
        if x in n_set:
            print("yes", end=' ')
        else:
            print("no", end=' ')


solution3()
