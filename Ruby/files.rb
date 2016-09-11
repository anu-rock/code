##################################################
#
# Reading & writing text files
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

# Reading files
sample_file = open(file_name)
puts sample_file.read
sample_file.close

# Writing files
sample2_file = open('sample2.txt', 'w')
sample2_file.write("Hahahaha")
sample2_file.write("\n")
sample2_file.close