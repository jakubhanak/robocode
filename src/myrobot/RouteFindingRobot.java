package myrobot;

import java.util.TreeSet;

import environment.World;
import environment.Node;
import environment.Point;
import robocode.Robot;


public class RouteFindingRobot extends Robot {

	
	private World world = new World();
	
//	private TreeSet<Node> open = new TreeSet<Node>();
//	private TreeSet<Node> closed = new TreeSet<Node>();
//	private Node[] open, closed = new Node[];
	
//	private 
	
//	private static
	
	public void run() {
		
		doNothing();
		
//		Node n = new Node(gen.start, new Point());
//		open.add(n);
//		
//		while (true) {
//			n = open.first();
//			open.remove(n);	
//			closed.add(n);
//
//			Point[] points = new Point[4];
//			
//			// Upper square
//			points[0] = new Point(n.getCurrent().getX(), n.getCurrent().getY() + Generator.PX_STEP);
//			// Right square
//			points[1] = new Point(n.getCurrent().getX() + Generator.PX_STEP, n.getCurrent().getY());
//			// Lower square
//			points[2] = new Point(n.getCurrent().getX(), n.getCurrent().getY() - Generator.PX_STEP);
//			// Left square
//			points[3] = new Point(n.getCurrent().getX() - Generator.PX_STEP, n.getCurrent().getY());
//			
//			for (Point p : points) {
//				if (isInsideMap(p) && isClear(p)) {
//					Node adj = new Node(p, n.getCurrent());
//					if (!closed.contains(adj)) {
//						open.add(adj);
//					}
//					else if (open.contains(adj)) {
////						open.
//					}
//				}
//			}
			
//			Node nu = new Node(pu, n.getCurrent());
//			Node nr = new Node(pr, n.getCurrent());
//			Node nd = new Node(pd, n.getCurrent());
//			Node nl = new Node(pl, n.getCurrent());			
			
//			
//			
//			
////			if (lowestP)
//		}

	}
	
//	private void processPoint(Point p) {
//		if (isWalkable(p) && !closed.contains(p) && !open.contains(p)) {
////			open.add(p);	
//			
//		}
//	}
//	
//	private boolean isClear(Point p) {
//		return !world.obstacles.contains(p);
//	}
//	
//	private boolean isInsideMap(Point p) {
//		return (p.getX() >= 0 && 
//				p.getX() < World.NUM_COLS * World.SQUARE_EDGE_LENGHT &&
//				p.getY() >= 0 &&
//				p.getY() < World.NUM_ROWS * World.SQUARE_EDGE_LENGHT);
//	}

	
	
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
		ahead(num * world.getSquareEdgeLenght());
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
