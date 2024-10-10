package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants;
import frc.robot.subsystems.TwoNeoNS;

public class NinetyPID extends Command {
    private TwoNeoNS e_TwoNeoNS = new TwoNeoNS(Constants.MotorConstants.TurnMotorID);
    private double targetPosition;
    private PIDController e_PidController = new PIDController(Constants.MotorConstants.turnP, Constants.MotorConstants.turnI, Constants.MotorConstants.turnD);

    public NinetyPID (TwoNeoNS e_TwoNeoNS, double targetPosition) {
        this.e_TwoNeoNS = e_TwoNeoNS;
        addRequirements(e_TwoNeoNS);

        this.targetPosition = targetPosition;
    }

    @Override
    public void initialize() {
        e_PidController.setSetpoint(targetPosition);
        e_PidController.reset();
    }

    @Override
    public void execute() {
        e_TwoNeoNS.turnMotorNinety(e_PidController.calculate(e_TwoNeoNS.getMotorPosition()));
    }

    @Override
    public boolean isFinished() {
        if (e_PidController.getPositionError() < 5/* I found that 5 actually is in whatever units you are measuring the set point/position in. */) {
            return true;
        } else {
            return false;
        }
    }


    @Override
    public void end(boolean interrupted){
        
    }
}
