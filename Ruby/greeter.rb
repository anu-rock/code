##################################################
#
# Greeter
# An object oriented way of greeting multiple people.
# Adapted from "Ruby in 20 minutes."
# https://www.ruby-lang.org/en/documentation/quickstart/3/
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

class Greeter
  attr_accessor :names

  def initialize ( names = "John" )
    @names = names
  end

  def say_hi
    if @names.nil?
      puts "..."
    elsif @names.respond_to?("each") # it's an array
      @names.each do |name|
        puts "Bonjour, #{name}."
      end
    else
      puts "Bonjour, #{@names}."
    end
  end

  def say_bye
    if @names.nil?
      puts "..."
    elsif @names.respond_to?("join")
      puts "Au revoir, #{@names.join(", ")}. À bientôt."
    else
      puts "Au revoir, #{@names}."
    end
  end
end

if __FILE__ == $0
  greeter = Greeter.new
  greeter.say_hi
  greeter.say_bye

  greeter.names = nil
  greeter.say_hi
  greeter.say_bye

  greeter.names = [ "Huey", "Dewey", "Louie" ]
  greeter.say_hi
  greeter.say_bye
end
