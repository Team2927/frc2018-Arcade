

package org.usfirst.frc.team2927.robot.subsystems;

import org.usfirst.frc.team2927.robot.*;
import org.usfirst.frc.team2927.robot.commands.*;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {
	private final DifferentialDrive robotDrive = RobotMap.driveTrainRobotDrive;
	
	ADXRS450_Gyro g = RobotMap.gyro;
	SpeedControllerGroup l = RobotMap.m_left;
	SpeedControllerGroup r = RobotMap.m_right;
    
	public void drive(double RMotor, double LMotor) {
		r.set(RMotor);
		l.set(LMotor);
	}
	
	public void stop() {
		l.set(0);
		r.set(0);
	}
	
    public void arcadeDrive(double xSpeed, double zRotate) {
		robotDrive.arcadeDrive(xSpeed, zRotate);
	}
    
    public void initDefaultCommand() {
    	double angle = g.getAngle();
    	SmartDashboard.putNumber("Angle: ", angle);
    	setDefaultCommand(new DriveWithJoystick());
    }
    
    
}

