package org.usfirst.frc.team6644.robot.commands;

import org.usfirst.frc.team6644.robot.subsystems.GrabberMotors;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDrop extends Command {
	private double speed = 0.3;

	public AutoDrop() {
		// Use requires() here to declare subsystem dependencies
		requires(GrabberMotors.getInstance());
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		GrabberMotors.getInstance().setSpeed(-speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		GrabberMotors.getInstance().stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
