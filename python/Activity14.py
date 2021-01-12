def fibonacciSeries(limit):
    if(limit<=1):
        return 1
    else:
        return (fibonacciSeries(limit-1)+fibonacciSeries(limit-2))
    
num = int(input("Enter range for Fibonacci series : "))

for i in range(num):
    print(fibonacciSeries(i), end=' ')