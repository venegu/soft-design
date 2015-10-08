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

public class Battleship extends JApplet
{
   private static final int NUM_ROWS = 10;
   private static final int NUM_COLS = 10;
   private static final int PANEL_WIDTH = 601;
   private static final int PANEL_HEIGHT = 601;

   private BattleshipPanel battleshipPanel;
   private HitMissPanel hitMissPanel;

   public Battleship()
   {
      hitMissPanel = new HitMissPanel(PANEL_WIDTH, 50);
      battleshipPanel = new BattleshipPanel(PANEL_WIDTH, PANEL_HEIGHT,
      new BattleshipGrid(NUM_ROWS, NUM_COLS), hitMissPanel);
   }

   public void init()
   {
      try
      {
         SwingUtilities.invokeAndWait(
            new Runnable()
            {
               public void run()
               {
                  getContentPane().setLayout(new BorderLayout());
                  add(battleshipPanel, BorderLayout.CENTER);
                  add(hitMissPanel, BorderLayout.PAGE_END);
               }
            }
         );
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public static void main(String[] args)
   {
      Battleship applet = new Battleship();
      applet.init();

      JFrame frame = new JFrame("Battleship!");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(applet);
      frame.pack();
      frame.setVisible(true);
      applet.start();
   }
}