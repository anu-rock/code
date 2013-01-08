import sys

if(sys.argv[1] == '--help'):
    print 'This is the help text'
if(sys.argv[1] == '--author'):
    print 'Anurag Bhandari'
if(sys.argv[1] == '--version'):
    print 'Arguments tester v1.0'
if(sys.argv[1] == '--name'):
    print 'This is the name of the script: ' + sys.argv[0]
else:
    print 'Available options are:\n--help\n--author\n--version\n--name'
