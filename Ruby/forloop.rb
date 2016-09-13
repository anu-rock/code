##################################################
#
# For loop and arrays
# Calculates the factorial of a given number
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

# Functions
def factorial_recursion (num)
	if num == 1 || num == 0
		return 1
	else
		return num * factorial_recursion(num-1)
	end
end

def factorial_looping (num)
	factorial = 1
	if num > 0
		(1..num).each do |n|
			factorial *= n
		end
	end
	return factorial
end

# Array
things_on_bed = [ "pillow", "blanket", "phone", "tablet", "piano" ]

# For loop
things_on_bed.each do |thing|
	puts "#{thing} is on my bed."
end

# User input
puts "##################################################"
puts "What method to you want to use for factorial calculation?"
puts "Recursion (r)"
puts "Looping (l)"
print "Enter either r or l: "
factorial_method = $stdin.gets.chomp

# Range operator
# (creates a new array)
factorials = []
(1..10).each do |num|
	if factorial_method == 'r'
		factorials << factorial_recursion(num)
	elsif factorial_method == 'l'
		factorials.push(factorial_looping(num)) # alternative syntax
	end
end

# for-in loop
# (discouraged in Ruby)
puts "Calculated factorials for 1 to 10 are:"
for factorial in factorials
	puts factorial
end
