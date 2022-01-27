// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class TankDriveCommand extends CommandBase {
    // Drivetrain subsystem to command
    private final Drivetrain m_drivetrain;
    // Use double supplier so that we can constantly get new values.
    // We do this instead of using a joystick so that this class can take any double
    // source like a controller or joystick.
    private final DoubleSupplier m_left, m_right;

    /** Creates a new TankDriveCommand. */
    public TankDriveCommand(Drivetrain drivetrain, DoubleSupplier left, DoubleSupplier right) {
        m_drivetrain = drivetrain;
        m_right = right;
        m_left = left;
        // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(drivetrain);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        // We don't need to do anything in here
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // A double supplier's `get` method will get the latest value from it's source
        m_drivetrain.drivePercent(m_left.getAsDouble(), m_right.getAsDouble());
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // This command won't ever end because there will not be another command that
        // requires the drivetrain subsystem, but if the command is interrupted it's a
        // good idea to tell the drivetrain to
        // stop.
        m_drivetrain.stop();
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false; // returning false will make this command perpetual
    }
}
