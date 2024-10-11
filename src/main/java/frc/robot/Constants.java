package frc.robot;

public class Constants {
    public static class OperatorConstants {
        public static final int weaponsControllerPort = 0;
      }
    
      public static class MotorConstants {
        public static final int TurnMotorID = 1;
        public static final int SpinMotorID = 2;
    
        public static final boolean MotorInvert = false;
    
        public static final double MotorOutput = 0.25;
    
        public static final double FirstMotorMaxPosition = 90;
        public static final double FirstMotorMinPosition = 0;
    
        public static final double MotorStartPosition = 0;
    
        public static final double maxMotorVoltage = 10;
    
        /* The constants below are used in ElevatorCommand.java */
        public static final double StickDeadband = 0.1;
    
        /* The constants below are used in PIDElevator.java */
        public static final double turnP = 0.1;
        public static final double turnI = 0;
        public static final double turnD = 0;
      }
}
