n = int(input())
number = input()


def count_ways_to_avoid(num_of_friends, total):
    count = 0
    for i in range(1, 6):
        if (total + i) % (num_of_friends + 1) != 1:
            count += 1
    return count


print(count_ways_to_avoid(n, sum([int(x) for x in number.split(" ")])))
