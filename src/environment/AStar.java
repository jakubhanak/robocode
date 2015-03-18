package environment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AStar {

	private Set<Node> open = new HashSet<Node>();
	private Set<Node> closed = new HashSet<Node>();
	private List<Node> nodes = new ArrayList<Node>();
	
	public AStar(Node start, Node goal) {

		start.setG(0);
		start.setH(manhattanDistance(start, goal));
		start.setF(start.getH());

		open.add(start);

		while (true) {
			Node current = null;

			if (open.size() == 0) {
				throw new RuntimeException("no route");
			}

			for (Node node : open) {
				if (current == null || node.getF() < current.getF()) {
					current = node;
				}
			}

			if (current == goal) {
				break;
			}

			open.remove(current);
			closed.add(current);

			for (Node neighbor : current.getNeighbors()) {
				if (neighbor == null) {
					continue;
				}

				int nextG = current.getG() + neighbor.getCost();

				if (nextG < neighbor.getG()) {
					open.remove(neighbor);
					closed.remove(neighbor);
				}

				if (!open.contains(neighbor) && !closed.contains(neighbor)) {
					neighbor.setG(nextG);
					neighbor.setH(manhattanDistance(neighbor, goal));
					neighbor.setF(neighbor.getG() + neighbor.getH());
					neighbor.setParent(current);
					open.add(neighbor);
				}
			}
		}

		
		Node current = goal;
		while (current.getParent() != null) {
			nodes.add(current);
			current = current.getParent();
		}
		nodes.add(start);


	}
	
	public List<Node> getNodes() {
		return nodes;
	}

	private int manhattanDistance(Node node1, Node node2) {
		return Math.abs(node1.getX() - node2.getX()) + Math.abs(node1.getY() - node2.getY());
	}	
}
