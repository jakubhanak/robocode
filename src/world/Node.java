package world;

import world.Point;

public class Node implements Comparable<Node>{
//	
//	public static int lowestF;
//	
//	public static Point lowestP;
	
	public static final int COST = 1;
	
	private Point current, parent;
	
	private int F, G, H;

	public Node(Point current, Point parent) {
		
		this.current = current;
		this.parent = parent;
		
		G += COST;
		H = manhattan(parent, current);
		F = G + H;
	}
//	
//	public Node(Point current) {
//		this.current = current;
//		
//		H = manhattan(new Point(), current);
//		F = G + H;
//	}
	
	private int manhattan(Point start, Point stop) {
		return Math.abs(start.getX() - stop.getX()) + Math.abs(start.getX() - stop.getY());
	}
	
	public int getF() {
		return F;
	}
	
	public int getG() {
		return G;
	}

	public int getH() {
		return H;
	}
	
	public Point getCurrent() {
		return current;
	}
	
	public Point getParent() {
		return parent;
	}
	
	@Override
	public int compareTo(Node compareNode) {
		 
		int compareQuantity = ((Node) compareNode).getF(); 
 
		//ascending order
		return this.F - compareQuantity;
 
		//descending order
		//return compareQuantity - this.quantity;
 
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (current.getX() != node.current.getX()) return false;
        if (current.getY() != node.current.getY()) return false;

        return true;
    }

    @Override 
    public int hashCode() {
        int result = current.getX();
        result = Generator.PX_STEP * result + current.getY();
        return result;
    }	
}
