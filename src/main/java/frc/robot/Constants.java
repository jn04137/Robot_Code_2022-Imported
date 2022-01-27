// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    /**
     * These constants are for the drivetrain
     */
    public final class kDrivetrain {
        // CAN IDs set from the REV Hardware Client
        public static final int FRONT_LEFT = 1;
        public static final int FRONT_RIGHT = 2;
        public static final int BACK_LEFT = 3;
        public static final int BACK_RIGHT = 4;

        // Change this to true if the robot is driving in the wrong direction
        public static final boolean REVERSED = false;
    }

    /**
     * These constants are for IO (Input Output) devices such as joysticks
     */
    public final class kIO {
        // These are the ID of the channel on the driver station.
        // You might have to change the order around in the driver station to get the
        // left and right one correct.
        public static final int LEFT_JOY = 0;
        public static final int RIGHT_JOY = 1;
    }

}
