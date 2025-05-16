package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Subsystems.Elevator.ElevatorIO;
import frc.robot.Subsystems.Elevator.Elevetor;

public class ElevatorCommands extends Command {

    public Command ElevatorUP(Elevetor elevetor,double speed){
        return Commands.runEnd(()-> elevetor.getIO().setMotorPrecentage(speed) ,() -> elevetor.getIO().setMotorPrecentage(0),elevetor);
    }
    
    

}
