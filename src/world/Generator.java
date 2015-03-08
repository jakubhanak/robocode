package world;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Generator {

	private static final int SEED = 2;
	
	
	public static final int PX_STEP = 64;
	public static final int PX_OFFSET = 32;

	public static final int COLS = 16;
	public static final int ROWS = 10;


	public static final int NUM_OBSTACLES = (int) (COLS * ROWS * 0.25);

	
	// Contains poistions of obstacles, start point and destination
//	public static Point[] obstacles = new Point[NUM_OBSTACLES];
//	public static Point[] agent = new Point[2];		
	public Set<Point> obstacles = new HashSet<>();
	public Point start, stop;
	
	
	Random rand;

	// Excuse the crudity of the code, never programmed in Java before
	// Could not resolve "pass-by-reference" in Java, thus the code is repeating :/
	public Generator() {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		rand = new Random();
		rand.setSeed(SEED);
		
		// add the obstacles
		for (int NdxObstacle = 0; NdxObstacle < NUM_OBSTACLES; NdxObstacle++) {

			addPoint();

		}
		
		// Add the starting position
		addStart();
		
		// Add the 

	}
	
	public void addPoint() {
		// try to find free place for an obstacle
		while (true) {
			
			int x = randInt(0, COLS -1);
			int y = randInt(0, ROWS -1);
			
			Point point = new Point(x, y);
			if (!obstacles.contains(point)) {
				obstacles.add(point);
				return;
			}
		}
	}
	
	public void addStart() {
		// try to find free place for an obstacle
		while (true) {
			// -1 is due the offset
			int x = randInt(0, COLS -1);
			int y = randInt(0, ROWS -1);
			
			Point point = new Point(x, y);
			if (!obstacles.contains(point)) {
				start = point;
				return;
			}
		}
	}
	
	public void addStop() {
		// try to find free place for an obstacle
		while (true) {
			// -1 is due the offset
			int x = randInt(0, COLS -1);
			int y = randInt(0, ROWS -1);
			
			Point point = new Point(x, y);
			if (!obstacles.contains(point) && start != point) {
				stop = point;
				return;
			}
		}
	}
	

//	
//	public boolean isObstacle(int x, int y) {
//		return this.obstacles
//	}
//	

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

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}


