package world;

import robocode.control.*;
//import world.Coordinate;

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

		Generator gen = new Generator();
		
		// Create the battlefield
		int NumPixelCols = Generator.COLS * Generator.PX_STEP;
		int NumPixelRows = Generator.ROWS * Generator.PX_STEP;

		BattlefieldSpecification battlefield = new BattlefieldSpecification(NumPixelCols, NumPixelRows);
		

		/*
		 * Create obstacles and place them at random so that no pair of obstacles are at the same position
		 */
		RobotSpecification[] modelRobots = engine.getLocalRepository("sample.SittingDuck,myrobot.FirstRobot*");

		RobotSpecification[] existingRobots = new RobotSpecification[Generator.NUM_OBSTACLES + 1];
		RobotSetup[] robotSetups = new RobotSetup[Generator.NUM_OBSTACLES + 1];

		int NdxObstacle = 0;
		for (Point p : gen.obstacles) {
			// added offset so the tanks are in the middle of the tiles
			double InitialObstacleCol = (double) p.getX_();
			double InitialObstacleRow = (double) p.getY_();
			existingRobots[NdxObstacle] = modelRobots[0];
			robotSetups[NdxObstacle++] = new RobotSetup(InitialObstacleCol, InitialObstacleRow, 0.0);
		}

		/*
		 * Create the agent and place it in a random position without obstacle
		 */
		existingRobots[Generator.NUM_OBSTACLES] = modelRobots[1];
		double InitialAgentCol = (double) gen.start.getX_();
		double InitialAgentRow = (double) gen.start.getY_();
		robotSetups[Generator.NUM_OBSTACLES] = new RobotSetup(InitialAgentCol, InitialAgentRow, 0.0);

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