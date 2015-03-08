package world;

public class Point{

    private int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
    	return x;
    }

    public int getX_() {
        return x * Generator.PX_STEP + Generator.PX_OFFSET;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
    	return y;
    }

    public int getY_() {
        return y * Generator.PX_STEP + Generator.PX_OFFSET;
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