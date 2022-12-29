array = [5, 4, 3, 2, 1]

for i in range(len(array)):
    min_index = i
    for j in range(i + 1, len(array)):
        if array[min_index] < array[j]:
            min_index = j
    array[min_index], array[i] = array[i], array[min_index]

print(array)
