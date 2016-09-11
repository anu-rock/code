##################################################
#
# Variable replacements and formatted strings
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

# Variable replacement in a string
character = "good"
puts "Anurag Bhandari is a #{character} boy."

# Formatted string
formatted_string = "%{name} is a %{character} boy."
puts formatted_string % {
	name: "Ramesh",
	character: "nice"
}