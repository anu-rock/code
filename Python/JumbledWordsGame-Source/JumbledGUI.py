# Author: Anurag Bhandari | Contact: anurag.bhd@gmail.com
#
# Program: Jumbled Words Game | Version: 1.0 | Licence: GPLv2
#
# This is the console version of the  jumbled words solving game
# It's sure an interesting thing to do in free time

import wx
import random

# First, we define a dictionary of jumbled words dynamically

words_list = []
# We create a list of words from a text file
# This idea given by "paulthom12345" at www.daniweb.com
f = open("words.txt")
for thing in f:
	# As "thing" is a string, slicing applies on it.
	# Now, "thing" means a word per line + the newline character (\n)
	# So, we slice "thing" so that the newline character gets removed
	words_list.append(thing[:-1])

# We create the required dictionary of words-jumbledwords from the words list
# This idea given by "Ene Uran" at www.daniweb.com
def jumble_word(word):
    # create a list of characters of the word
    char_list = list(word)
    # shuffle sequence in place
    random.shuffle(char_list)
    # joint to form a word again
    return "".join(char_list)

# create a list of jumbled words
jumbles = []
for word in words_list:
    jumbles.append(jumble_word(word))

# create a dictionary from the two lists
words_dict = dict(zip(words_list, jumbles))

global tot_words
tot_words = len(words_dict)
# "correct" variable implements the score system
global correct
correct = 0
# the flag variable will ensure the correctful working of score system
# otherwise, if player had got a question right, pressing "Guess" button multiple times
# would have incremented the score that many times until the "Next" button was pressed
global flag

def func():
    'This is the core function of the program'
    # The result of popitem() method is a tuple
    # The following is an example of "sequence unpacking"
    word, jumbled = words_dict.popitem()
    return word, jumbled
    
def guess(even):
    ans = input_word.GetValue()
    global flag
    global correct
    if(ans == query[0]):
        result.SetLabel(label="Congrats! You got it right.")
	# remind this function that "correct" is a global variable
	if(flag==1):
		correct+=1
	score.SetLabel(label="Your score is: "+str(correct)+"/"+str(tot_words))
	flag = 0
    else:
        result.SetLabel(label="Sorry, wrong answer. Better luck next time!")
	flag = 1

def next(event):
    # After a person clicks the Start button for the first time, this will happen
    nextButton.SetLabel("Next")
    guessButton.Enable()
    hintButton.Enable()
    input_word.SetValue("")
    # Unless we define the variable "query" as global, the function "guess" won't be able to access it
    global query
    query = func()
    if(words_dict!={}):
        question.SetLabel(label=query[1])
	result.SetLabel(label="Waiting for your input...")
	global flag
	flag = 1
    else:
        question.SetLabel(label="Game Over!")
        result.SetLabel(label="Yup, the game is finally over!")
        guessButton.Disable()
        nextButton.Disable()
        hintButton.Disable()

def hint(event):
    input_word.SetValue(query[0])
        
app = wx.App()
# The definition of splash screen is done after an object for the wx.App class has been defined. Same applies to all the other widgets
splash_image = wx.Image("splash.png", wx.BITMAP_TYPE_PNG)
bmp = splash_image.ConvertToBitmap()
wx.SplashScreen(bmp, wx.SPLASH_CENTRE_ON_SCREEN | wx.SPLASH_TIMEOUT, 2000, None, -1)
wx.Yield()
win = wx.Frame(None, title="Jumbled Words Game", size=(460, 285))
win.SetIcon(wx.Icon('star.ico', wx.BITMAP_TYPE_ICO))
win.CenterOnScreen()
bkg = wx.Panel(win)
# Provide some color to the boring background
bkg.SetBackgroundColour('#F9F7ED')
guessButton = wx.Button(bkg, label='Guess')
guessButton.Bind(wx.EVT_BUTTON, guess)
guessButton.SetDefault()
# Unless the player has pressed the Start button, the Guess button will be disabled
guessButton.Disable()
nextButton = wx.Button(bkg, label='Start')
nextButton.Bind(wx.EVT_BUTTON, next)
hintButton = wx.Button(bkg, label='Hint')
hintButton.Bind(wx.EVT_BUTTON, hint)
hintButton.Disable()
input_word = wx.TextCtrl(bkg)
question = wx.StaticText(bkg, label="Welcome to jumbled words game\nTotal words: "+str(tot_words), style=wx.ALIGN_CENTER)
# We define some stylish fonts for the welcome message / game questions
font = wx.Font(pointSize=20, family=wx.ROMAN, style=wx.NORMAL, weight=wx.NORMAL)
question.SetFont(font)
bgimage = wx.Image("bgimage.bmp", wx.BITMAP_TYPE_BMP)
photo = wx.StaticBitmap(bkg, -1, wx.BitmapFromImage(bgimage))
score = wx.StaticText(bkg, label="Your score is: 0/"+str(tot_words), style=wx.ALIGN_LEFT)
result = wx.StaticText(bkg, label="Waiting for the initial result...", style=wx.ALIGN_CENTER)
hbox = wx.BoxSizer()
hbox.Add(input_word, proportion=1, flag=wx.EXPAND)
hbox.Add(guessButton, proportion=0, flag=wx.LEFT, border=5)
hbox.Add(nextButton, proportion=0, flag=wx.LEFT, border=5)
hbox.Add(hintButton, proportion=0, flag=wx.LEFT, border=5)
vbox = wx.BoxSizer(wx.VERTICAL)
vbox.Add(question, proportion=1, flag=wx.EXPAND | wx.ALL, border=5)
vbox.Add(photo, proportion=0, flag=wx.EXPAND | wx.ALL, border=5)
vbox.Add(score, proportion=0, flag=wx.EXPAND | wx.ALL, border=5)
vbox.Add(hbox, proportion=0, flag=wx.EXPAND | wx.LEFT | wx.BOTTOM | wx.RIGHT, border=5)
vbox.Add(result, proportion=0, flag=wx.EXPAND | wx.LEFT | wx.BOTTOM | wx.RIGHT, border=5)
bkg.SetSizer(vbox)
win.Show()
app.MainLoop()
