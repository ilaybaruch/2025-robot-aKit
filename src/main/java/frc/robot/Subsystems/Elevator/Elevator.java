package frc.robot.Subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private final ElevatorIO elevatorIO;
    private final ElevatorIOAutoLogged elevatorInputs = new ElevatorIOAutoLogged();

    public Elevator(ElevatorIO elevatorIO) {
        this.elevatorIO = elevatorIO;
    }

    public void periodic() {
        elevatorIO.updateInputs(elevatorInputs);
        Logger
    }

}
