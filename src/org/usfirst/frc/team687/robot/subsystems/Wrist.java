/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team687.robot.subsystems;

import org.usfirst.frc.team687.robot.RobotMap;
import org.usfirst.frc.team687.robot.utilities.NerdyTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Wrist extends Subsystem {

  private final NerdyTalon m_wrist;

  public Wrist() {
    m_wrist = new NerdyTalon(RobotMap.kWristTalonSRXID);
    m_wrist.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
  }

  public double getPosition() {
    return m_wrist.getSelectedSensorPosition(0);
  }
  public double getAngle() {
    return ticksToDegrees(getPosition());
  }

  public double ticksToDegrees(double ticks) {
    return ticks / 4096 * 360; 
  }

  public void setPosition(double position) {
    m_wrist.set(ControlMode.MotionMagic, position);
  }

  public void setPower(double power) {
    m_wrist.set(ControlMode.PercentOutput, power);
  }

  public void resetEncoders() {
    m_wrist.setSelectedSensorPosition(0, 0, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
