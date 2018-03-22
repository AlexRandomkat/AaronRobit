package org.usfirst.frc.team6644.robot.commands;

import org.usfirst.frc.team6644.robot.OI;
import org.usfirst.frc.team6644.robot.subsystems.GrabberMotors;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabberEStop extends Command {

	public GrabberEStop() {
		// Use requires() here to declare subsystem dependencies
		// requires(GrabberMotors.getInstance());
		requires(GrabberMotors.getInstance());
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		GrabberMotors.getInstance().fold(0);
		GrabberMotors.getInstance().setSpeed(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		GrabberMotors.getInstance().fold(0);
		GrabberMotors.getInstance().setSpeed(0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return OI.grabberEStop.get();
	}

	// Called once after isFinished returns true
	protected void end() {
		GrabberMotors.getInstance().fold(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
