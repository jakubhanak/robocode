package myrobot;

/*******************************************************************************
 * Copyright (c) 2001-2014 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/epl-v10.html
 *******************************************************************************/

import robocode.HitByBulletEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * MyFirstRobot - a sample robot by Mathew Nelson.
 * <p/>
 * Moves in a seesaw motion, and spins the gun around at each end.
 *
 * @author Mathew A. Nelson (original)
 */
public class FirstRobot extends Robot {

	/**
	 * MyFirstRobot's run method - Seesaw
	 */
	public void run() {

		while (true) {
			right();
			ahead(128);

			down();
			ahead(64);

			left();
			ahead(128);

			up();
			ahead(64);
			
			right();
			ahead(128);		

			up();
			ahead(64);		
			
			left();
			ahead(128);
			
			down();
			ahead(64);

		}

	}

	public void up() {
		turn(0);
	}

	public void right() {
		turn(90);
	}

	public void down() {
		turn(180);
	}

	public void left() {
		turn(270);
	}

	private void turn(int dest) {
		int curr = (int) getHeading();
		if (curr != dest) {
			int diff = curr - dest;
			if (Math.abs(diff) > 180)
				turnRight(diff % 180);
			else
				turnLeft(diff);
		}
	}



	/**
	 * Fire when we see a robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		fire(1);
	}

	/**
	 * We were hit! Turn perpendicular to the bullet, so our seesaw might avoid a future shot.
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		turnLeft(90 - e.getBearing());
	}
}
