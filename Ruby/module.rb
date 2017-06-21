##################################################
#
# Module
# Defines a dummy module that pretends to perform
# face recognition operations.
# This module is used in sandbox.rb.
# Anurag Bhandari <anurag.bhd@gmail.com>
#
##################################################

module FaceRecognitionModule
  def FaceRecognitionModule.detect()
    puts "2 persons detected. A 25 years old female and a 31 years old male."
  end

  def FaceRecognitionModule.recognize()
    puts "I think the persons are Jaya and Veeru."
  end

  VERSION = "v0.75 x86_64"
end
