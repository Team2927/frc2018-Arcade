package org.usfirst.frc.team2927.robot.commands;

import org.usfirst.frc.team2927.robot.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pickup extends Command {
	private double speed;
    public Pickup(double speed) {
    	requires(Robot.Launcher);
    	this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.Launcher.Pickup(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.Launcher.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
