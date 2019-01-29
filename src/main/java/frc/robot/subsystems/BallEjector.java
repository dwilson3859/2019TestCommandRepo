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
public class BallEjector extends Subsystem {

  public void configEjectorEncoder(){
    RobotMap.ejectorEncoder.setQuadraturePosition(0, Constants.timeoutMs);
  }

  public void spit(){
    RobotMap.rightRoller.set(ControlMode.PercentOutput, .8);
    RobotMap.leftRoller.set(ControlMode.PercentOutput, .8);
  }

  public void suck(){
    RobotMap.rightRoller.set(ControlMode.PercentOutput, -.8);
    RobotMap.leftRoller.set(ControlMode.PercentOutput, -.8);
  }

  public void setEjectorArm(int position){
    RobotMap.ejectorArm.set(ControlMode.MotionMagic, position);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
