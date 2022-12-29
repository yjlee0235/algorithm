array = [5, 4, 4, 3, 2, 1]

count = [0] * (max(array) + 1)

for i in array:
    count[i] += 1

result = []
for i, x in enumerate(count):
    result += [i] * x

print(result)