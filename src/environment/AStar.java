package environment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import environment.Node;
import environment.World;

public class AStar {

	private World world;

	public AStar(World world) {

		this.world = world;

	}

	
	/**
	 * @return the nodes
	 */
	public List<Node> getNodes() {
		// Variable initializations
		List<Node> nodes = new ArrayList<Node>();

		Set<Node> open = new HashSet<Node>();
		Set<Node> closed = new HashSet<Node>();

		Node start = new Node(world, world.getStart().getX(), world.getStart().getY());
		Node stop = new Node(world, world.getStop().getX(), world.getStop().getY());

		// Calculate the initial attributes
		start.setG(0);
		start.setH(manhattanDistance(start, stop));
		start.setF(start.getH());

		// Add the first node to the open set
		open.add(start);

		while (true) {
			Node current = null;

			// Stop when there are no other nodes in the open set
			if (open.size() == 0) {
				throw new RuntimeException("no route");
			}

			// Find the node with the lowest F
			for (Node node : open) {
				if (current == null || node.getF() < current.getF()) {
					current = node;
				}
			}

			// Stop when the destination node is found
			if (current.equals(stop)) {
				stop.setParent(current.getParent());
				break;
			}

			// Swtich the current node from open to closed list
			open.remove(current);
			closed.add(current);

			// Add four adjacent neihbours
			List<Node> neighbors = new ArrayList<Node>();
			neighbors.add(new Node(world, current.getX() + world.getSquareEdgeLenght(), current.getY()));
			neighbors.add(new Node(world, current.getX() - world.getSquareEdgeLenght(), current.getY()));
			neighbors.add(new Node(world, current.getX(), current.getY() + world.getSquareEdgeLenght()));
			neighbors.add(new Node(world, current.getX(), current.getY() - world.getSquareEdgeLenght()));
			current.setNeighbors(neighbors);

			
			// Foreach through the neighbours
			for (Node neighbor : current.getNeighbors()) {
				
				// Ignore occupied and out-of-the-map modes
				if (neighbor == null || isOccupied(neighbor) || isOutsideMap(neighbor)) {
					continue;
				}

				// Recalculate the G
				int nextG = current.getG() + neighbor.getCost();

				// Comapre and use the one with lower G (better path)
				if (nextG < neighbor.getG()) {
					open.remove(neighbor);
					closed.remove(neighbor);
				}

				// Add the new neighbour to the open set if not present 
				if (!open.contains(neighbor) && !closed.contains(neighbor)) {
					neighbor.setG(nextG);
					neighbor.setH(manhattanDistance(neighbor, stop));
					neighbor.setF(neighbor.getG() + neighbor.getH());
					neighbor.setParent(current);
					open.add(neighbor);
				}
			}
		}

		// Create the List of the path
		Node current = stop;
		while (current.getParent() != null) {
			nodes.add(current);
			current = current.getParent();
		}
		nodes.add(start);

		return nodes;
	}

	private int manhattanDistance(Node node1, Node node2) {
		return Math.abs(node1.getX() - node2.getX()) + Math.abs(node1.getY() - node2.getY());
	}

	private boolean isOccupied(Node node) {
		return world.getObstacles().contains(node);
	}

	private boolean isOutsideMap(Node node) {
		return !(node.getX() >= 0 && node.getX() < world.getWorldWidth() && node.getY() >= 0 && node.getY() < world
				.getWorldHeight());
	}

}
