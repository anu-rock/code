##################################################
#
# Block
# A simple program to demonstrate the power
# of Ruby blocks (closures in other languages).
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

def my_custom_loop (items)
    if items.respond_to? "each"
        items.each do |item|
            yield("Anurag's ")
            print "#{item}"
            puts ""
        end
    else
        yield("Anurag's ")
        print "#{item}"
    end
end

# Invocation of the above method with a block.
# "prefix" is a block variable (optional).
# The block's code is executed each time "yield" is encountered.
my_custom_loop ["mobile", "photo frame", "chocolate"] do |prefix|
    print "#{prefix}"
end
