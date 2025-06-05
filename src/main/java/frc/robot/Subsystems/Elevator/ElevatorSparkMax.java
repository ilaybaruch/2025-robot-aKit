package frc.robot.Subsystems.Elevator;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import dev.doglog.internal.tunable.Tunable;

import com.revrobotics.spark.config.SparkMaxConfig;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.*;

import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.lib.logfields.LogFieldsTable;
import frc.lib.tuneables.Tuneable;
import frc.lib.tuneables.TuneableBuilder;
import frc.lib.tuneables.TuneablesManager;
import frc.lib.tuneables.extensions.TuneableElevatorFeedforward;

public class ElevatorSparkMax extends ElevatorIO implements Tuneable{

    private final SparkMax motor = new SparkMax(0, MotorType.kBrushless);
    private final RelativeEncoder encoder = motor.getEncoder();
    private final DigitalInput limitSwitch = new DigitalInput(0);
    ProfiledPIDController pidController;
    private TuneableElevatorFeedforward feedforward;


    public ElevatorSparkMax (LogFieldsTable FieldsTable){
        super(FieldsTable);

        feedforward = new TuneableElevatorFeedforward(Ks, Kg, Kv, Ka);
        pidController = new ProfiledPIDController(Kp, Ki, Kd, new TrapezoidProfile.Constraints(MAX_VELOCITY,MAX_ACCELERATION));
        TuneablesManager.add("PID controller", pidController);
        TuneablesManager.add("feed forward", feedforward);

        SparkMaxConfig config = new SparkMaxConfig();

        config.idleMode(IdleMode.kBrake).inverted(INVERTED)
                .smartCurrentLimit(CURRENT_LIMIT)
                .voltageCompensation(VOLTAGE_COMPENSATION);

        config.encoder.positionConversionFactor(POSITION_CONVERSION_FACTOR)
                .velocityConversionFactor(POSITION_CONVERSION_FACTOR / 60.0);

        motor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        encoder.setPosition(0);

        pidController.setTolerance(TOLERANCE);

        TuneablesManager.add("Elevator", (Tuneable) this);
        

    }

    @Override
    public void periodic() {
        if (isPressed.getAsBoolean()) {
            encoder.setPosition(0);       
        }

        LogFieldsTable.updateAllTables();
        TuneablesManager.update();

    }

    @Override
    public void initTuneable(TuneableBuilder builder) {
        builder.addChild("PID controler", pidController);
        builder.addChild("Feed forward", feedforward);

    }




    //inputs

    protected double getMotorPrecentage(){
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

    @Override
    public void setMotorVoltageWithFeedForward(double Goal){
        motor.setVoltage(pidController.calculate(encoder.getPosition(), Goal)
         + feedforward.calculate(pidController.getSetpoint().velocity));
    }

    @Override
    public void setMotorVoltageWithFeedForwardWithoutGoal(){
        motor.setVoltage(pidController.calculate(encoder.getPosition())
         + feedforward.calculate(pidController.getSetpoint().velocity));
    }

    
    
    


}
