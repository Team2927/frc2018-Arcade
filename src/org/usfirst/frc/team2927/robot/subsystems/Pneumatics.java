package org.usfirst.frc.team2927.robot.subsystems;

import org.usfirst.frc.team2927.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

    DoubleSolenoid L = RobotMap.leftArm;
    DoubleSolenoid R = RobotMap.rightArm;

    public void Extend() {
    	L.set(Value.kForward);
    	R.set(Value.kForward);
    }
    
    public void Retract() {
    	L.set(Value.kReverse);
    	R.set(Value.kReverse);
    }
    
    public void initDefaultCommand() {
    }
}