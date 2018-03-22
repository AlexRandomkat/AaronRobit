package org.usfirst.frc.team6644.robot.commands;

import org.usfirst.frc.team6644.robot.subsystems.drive.DriveMotors;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Calibrate extends Command {
	double i = -1;

	public Calibrate() {
		// Use requires() here to declare subsystem dependencies
		requires(DriveMotors.getInstance());
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		DriveMotors.getInstance().startAutoMode();
		System.out.println("\n\n\n\n\n_________________________________\n\n\t\t\tCalibrate Starting...");
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		DriveMotors.getInstance().tankDrive(i, i, false);
		i += 0.01;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return i > 1;
	}

	// Called once after isFinished returns true
	protected void end() {
		DriveMotors.getInstance().stop();
		System.out.println("\n\t\t\tCalibrate Ended\n_________________________________");
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
