package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Shooter.Shooter;


public class ShooterCommands extends Command {
    public static Command shoot(Shooter shooter, double goal) {
        return shooter.runEnd(()-> shooter.getIO().setSetPoint(goal),()-> shooter.getIO().stopMotor()).until(shooter.getIO().atSetPoint());
    }

    public static Command stop(Shooter shooter) {
        return shooter.run(()-> shooter.getIO().stopMotor());
    }

    
    
}
