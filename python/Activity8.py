listLen = int(input('Enter the length of list : '))
myList = []

for i in range(0,listLen):
    currNum = int(input(f'Enter num at index {i} : '))
    myList.append(currNum)

print(myList)

if(myList[0]==myList[-1]):
    print(True)
else:
    print(False)