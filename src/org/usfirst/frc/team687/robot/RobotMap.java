/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team687.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static final int kLeftMasterTalonSRXID = 1;
	public static final int kLeftSlaveTalonSRX1ID = 2;
	public static final int kLeftSlaveTalonSRX2ID = 3;
	
	public static final int kRightMasterTalonSRXID = 4;
	public static final int kRightSlaveTalonSRX1ID = 5;
	public static final int kRightSlaveTalonSRX2ID = 6;
	
	public static final int kElevatorTalonSRXID = 7;
	public static final int kWristTalonSRXID = 8;
	
	public static final int kIntakeRollersTalonSRXID = 9;

}
