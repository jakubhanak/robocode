package world;

public class Point{

    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Point() {
    	this.x = -1;
    	this.y = -1;
    }
    
    public int getX() {
    	return x * Generator.PX_STEP + Generator.PX_OFFSET;
    }

    public int getX(boolean withoutOffset) {
    	if (withoutOffset)
    		return x;
    	else
    		return this.getX();
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
    	return y * Generator.PX_STEP + Generator.PX_OFFSET;
    }

    public int getY(boolean withoutOffset) {
    	if (withoutOffset)
    		return y;
    	else
    		return this.getY();
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        if (y != point.y) return false;

        return true;
    }

    @Override 
    public int hashCode() {
        int result = x;
        result = Generator.PX_STEP * result + y;
        return result;
    }
}