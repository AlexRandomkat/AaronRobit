package org.usfirst.frc.team6644.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team6644.robot.Robot;
import org.usfirst.frc.team6644.robot.subsystems.Encoders;
import org.usfirst.frc.team6644.robot.subsystems.Gyro;
import org.usfirst.frc.team6644.robot.subsystems.drive.DriveMotors;

/**
 *
 */
public class DriveStraight extends Command {
	

		private double speed = 0;
		private double distance = 0;
		private double kP = 0.1;
		private boolean done = false;

		public DriveStraight(double distance, double speed) {
			// Use requires() here to declare subsystem dependencies
			requires(DriveMotors.getInstance());
			DriveMotors.getInstance().startAutoMode();
			this.speed = speed;
			this.distance = distance;
		}

		// Called just before this Command runs the first time
		protected void initialize() {
			Gyro.getInstance().reset();
			Robot.encoders.reset();
			DriveMotors.getInstance().startAutoMode();
		}

		// Called repeatedly when this Command is scheduled to run
		protected void execute() {
			double[] encoderValues = Robot.encoders.getDistance();
			double averageEncoder = (encoderValues[0] + encoderValues[1]) / 2;
			if(averageEncoder >= distance)
				this.done = true;
			DriveMotors.getInstance().arcadeDrive(speed, Gyro.getInstance().getDegrees() * kP);
		}

		// Make this return true when this Command no longer needs to run execute()
		protected boolean isFinished() {
			return done;
		}

		// Called once after isFinished returns true
		protected void end() {
			DriveMotors.getInstance().stop();
		}

		// Called when another command which requires one or more of the same
		// subsystems is scheduled to run
		protected void interrupted() {
		}
	}
