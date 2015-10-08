/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 *
 * @author Lisa Maldonado
 * CSC 221 Professor Kawaguchi
 */
public class BattleshipGrid {
   public static final int OUT_OF_BOUNDS = -1;

   // values to be used in the 2D grid
   public static final int EMPTY = 0;
   public static final int SHIP = 1;
   public static final int HIT = 2;
   public static final int MISS = 3;

   // directions used for shape placement
   private static final int DIRECTION_RIGHT = 0;
   private static final int DIRECTION_DOWN = 1;

   // lengths of the various ships in the game
   private static final int AIRCRAFT_CARRIER_LENGTH = 5;
   private static final int BATTLESHIP_LENGTH = 4;
   private static final int DESTROYER_LENGTH = 3;
   private static final int SUBMARINE_LENGTH = 3;
   private static final int PATROL_BOAT_LENGTH = 2;
   private static final int RANDOM_SHIP_LENGTH = 2;

   // array of all ship lengths
   private static final int[] SHIP_LENGTHS = {
      AIRCRAFT_CARRIER_LENGTH,
      BATTLESHIP_LENGTH,
      DESTROYER_LENGTH,
      SUBMARINE_LENGTH,
      PATROL_BOAT_LENGTH,
      RANDOM_SHIP_LENGTH
   };

   // the total number of hits required to destroy all ships
   private static int totalHitsRequired;

   // the number of rows and columns in this grid
   public final int NUM_ROWS;
   public final int NUM_COLS;

   /* 2d array */
   private int[][] grid;

   public BattleshipGrid(int numRows, int numCols) {
      NUM_ROWS = numRows;
      NUM_COLS = numCols;

      // initialize the grid so all cells are EMPTY
      initializeGrid();

      // determine the total number of hits required to win
      calculateTotalHitsRequired();

      // randomly place all of the ships on the grid
      placeAllShips();
   }

    /* Initializes the game grid to size [NUM_ROWS][NUM_COLS] */
   public void initializeGrid() {
      /* 2d array */
      grid = new int[NUM_ROWS][NUM_COLS];

      for(int i = EMPTY; i < NUM_ROWS; i++) {
         for(int j = EMPTY; j < NUM_COLS; j++) {

         }
      }
   }

   /* Determining hits necessary to win */
   public static void calculateTotalHitsRequired() {
      totalHitsRequired = 0;

      /* runs through array and adds ship lengths */
      for (int length : SHIP_LENGTHS)
      {
         totalHitsRequired += length;
      }
   }

   /* Putting all the ships on the grid randomly */
   public void placeAllShips() {
      SecureRandom random = new SecureRandom();

      /* Substring Method */
       /*for(int length : SHIP_LENGTHS) {
         int min = 0;
         int max = 9;
         int r = random.nextInt(max-min+1)+min;
         int c = random.nextInt(max-min+1)+min;

         String row = "";
         for(int i = 0; i <10; i++){
            row += grid[r][i];
         }
         String ship = "";
         String zeroes = "";
         for(int s = 0; s < length; s++){
           ship += length;
           zeroes += 0;
         }

         int index = row.indexOf(zeroes);
         //System.out.println(index);

         while(index == -1){
            row = "";
            r = random.nextInt(max-min+1)+min;

            for(int i = 0; i < 10; i++){
               row += grid[r][i];
            }
            System.out.println("Row: " + row);
            index = row.indexOf(zeroes);
         }
         if(index != -1) {
            int insertionMark = 0;
            for(int s = index; insertionMark < ship.length(); s++){
               grid[r][s] = length;
               // Each time we place a piece of the current ship, we increase by 1
               insertionMark += 1;
            }
         }
       }*/

      /* Checking if in bounds method with randomized column selector*/
      boolean p = false;
      /* Six ships */
      for (int j = 0; j < 6; j++) {
         /* Infinite loop to place all ships (won't break until p = true) */
         while (!p) {
            int row = random.nextInt(10);
            int col = random.nextInt(10);
            int rand = random.nextInt(2);
            boolean clear = true;
            if (rand == 0) {
               /* Column */
               /* Determining if ship can be placed */
               if (inBounds(row, col + SHIP_LENGTHS[j])) {
                  for (int i = 0; i < SHIP_LENGTHS[j]; i++) {
                     if (grid[row][(col + i)] != 0) {
                        clear = false;
                     }
                  }
                  if (clear) {
                     for (int i = 0; i < SHIP_LENGTHS[j]; i++) {
                     grid[row][(col + i)] = 1;
                     }
                     p = true;
                  }
               }
            }
            /* Determining if ship can be placed */
            else if (inBounds(row + SHIP_LENGTHS[j], col)) {
               /* Row */
               for (int i = 0; i < SHIP_LENGTHS[j]; i++) {
                  if (grid[(row + i)][col] != 0) {
                     clear = false;
                  }
               }
               if (clear) {
                  for (int i = 0; i < SHIP_LENGTHS[j]; i++) {
                     grid[(row + i)][col] = 1;
                  }
                  p = true;
               }
            }
         }
         p = false;
      }
   }

   /* Attacking a specific cell */
   public boolean attack(int row, int col) {
      if (grid[row][col] == 1){
         // Hit a ship
         grid[row][col] = HIT;
         totalHitsRequired--;
         return true;
      }
      if(grid[row][col] == 0) {
         // Didn't hit a ship
         grid[row][col] = MISS;
         return false;
      }
      else {
         return false;
      }
   }

   /* Checking if all ships are destroyed */
   public boolean allDestroyed() {
      if (totalHitsRequired == 0) {
         /* All ships destroyed */
         System.out.println("You win!");
         return true;
      }
      else {
         System.out.println("You didn't win yet...");
         return false;
      }
   }

   /* Is the ship in bounds? */
   private boolean inBounds(int row, int col) {
      return ((row >= 0) && (row < NUM_ROWS) && (col >= 0) && (col < NUM_COLS));
   }

   /* Returning cell's value */
   public int getCell(int row, int col) {
      if (inBounds(row, col))
         return grid[row][col];
      else
         return OUT_OF_BOUNDS;
    }

   /* Printing the grid */
   public void printGrid() {
      for(int i = EMPTY; i < NUM_ROWS; i++) {
         for(int j = EMPTY; j < NUM_COLS; j++) {
            System.out.print(grid[i][j]);
               if(j < grid[i].length -1){
                  System.out.print(" ");
               }
         }
         System.out.println();
      }

   }

}
