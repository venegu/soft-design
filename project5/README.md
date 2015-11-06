#A Simple GUI Environment

This assignment is to exercise GUI implementation based on Swing Java Foundation Classes (JFC). Your program needs to show a window that contains one randomly generated rectangle that never exceeds the window size. When program starts, it shows only "Redraw," "Motion Menu," and "Quit" buttons as illustrated by the figure below (left-hand side). The "Redraw" button allows to generate a rectangle when pushed, and the "Quit" buttom terminates the window presentation.The generated rectangle never exceeds the window size and is shown by thick black-colored lines, accompanied by its area size as a total pixel count. See below for two rectangle generations. 

[ The following image set is from my implementation of C++ version. Java version will be produced and the image will be replaced with it. ]

![alt text](https://github.com/venegu/soft-design/raw/master/images/1prog5.png "Project 5 Image 1") ![alt text](https://github.com/venegu/soft-design/raw/master/images/2prog5.png "Project 5 Image 2")

The "Motion Memu" buttom expands when pushed, and shows a vertical tab selection of selection of "expand," "shrink," and "rotate" as shown above (right-hand side). An "expand" option increases the size of area 10% more. The expanded rectrangle will be shown by red-colored lines as well as the increases area size, while a "shrink" option does the reverse motion in that the size of area reduces 10% and the new rectangle is shown by blue-colored lines. These operations can be applied repeatedly. 

![alt text](https://github.com/venegu/soft-design/raw/master/images/3prog5.png "Project 5 Image 3") ![alt text](https://github.com/venegu/soft-design/raw/master/images/4prog5.png "Project 5 Image 4")

The "rotate" option rotates the rectangle 15 degree (or π/6 radian) in clockwise. The rotated rectangle is shown by dark-green-colored lines. As shown below, the subsequent "shrink" and "expand" operations can also applied to the rotated object. 

![alt text](https://github.com/venegu/soft-design/raw/master/images/5prog5.png "Project 5 Image 5") ![alt text](https://github.com/venegu/soft-design/raw/master/images/6prog5.png "Project 5 Image 6")


There are websites showing various pieces of code to give you hints to realize this implementation such as [here](http://stackoverflow.com/questions/2259476/rotating-a-point-about-another-point-2d) and [here](http://stackoverflow.com/questions/13194140/expand-or-shrink-irregular-polygon) referred for my own implementation. There is also some similar implementation available somewhere in the demo and sample files downloadable at the official Java site. 
