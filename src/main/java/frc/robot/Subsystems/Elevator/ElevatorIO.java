package frc.robot.Subsystems.Elevator;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import frc.lib.logfields.IOBase;
import frc.lib.logfields.LogFieldsTable;

public abstract class ElevatorIO extends IOBase {

    public  final DoubleSupplier speed = fields.addDouble("speed", this::getMotorPrecentage);
    public  final DoubleSupplier position = fields.addDouble("position", this::getPosition);
    public  final DoubleSupplier voltage = fields.addDouble("voltage", this::getMotorVoltage);
    public final BooleanSupplier isPressed = fields.addBoolean("is pressed", this::getLimitSwitch);
    public final DoubleSupplier motorCurrent = fields.addDouble("motor current", this::getMotorCurrent);

    

    public ElevatorIO(LogFieldsTable logFieldsTable){
        super(logFieldsTable);
    }

    public abstract void periodic();
    
    

    //inputs

    protected abstract double getMotorPrecentage();

    protected abstract double getMotorVoltage();

    protected abstract boolean getLimitSwitch();

    protected abstract double getPosition();

    protected abstract double getMotorCurrent();

    //outputs
    
    public abstract void setMotorPrecentage(double precent);
    
    public abstract void setMotorVoltage(double voltage);

    public abstract void setMotorVoltageWithFeedForward(double Goal);

    public abstract void setMotorVoltageWithFeedForwardWithoutGoal();

    


    

}
    

