##################################################
#
# Conditionals
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

# User input
print "What's your first name? "
first_name = gets.chomp
print "What's your age? "
age = gets.chomp.to_i
puts "Have a nice day, #{age} year-old #{first_name}."

# Conditions
if age > 25
	puts "Btw, you are an old soul."
elsif age > 20
	puts "Btw, you are pretty young."
else
	puts "Btw, what's up kiddo?"
end