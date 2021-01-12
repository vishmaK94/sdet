def recursiveAdder(num):
    if(num<=1):
        return 1
    else:
        return num + recursiveAdder(num-1)

print(recursiveAdder(10))