package frc.robot.Commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.NeoNS;

public class SpinTimer extends Command{
    private NeoNS e_NeoNS = new NeoNS(Constants.MotorConstants.SpinMotorID);
    private Timer e_Timer = new Timer();

    public SpinTimer (NeoNS e_NeoNS){
        this.e_NeoNS = e_NeoNS;
        addRequirements(e_NeoNS);
    }

    @Override
    public void initialize() {
        e_Timer.reset();
        e_Timer.start();
    }

    @Override
    public void execute() {
        e_NeoNS.setMotorVoltage(Constants.MotorConstants.maxMotorVoltage);
    }

    @Override
    public boolean isFinished() {
        if (e_Timer.get() >= 10) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void end(boolean interrupted) {
        
    }
    
}
