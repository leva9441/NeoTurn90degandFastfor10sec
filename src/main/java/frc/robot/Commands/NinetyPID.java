package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.math.controller.PIDController;

import frc.robot.Constants;
import frc.robot.subsystems.NeoNS;

public class NinetyPID extends Command {
    private NeoNS e_NeoNS = new NeoNS(Constants.MotorConstants.TurnMotorID);
    private double targetPosition;
    private PIDController e_PidController = new PIDController(Constants.MotorConstants.turnP, Constants.MotorConstants.turnI, Constants.MotorConstants.turnD);

    public NinetyPID (NeoNS e_NeoNS, double targetPosition) {
        this.e_NeoNS = e_NeoNS;
        addRequirements(e_NeoNS);

        this.targetPosition = targetPosition;
    }

    @Override
    public void initialize() {
        e_PidController.setSetpoint(targetPosition);
        e_PidController.reset();
    }

    @Override
    public void execute() {
        e_NeoNS.setMotorVoltage(e_PidController.calculate(e_NeoNS.getMotorPosition()));
    }

    @Override
    public boolean isFinished() {
        if (e_PidController.getPositionError() < 5 /* I found that 5 actually is in whatever units you are measuring the set point/position in. */) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void end(boolean interrupted){
        e_NeoNS.brakeMotor();
    }
}
