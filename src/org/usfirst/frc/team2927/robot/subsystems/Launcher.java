package org.usfirst.frc.team2927.robot.subsystems;

import org.usfirst.frc.team2927.robot.*;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Launcher extends Subsystem {
    
	Talon Left = (Talon) RobotMap.launcherLeft;
	Talon Right = (Talon) RobotMap.launcherRight;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void Shoot(double speed){
    	Left.set(speed);
    	Right.set(-speed);
    }
    
    public void Pickup(double speed){
    	Left.set(-speed);
    	Right.set(speed);
    }
    
    public void stop(){
    	Left.set(0);
    	Right.set(0);
    }
    
}

