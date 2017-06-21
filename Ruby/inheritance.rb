##################################################
#
# Inheritance
# A primer on the basics of inheritance.
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

class Politician
  def initialize(name)
    @name = name
  end

  def give_introduction()
    puts "I am #{@name} and I am a politician."
  end

  def give_speech(script)
    puts script
  end
end

class President < Politician
  def initialize(name, president_number)
    super(name)
    @president_number = president_number
  end

  def go_nuclear()
    puts "The president has executed the nuclear codes."
  end
end


trump = President.new("Donald Trump", 45)
trump.give_introduction()
