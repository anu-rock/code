# This is a simple program by Anurag Bhandari <anurag.bhd@gmail.com>
# This program inputs the names and corresponding ages of 3 different
# persons and makes a database (list) out of them

# Initialize a list "a" (this step is mandatory)
a = [None]*3
x = 0
while(x<3):
    name = raw_input("Enter your name: ")
    age = input("Enter your age: ")
    print "\n"
    a[x] = [name, age]
    x +=1

x = 0
print "Our database currently includes the following records:"
while(x<3):
    print a[x]
    x +=1
