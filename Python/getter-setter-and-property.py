# This program demonstrates the working of 'property' using getter and setter.

# It is necessary to create a subclass of 'object' for 'property' to work.
class Screen(object):
    def __init__(self):
        self.width = 0
        self.height = 0

    def getResolution(self):
        print (self.width, self.height)

    def setResolution(self, reso):
        (self.width, self.height) = reso

    # Perhaps this tells the compiler to associate 'getResolution' method as the
    # getter and 'setResolution' method as the setter of 'size' variable.
    resolution = property(getResolution, setResolution)

screen1 = Screen()
# As 'resolution' is just being accessed and nothing is being assigned to it, 
# the compiler understands this and exectutes whatever is in its getter.
screen1.resolution
# As 'size' is being assigned something, the compiler understands this
# and exectutes whatever is in its setter.
screen1.resolution = 1024, 768
screen1.resolution
screen1.height
