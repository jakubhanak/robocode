package environment;

import java.util.List;
import java.util.ArrayList;

public class Node {
	
	private List<Node> neighbors = new ArrayList<Node>();
	private Node parent;
	private int f;
	private int g;
	private int h;
	private int x;
	private int y;
	private int cost;

	/**
	 * @return the neighbors
	 */
	public List<Node> getNeighbors() {
		return neighbors;
	}

	/**
	 * @param neighbors
	 *            the neighbors to set
	 */
	public void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}

	/**
	 * @return the parent
	 */
	public Node getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * @return the f
	 */
	public int getF() {
		return f;
	}

	/**
	 * @param f
	 *            the f to set
	 */
	public void setF(int f) {
		this.f = f;
	}

	/**
	 * @return the g
	 */
	public int getG() {
		return g;
	}

	/**
	 * @param g
	 *            the g to set
	 */
	public void setG(int g) {
		this.g = g;
	}

	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}

	/**
	 * @param h
	 *            the h to set
	 */
	public void setH(int h) {
		this.h = h;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
}
