package org.usfirst.frc.team2927.robot.commands;

import org.usfirst.frc.team2927.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Extend extends Command {

    public Extend() {
        requires(Robot.pneumatics);
        
    }
    
    protected void initialize() {
    	
    }
    
    protected void execute() {
    	Robot.pneumatics.Extend();
    }
    
    protected boolean isFinished() {
        return true;
    }
    
    protected void end() {
    	
    }
    
    protected void interrupted() {
    	
    }
}