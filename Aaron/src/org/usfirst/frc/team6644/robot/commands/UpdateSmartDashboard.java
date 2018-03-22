package org.usfirst.frc.team6644.robot.commands;

import org.usfirst.frc.team6644.robot.subsystems.ForceSensor;
import org.usfirst.frc.team6644.robot.subsystems.drive.DriveMotors;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class UpdateSmartDashboard extends Command {
	double[] encoderDistances;
	double[] encoderRates;
	double[] driveOutputs;
	JoystickButton linearDrive;
	JoystickButton compensate;

	// ForceSensor test;
	public UpdateSmartDashboard() {
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		DriveMotors.getInstance();
		// test=new ForceSensor(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		/*
		if (DriverStation.getInstance().isDisabled()) {
			DriveMotors.getInstance().testDrive(linearDrive.get(), compensate.get());
		}

		encoderDistances = DriveMotors.getInstance().getEncoders().encoderDistance();
		encoderRates = DriveMotors.getInstance().getEncoders().encoderRate();
		*/
		driveOutputs = DriveMotors.getInstance().getDriveOutputs();
		SmartDashboard.putNumber("Encoder distance left value", encoderDistances[0]);
		SmartDashboard.putNumber("Encoder distance right value", encoderDistances[1]);
		SmartDashboard.putNumber("Encoder rate left value", encoderRates[0]);
		SmartDashboard.putNumber("Encoder rate left value", encoderRates[1]);
		SmartDashboard.putNumber("Drive left value", driveOutputs[0]);
		SmartDashboard.putNumber("Drive right value", driveOutputs[1]);

		// SmartDashboard.putNumber("ForceSensor Voltage: ", test.getVoltage());
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
