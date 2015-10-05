/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipdriver;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 *
 * @author gale
 */
public class battleshipGrid {
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
    private static final int RANDOM_SHIP_LENGTH = 1;

    // array of all ship lengths
    private static final int[] SHIP_LENGTHS =
    {
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

    // ::: DECLARE YOUR 2D ARRAY NAMED grid HERE

    private int[][] grid;


    /**
     * Creates a new BattleshipGrid instance and randomly places
     * ships on the grid.
     *
     * @param    numRows    the number of rows in this grid
     * @param    numCols    the number of columns in this grid
     */
    public battleshipGrid(int numRows, int numCols)
    {
        NUM_ROWS = numRows;
        NUM_COLS = numCols;

        // initialize the grid so all cells are EMPTY
        initializeGrid();

        // determine the total number of hits required to win
        calculateTotalHitsRequired();

        // randomly place all of the ships on the grid
        placeAllShips();
    }

    /**
     * Initializes the game grid to size [NUM_ROWS][NUM_COLS]
     * and sets each element of the grid to the constant EMPTY.
     */
    private void initializeGrid()
    {
        // ::: MAKE grid A 2D ARRAY OF THE APPROPRIATE DIMENSIONS AS
        //     SPECIFIED IN THE METHOD DESCRIPTION. REMEMBER THAT YOU
        //     HAVE ALREADY DECLARED grid AS AN INSTANCE VARIABLE AND
        //     THAT YOU SHOULD NOT REDECLARE IT HERE.


      grid = new int[NUM_ROWS][NUM_COLS];

      for(int i = EMPTY; i < NUM_ROWS; i++) {
          for(int j = EMPTY; j < NUM_COLS; j++) {
          }
      }
    }

    /**
     * Calculates the total number of hits required to
     * destroy all ships and win the game.
     */
    private static void calculateTotalHitsRequired()
    {
        totalHitsRequired = 0;

        // add all the ship lengths together to get
        // the total number of hits required
        for (int length : SHIP_LENGTHS)
        {
            totalHitsRequired += length;
        }
    }

    /**
     * Places all of the game's ships onto the grid.
     */
    private void placeAllShips()
    {
       SecureRandom random = new SecureRandom();

       for(int length : SHIP_LENGTHS) {
         /* Generating random numbers */
         int min = 0;
         int max = 9;
         int r = random.nextInt(max-min+1)+min;
         int c = random.nextInt(max-min+1)+min;
         /* Getting String output of row */
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
         System.out.println(row);
         System.out.println(ship);
         System.out.println(zeroes);
         /*  */
         int index = row.indexOf(zeroes);
         //System.out.println(index);
         for(int s = index; s < length; s++){
            grid[r][s]= length;
         }

         //System.out.println(r);
         //break;
       }

       System.out.println();

    }



    /**
     * Attacks the grid cell at the specified row and column.
     * If the grid cell contains:
     *   - SHIP: the value of the cell is set to HIT
     *   - HIT: the value of the cell does not change
     * Otherwise, the value of the cell is set to MISS.
     *
     * This method returns true if the attack resulted in a ship being hit,
     * and false otherwise.
     *
     * Note: this method also returns true if a cell that has already
     * been hit is attacked.
     *
     * @param    row    the row of the cell to attack
     * @param    col    the column of the cell to attack
     *
     * @return   true if the attack results in a ship being hit (even
     *           if the ship at that cell has already been hit),
     *           false otherwise
     */
    public boolean attack(int row, int col)
    {
        // ::: FILL IN THIS CODE

        return false;
    }



    /**
     * Returns true if all of the ships have been destroyed, and
     * false otherwise.
     *
     * @return   true if all ships have been destroyed, false otherwise
     */
    public boolean allDestroyed()
    {
        // ::: FILL IN THIS CODE. NOTE THAT THERE IS A VARIABLE NAMED
        //     totalHitsRequired THAT CONTAINS THE TOTAL NUMBER OF HITS
        //     REQUIRED TO DESTROY ALL SHIPS

        return false;
    }



    /**
     * Determine if the cell at the specified row and column is in
     * the grid's bounds.
     *
     * @param    row    the cell's row
     * @param    col    the cell's column
     *
     * @return   true if the cell is in bounds, false otherwise
     */
    private boolean inBounds(int row, int col)
    {
        return ((row >= 0) && (row < NUM_ROWS) &&
                (col >= 0) && (col < NUM_COLS));
    }

    /**
     * Returns the value of the cell at [row][col] if the cell is in
     * bounds. Otherwise, returns OUT_OF_BOUNDS.
     *
     * @param    row    the cell's row
     * @param    col    the cell's column
     *
     * @return   if in bounds, the value of the cell at [row][col],
     *           otherwise OUT_OF_BOUNDS
     */
    public int getCell(int row, int col)
    {
        if (inBounds(row, col))
            return grid[row][col];
        else
            return OUT_OF_BOUNDS;
    }

    /**
     * Prints the grid.
     */
    public void printGrid()
    {
        // ::: FILL IN THIS CODE

       for(int i = EMPTY; i < NUM_ROWS; i++) {
          for(int j = EMPTY; j < NUM_COLS; j++) {
              System.out.print(grid[i][j]);
          }
          System.out.println();
      }
    }

}