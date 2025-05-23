package frc.robot.Commands;

import static frc.robot.Subsystems.Elevator.ElevatorConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Subsystems.Elevator.ElevatorIO;
import frc.robot.Subsystems.Elevator.Elevetor;

public class ElevatorCommands extends Command {

    public Command Elevator(Elevetor elevetor,double speed){
        return Commands.runEnd(()-> elevetor.getIO().setMotorVoltageWithFeedForward(L2_POS)
         ,() -> elevetor.getIO().setMotorPrecentage(0),elevetor);
    }

    public Command ElevatorWithoutGoal(Elevetor elevetor,double speed){
        return Commands.runEnd(()-> elevetor.getIO().setMotorVoltageWithFeedForwardWithoutGoal()
         ,() -> elevetor.getIO().setMotorPrecentage(0),elevetor);
    }

    public Command Stop_Elevator(Elevetor elevetor,double speed){
        return Commands.run(()-> elevetor.getIO().setMotorPrecentage(0),elevetor);
    }
    
    

}
