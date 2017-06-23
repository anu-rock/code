##################################################
#
# Chromecast Background Images Downloader
# Downloads n background images that appear
# in Chromecast's standby mode,
# where 0 <= n <= 781
# Source: http://chromecastbg.alexmeub.com/
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

require "json"
require "open-uri"

n = ARGV.first

# Converts a string into *NIX friendly file name
# http://stackoverflow.com/a/6672372
def friendly_filename(filename)
    filename.gsub(/[^\w\s_-]+/, '')
            .gsub(/(^|\b\s)\s+($|\s?\b)/, '\\1\\2')
            .gsub(/\s+/, '_')
end

# Read the image JSON data from file
imagesJsonFile = File.open("data/images.v7.json")
imagesJson = imagesJsonFile.read

# Parse the file's read contents into objects
images = JSON.parse(imagesJson)

# Download n images
images.each_with_index do |image, i|
  image_num = i + 1
  puts "Image #{image_num} download started."
  File.open("cc-bg-images/#{friendly_filename(image["location"])}.jpg", 'wb') do |fo|
    fo.write open("http://chromecastbg.alexmeub.com/images/1080_#{image["name"]}").read
  end
  puts "Image #{image_num} download finished."
  break if image_num == n.to_i
end
