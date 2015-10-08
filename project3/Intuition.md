Intuition on how to do this project
===================================

1. Create 2D array following this [link](http://stackoverflow.com/questions/12231453/syntax-for-creating-a-two-dimensional-array) and the following code:

```
int[][] multD = new int[10][];
for (int i = 0; i < 11; i++) {
  multD[i] = new int[10];
}
int[][] multD = new int[10][10];
```

DONE

2. Create a for-loop for placing 6 randomly sized ships (sized using Secure Random to generate ship size within the loop and placed by making sure certain indexes are not already filled).
  - Generate a random size for the ships from 2 - 6
  - Get the total # of squares ships will be taking and set that to a variable (for later use to determine if the game is over)
  - Have a function here that places ships

3. Create placeShip function that will check the board row and column to determine if the cell is empty and try to place a ship
  - It will convert a row into a string and use substring to see if it has space, if so replace the space with a ship:

  ```
  import java.io.*;

    public class Test {

       public static void main(String args[]) {
          // Row / Column string
          String Str = new String("00111000");
          // We always want to search for a string of zeroes of a random length (length of ship)
          String SubStr1 = new String("000");
          // Based on our for loop for placing the ship, this is the number below
          String SubStr2 = new String("222");

          // indexOf will test that the entire string has space for X amount of 0's
          // If index is a number, it marks where we start placing our ship
          int index = Str.indexOf(SubStr1);
          //System.out.println( Str.indexOf( SubStr1 ));

          // Replace row/column string with our ship string
          String newString = Str.substring(0, index) + SubStr2;
          // Confirm new string
          System.out.println(newString);
       }
    }
    ```

DONE

4. Create a function that will take in user input for string location and check if that cell has a ship piece, if it does mark with an X and decrement the ship count and try to check if the game is already over (when shipCount == 0)

DONE

5. GUI with Java swing and mouse interactions...

DONE ... somehow O_o

