package org.usfirst.frc.team6644.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DStation extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public static String getGameData() {
		return DriverStation.getInstance().getGameSpecificMessage();
	}
	
	public static DriverStation.Alliance getAlliance() {
		return DriverStation.getInstance().getAlliance();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

