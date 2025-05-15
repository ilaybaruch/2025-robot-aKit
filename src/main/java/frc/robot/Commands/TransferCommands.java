package frc.robot.Commands;

import static frc.robot.Subsystems.Transfer.TransferConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.Transfer.Transfer;

public class TransferCommands extends Command {
    public static Command transfer(Transfer transfer) {
        return transfer.startEnd(() -> transfer.setSpeed(TRANSFER_MOTOR_SPEED), transfer::stopMotor).until(()->transfer.getTransferSensor());
    }
    
    public static Command reverseTransfer(Transfer transfer) {
        return transfer.startEnd(() -> transfer.setSpeed(REVERSE_TRANSFER_MOTOR_SPEED), transfer::stopMotor);
    }

    public static Command shoot(Transfer transfer) {
        return transfer.startEnd(() -> transfer.setSpeed(TRANSFER_SHOOT_MOTOR_SPEED), transfer::stopMotor);
    }


}
