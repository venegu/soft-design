package battleship;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 *
 * @author gale
 */
public class Battleship {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      /* Generating the board 10 x 10  */
      int rows = 10;
      int columns = 10;

      int[][] board = new int[rows][columns];

      for(int i = 0; i<rows; i++)
          for(int j = 0; j<columns; j++)
              board[i][j] = 0;

      for(int i = 0; i<rows; i++) {
          for(int j = 0; j<columns; j++) {
              System.out.print(board[i][j]);
          }
          System.out.println();
      }
      /* To get randomized ship sizes */
      SecureRandom random = new SecureRandom();

      /* Loop to place ships */
      int shipCount = 0;
      for(int s = 1; s <= 6; s++){
         int max = 5;
         int min = 2;
         int shipLength = random.nextInt(max-min+1)+min;
         System.out.println(shipLength);

         shipCount = shipCount+shipLength;

      }
      System.out.println(shipCount);
   }

}
