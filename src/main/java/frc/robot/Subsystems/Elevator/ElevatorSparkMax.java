package frc.robot.Subsystems.Elevator;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.lib.logfields.LogFieldsTable;

import static frc.robot.Subsystems.Elevator.ElevatorConstants.*;

public class ElevatorSparkMax extends ElevatorIO {

    private final SparkMax motor = new SparkMax(0, MotorType.kBrushless);

    private final DigitalInput limitSwitch = new DigitalInput(0);

    private final SparkMaxConfig motorConfing = new SparkMaxConfig();

    public ElevatorSparkMax (LogFieldsTable FieldsTable){
        super(FieldsTable);

        motorConfing.smartCurrentLimit(0);

        motorConfing.idleMode(IdleMode.kCoast);

    }


    //inputs

    protected double getMotorSpeed(){
        return motor.get();
    }

    protected double getMotorVoltage(){
        return motor.getBusVoltage();
    }

    protected double getPosition(){
        return motor.getEncoder().getPosition();
    }

    protected double getMotorCurrent(){
        return motor.getAppliedOutput();
    }

    protected boolean getLimitSwitch(){
        return limitSwitch.get();
    }




    //outputs

    @Override
    public void setMotorPrecentage(double precent){
        motor.set(precent);
    }

    @Override
    public void setMotorVoltage(double voltage){
        motor.setVoltage(voltage);
    }




}
