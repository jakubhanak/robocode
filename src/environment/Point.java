package environment;

import environment.World;

public class Point{


	private World world;
    private int col, row;

    /**
     * @Point world
     * @param col
     * @param row
     */
    public Point(World world, int col, int row) {
    	this.world = world;
        this.col = col;
        this.row = row;
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
    }

    
    /**
     * @return true x position in pixels on the world map
     */
    public int getX() {
    	return col * world.getSquareEdgeLenght() + world.getSquareCornerOffset();
    }
    
    /**
     * @return true y position in pixels on the world map
     */
    public int getY() {
    	return row * world.getSquareEdgeLenght() + world.getSquareCornerOffset();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (col != point.col) return false;
        if (row != point.row) return false;

        return true;
    }

    @Override 
    public int hashCode() {
        int result = col;
        result = world.getSquareEdgeLenght() * result + row;
        return result;
    }
}