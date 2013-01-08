# This is a simple program by Anurag Bhandari <anurag.bhd@gmail.com>

name = raw_input("Enter your name: ")
welcome_line = "Hello %s! Welcome to Granular Linux"
print welcome_line % name
print "\n"
usage_time = raw_input("Since how many days are you using Granular? ")
liking_reason = raw_input("Tell us why do you use Granular: ")
interaction_tuple_1 = (usage_time, liking_reason)
interaction_line_1 = "Are you sure you are using Granular since %s days because %s?"
print interaction_line_1 % interaction_tuple_1
