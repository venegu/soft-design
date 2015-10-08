/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package battleship;

/**
 *
 * @author Lisa Maldonado
 * CSC 221 Professor Kawaguchi
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/* Graphical foo */
public class BattleshipPanel extends JPanel
{
   // the width and height of this panel
   private final int PANEL_WIDTH;
   private final int PANEL_HEIGHT;

   private BattleshipGrid grid;
   private HitMissPanel hitMissPanel;

   private boolean hint = false;

   private int numHits;
   private int numMisses;

   public BattleshipPanel(int width, int height, BattleshipGrid battleshipGrid, HitMissPanel hmp)
   {
      PANEL_WIDTH = width;
      PANEL_HEIGHT = height;
      grid = battleshipGrid;
      hitMissPanel = hmp;

      numHits = 0;
      numMisses = 0;

      setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));

      /* reset button */
      JButton reset = new JButton("Reset");
      reset.addActionListener(new Reset());
      add(reset);

      /* quit button */
      JButton quit = new JButton("Quit");
      quit.addActionListener(new Quit());
      add(quit);

      /* hint button */
      JButton hint = new JButton("Hint");
      hint.addActionListener(new Hint());
      add(hint);

      addMouseListener(
         new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               // attack the grid based on where the user clicked
               attackGrid(e.getX(), e.getY());

               // update the graphics
               repaint();

               // have all of the ships been destroyed?
               if (grid.allDestroyed())
               {
                  JOptionPane.showMessageDialog(null, "You win!");
                  System.exit(0);
               }
            }
         }
      );
   }

   /* Quits the entire game */
   class Quit implements ActionListener {
      Quit() {}

      public void actionPerformed(ActionEvent e) {
         System.exit(0);
      }
   }

   /* Re-starts everything so you can try again! */
   class Reset implements ActionListener {
      Reset() {}

      public void actionPerformed(ActionEvent e)
      {
         /* running grid related things start the game over */
         grid.initializeGrid();
         grid.calculateTotalHitsRequired();
         grid.placeAllShips();

         /* Resetting misses and hits */
         numMisses = 0;
         numHits = 0;
         hitMissPanel.setStats(numHits, numMisses);

         /* Setting to blank grid */
         repaint();
      }
   }


   /* For foo relate to hint button */
   class Hint implements ActionListener {
      Hint() {}

      public void actionPerformed(ActionEvent e)
      {
         hint = true;
         repaint();
      }
   }

   /* Painting the board */
   public void paintComponent(Graphics g)
   {
      setBackground(Color.darkGray);
      super.paintComponent(g);

      drawGridLines(g);
      drawGridCells(g);

      if (hint) {
         hint = false;
      }
   }

   /* Grid lines */
   private void drawGridLines(Graphics g) {
      g.setColor(Color.WHITE);

      // draw vertical grid lines
      for (int x = 0; x < PANEL_WIDTH; x += PANEL_WIDTH / grid.NUM_COLS) {
            g.drawLine(x, 0, x, PANEL_HEIGHT - 1);
      }

      // draw horizontal grid lines
      for (int y = 0; y < PANEL_HEIGHT; y += PANEL_HEIGHT / grid.NUM_ROWS) {
         g.drawLine(0, y, PANEL_WIDTH - 1, y);
      }
   }

   private void drawGridCells(Graphics g) {
      for (int row = 0; row < 10; row++) {
         for (int col = 0; col < 10; col++) {
            int c = (col * 60)+ 2;
            int r = (row * 60)+ 2;

            /* Hit - Pink */
            if (grid.getCell(row, col) == 2) {
               g.setColor(Color.pink);
               g.fillOval(c, r, 56, 56);
            }

            /* Miss - Blue */
            if (grid.getCell(row, col) == 3) {
               g.setColor(Color.cyan);
               g.fillOval(c, r, 56, 56);
            }

            /* Hint - White */
            if (hint) {
               if (grid.getCell(row, col) == 1) {
                  g.setColor(Color.white);
                  g.fillOval(c, r, 56, 56);
               }
            }
         }
      }
   }

   /* Getting the cell the user clicked & feeding that to attack function */
   private void attackGrid(int mouseX, int mouseY)
   {
      int c = mouseX/60;
      int r = mouseY/60;
      if(grid.attack(r, c) == true){
         numHits++;
      }
      else if (grid.attack(r, c) == false) {
         numMisses++;
      }
      hitMissPanel.setStats(numHits, numMisses);
      grid.attack(r, c);
   }
}