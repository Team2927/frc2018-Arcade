/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2927.robot;

import org.usfirst.frc.team2927.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public Joystick controller;
	public JoystickButton shoot;
	public JoystickButton pull;
	public JoystickButton armDown;
	public JoystickButton armUP;
	/*
	public JoystickButton ***;
	public JoystickButton ***;
	public JoystickButton ***;
	public JoystickButton ***;
	public JoystickButton ***;
	public JoystickButton ***;
	public JoystickButton ***;
	*/
	
	public OI(){
		//// CREATING BUTTONS
		// You create one by telling it which joystick it's on and which button
		// number it is.
		// Joystick stick = new Joystick(port);
		// Button button = new JoystickButton(stick, buttonNumber);
		controller = new Joystick(0);
		shoot = new JoystickButton(controller, 1);
		pull = new JoystickButton(controller, 2);
		armDown = new JoystickButton(controller, 3);
		// **** = new JoystickButton(controller, 4);
		armUP = new JoystickButton(controller, 5);
		// **** = new JoystickButton(controller, 6);
		// noob = new JoystickButton(controller, 7);
		// novis = new JoystickButton(controller, 8);
		// regular = new JoystickButton(controller, 9);
		// advanced = new JoystickButton(controller, 10);
		// **** = new JoystickButton(controller, 11);
		// **** = new JoystickButton(controller, 12);
		
		armUP.whenPressed(new Extend());
		armUP.whileHeld(new Pickup(0.5));
		armDown.whenPressed(new Retract());
		shoot.whileHeld(new Shoot(1.5));
		pull.whileHeld(new Pickup(0.5));
	}
    public Joystick getController() {
    	return controller;
    }
}
