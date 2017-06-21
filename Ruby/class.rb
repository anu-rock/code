##################################################
#
# Class
# A simple class that represents a farm,
# which has animals and crops.
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

class Farm
  # Attribute accessors are purely optional
  attr_reader :animals # this object's animals variable is read-only
  attr_reader :crops # the crops variable is read and write
  attr_writer :crops

  # Constructor
  def initialize(animals)
    @animals = animals
  end

  # A method
  def count_animals()
    return animals.length()
  end
end
