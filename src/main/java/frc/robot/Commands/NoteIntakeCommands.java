package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Subsystems.NoteIntake.NoteIntake;
import static frc.robot.Subsystems.NoteIntake.NoteIntakeConstants.*;

public class NoteIntakeCommands extends Command {
    public static Command Intake(NoteIntake noteIntake) {
        return noteIntake.startEnd(() -> noteIntake.setSpeed(INTAKE_MOTOR_SPEED), noteIntake::stopMotor);
    }
}
