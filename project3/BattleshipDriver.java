/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleshipdriver;

/**
 *
 * @author gale
 */
public class BattleshipDriver {

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args) {
      // TODO code application logic here
      battleshipGrid game = new battleshipGrid(10, 10);

        game.printGrid();
   }

}