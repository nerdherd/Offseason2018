/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team687.robot.subsystems.Drive;
import org.usfirst.frc.team687.robot.subsystems.Elevator;
import org.usfirst.frc.team687.robot.subsystems.Intake;
import org.usfirst.frc.team687.robot.subsystems.Wrist;

/**
 * 
 * @author dbarv
 * Code heavily based on Tedklin's, 90% is based on stuff I've learned from him
 *
 */

public class Robot extends TimedRobot {
	public static PowerDistributionPanel pdp;
	public static Drive drive;
	public static Elevator elevator;
	public static OI oi;
	public static Wrist wrist;
	public static Intake intake;

	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		pdp = new PowerDistributionPanel();
		drive = new Drive();
		elevator = new Elevator();
		oi = new OI();
		wrist = new Wrist();
		intake = new Intake();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		Robot.drive.calcXY();
		Robot.drive.reportToSmartDashboard();
		Robot.oi.reportToSmartDashboard();
		Robot.wrist.reportToSmartDashboard();
		Robot.intake.reportToSmartDashboard();
		SmartDashboard.putData(pdp);

	}

	@Override
	public void disabledPeriodic() {
		Robot.drive.calcXY();
		Scheduler.getInstance().run();
		Robot.drive.reportToSmartDashboard();
		Robot.oi.reportToSmartDashboard();
		SmartDashboard.putData(pdp);

	}

	
	@Override
	public void autonomousInit() {
		Robot.drive.calcXY();	
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		Robot.drive.calcXY();
	}

	@Override
	public void teleopInit() {
		Robot.drive.reportToSmartDashboard();
		Robot.oi.reportToSmartDashboard();
		Robot.drive.calcXY();
		SmartDashboard.putData(pdp);
		
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		Robot.drive.calcXY();
		Robot.drive.reportToSmartDashboard();
		Robot.oi.reportToSmartDashboard();
		SmartDashboard.putData(pdp);

	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
		Robot.drive.calcXY();
		Robot.drive.reportToSmartDashboard();
		Robot.oi.reportToSmartDashboard();
		SmartDashboard.putData(pdp);

	}
}
