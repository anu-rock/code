# This is the console version of the  jumbled words solving game
# It's sure an interesting thing to do in free time

import wx

# First, we define a dictionary of jumbled words
dict = {'special':'licapes', 'anurag':'garuna', 'guava':'augav', "begin":"ngibe", "compression":"serniospmoc", "praying":"igyaprn"}

def func():
    'This is the core function of the program'
    # The result of popitem() method is a tuple
    # The following is an example of "sequence unpacking"
    word, jumbled = dict.popitem()
    return word, jumbled
    
def guess(event):
    ans = input_word.GetValue()
    if(ans == query[0]):
        result.SetLabel(label="Congrats! You got it right.")
    else:
        result.SetLabel(label="Sorry, wrong answer. Better luck next time!")

def next(event):
    #ques = "The jumbled word is", query[1]
    global query
    query = func()
    if(dict!={}):
        question.SetLabel(label="The jumbled word is: "+query[1])
    else:
        question.SetLabel(label="Game Over!")
        guessButton.Disable()
        nextButton.Disable()

app = wx.App()
win = wx.Frame(None, title="Jumbled Words Game", size=(410, 335))
bkg = wx.Panel(win)
guessButton = wx.Button(bkg, label='Guess')
guessButton.Bind(wx.EVT_BUTTON, guess)
guessButton.SetDefault()
#result_text = guess()
nextButton = wx.Button(bkg, label='Next')
nextButton.Bind(wx.EVT_BUTTON, next)
#question_text = next()
input_word = wx.TextCtrl(bkg)
question = wx.StaticText(bkg, label="Welcome to jumbled words game", style=wx.ALIGN_CENTER)
font = wx.Font(pointSize=18, family=wx.DECORATIVE, style=wx.NORMAL, weight=wx.NORMAL)
question.SetFont(font)
result = wx.StaticText(bkg, label="Waiting for the initial result...", style=wx.ALIGN_CENTER)
hbox = wx.BoxSizer()
hbox.Add(input_word, proportion=1, flag=wx.EXPAND)
hbox.Add(guessButton, proportion=0, flag=wx.LEFT, border=5)
hbox.Add(nextButton, proportion=0, flag=wx.LEFT, border=5)
vbox = wx.BoxSizer(wx.VERTICAL)
vbox.Add(question, proportion=1, flag=wx.EXPAND | wx.ALL, border=5)
vbox.Add(hbox, proportion=0, flag=wx.EXPAND | wx.LEFT | wx.BOTTOM | wx.RIGHT, border=5)
vbox.Add(result, proportion=0, flag=wx.EXPAND | wx.LEFT | wx.BOTTOM | wx.RIGHT, border=5)
bkg.SetSizer(vbox)
win.Show()
app.MainLoop()
