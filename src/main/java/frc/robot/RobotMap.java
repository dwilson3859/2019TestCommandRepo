/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.ctre.phoenix.motorcontrol.SensorCollection;
import frc.robot.subsystems.*;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static DriveTrain driveTrain = new DriveTrain();
  public static OI oi = new OI();
  public static Autonomous auto = new Autonomous();
  public static Hatch hatch = new Hatch();

  //left drive motors
  public static TalonSRX leftDrive = new TalonSRX(1);
  public static VictorSPX leftFollow1 = new VictorSPX(2);
  public static VictorSPX leftFollow2 = new VictorSPX(3);


  //Ball Intake motors
  public static VictorSPX intake = new VictorSPX(13);
  public static VictorSPX rightIntakeArm = new VictorSPX(12);
  public static TalonSRX leftIntakeArm = new TalonSRX(11);

  //Ball Ejector
  public static VictorSPX ejectRollers = new VictorSPX(16);
  public static TalonSRX rightEjectArm = new TalonSRX(14);
  public static TalonSRX leftEjectArm = new TalonSRX(15);

  //encoders
  public static SensorCollection leftEncoder = new SensorCollection(leftDrive);
  public static SensorCollection rightEncoder = new SensorCollection(rightDrive);

  //gyro
  public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();



  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}