package environment;

import java.util.Set;
import java.util.HashSet;
import java.util.Random;

public class World {

	// PRNG seed - level
	private final int LEVEL = 2;

	// Dimensional constants to match the background's grid pattern
	private final int SQUARE_EDGE_LENGHT = 64;
	private final int SQUARE_CORNER_OFFSET = 32;

	// Map size
	private final int NUM_COLS = 16;
	private final int NUM_ROWS = 10;

	// Obstacle (sitting ducks) count
	private final int NUM_OBSTACLES = (int) (NUM_COLS * NUM_ROWS * 0.25);

	// Contains poistions of obstacles, start point and destination
	private Set<Point> obstacles = new HashSet<>();
	private Point start, stop;

	// PRNG instance
	private Random rand;

	// Excuse the crudity of the code, never programmed in Java before
	// Could not resolve "pass-by-reference" in Java, thus the code is repeating :/
	public World() {

		// Seed the PRNG with the level
		rand = new Random();
		rand.setSeed(LEVEL);

		// Generate the obstacles
		for (int i = 0; i < getNumObstacles(); i++) 
			obstacles.add(fillEmptyPosition());

		// Generate start/stop positions
		start = fillEmptyPosition();
		stop = fillEmptyPosition();
		
	}


	/**
	 * @return the level
	 */
	public int getLevel() {
		return LEVEL;
	}

	/**
	 * @return the squareEdgeLenght
	 */
	public int getSquareEdgeLenght() {
		return SQUARE_EDGE_LENGHT;
	}

	/**
	 * @return the squareCornerOffset
	 */
	public int getSquareCornerOffset() {
		return SQUARE_CORNER_OFFSET;
	}

	/**
	 * @return the numCols
	 */
	public int getNumCols() {
		return NUM_COLS;
	}

	/**
	 * @return the numRows
	 */
	public int getNumRows() {
		return NUM_ROWS;
	}

	/**
	 * @return the numObstacles
	 */
	public int getNumObstacles() {
		return NUM_OBSTACLES;
	}

	/**
	 * @return the obstacles
	 */
	public Set<Point> getObstacles() {
		return obstacles;
	}

	/**
	 * @return the start point
	 */
	public Point getStart() {
		return start;
	}

	/**
	 * @return the stop point
	 */
	public Point getStop() {
		return stop;
	}


	/**
	 * @return the worldWidth in px
	 */
	public int getWorldWidth() {
		return getNumCols() * getSquareEdgeLenght();
	}

	/**
	 * @return the worldHeight in px
	 */
	public int getWorldHeight() {
		return getNumRows() * getSquareEdgeLenght();
	}	
	

	private Point fillEmptyPosition() {
		// try to find free place for an obstacle
		while (true) {

			int col = randInt(0, getNumCols() - 1);
			int row = randInt(0, getNumRows() - 1);

			// Generate point in this world
			Point point = new Point(this, col, row);
			
			// Check if the point is still free
			if (!obstacles.contains(point) && start != point && stop != point) {
				return point;
			}
		}
	}
	
	
	/**
	 * Returns a pseudo-random number between min and max, inclusive. The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min
	 *            Minimum value
	 * @param max
	 *            Maximum value. Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	private int randInt(int min, int max) {

		// Make sure the randomizer was initialised
		if (rand == null)
			throw new RuntimeException("PRNG not initialised prior to call");

		// nextInt is normally exclusive of the top value, so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}
