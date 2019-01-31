/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Add your docs here.
 */
public class Hatch extends Subsystem {
  
  RobotMap map = new RobotMap();

  //grab hatch
  public void giveDaMiddleFinger(){
    RobotMap.middleFinger.set(Value.kForward);
  }

  //lets go of match
  public void putDownDaMiddleFinger(){
    RobotMap.middleFinger.set(Value.kForward);
  }

  //tell hatch to roll out
  public void hatchDeploy(){
    RobotMap.hatchMotor.set(ControlMode.PercentOutput, .2);
  }

  //tell hatch to retreat
  public void hatchRetract(){
    RobotMap.hatchMotor.set(ControlMode.PercentOutput, -.2);
  }

  public Boolean isHatchRetracted(){
    return RobotMap.backLimitSwitch.get();
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
