list1 = [23, 79, 7, 8, 0, -2]
list2 = [3, 89, 88, 54, 13, 12]

oddList = []
evenList = []

for num in list1:
    if(num%2!=0): oddList.append(num)

for num in list2:
    if(num%2==0): evenList.append(num)

print(f'First list : {list1}')
print(f'Odd list : {oddList}')
print(f'Second list : {list2}')
print(f'Even list : {evenList}')