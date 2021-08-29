values = input().split(" ")
n = int(values[0])
k = int(values[1])

even_length = n // 2
odd_length = n // 2
if n % 2 == 1:
    odd_length = (n // 2) + 1

if k > odd_length:
    remainder = k - odd_length
    print(2 * remainder)
else:
    print(2 * k - 1)
