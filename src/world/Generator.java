package world;

import java.util.Random;



public class Generator {
	
	public static final int PX_STEP = 64;
	
	public static final int WIDTH = 12;
	public static final int HEIGHT = 10;
	
	private static final int SEED = 1;
	
	
//	public static int NumObstacles = (int) (WIDTH * HEIGHT * 0.3);
	public static int NumObstacles = (int) 1;

	// Initialize PRNG
	Random gen = new Random(SEED);
	
	for (int NdxObstacle = 0; NdxObstacle < NumObstacles; NdxObstacle++) 
		;
	
	
}
