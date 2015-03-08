package standalone;

import robocode.control.*;
//import robocode.control.events.*;


public class RouteFinder {

	
	
	public static void main(String[] args) {

		// Location of the robocode, e.g. "C:/robocode"
		String location = "/opt/robocode";
		
		// Setup battle parameters
		int numberOfRounds = 1;
		long inactivityTime = 10000000;
		double gunCoolingRate = 1.0;
		int sentryBorderSize = 50;
		boolean hideEnemyNames = false;

	
		// Create the RobocodeEngine
		RobocodeEngine engine = new RobocodeEngine(new java.io.File(location));

		// Show the Robocode battle view
		engine.setVisible(true);

		// Create the battlefield
		int NumPixelRows = world.Generator.ROWS * world.Generator.PX_STEP;
		int NumPixelCols = world.Generator.COLS * world.Generator.PX_STEP;

		BattlefieldSpecification battlefield = new BattlefieldSpecification(NumPixelRows, NumPixelCols); 



		/*
		 * Create obstacles and place them at random so that no pair of obstacles are at the same position
		 */
		RobotSpecification[] modelRobots = engine.getLocalRepository("sample.SittingDuck,myrobot.FirstRobot*");

		RobotSpecification[] existingRobots = new RobotSpecification[world.Generator.NumObstacles + 1];
		RobotSetup[] robotSetups = new RobotSetup[world.Generator.NumObstacles + 1];

		for (int NdxObstacle = 0; NdxObstacle < world.Generator.NumObstacles; NdxObstacle++) {

			// double InitialObstacleRow = null;
			// double InitialObstacleCol = null;
			existingRobots[NdxObstacle] = modelRobots[0];
			robotSetups[NdxObstacle] = new RobotSetup(null, null, 0.0);
		}

		/*
		 * Create the agent and place it in a random position without obstacle
		 */
		existingRobots[world.Generator.NumObstacles] = modelRobots[1];
		// double InitialAgentRow = 1;
		// double InitialAgentCol = 1;
		robotSetups[world.Generator.NumObstacles] = new RobotSetup(null, null, 0.0);

		/* Create and run the battle */
		BattleSpecification battleSpec = new BattleSpecification(battlefield, numberOfRounds, inactivityTime, gunCoolingRate,
				sentryBorderSize, hideEnemyNames, existingRobots, robotSetups);

		// Run our specified battle and let it run till it is over
		engine.runBattle(battleSpec, true); // waits till the battle finishes

		// Cleanup our RobocodeEngine
		engine.close();

		// Make sure that the Java VM is shut down properly
		System.exit(0);
	}

}