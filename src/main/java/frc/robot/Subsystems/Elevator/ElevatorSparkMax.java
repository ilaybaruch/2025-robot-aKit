package frc.robot.Subsystems.Elevator;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.servohub.ServoHub.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.*;

import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.lib.logfields.LogFieldsTable;

public class ElevatorSparkMax extends ElevatorIO {

    private final SparkMax motor = new SparkMax(0, MotorType.kBrushless);
    private final RelativeEncoder encoder = motor.getEncoder();
    private final DigitalInput limitSwitch = new DigitalInput(0);
    ProfiledPIDController pidController;
    private ElevatorFeedforward feedforward;


    public ElevatorSparkMax (LogFieldsTable FieldsTable){
        super(FieldsTable);

        feedforward = new ElevatorFeedforward(Ks, Kg, Kv);
        pidController = new ProfiledPIDController(Kp, Ki, Kd, new TrapezoidProfile.Constraints(MAX_VELOCITY,MAX_ACCELERATION));

        SparkMaxConfig config = new SparkMaxConfig();

        config.idleMode(IdleMode.kCoast).inverted(INVERTED)
                .smartCurrentLimit(CURRENT_LIMIT)
                .voltageCompensation(VOLTAGE_COMPENSATION);

        config.encoder.positionConversionFactor(POSITION_CONVERSION_FACTOR)
                .velocityConversionFactor(POSITION_CONVERSION_FACTOR / 60.0);

        //motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        encoder.setPosition(0);

    }


    //inputs

    protected double getMotorSpeed(){
        return motor.get();
    }

    protected double getMotorVoltage(){
        return motor.getBusVoltage();
    }

    protected double getPosition(){
        return encoder.getPosition();
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
