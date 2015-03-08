package myrobot;

import java.util.HashSet;
import java.util.Set;

import robocode.Robot;
import world.Generator;
import world.Point;


public class FirstRobot extends Robot {

	// cost is always 1 because we do not move on diagonals
	public static final int G = 1;
	
	private static Generator gen = new Generator();
	
	private static Set<Point> open = new HashSet<>();
	private static Set<Point> closed = new HashSet<>();
	
	private static Point lowestP;
	private static int lowestF = 0;
	
	public void run() {

		
		while (true) {
		
			open.add(gen.start);
			
			for (Point p : open) {
				int H = Manhattan(p, gen.stop);
				int F = G + H;
				
				if (lowestF == 0 || lowestF >= F) {
					lowestF = F;
					lowestP = p;
				}
			}
			
			open.remove(lowestP);
			closed.add(lowestP);
			
			Point pu = new Point(lowestP.getX(), lowestP.getY() + 1);
			Point pr = new Point(lowestP.getX() + 1, lowestP.getY());
			Point pd = new Point(lowestP.getX(), lowestP.getY() - 1);
			Point pl = new Point(lowestP.getX() - 1, lowestP.getY());
			
			
			
//			if (lowestP)
		}

	}
	
	private void calculatePoint(Point p) {
		if (isWalkable(p)) {
			if (!open.contains(p)) {
				open.add(p);	
			}
		}
	}
	
	private boolean isWalkable(Point p) {
		return (!gen.obstacles.contains(p) && 
				!closed.contains(p) &&
				p.getX() >= 0 && 
				p.getX() < Generator.ROWS &&
				p.getY() >= 0 &&
				p.getY() < Generator.COLS);
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
	
	public void steps(int num) {
		ahead(num * world.Generator.PX_STEP);
	}

	private int Manhattan(Point start, Point stop) {
		return Math.abs(start.getX() - stop.getX()) + Math.abs(start.getX() - stop.getY());
	}
	
	public void up() {
		north();
		steps(1);
	}
	
	public void right() {
		east();
		steps(1);
	}
	
	public void down() {
		south();
		steps(1);
	}
	
	public void left() {
		west();
		steps(1);
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

}
