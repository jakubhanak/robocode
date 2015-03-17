package myrobot;

import java.util.Arrays;
//import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

import robocode.Robot;
import world.Generator;
import world.Node;
import world.Point;


public class FirstRobot extends Robot {

	
	private Generator gen = new Generator();
	
	private TreeSet<Node> open = new TreeSet<Node>();
	private TreeSet<Node> closed = new TreeSet<Node>();
//	private Node[] open, closed = new Node[];
	
//	private 
	
//	private static
	
	public void run() {

		Node n = new Node(gen.start, new Point());
		open.add(n);
		
		while (true) {
			n = open.first();
			open.remove(n);	
			closed.add(n);

			
			Point pu = new Point(n.getCurrent().getX(), n.getCurrent().getY() + 1);
			Point pr = new Point(n.getCurrent().getX() + 1, n.getCurrent().getY());
			Point pd = new Point(n.getCurrent().getX(), n.getCurrent().getY() - 1);
			Point pl = new Point(n.getCurrent().getX() - 1, n.getCurrent().getY());
			
			Node nu = new Node(pu, n.getCurrent());
			Node nr = new Node(pr, n.getCurrent());
			Node nd = new Node(pd, n.getCurrent());
			Node nl = new Node(pl, n.getCurrent());			
			
//			
//			
//			
////			if (lowestP)
		}

	}
	
	private void processPoint(Point p) {
		if (isWalkable(p) && !closed.contains(p) && !open.contains(p)) {
//			open.add(p);	
			
		}
	}
	
	private boolean isInsideMap(Point p) {
		return (p.getX() >= 0 && 
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
