def decode_borze(string, curr_symbol, index, result=""):
    if curr_symbol == ".":
        result += "0"
        curr_symbol = ""
    elif curr_symbol == "-.":
        result += "1"
        curr_symbol = ""
    elif curr_symbol == "--":
        result += "2"
        curr_symbol = ""

    if index == len(string):
        return result
    curr_symbol += string[index]
    return decode_borze(string, curr_symbol, index + 1, result)


print(decode_borze(input(), "", 0))
