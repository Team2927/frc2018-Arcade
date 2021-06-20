package org.usfirst.frc.team2927.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.ConditionalCommand;

public class SwitchConditional extends ConditionalCommand {
	boolean x;
	
    public SwitchConditional(Command CommandTrue, Command CommandFalse, boolean side) {
    	super(CommandTrue, CommandFalse);
    	x = side;
    	
    }
    
	@Override
	protected boolean condition() {
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		if(gameData.length() > 0){
			if(x == true){
				if(gameData.charAt(0) == 'R'){
					return true;
				}
			}
			if(x == false){
				if(gameData.charAt(0)== 'L'){
					return true;
				}
			}
		}
		return false;
	}
}
