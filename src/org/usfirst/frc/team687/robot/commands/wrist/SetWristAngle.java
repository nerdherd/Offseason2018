/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team687.robot.commands.wrist;

import org.usfirst.frc.team687.robot.Robot;
import org.usfirst.frc.team687.robot.constants.WristConstants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class SetWristAngle extends Command {
  private double m_desiredAngle;
  private double m_error, m_prevError, m_output;
  private double m_time, m_prevTime;
  private double m_dTerm;
  
  public SetWristAngle(double angle) {
    m_desiredAngle = angle;
    
    requires(Robot.wrist);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.wrist.resetEncoders(); 

    m_time = Timer.getFPGATimestamp(); 
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    m_error = m_desiredAngle - Robot.wrist.getAngle();

    m_dTerm = (m_prevError - m_error) / (Timer.getFPGATimestamp() - m_prevTime);
    
    m_output = WristConstants.kWristP * m_error + WristConstants.kWristD * m_dTerm + WristConstants.kWristF;
    Robot.wrist.setPower(m_output);
    
    m_prevError = m_error;
    m_prevTime = Timer.getFPGATimestamp();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
