# This is the console version of the  jumbled words solving game
# It's sure an interesting thing to do in free time

# First, we define a dictionary of jumbled words
dict = {'special':'licapes', 'anurag':'garuna', 'guava':'augav', "begin":"ngibe", "compression":"serniospmoc", "praying":"igyaprn"}

def func():
    'This is the core function of the program'
	# The result of popitem() method is a tuple
	# The following is an example of sequence unpacking"
    word, jumbled = dict.popitem()
    return word, jumbled

# Then, we define the main loop (actually, a nested loop) for the game
while(dict!={}):
    #Note: The call to the function returns a tuple which we will store in "query"
    query = func()
    print "The jumbled word is:", query[1]
    ans = raw_input("Your anwser is: ")
    if(ans == query[0]):
        print "Congrats! You got it right."
    else:
        print "Sorry, wrong answer. Better luck next time!"
    whether_continue = raw_input("\nDo you want to continue? [y/n]: ")
    if(whether_continue.upper() == 'Y'):
        if(dict == {}):
            print "\nSorry, the word list has exhausted"
            break
        else:
            print "\nOk, here's your next question\n"
    else:
        break
