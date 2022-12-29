n = int(input())

students = []
for _ in range(n):
    input_value = input().split()
    students.append((input_value[0], int(input_value[1])))

students.sort(key=lambda x: x[1])

for s in students:
    print(s[0], end=' ')
