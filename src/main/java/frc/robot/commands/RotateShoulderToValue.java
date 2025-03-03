// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShoulderSystem;

public class RotateShoulderToValue extends CommandBase {
  /** Creates a new RotateShouldToValue. */
  private static ShoulderSystem m_pid_shoulder_system;
  double destination;
  
  public RotateShoulderToValue(ShoulderSystem m_shouldersystem, int i) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_pid_shoulder_system = m_shouldersystem;
    destination = i;
    addRequirements(m_pid_shoulder_system);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_pid_shoulder_system.setPosition(destination);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_pid_shoulder_system.atSetpoint();
  }
}
