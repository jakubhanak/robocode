package environment;

import robocode.control.*;
//import world.Coordinate;

//import robocode.control.events.*;

public class RouteFinder {

	public static void main(String[] args) {

		// Location of the robocode, e.g. "C:/robocode"
		final String location = "/opt/robocode";

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
		
		// The world instance with the obstacles, the start and the stop position
		World world = new World();
		
		// Create the battlefield
		BattlefieldSpecification battlefield = new BattlefieldSpecification(world.getWorldWidth(), world.getWorldHeight());
		

		// Create obstacles and place them at random so that no pair of obstacles are at the same position
		RobotSpecification[] modelRobots = engine.getLocalRepository("sample.SittingDuck,myrobot.RouteFindingRobot*");

		RobotSpecification[] existingRobots = new RobotSpecification[world.getNumObstacles() + 1];
		RobotSetup[] robotSetups = new RobotSetup[world.getNumObstacles() + 1];

		int NdxObstacle = 0;
		for (Point point : world.getObstacles()) {
			// added offset so the tanks are in the middle of the tiles
			double InitialObstacleCol = (double) point.getX();
			double InitialObstacleRow = (double) point.getY();
			existingRobots[NdxObstacle] = modelRobots[0];
			robotSetups[NdxObstacle++] = new RobotSetup(InitialObstacleCol, InitialObstacleRow, 0.0);
		}

		// Create the agent and place it in a random position without obstacle
		existingRobots[world.getNumObstacles()] = modelRobots[1];
		double InitialAgentCol = (double) world.getStart().getX();
		double InitialAgentRow = (double) world.getStart().getY();
		robotSetups[world.getNumObstacles()] = new RobotSetup(InitialAgentCol, InitialAgentRow, 0.0);

		// Create and run the battle
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