/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class IntakeArm extends Subsystem {

  public void suck(){
    RobotMap.intake.set(ControlMode.PercentOutput, .8);
  }

  // public void setIntakeArm(double position){
  //   RobotMap.leftIntakeArm.set(ControlMode.Position, position);
  //   RobotMap.rightIntakeArm.set(ControlMode.Position, position);
  // }

  // public void raiseIntakeArm(){
  //   setIntakeArm(position);
  // }

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new MySpecialCommand());
  }
}
