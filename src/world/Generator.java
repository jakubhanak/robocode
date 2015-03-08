package world;

import java.util.Random;



public class Generator {
	
	public static final int PX_STEP = 64;
	
	public static final int COLS = 12;
	public static final int ROWS = 10;
	
	private static final int SEED = 1;
	
	
//	public static int NumObstacles = (int) (WIDTH * HEIGHT * 0.3);
	public static int NumObstacles = 1;

	
	// Contains poistions of obstacles and agent
	public static int obstacles[][];

	
	public static void main(String[] args) {
		
		int NdxObstacle = 0;
		
		while (true) {
			int x = randInt(0, COLS);
			int y = randInt(0, ROWS);
			
			
			NdxObstacle++;
		}
		
	}
	
	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random(SEED);

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}	
	
	
	
}
