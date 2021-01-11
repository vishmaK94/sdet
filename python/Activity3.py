p1 = input('Enter your choice Player 1 (rock, paper, scissors) : ').lower()
p2 = input('Enter your choice Player 2 (rock, paper, scissors) : ').lower()


if (p1==p2):
    print("It's a tie!")
elif (p1=='rock' and p2=='paper') or (p1=='paper' and p2=='scissors') or (p1=='scissors' and p2=='rock'):
    print('Player 2 wins!')
elif (p1 not in 'rockpaperscissors') or (p2 not in 'rockpaperscissors'):
    print('Invalid inputs')
else:
    print('Player 1 wins!')    
    
