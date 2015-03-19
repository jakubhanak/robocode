package environment;

import java.util.List;
import java.util.ArrayList;

import environment.World;

public class Node {
	
	private List<Node> neighbors = new ArrayList<Node>();
	private Node parent;
	private int f;
	private int g;
	private int h;
	private int x;	
	private int y;
	private final int cost = 1;
	
	private int col;
	private int row;
	
	private World world;
	

	public Node(World world, int x, int y) {
		this.world = world;
		this.x = x;
		this.y = y;
		
		this.col = xToCol(x);
		this.row = yToRow(y);
	}

	public Node(World world, int col, int row, boolean useRowsCols) {
		this.world = world;
		
		if (useRowsCols) {
			this.col = col;
			this.row = row;
			
			this.x = colToX(col);
			this.y = rowToY(row);
		}
		else {
			this.x = col;
			this.y = row;
			
			this.col = xToCol(col);
			this.row = yToRow(row);	
		}
	}
	
	
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
		this.col = xToCol(x);
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
		this.row = yToRow(y);
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

    /**
     * @return
     */
    public int getCol() {
    	return col;
    }
    
    /**
     * @param col
     */
    public void setCol(int col) {
    	this.col = col;
    	this.x = colToX(col);
    }
    
    /**
     * @return
     */
    public int getRow() {
    	return row;
    }
    
    /**
     * @param row
     */
    public void setRow(int row) {
    	this.row = row;
    	this.y = rowToY(row);
    }

    public int colToX(int col) {
		return col * world.getSquareEdgeLenght() + world.getSquareCornerOffset();
	}
    
    public int rowToY(int row) {
    	return colToX(row);
    }
    
    public int xToCol(int x) {
    	return (x - world.getSquareCornerOffset()) / world.getSquareEdgeLenght();
    }
    
    public int yToRow(int y) {
    	return xToCol(y);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (col != node.col) return false;
        if (row != node.row) return false;

        return true;
    }

    @Override 
    public int hashCode() {
        return world.getSquareEdgeLenght() * col + row;
    }	

}
