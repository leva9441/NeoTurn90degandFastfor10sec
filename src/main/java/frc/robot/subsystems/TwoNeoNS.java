package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class TwoNeoNS extends SubsystemBase{
    private final CANSparkMax nSMotor;
    private final int motorID;

    public TwoNeoNS(int motorID){
        nSMotor = new CANSparkMax(motorID, MotorType.kBrushless);
        this.motorID = motorID;
        new Thread (() -> {
                try {
                    Thread.sleep(250);
                    nSMotor.setInverted(Constants.MotorConstants.MotorInvert); // Evan: Might need to be changed after testing
                    nSMotor.getEncoder().setPosition(Constants.MotorConstants.MotorStartPosition);

                } catch (Exception e) {}
        }).start();
    }
    

    public void turnMotorNinety(double speed){
        if (checkMotorInvertsAreCorrect()){
            if (checkMotorMovementsAreValid(speed)){
                nSMotor.set(speed);
            } else {
                brakeMotor();
            } 
        } else{
            brakeMotor();
            System.out.println("[setElevatorMotorSpeeds] WARNING: Elevator motor inverts are INCORRECT!");
        }
    }

    public void brakeMotor(){
        nSMotor.set(0);
    }

    public double getMotorPosition(){
        double nSMotorPosition = nSMotor.getEncoder().getPosition(); // getPosition() returns the number of rotations of the motor so it should be a double.
        return Units.rotationsToDegrees(nSMotorPosition); // you went with degrees so I'll go with it but I want to know why
      }

    public boolean checkMotorMovementsAreValid (double speed) {
        if (motorID == Constants.MotorConstants.TurnMotorID) {
            if (getMotorPosition() < Constants.MotorConstants.FirstMotorMinPosition) {
                 if (speed > 0) {
                     return true;
                    } else {
                    return false;
                    }
            } else if (getMotorPosition() > Constants.MotorConstants.FirstMotorMaxPosition) {
                if (speed < 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
    }


}
