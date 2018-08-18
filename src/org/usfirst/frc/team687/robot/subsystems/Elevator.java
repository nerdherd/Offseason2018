package org.usfirst.frc.team687.robot.subsystems;

import org.usfirst.frc.team687.robot.RobotMap;
import org.usfirst.frc.team687.robot.utilities.NerdyTalon;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {

	private final NerdyTalon m_elevator;
	
    public Elevator() {
    	m_elevator = new NerdyTalon(RobotMap.kElevatorTalonSRXID);
    	m_elevator.configDefaultSettings();
    	m_elevator.setInverted(false);
    	m_elevator.setSensorPhase(true);
    	m_elevator.setNeutralMode(NeutralMode.Brake);
    	m_elevator.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
    }

    public void setPower(double power) {
    	m_elevator.set(ControlMode.PercentOutput, power);
    }
    
    public double getVoltage() {
    	return m_elevator.getMotorOutputVoltage();
    }
    
    public double getPosition() {
    	return m_elevator.getSelectedSensorPosition(0);
    }
    
    public double getVelocity() {
    	return m_elevator.getSelectedSensorVelocity(0);
    }
    
    public double getCurrent() {
    	return m_elevator.getOutputCurrent();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void reportToSmartDashboard() {
    	SmartDashboard.putNumber("Elevator Position", getPosition());
    	SmartDashboard.putNumber("Elevator Current", getCurrent());
    	SmartDashboard.putNumber("Elevator Velocity", getVelocity());
    	SmartDashboard.putNumber("Elevator Voltage", getVoltage());
    }
}

