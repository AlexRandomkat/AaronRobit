package org.usfirst.frc.team6644.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DStation extends Subsystem {
	private static Timer timer = new Timer();

	public static String getGameData() {
		String gameData = null;
		timer.reset();
		timer.start();
		while (gameData == null || timer.get() < 1.5) {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
		}
		timer.stop();
		return gameData;
	}

	public static DriverStation.Alliance getAlliance() {
		DriverStation.Alliance alliance = null;
		timer.reset();
		timer.start();
		while (alliance == null || timer.get() < 1.5) {
			alliance = DriverStation.getInstance().getAlliance();
		}
		timer.stop();
		return alliance;
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
