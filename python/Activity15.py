try:
    print(undefinedVariableName)
except NameError:
    print('A name error appeared!')
finally:
    print('Code execution finished')