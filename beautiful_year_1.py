def find_first_distinct_year_after(year):
    result = set(str(year))
    if len(result) == len(str(year)):
        return year
    return find_first_distinct_year_after(year + 1)


year_input = int(input())
print(find_first_distinct_year_after(year_input + 1))
