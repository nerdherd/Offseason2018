package org.usfirst.frc.team687.robot.subsystems;

import org.usfirst.frc.team687.robot.RobotMap;
import org.usfirst.frc.team687.robot.utilities.NerdyTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Intake extends Subsystem {

	NerdyTalon m_rollers;
	
    public Intake() {
    	m_rollers = new NerdyTalon(RobotMap.kIntakeRollersTalonSRXID);
    	m_rollers.configDefaultSettings();
    	m_rollers.setNeutralMode(NeutralMode.Coast);
    	m_rollers.setInverted(true);
    }
    
    public void setRollerPower(double power) {
    	m_rollers.set(ControlMode.PercentOutput, power);
    }
    
    public double getVoltage() {
    	return m_rollers.getMotorOutputVoltage();
    }
    
    public double getCurrent() {
    	return m_rollers.getOutputCurrent();
    }
    
    public void reportToSmartDashboard() {
  	  SmartDashboard.putNumber("Roller Voltage", getVoltage());
  	  SmartDashboard.putNumber("Roller Current", getCurrent());
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

