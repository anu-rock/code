# This is a simple program by Anurag Bhandari <anurag.bhd@gmail.com>

# The __future__ module returns the division of two integers as a float value
from __future__ import division

x = input("Enter the dividend: ")
y = input("Enter the divisor: ")
#Perform calculation
z = x/y
i = x//y
# Print the answer
# `z` is equivalent to saying repr(z). The backticks convert result number to strings here, so it could be concatenated to the string
print "The answer of division is = " + `z`
# This truncates the decimal part of the result
print "The integer part of the result = " + `i`

# Perform a dangerous (unstable) operation
p = 9/0
