package myrobot;

import robocode.Robot;


public class FirstRobot extends Robot {

	public void run() {

		while (true) {
			doNothing();

		}

	}

	public void north() {
		turn(0);
	}

	public void east() {
		turn(90);
	}

	public void south() {
		turn(180);
	}

	public void west() {
		turn(270);
	}
	
	public void steps(int num) {
		ahead(num * world.Generator.STEP);
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




}
