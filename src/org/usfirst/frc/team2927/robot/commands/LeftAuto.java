package org.usfirst.frc.team2927.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftAuto extends CommandGroup {

    public LeftAuto() {
    	addSequential(new SwitchConditional(new AutoSwitchLeft(), new AutoLine(0.5, 1.8), false));
    }
}