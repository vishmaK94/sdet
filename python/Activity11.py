fruitBasket = {
    "banana" : 70,
    "apple" : 140,
    "pomegrenate" : 200,
    "lemon" : 120,
    "pineapple" : 120,
    "custard" : 200,
    "mango" : 150,
    "watermelon" : 50
}

fruitName = input("Enter fruit name to find : ").lower()
#print(fruitName)

notFound = True
for fruit, price in fruitBasket.items():
    #print(fruit, price)
    if(fruit==fruitName):
        print(f'{fruitName} is available at a price of {price}')
        notFound = False
        break

if(notFound):
    print(f'Sorry! {fruitName} is not available right now. Come back later!')