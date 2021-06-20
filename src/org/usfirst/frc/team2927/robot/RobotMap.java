/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2927.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static SpeedController driveTrainLeftFront;
	public static SpeedController driveTrainLeftBack;
	public static SpeedControllerGroup m_left;
	public static SpeedController driveTrainRightFront;
	public static SpeedController driveTrainRightBack;
	public static SpeedControllerGroup m_right;
    public static SpeedController launcherLeft;
    public static SpeedController launcherRight;
    public static SpeedController attachmentMotor3;
    public static SpeedController attachmentMotor4;
    public static SpeedController attachmentMotor5;
    public static SpeedController attachmentMotor6;
    public static DifferentialDrive driveTrainRobotDrive;
    
    public static Compressor pnueCompressor;
    public static Relay leds;
	public static DoubleSolenoid leftArm;
	public static DoubleSolenoid rightArm;
	//private static final int kport = 0;
	public static ADXRS450_Gyro gyro;
    
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
    public static void init() {
    	driveTrainLeftFront = new Talon(2);
    	driveTrainLeftBack = new Talon(3);
    	m_left = new SpeedControllerGroup(driveTrainLeftFront, driveTrainLeftBack);
    	driveTrainRightFront = new Talon(1);
    	driveTrainRightBack = new Talon(0);
    	m_right= new SpeedControllerGroup(driveTrainRightFront, driveTrainRightBack);
        launcherLeft = new Talon(4);
        launcherRight = new Talon(5);
        //attachmentMotor3 = new Talon(6);
        //attachmentMotor4 = new Talon(7);
        //attachmentMotor5 = new Talon(8);
        //attachmentMotor6 = new Talon(9);
        driveTrainRobotDrive = new DifferentialDrive(m_left, m_right);
        
        //driveTrainRobotDrive.setSafetyEnabled(saftey);
        //driveTrainRobotDrive.setExpiration(0.2);
        driveTrainRobotDrive.setMaxOutput(3.0);
        
        gyro = new ADXRS450_Gyro();
        leds = new Relay(0);
        
        pnueCompressor = new Compressor(0);
		
		leftArm = new DoubleSolenoid(0, 0, 1);
		rightArm = new DoubleSolenoid(0, 3, 2);
    }
    
	public static final boolean saftey = true;
}
