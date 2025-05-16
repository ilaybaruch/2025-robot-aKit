package frc.robot.Subsystems.Elevator;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.logfields.LogFieldsTable;
import frc.robot.Robot;
import frc.robot.Subsystems.Elevator.ElevatorSparkMax;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.*;

public class Elevetor extends SubsystemBase {
    
    private final LogFieldsTable fieldsTable = new LogFieldsTable(getName());
    //private final Debouncer 

    private final ElevatorIO io = new ElevatorSparkMax(fieldsTable);

    public Elevetor() {}

    public ElevatorIO getIO(){
        return io;
    }

    @Override
    public void periodic(){
        fieldsTable.recordOutput("current command", getCurrentCommand() != null ? getCurrentCommand().getName() : "None");
        SmartDashboard.putNumber("elevator position", io.getPosition());
        fieldsTable.recordOutput("elevator position", io.getPosition());//need to check names
    }

    public void setMotorsVoltage(double motorVoltage){
        fieldsTable.recordOutput("motor voltage", motorVoltage);

        io.setMotorVoltage(MathUtil.clamp(motorVoltage, MOTOR_MIN_VOLTAGE , MOTOR_MAX_VOLTAGE));
    }

    public void stop(){
        fieldsTable.recordOutput("motor voltage", 0.0);

        io.setMotorVoltage(0);
    }

    

}
