/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Notifier;
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.PathfinderFRC;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.followers.EncoderFollower;

/**
 * Add your docs here.
 */
public class Autonomous extends Subsystem {

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
 static final String pathName = "tesuto";

 // idk what this does
 EncoderFollower leftFollower;
 EncoderFollower rightFollower;
 Notifier followerNotifier;




 public void autoConfig(){
  Trajectory left_trajectory = PathfinderFRC.getTrajectory(pathName + ".left");
  Trajectory right_trajectory = PathfinderFRC.getTrajectory(pathName + ".right");

  leftFollower = new EncoderFollower(left_trajectory);
  rightFollower = new EncoderFollower(right_trajectory);
    
  leftFollower.configureEncoder(RobotMap.leftEncoder.getQuadraturePosition(), ticks_per_revolution, wheel_diameter);
  leftFollower.configurePIDVA(kp, ki, kd, kv, ka);

  rightFollower.configureEncoder(RobotMap.rightEncoder.getQuadraturePosition(), ticks_per_revolution, wheel_diameter);
  rightFollower.configurePIDVA(kp, ki, kd, kv, ka);

  followerNotifier = new Notifier(this::followPath);
  followerNotifier.startPeriodic(left_trajectory.get(0).dt);  
}

public void followPath(){
  if (leftFollower.isFinished() || rightFollower.isFinished()){
    followerNotifier.stop();
  } else {
    double leftSpeed = leftFollower.calculate(RobotMap.leftEncoder.getQuadraturePosition());
    double rightSpeed = rightFollower.calculate(RobotMap.rightEncoder.getQuadraturePosition());
    double heading = RobotMap.gyro.getAngle();
    double desiredHeading = Pathfinder.r2d(leftFollower.getHeading());
    double headingDifference = Pathfinder.boundHalfDegrees(desiredHeading - heading);
    double turn = 0.8 * (-1.0/80.0) * headingDifference;
    Robot.driveTrain.setLeftSpeed(leftSpeed + turn);
    Robot.driveTrain.setRightSpeed(rightSpeed - turn);
  
  }
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
