// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.NinetyPID;
import frc.robot.Commands.SpinTimer;
import frc.robot.subsystems.NeoNS;

public class RobotContainer {
  private final Joystick weapons = new Joystick(Constants.OperatorConstants.weaponsControllerPort);

  private final JoystickButton runTheThings = new JoystickButton(weapons, XboxController.Button.kA.value);

  NeoNS e_NeoNS;




  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    runTheThings.onTrue(new NinetyPID(e_NeoNS, 90).andThen(new SpinTimer(e_NeoNS).andThen(new NinetyPID(e_NeoNS, 0))));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
