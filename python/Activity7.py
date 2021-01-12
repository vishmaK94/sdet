listLen = int(input('Enter the length of list : '))
myList = []

for i in range(0,listLen):
    currNum = int(input(f'Enter num at index {i} : '))
    myList.append(currNum)

sum = 0
for num in myList:
    sum += num

print(myList)
print(f'Sum of all elements of the list : {sum}')