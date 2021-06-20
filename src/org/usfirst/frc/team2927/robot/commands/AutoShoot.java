
package org.usfirst.frc.team2927.robot.commands;

import org.usfirst.frc.team2927.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoShoot extends Command {
	double speed;
	double delay;
	Timer t;
	
	public AutoShoot(double s, double d) {
		requires(Robot.Launcher);
		speed = s;
		delay = d;
		t = new Timer();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	t.reset();
    	t.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.Launcher.Shoot(this.speed);
    	SmartDashboard.putNumber("Shoot Timer", t.get());
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (t.get()>=delay){
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.Launcher.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
    
}
