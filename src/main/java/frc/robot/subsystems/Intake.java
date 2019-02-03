/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {

  public void configIntakeEncoder(){
    RobotMap.intakeEncoder.setQuadraturePosition(0, Constants.timeoutMs);
  } 

  public void suck(){
    RobotMap.leftIntake.set(ControlMode.PercentOutput, .4);
    RobotMap.rightIntake.set(ControlMode.PercentOutput, .4);
  }

  public void spit(){
    RobotMap.leftIntake.set(ControlMode.PercentOutput, -.4);
    RobotMap.rightIntake.set(ControlMode.PercentOutput, -.4);
  }

  public void stop(){
    RobotMap.leftIntake.set(ControlMode.PercentOutput, 0);
    RobotMap.rightIntake.set(ControlMode.PercentOutput, 0);
  }

  public void setIntakeArm(int position){
    RobotMap.intakeArm1.set(ControlMode.MotionMagic, position);
    RobotMap.intakeArm2.set(ControlMode.MotionMagic, position);
  }

  // public void raiseIntakeArm(){
  //   RobotMap.intakeArm.set(ControlMode.MotionMagic, 1000);//must fix later
  // }

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new MySpecialCommand());
  }
}
