array = [5, 4, 3, 2, 1]

for i in range(1, len(array)):
    for j in range(i, 0, -1):
        if array[j - 1] < array[j]:
            array[j], array[j - 1] = array[j - 1], array[j]
        else:
            break

print(array)
