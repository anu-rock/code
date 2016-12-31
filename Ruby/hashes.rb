##################################################
#
# Hashes
# Hashes are like arrays in PHP and
# objects in JavaScript.
# This program explores stuff that
# one can do with a hash in Ruby.
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

# Hash with string keys and string values
states = {
    "AP" => "Andhra Pradesh",
    "DL" => "Delhi",
    "HR" => "Haryana",
    "PB" => "Punjab"
}

# Hash with string keys and hash values
# (City abbreviations taken from IRCTC)
cities = {
    "AP" => {
        "HYD" => "Hyderabad"
    },
    "DL" => {
        "NDLS" => "New Delhi"
    },
    "HR" => {
        "GGN" => "Gurgaon",
        "UMB" => "Ambala"
    },
    "PB" => {
        "JUC" => "Jalandhar",
        "LDH" => "Ludhiana",
        "ASR" => "Amritsar"
    }
}

# Print out nested hash values
cities.each do |stateAbbr, constituentCities|
    puts # new line
    puts "Cities in the state of #{states[stateAbbr]} are:"
    constituentCities.each do |cityAbbr, cityName|
        puts "* #{cityName} (abbr. #{cityAbbr})"
    end
end

# Hash with numeric keys and string values
numbers = {
    1 => "One",
    2 => "Two",
    3 => "Three"
}

# Print out a separator
puts
puts "-" * 25
puts

# Add new pairs to a hash
numbers[4] = "Four"
numbers["5"] = "Five"

# Print out a "hybrid" hash
puts numbers
numbers.each { |key, value| puts "#{key} is #{value} in English." }

# Print out a separator
puts
puts "-" * 25
puts

# Delete a pair from a hash
puts "Deleted #{numbers.delete(3)} from numbers hash."
numberThree = numbers[3]
numberThree ||= "nil (doesn't exist)"; # assign a default value to a non-existent member
puts "Calling numbers[3] now returns #{numberThree}."
puts "Still don't believe me? Here's the modified hash:"
puts numbers
