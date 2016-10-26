import urllib2
#Daniel Lindberg
#2-26-2016

#this is a simple script it asks that you input a URL and it takes the webpage at that URL

"""
The big thing about this script is that it does error handling well. Security can mean that no one accesses info from some system
but it can also mean that a software only allows the correct information to go through it. Below I force someone to give a URL 
location, if it is not valid it tells them and asks if they would like to re-enter. Then it trys to enter that URL. 
This is a form of security because it forces the correct input to certain paths
"""


answer = 'y'
while(answer == 'Y' or answer == 'y'):
	pageLocation = raw_input('Enter a URL, ex: http://cnn.com:')
	try:
		html = urllib2.urlopen(pageLocation)
		#this breaks out of while loop if it works
		answer = 'Got One'
	except:
		answer = raw_input('That isn not a valid URL, would you like to try again (Y/N)')
		
if(answer=='y' or answer == 'Y'):
	the_page = html.read()
	with open('imgs/StrippedWebPage.html','w') as fid:
		fid.write(the_page)
		print 'It wrote to imgs/StrippedWebPage.html'
