# This is a minimal client

import socket

# we create the default socket object
s = socket.socket()

# we connect the client to the server
# 'socket.gethostname()' indicates the machine on which client will run
# to connect to a remote machine, replace gethostname function with
# the actual socket address of the server
s.connect((socket.gethostname(),1234))

# we print the message sent by the server and received by client
# we are receiving just 1024 bytes from the server-sent message
print s.recv(1024)
