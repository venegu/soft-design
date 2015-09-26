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
public class Tort {
	/*
	 * Simple Object class to store the ball's co-ordinates.
	 */
	private int x;
	private int y;

	Tort() {
		;
	} // default constructor

	public int getX() { // accessor/GET method for data
		return x;
	}

	public void setX(int x2) { // mutator/SET method for data
		x = x2;
	}

	public int getY() {
		return y;
	}

	public void setY(int y2) {
		y = y2;
	}
}
