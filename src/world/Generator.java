package world;

import java.util.Random;

public class Generator {

	public static final int PX_STEP = 64;

	public static final int COLS = 12;
	public static final int ROWS = 10;

	private static final int SEED = 1;

	public static int NumObstacles = (int) (COLS * ROWS * 0.3);

	
	// Contains poistions of obstacles, start point and destination
	public static int[] obstacles = new int[NumObstacles];

	// Excuse the crudity of the code, never programmed in Java before
	public static void main(String[] args) {

		
		for (int NdxObstacle = 0; NdxObstacle < NumObstacles; NdxObstacle++) {

//			// try to find free place for an obstacle
//			while (true) {
//				int x = randInt(0, COLS);
//				int y = randInt(0, ROWS);
//
//				if (obstacles[x][y] == 0) {
//					obstacles[x][y] = 1;
//					break;
//				}
//
//			}

		}

/*		// try to find free place for a start position
		while (true) {
			int x = randInt(0, COLS);
			int y = randInt(0, ROWS);

			if (start[x][y] == 0) {
				start[x][y] = 1;
				break;
			}

		}

		// try to find free place for a destination
		while (true) {
			int x = randInt(0, COLS);
			int y = randInt(0, ROWS);

			if (stop[x][y] == 0) {
				stop[x][y] = 1;
				break;
			}

		}*/

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
