##################################################
#
# Parameters, Unpacking, Variables
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

file_name, second, third = ARGV
puts "The captured command-line arguments are: #{file_name}, #{second}, #{third}"
puts "Another way to get the first argument is: #{ARGV.first}"
puts "Do not even think of trying something like ARGV.second"
print "Password: "
password = $stdin.gets.chomp
puts "Your password is #{password.to_i}"