
package org.usfirst.frc.team2927.robot.commands;

import org.usfirst.frc.team2927.robot.Robot;
import org.usfirst.frc.team2927.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Rotate extends Command {
	double speed;
	double angle;
	
	public Rotate(double s, double a) {
		requires(Robot.driveTrain);
		speed = s;
		angle = a;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.gyro.reset();
    }

    // Called repeatedly when this Command is scheduled to runs
    protected void execute() {
    	SmartDashboard.putNumber("Rotate Angle", RobotMap.gyro.getAngle());		//display Angle
    	if(RobotMap.gyro.getAngle() >= angle){
    		Robot.driveTrain.arcadeDrive(0, this.speed);		//Right Turn
    	} if(RobotMap.gyro.getAngle() <= angle){
    		Robot.driveTrain.arcadeDrive(0, -this.speed);		//Left Turn
    	}
    }
    
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	SmartDashboard.putNumber("Variation ", Math.abs(angle)- Math.abs(RobotMap.gyro.getAngle()));
        if(Math.abs(angle)- Math.abs(RobotMap.gyro.getAngle()) < 2) {
        	return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
    
}
