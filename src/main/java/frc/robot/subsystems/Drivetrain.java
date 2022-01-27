// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.kDrivetrain;

public class Drivetrain extends SubsystemBase {
    private final CANSparkMax frontLeft, frontRight, backLeft, backRight; // Motors
    private final DifferentialDrive differentialDrive; // This lets us use different ways of controlling the robot.
    // I recommend reading the documentation on the DifferentialDrive object because
    // it has a lot of really good methods for controlling a differential drive
    // robot.

    /** Creates a new Drivetrain. */
    public Drivetrain() {
        // Instanciating our motors here with their ID and the specific motor type
        // NEO motors must have MotorType.kBrushless or else you can damage the motor
        frontLeft = new CANSparkMax(kDrivetrain.FRONT_LEFT, MotorType.kBrushless);
        frontRight = new CANSparkMax(kDrivetrain.FRONT_RIGHT, MotorType.kBrushless);
        backLeft = new CANSparkMax(kDrivetrain.BACK_LEFT, MotorType.kBrushless);
        backRight = new CANSparkMax(kDrivetrain.BACK_RIGHT, MotorType.kBrushless);

        // This clears what might have been on the spark maxes
        frontRight.restoreFactoryDefaults();
        frontLeft.restoreFactoryDefaults();
        backRight.restoreFactoryDefaults();
        backLeft.restoreFactoryDefaults();

        // You can set this to be either brake or coast mode
        // Brake - motor comes to stop very fast when it is commanded to 0
        // Coast - motor comes to stop slowly when it is commanded to 0
        frontLeft.setIdleMode(IdleMode.kBrake);
        frontRight.setIdleMode(IdleMode.kBrake);
        backLeft.setIdleMode(IdleMode.kBrake);
        backRight.setIdleMode(IdleMode.kBrake);

        // This determines whether the drivetrain should be reversed
        frontLeft.setInverted(kDrivetrain.REVERSED);
        frontRight.setInverted(!kDrivetrain.REVERSED);
        backLeft.setInverted(kDrivetrain.REVERSED);
        backRight.setInverted(kDrivetrain.REVERSED);

        // This lets us command one motor and the other motor will simply follow the
        // other
        backLeft.follow(frontLeft);
        backRight.follow(backRight);

        // This makes all values "stick"
        frontLeft.burnFlash();
        frontRight.burnFlash();
        backLeft.burnFlash();
        backRight.burnFlash();

        differentialDrive = new DifferentialDrive(frontLeft, frontRight);
    }

    /**
     * Drives the robot's sides a certain percent.
     * <p>
     * The input is expected to be from [-1, 1] where -1 is full reverse, 0 is stop,
     * and 1 is full forward.
     * 
     * @param left  Left percentage.
     * @param right Right percentage.
     */
    public void drivePercent(double left, double right) {
        differentialDrive.tankDrive(left, right);
    }

    /**
     * Stops the drivetrain from moving.
     */
    public void stop() {
        differentialDrive.tankDrive(0, 0);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
