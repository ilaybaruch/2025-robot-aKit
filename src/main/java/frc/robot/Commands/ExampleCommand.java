package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.PomMotorSubsystem;

public class ExampleCommand extends Command {
    PomMotorSubsystem subsystem;

    public ExampleCommand(PomMotorSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        subsystem.setMotor(1);
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        subsystem.stopMotor();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
