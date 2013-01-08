class Car:
    noOfTyres = 4
    def __init__(self, doors=4):
        self.noOfDoors = doors
    def getInfo(self):
        print '\nNumber of tyres in this car:', Car.noOfTyres
        print '\nNumber of doors in this car:', self.noOfDoors

car1 = Car()
car2 = Car(2)
car1.getInfo()
car2.getInfo()
