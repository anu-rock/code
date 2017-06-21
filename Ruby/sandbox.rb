##################################################
#
# A sandbox use and test other code.
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

# Playing with modules
require("./module.rb")
FaceRecognitionModule.detect() # call a module's function
FaceRecognitionModule.recognize()
puts "Module version #{FaceRecognitionModule::VERSION}" # access a module's variable

# Playing with classes
require("./class.rb")
my_farm = Farm.new(["cows", "goats", "pigs"]) # create an object
puts "There are #{my_farm.count_animals()} animals on my farm." # access a method
my_farm.crops = ["potatoes", "carrots", "wheat"] # set an attribute; setting my_farm.animals won't work!
puts "My farm has #{my_farm.crops.join(", ")} crops." # get an attribute
