package org.usfirst.frc.team2927.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightAuto extends CommandGroup {

    public RightAuto() {
    	addSequential(new SwitchConditional(new AutoSwitchRight(), new AutoLine(0.5, 1.8), true));
    }
}