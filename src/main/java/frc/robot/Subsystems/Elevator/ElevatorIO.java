package frc.robot.Subsystems.Elevator;

public interface ElevatorIO {

    // @AutoLog

    public static class ElevatorIOInputs {
        double voltage;
        double velocity;
        boolean limitSwitch;

    }

    public default void updateInputs(ElevatorIOInputs inputs) {
    }

    public default void setSpeed(double precentage) {
    }

    public default void setVoltage(double voltage) {
    }

    public default void stopElevator() {
    }

}