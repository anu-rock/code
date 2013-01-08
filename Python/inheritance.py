class Man:
    def __init__(self, name='Man', petname='Man', eyes=2, ears=2, ec='Black'):
        self.name = name
        self.petName = petname
        self.noOfEyes = eyes
        self.noOfEars = ears
        self.eyeColor = ec

    def introduce(self):
        print 'Hello, I am ' + self.name + '. People also call me ' + self.petName + \
              '. I have ' + str(self.noOfEyes) + ' eyes, ' + str(self.noOfEars) + \
              ' ears, ' + 'and my eye color is ' + self.eyeColor + '.'

    def sing(self):
        print 'Hmm... hmm... hmm... hmmmm...'

    def eat(self):
        print 'Yum... yum... yum... yum...'


class BadSingingMan(Man):
    def sing(self):
        print 'Rararararahhaa...!!@@##$$'


class AngryMan(Man):
    def __init__(self, *args):
        Man.__init__(self, *args)
        #super(AngryMan, self).__init__(*args)
        self.petLine = 'What were ya thinkin\', ya dumbhead?'
        
    def sing(self):
        print 'Sing? I sing? You sing, you idiot!'

    def eat(self):
        print 'Don\'t force me to eat, else I\'ll stab you in your back!'

    def talk(self):
        print self.petLine


BlueEyedMan = Man('Blue Eyed Man', 'Dingo', ec='Blue')
BlueEyedMan.introduce()
BlueEyedMan.sing()
BlueEyedMan.eat()
Pirate = AngryMan('Pirate', 'One Eyed Man', 1, 2)
Pirate.introduce()
Pirate.sing()
Pirate.eat()
Pirate.talk()
