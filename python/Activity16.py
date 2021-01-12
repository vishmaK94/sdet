class Car:
    'This class represents a car'

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(f'{self.manufacturer} {self.model} is moving')
    
    def stop(self):
        print(f'{self.manufacturer} {self.model} has stopped')


car1 = Car('Volkswagen Group', '100', 'Audi', 'automatic', 'teal')
car2 = Car('FIAT', '124 Spider', 'FIAT', 'automatic', 'white')
car3 = Car('GMC', '1500 Club Coupe', 'GMC', 'automatic','red')

car1.accelerate()
car1. stop()

car2.accelerate()
car2.stop()

car3.accelerate()
car3.stop()