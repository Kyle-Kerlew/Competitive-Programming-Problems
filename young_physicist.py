n = int(input(''))  # Parse to int type

x_vector = y_vector = z_vector = 0

for i in range(n):
    x, y, z = map(int, input('').split(' '))
    x_vector += x
    y_vector += y
    z_vector += z

if x_vector == y_vector == z_vector == 0:
    print("YES")
else:
    print("NO")
