package org.usfirst.frc.team687.robot.commands.superstructure;

import org.usfirst.frc.team687.robot.Robot;
import org.usfirst.frc.team687.robot.constants.SuperstructureConstants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetElevatorPosition extends Command {

	private double m_position, m_output, m_error;
	private double m_prevError, m_prevTime, m_time;
	
    public SetElevatorPosition(double position) {
    	m_position = position;
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_prevError = m_position - Robot.elevator.getPosition();
    	m_prevTime = Timer.getFPGATimestamp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_error = m_position - Robot.elevator.getPosition();
    	m_time = Timer.getFPGATimestamp();
    	m_output = m_error * SuperstructureConstants.kElevatorP + (m_error - m_prevError)/(m_time - m_prevTime)
    			* SuperstructureConstants.kElevatorD + SuperstructureConstants.kElevatorF;
    	Robot.elevator.setPower(m_output);
    	m_prevError = m_error;
    	m_prevTime = m_time;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(m_error) <= SuperstructureConstants.kElevatorPositionTolerance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.setPower(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
