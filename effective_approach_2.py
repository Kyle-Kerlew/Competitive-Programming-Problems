n = int(input())
n_integers = {v: k for k, v in enumerate(map(int, input().split(' ')))}
m = int(input())
m_integers = map(int, input().split(' '))
forward_count = 0
backward_count = 0

for i in m_integers:
    forward_count += n_integers.get(i) + 1
    backward_count += n - n_integers.get(i)
print(forward_count, backward_count)
