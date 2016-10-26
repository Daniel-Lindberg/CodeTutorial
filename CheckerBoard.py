from PIL import Image, ImageDraw
#Daniel Lindberg
#2-25-2016


"""Garret this is an example of a python script
It generates a checkerboard, at the top you specify how many columns and rows you want
Along with how the width and height of the image in pixels, this is abstraction
My code will work regardless how you change these variable values, that's how you should code 
Make it so that you can change variable names at the top and that it can still work as desired
By that I create variable names such as cell_width and cell_height which are calculated on formulas
And not by actual values
"""
columns = 12
rows = 12

width=600
height=600

cell_width=width/rows
cell_height=height/columns

image = Image.new('RGB',(width,height))
drawnImage = ImageDraw.Draw(image)

for i in range(rows):
	for j in range(columns):
		if (i + j) % 2 == 0:
			color = 'white'
		else:
			color = 'black'
		startX = i*cell_width
		startY = j*cell_height
		drawnImage.rectangle(((startX,startY),(startX+cell_width,startY+cell_height)), fill=color)


image.save("checkerboard.png")
