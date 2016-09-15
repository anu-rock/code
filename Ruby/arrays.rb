##################################################
#
# Arrays methods.
# Things we can do with arrays.
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

things_on_desk = [ "Bag", "Headset", "Mobile", "Notebook", "Laptop", "Pen", "Bottle" ]

puts "You've got an interesting array over there."
gets
puts "#{things_on_desk} - nice"
gets
puts "I'm quick at counting. It contains #{things_on_desk.length} items."
gets
puts "I can pop an item out of it."
gets
puts "POP."
gets
puts "Here it is: #{things_on_desk.pop}."
gets
puts "Whoops! Here's another one: #{things_on_desk.pop}."
gets
puts "Sorry, slippery hands!"
gets
puts "You want the 2nd and 3rd items? At once?"
gets
puts "Okay. Take this! #{things_on_desk[1..2]}"
gets
puts "And now you ask for the last item?"
gets
puts "You got it: #{things_on_desk[-1]}"
gets
puts "As a bonus, I give you a space-separated version of your array."
gets
puts "With an added surprise item."
things_on_desk.push("iPhone")
gets
puts "#{things_on_desk.join(' ')}"
gets
puts "Bye!"
gets
