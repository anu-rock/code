# This is a simple program by Anurag Bhandari <anurag.bhd@gmail.com>
# This program inputs a string from the user and displays it in a textbox of appropriate size

text = raw_input("Enter the text to be displayed in the box: ")
text_length = len(text)
box_width = text_length + 4

print "+" + "-"*(box_width-2) + "+"
print "| " + " "*text_length + " |"
print "| " + text + " |"
print "| " + " "*text_length + " |"
print "+" + "-"*(box_width-2) + "+"
