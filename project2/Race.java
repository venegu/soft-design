/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race;

import java.security.SecureRandom;
import java.awt.Panel;
import javax.swing.*;

/**
 *
 * @author gale
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Race extends JFrame {
	// Simple Object class used to add our MainPanel to a JFrame so that it can
	// be displayed without the use of an applet.
	MainPanel mPanel;

	Race() {

		setTitle("Ball animation");
		mPanel = new MainPanel();
		setSize(700, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(mPanel); // add MainPanel JPanel to JFrame
		setVisible(true); // show class

	}

	public static void main(String[] args) {
		new Race();
      
      Hare currentHare = new Hare();
      
      /* Sim Logic */
      Boolean simNotOver = true;
      
      while(simNotOver) {
         
      }
	}
}
