# Recursion으로 구현
def binary_search1(array, target, start, end):
    if start > end:
        return None
    mid = (start + end) // 2
    if array[mid] == target:
        return mid
    elif array[mid] < target:
        return binary_search1(array, target, start, mid - 1)
    elif array[mid] > target:
        return binary_search1(array, target, mid + 1, end)


# 반복문으로 구현
def binary_search2(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return mid
        elif array[mid] < target:
            end = mid - 1
        else:
            start = mid + 1
    return None
