package world;

import java.util.Random;
import world.Coordinate;

public class Generator {

	private static final int SEED = 1;
	
	
	public static final int PX_STEP = 64;

	public static final int COLS = 12;
	public static final int ROWS = 10;


	public static final int NUM_OBSTACLES = (int) (COLS * ROWS * 0.3);

	
	// Contains poistions of obstacles, start point and destination
	public Coordinate[] obstacles = new Coordinate[NUM_OBSTACLES];
	public Coordinate start = new Coordinate();		
	public Coordinate stop = new Coordinate();	


	// Excuse the crudity of the code, never programmed in Java before
	// Could not resolve "pass-by-reference" in Java, thus the code is repeating :/
	public static void main(String[] args) {

	
		
		for (int NdxObstacle = 0; NdxObstacle < NUM_OBSTACLES; NdxObstacle++) {

			// try to find free place for an obstacle
			while (true) {
				int x = randInt(0, COLS);
				int y = randInt(0, ROWS);

				if (obstacles[NdxObstacle] != null) {
					obstacles[NdxObstacle].setX(x);
					obstacles[NdxObstacle].setY(y);
					break;
				}

			}

		}

		// try to find free place for a start position
		while (true) {
			int x = randInt(0, COLS);
			int y = randInt(0, ROWS);

			if (start != null) {
				start.setX(x);
				start.setY(y);
				break;
			}

		}

		// try to find free place for a destination
		while (true) {
			int x = randInt(0, COLS);
			int y = randInt(0, ROWS);

			if (stop != null) {
				stop.setX(x);
				stop.setY(y);
				break;
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
	private static int randInt(int min, int max) {

		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random(SEED);

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

}


