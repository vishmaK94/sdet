tupLen = int(input('Enter the length of tuple : '))
tempList = []
for i in range(tupLen):
    currNum = int(input(f'Enter num at index {i} : '))
    tempList.append(currNum)

myTuple = tuple(tempList)
print(myTuple)

print('Numbers divisible by 5 : ')
for num in myTuple:
    if(num%5==0): print(num)