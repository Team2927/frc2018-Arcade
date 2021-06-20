package org.usfirst.frc.team2927.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoSwitchRight extends CommandGroup {

	public AutoSwitchRight() {
		//addSequential(new AutoLine(0.5, 1.8));
		//SmartDashboard.putString("Progress", "Finished Line");
		addSequential(new Rotate(0.34, 90));
		SmartDashboard.putString("Target Angle?", "90");
		SmartDashboard.putString("Progress", "Finished Rotating");
		//addSequential(new AutoShoot(0.5, 0.3));
		//SmartDashboard.putString("Progress", "Finished Shooting");
	}
}