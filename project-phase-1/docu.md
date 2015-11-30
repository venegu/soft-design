# Refining Battleship
I would like to create new features on top of __[Project 3 - the Battleship implementation](https://github.com/venegu/soft-design/tree/master/project3)__. The features that will make the game play more fun and difficult include the following: 

1. Creating an idea of “levels of difficulty” that is based on the size of the grid. 
2. Randomizing the number of ships that can be on the field.
3. Randomizing ship length (how many squares they take up on the grid).

I will discuss each one of these features in order below.

## 1. Levels of Difficulty
Hypothetically, if the grid is bigger then game is vastly more difficult. With this in mind, providing levels of difficulty would be a very welcomed feature that will allow the game to reach more players and users. The way that this feature could be tackled is to have a home screen, shown below, that has buttons for different levels of difficulty.

![alt text](https://github.com/venegu/soft-design/raw/master/images/home-screen.png "Home Screen")

__The user will click the button that describes the difficulty level that they want to play, a grid of the correct size will be generated, ships will be added to the grid and it will display in another screen.__

### Implementation
The “Easy” button will create a 5 x 5 grid, the “Medium” button will create a 10 x 10 grid, and the “Hard” button will create 15 x 15 grid. On click, the “Easy”, “Medium” and “Hard” buttons will set the integer variables `NUM_ROW` and `NUM_COL` equal to 5, 10, and 15, respectively. These two variables are used in the creation of the game grid within `initializeGrid( )` function.

__Input:__ User clicks the button.

__Output:__ A grid will be programmatically generated with a specific size based on the button clicked (each button represents a different difficulty level).

### Potential Errors
It is very unlikely that adding three buttons will result in errors, but errors may certainly occur when trying to add ships to the grid inside the `placeAllShips( )` function. This function will need to be checked to make sure that it is taking in the correct value for the size of the grid (`NUM_ROW` and `NUM_COL`). This piece cannot be hard coded because if it does have the wrong values for the grid row and column size then ships that may be too long might be placed. 

#### Wireframes of Difficulty Levels
![alt text](https://github.com/venegu/soft-design/raw/master/images/hard.png "Hard Level")
![alt text](https://github.com/venegu/soft-design/raw/master/images/med.png "Medium Level")
![alt text](https://github.com/venegu/soft-design/raw/master/images/easy.png "Easy Level")

## 2. Randomized Number of Ships
A way to make the game more challenging is to randomize the number of ships. This will make the game more surprising and fun. This feature will occur in the background, thus __there will be no input from the user, only output from the program__ in the form of a randomized number of ships.

### Implementation 
This could be implemented by using a random function between a certain range that is considered number of ships. Based on the size of the grid there will need to be an upper bound on how many ships can be placed. This upper bound can be determined through trial and error or by taking `NUM_ROW` and `NUM_COL`, multiplying them by each other and storing this value inside of an integer variable called `GRID_SIZE`. This will result in the number of spaces in the grid. This will allow us to do the permutation `GRID_SIZE` choose `(NUM_ROW - 1)`. This will tell you how many permutations are available to place ships of length `NUM_ROW - 1` inside the grid. This number can be used as an upper bound for randomly picking the number of ships to place.

### Potential Errors
This particular change may overcomplicate the ship placement function that currently exists. Additionally, when modifying the algorithm for ship placement there is always the possibility of accidentally allow it to place ships out of bounds. One will need to be very careful so as to not be able to place ships out of bounds by not extensively modifying the while loop that checks this.  

## 3. Randomized Length of Ships
Like the previous feature this will make the game more challenging because the player won’t know how long the ships will be, new lengths will be generated at the start of every new game. This randomization will need to be based on the size of the grid and the number of ships. Thus, the implementation of this last feature will be very dependent on the previous two features. __This will, once again, not have input from the user, only output from the program in the background.__

### Implementation 
The way to approach this is to create an algorithm that will create one of the several permutations mentioned in the previous feature’s implementation: `GRID_SIZE` choose `(NUM_ROW - 1)`. Since the grid sizes are fixed there is only a certain number of combinations of ship placement and ship sizes that will work.

### Potential Errors
Like the previous feature, this will modify the function `placeAllShips( )`, so great caution should be taken so as to not change this function significantly so that it does not place ships out of bounds or have ships overlap. 

## Resources 
   - [Python Implementation](https://www.codecademy.com/forum_questions/514caf925ebdb57da0000056)
   - [Heuristics for ship placement](http://stackoverflow.com/questions/16337427/avoiding-dead-ends-in-battleships-random-placement-algorithm)
   - [Paper Regarding Algorithm for Ship Placement](http://gritslab.gatech.edu/Pickem/wp-content/uploads/2012/12/cs6601_project_1_paper.pdf)
