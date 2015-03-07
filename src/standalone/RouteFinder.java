package standalone;

import robocode.control.*;
//import robocode.control.events.*;

//asdfafd
//...

public class RouteFinder {

	public static void main(String[] args) {

		// Create the RobocodeEngine, e.g. "C:/robocode"
		RobocodeEngine engine = new RobocodeEngine(new java.io.File("/opt/robocode"));

		// Show the Robocode battle view
		engine.setVisible(true);

		// Create the battlefield
		int NumPixelRows = 800;
		int NumPixelCols = 600;

		BattlefieldSpecification battlefield = new BattlefieldSpecification(NumPixelRows, NumPixelCols); // 800x600

		// Setup battle parameters
		int numberOfRounds = 1;
		long inactivityTime = 10000000;
		double gunCoolingRate = 1.0;
		int sentryBorderSize = 50;
		boolean hideEnemyNames = false;

		// int NumObstacles = (int) Math.round(NumPixelCols * NumPixelRows * 0.3);
		int NumObstacles = 5;

		/*
		 * Create obstacles and place them at random so that no pair of obstacles are at the same position
		 */
		RobotSpecification[] modelRobots = engine.getLocalRepository("sample.SittingDuck,myrobot.FirstRobot*");

		RobotSpecification[] existingRobots = new RobotSpecification[NumObstacles + 1];
		RobotSetup[] robotSetups = new RobotSetup[NumObstacles + 1];

		for (int NdxObstacle = 0; NdxObstacle < NumObstacles; NdxObstacle++) {

			// double InitialObstacleRow = null;
			// double InitialObstacleCol = null;
			existingRobots[NdxObstacle] = modelRobots[0];
			robotSetups[NdxObstacle] = new RobotSetup(null, null, 0.0);
		}

		/*
		 * Create the agent and place it in a random position without obstacle
		 */
		existingRobots[NumObstacles] = modelRobots[1];
		// double InitialAgentRow = 1;
		// double InitialAgentCol = 1;
		robotSetups[NumObstacles] = new RobotSetup(null, null, 0.0);

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