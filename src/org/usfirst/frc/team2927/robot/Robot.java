/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2927.robot;
import edu.wpi.first.wpilibj.TimedRobot;

import org.usfirst.frc.team2927.robot.commands.*;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2927.robot.subsystems.*;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;

import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {	
	//create a link to the subsystems
	public static DriveTrain driveTrain;
	public static Launcher Launcher;
	public static Pneumatics pneumatics;

	/** camera stuff**/
	CameraServer camServer;
	public static UsbCamera camFront;
	public static UsbCamera camBack;
	VideoSink server;

	/** Controls/inputs **/
	public static OI oi;

	/** Auto Stuff **/
	Command m_autonomousCommand;
	SendableChooser<Command> m_Command;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();

		driveTrain = new DriveTrain();
		Launcher = new Launcher();
		pneumatics = new Pneumatics();

		// OI must be constructed after subsystems.
		oi = new OI();

		/** Camera stuff **/
		CameraServer front = CameraServer.getInstance();
		front.startAutomaticCapture(0);
		CameraServer back = CameraServer.getInstance();
		back.startAutomaticCapture(1);
		server = CameraServer.getInstance().getServer();

		/** Auto stuffs **/
		m_Command = new SendableChooser<>();
		m_Command.addDefault("default", new AutoLine(0.5, 1.8));
		m_Command.addObject("Right Switch", new RightAuto());
		m_Command.addObject("Left Switch", new LeftAuto());
		m_Command.addObject("Do Nothing", null);
		SmartDashboard.putData("Auto Mode", m_Command);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		SmartDashboard.putString("Progress", "");
		SmartDashboard.putNumber("TellyOP Angle", 0);
		SmartDashboard.putNumber("Rotate Angle", 0);
		m_autonomousCommand = m_Command.getSelected();		
		if(m_autonomousCommand != null){
			m_autonomousCommand.start();		//Start Autonomous
		}
	}//end Autonomous

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.

		/*if (auto1 != null) {
			auto1.cancel();
		}*/
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
		RobotMap.gyro.reset();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("TellyOP Angle", RobotMap.gyro.getAngle());		//display Angle
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}

}