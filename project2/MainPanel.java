/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package race;

/**
 *
 * @author gale
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class MainPanel extends JPanel {
	Image ballImage;
   Tort currentBall = new Tort(); // instantiate our ball class
   
   Image hareImage;
   Hare currentHare = new Hare();
   
   Image mountImage;
   Mount currentMount = new Mount();

	public MainPanel() {
      
      ImageIcon mount_IMG_ICON = new ImageIcon("src/race/mount.jpg");
      mountImage = mount_IMG_ICON.getImage();
      
      /* ball */
		ImageIcon ball_IMG_ICON = new ImageIcon("src/race/tortoise1.png");
		ballImage = ball_IMG_ICON.getImage(); // get ImageIcon ball_IMG_ICON and
												// store it in Image ballImage
      
      ImageIcon hare_IMG_ICON = new ImageIcon("src/race/bunny1.png");
      hareImage = hare_IMG_ICON.getImage();
      
      prepareImage(mountImage, this);
		prepareImage(ballImage, this);
      prepareImage(hareImage, this);
      
      currentHare.setHareX(0);
      currentHare.setHareY(440);
      
		currentBall.setX(0);
		currentBall.setY(450); // set currentBall's X and Y Position
      
		setDoubleBuffered(true);

		/*
		 * Application will use buffers this is efficient as in this case the
		 * drawing is done in memory and then copied to the screen which can
		 * speed up our program although once again due to today's hardware
		 * features most Computer Systems will not lag running a program like
		 * this however this method is essential when you are drawing and
		 * animating many things at once.
		 */
		new Timer(1000, paintTimer).start();

		/*
		 * create Timer, call it in constructor of MainPanel() 15 = time between
		 * next call, measured in milliseconds. Decreasing this value can smooth
		 * animation but means your application requires more memory and
		 * processing to constantly paint, generally not a big issue today
		 * however. 15 millisecond interval equates to around 66 fps. paintTimer
		 * refers to the action method that we are going to call start()
		 * obviously starts our Timer
		 */
		// call paintTimer's action every 15 milliseconds
	}

	public void paint(Graphics g) {

		super.paint(g); // we repaint the JPanel and clear old images otherwise
						// the previous image and new image would overlap
		Graphics2D g2d = (Graphics2D) g; // creates a Graphics2D element which
											// we use for drawing
      g2d.drawImage(mountImage, currentMount.getMountX(), currentMount.getMountY(), this);
		g2d.drawImage(ballImage, currentBall.getX(), currentBall.getY(), this);// paint
																				// ballImage
																				// @
																				// currentBall's
																				// X
																				// and
																				// Y
																				// position
      g2d.drawImage(hareImage, currentHare.getHareX(), currentHare.getHareY(), this);
      
		Toolkit.getDefaultToolkit().sync(); // This is for linux systems, it
											// synchronizes the painting
											// otherwise it would not be smooth.
		g.dispose();

	}

	Action paintTimer = new AbstractAction() {

		public void actionPerformed(ActionEvent e) {// functionality of our
													// timer:

			// set X and Y co-ordinates that will then be fetched when drawing
			// the ball Image on the JPanel.
			currentBall.setX(currentBall.getX() + 50);
			currentBall.setY(currentBall.getY() + 0);
         
         currentHare.setHareX(currentHare.getHareX()+ 30);
         currentHare.setHareY(currentHare.getHareY()+ 0);
			repaint();
		}
	};
}