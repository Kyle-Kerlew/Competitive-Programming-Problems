"""Returns Number of moves it took to get to the center"""


def move_toward_center(pos_x, pos_y, counter=0):
    while pos_x != 3 or pos_y != 3:
        if pos_x > 3:
            pos_x -= 1
            counter += 1
        if pos_x < 3:
            pos_x += 1
            counter += 1
        if pos_y > 3:
            pos_y -= 1
            counter += 1
        if pos_y < 3:
            pos_y += 1
            counter += 1

    return counter


position_X = 0
position_Y = 0
for y in range(1, 6):
    line = input().split(' ')
    for x in range(1, 6):
        if line[x - 1].__contains__("1"):
            position_X = x
            position_Y = y
print(move_toward_center(position_X, position_Y))
