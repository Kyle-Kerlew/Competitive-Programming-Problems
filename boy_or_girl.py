def determine_gender(string):
    unique_chars = set(string)
    if len(unique_chars) % 2 == 1:
        return "IGNORE HIM!"
    else:
        return "CHAT WITH HER!"


print(determine_gender(input()))
