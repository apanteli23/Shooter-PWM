/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;



import com.revrobotics.PWMSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private PWMSparkMax leftMotor = new PWMSparkMax(1, MotorType.kBrushless);
  private PWMSparkMax rightMotor = new PWMSparkMax(2, MotorType.kBrushless);
  private double velocity;
  
  private final Timer m_timer = new Timer();



  @Override
  public void robotInit() {
    leftMotor.restoreFactoryDefaults();
    rightMotor.restoreFactoryDefaults();
    leftMotor.setInverted(true);
    leftMotor.follow(rightMotor);
    
    SmartDashboard.putNumber("Velocity", velocity);

  }

  @Override
  public void autonomousInit() {
    m_timer.reset();
    m_timer.start();
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    
    //get velocity from SmartDashboard
    double m_velocity = SmartDashboard.getNumber("Velocity", 0);

    // if velocity coefficients on SmartDashboard have changed, write new values to controller
    if(m_velocity != velocity) { 
      m_velocity = velocity;
    }
    
    double speed = velocity;
      
    SmartDashboard.putNumber("CurretVelocity", speed);
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
