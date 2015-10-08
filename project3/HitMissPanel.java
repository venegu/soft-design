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
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * A panel that displays hit and miss statistics.
 */
public class HitMissPanel extends JPanel
{
    private static final int FONT_SIZE = 20;

    private JLabel totalShotsLabel;
    private JLabel hitsLabel;
    private JLabel missesLabel;
    private JLabel hitPercentageLabel;

    private int hits;
    private int misses;
    public boolean hint = false;

    private DecimalFormat df = new DecimalFormat("0.00%");



    public HitMissPanel(int width, int height) {

      /*class Quit implements ActionListener {
         Quit() {}

         public void actionPerformed(ActionEvent e) {
            System.exit(0);
         }
      }


      class Reset implements ActionListener {
         Reset() {}

         public void actionPerformed(ActionEvent e) {
        // grid.initializeGrid();
         //grid.calculateTotalHitsRequired();
         //grid.placeAllShips();
         //numMisses = 0;
         //numHits = 0;
         //hitMissPanel.setStats(BattleshipPanel.this.numHits, BattleshipPanel.this.numMisses);
         repaint();
         }
      }


      class Hint implements ActionListener {
         Hint() {}

         public void actionPerformed(ActionEvent e)
         {
            //hint = true;
            repaint();
         }
      }*/

      setPreferredSize(new Dimension(width, height));
      setBackground(Color.DARK_GRAY);

      /*JButton reset = new JButton("Reset");
      reset.addActionListener(new Reset());
      add(reset);


      JButton quit = new JButton("Quit");
      quit.addActionListener(new Quit());
      add(quit);


      JButton hint = new JButton("Hint");
      hint.addActionListener(new Hint());
      add(hint);*/

      setLayout(new GridLayout(1, 0));

      // create a new label for the total number of shots
      totalShotsLabel = new JLabel("", JLabel.CENTER);
      totalShotsLabel.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
      totalShotsLabel.setForeground(Color.WHITE);

      // create a new label for the total number of hits
      hitsLabel = new JLabel("", JLabel.CENTER);
      hitsLabel.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
      hitsLabel.setForeground(Color.WHITE);

      // create a new label for the total number of misses
      missesLabel = new JLabel("", JLabel.CENTER);
      missesLabel.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
      missesLabel.setForeground(Color.WHITE);

      // create a new label for the hit percentage
      hitPercentageLabel = new JLabel("", JLabel.CENTER);
      hitPercentageLabel.setFont(new Font("Arial", Font.PLAIN, FONT_SIZE));
      hitPercentageLabel.setForeground(Color.WHITE);

      // initialize stats
      setStats(0, 0);

      // add the labels to this panel
      add(totalShotsLabel);
      add(hitsLabel);
      add(missesLabel);
      add(hitPercentageLabel);


   }

    /* Sets the # of hits and misses */
   public void setStats(int hits, int misses) {
      this.hits = hits;
      this.misses = misses;
      updateLabels();
   }

    /* Updates the hit and miss statistics labels */
   private void updateLabels() {
      totalShotsLabel.setText("Shots: " + (hits + misses));
      hitsLabel.setText("Hits: " + hits);
      missesLabel.setText("Misses: " + misses);

      double hitPercentage = 0.0;

      // compute hit percentage, taking into account divide by zero error
      if ((hits + misses) != 0) {
            hitPercentage = (double) hits / (hits + misses);
      }

      hitPercentageLabel.setText("Hit%: " + df.format(hitPercentage));
   }
}