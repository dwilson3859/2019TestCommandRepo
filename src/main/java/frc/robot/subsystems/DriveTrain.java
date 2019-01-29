/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Notifier;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import com.ctre.phoenix.motorcontrol.ControlMode;
import jaci.pathfinder.followers.EncoderFollower;
import frc.robot.Constants;
import frc.robot.OI;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  
 //Max Velocity of Robot in m/s 
 static final double maxVel = 12;
 


 //set pid for autopath
 static double kp = 1;
 static double ki = 0;
 static double kd = 0;
 static double kv = 1 / maxVel;
 static double ka = 0;

 //variables to calibrate encoders
 static final int ticks_per_revolution = 1024;
 static final double wheel_diameter = .70204; // in meters

 //mapping output of PathWeaver
 static final String pathName = "PathWeaver.ouput.tesuto";

 // idk what this does
 EncoderFollower leftFollower;
 EncoderFollower rightFollower;
 Notifier followerNotifier; 

/* 
  beginning of functions in drive class

  */
  public void configDriveTrain(){
    //left drivetrain
    RobotMap.leftFollow1.follow(RobotMap.leftDrive);
    RobotMap.leftFollow2.follow(RobotMap.leftDrive);
    
    //right drivetrain
    RobotMap.rightFollow1.follow(RobotMap.rightDrive);
    RobotMap.rightFollow2.follow(RobotMap.rightDrive);

    //drivetrain encoders
    RobotMap.leftEncoder.setQuadraturePosition(0, Constants.timeoutMs);
    RobotMap.rightEncoder.setQuadraturePosition(0, Constants.timeoutMs);
  }

  public void setLeftSpeed(double speed){
    RobotMap.leftDrive.set(ControlMode.PercentOutput, speed);
  }

  public void setRightSpeed(double speed){
    RobotMap.rightDrive.set(ControlMode.PercentOutput, speed);
  }

  public void stopDrive(){
    setLeftSpeed(0);
    setRightSpeed(0);
  }

  public void joystickDrive(Joystick j1, Joystick j2){
    setLeftSpeed(j1.getY());
    setRightSpeed(j2.getY());
  }

  @Override
  public void initDefaultCommand() {
    joystickDrive(OI.joy1, OI.joy2);
  }
}
