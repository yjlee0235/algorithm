n, m = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()


def calc_result(arr, mid, end):
    result = 0
    for x in range(mid, end + 1):
        if arr[x] > arr[mid]:
            result += arr[x] - arr[mid]
    return result


def binary_search(arr, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        result = calc_result(arr, mid, end)
        if target == result:
            return arr[mid]
        elif target > result:
            end = mid - 1
        else:
            start = mid + 1
    return None


print(binary_search(arr, m, 0, n - 1))
