##################################################
#
# While loop
# Generates Fibonacci sequence that is given
# numbers long
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

def fibonacci(n)
    sequence = [ 1 ]
    next_num = 1
    i = 0
    while i < n-1 # because our sequence already has one number
        sequence << next_num
        next_num += sequence[i]
        i += 1
    end
    puts "The first #{n} terms of Fibonacci sequence are: "
    sequence.each { |fNum| print "#{fNum}, " }
end

print "Enter the length of Fibonacci sequence to generate: "
n = $stdin.gets.chomp.to_i
fibonacci(n)
