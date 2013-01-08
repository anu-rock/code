# This is a minimal server

import socket

# we create the default socket object
s = socket.socket()

# we assign the socket a combination of hostname and port
s.bind((socket.gethostname(),1234))

# the server will listen to maximum 5 clients
s.listen(5)

# we start an infinite loop that starts accepting client connections
while True:
    c_socket, c_addr = s.accept()
    print 'Just got a connection from', c_addr
    c_socket.send('Thank you for connecting')
    c_socket.close()

# NOTES:
# c_addr is proper socket address of the connected client, returned as a tuple.
# accept() runs in an infinite loop which ensures that the program keeps
# on running in the command prompt so that we have enough time to
# run client program.
# if the while loop is not specified, accept() will accept just one
# connection, and then the program will end. So, while loop is also an
# infinite loop here.
