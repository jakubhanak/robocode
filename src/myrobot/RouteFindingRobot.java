package myrobot;

import java.awt.Graphics2D;
import java.util.List;

import com.google.common.collect.Lists;

import environment.AStar;
import environment.World;
import environment.Node;
import robocode.Robot;

public class RouteFindingRobot extends Robot {

	private World world = new World();

	public void run() {

		AStar aStar = new AStar(world);

		List<Node> nodes = aStar.getNodes();

		
		
		for (Node node : Lists.reverse(nodes)) {
			Node parent = node.getParent();
			if (parent != null)
				followPath(node, parent);
		}

		doNothing();

	}

	public void onPaint(Graphics2D g) {
		// Set the paint color to red
		g.setColor(java.awt.Color.GREEN);
		// Paint a filled rectangle at (50,50) at size 100x150 pixels
		g.fillRect(world.getStop().getX() - 16,
				world.getStop().getY() - 16, 32, 32);
	}

	private void followPath(Node node, Node parent) {
		if (node.getCol() < parent.getCol())
			left();
		else if (node.getCol() > parent.getCol())
			right();
		else if (node.getRow() < parent.getRow())
			down();
		else if (node.getRow() > parent.getRow())
			up();
		else
			throw new RuntimeException("wrong movement");

	}

	private void turn(int destination) {
		int current = (int) getHeading();
		if (current != destination) {
			int difference = current - destination;
			if (Math.abs(difference) > 180)
				turnRight(difference % 180);
			else
				turnLeft(difference);
		}
	}

	private void steps(int num) {
		ahead(num * world.getSquareEdgeLenght());
	}

	private void step() {
		steps(1);
	}

	private void up() {
		north();
		step();
	}

	private void right() {
		east();
		step();
	}

	private void down() {
		south();
		step();
	}

	private void left() {
		west();
		steps(1);
	}

	private void north() {
		turn(0);
	}

	private void east() {
		turn(90);
	}

	private void south() {
		turn(180);
	}

	private void west() {
		turn(270);
	}

}
