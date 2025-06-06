package frc.robot.Subsystems.Elevator;

import static frc.robot.Subsystems.Elevator.ElevatorConstants.CURRENT_LIMIT;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.INVERTED;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.Ka;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.Kd;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.Kg;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.Ki;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.Kp;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.Ks;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.Kv;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.MAX_ACCELERATION;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.MAX_VELOCITY;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.POSITION_CONVERSION_FACTOR;
import static frc.robot.Subsystems.Elevator.ElevatorConstants.VOLTAGE_COMPENSATION;

import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.ElevatorFeedforward;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.POM_lib.Motors.POMSparkMax;

public class ElevatorSparkMax {

    private final POMSparkMax motor = new POMSparkMax(0, MotorType.kBrushless);
    private final RelativeEncoder encoder = motor.getEncoder();
    private final DigitalInput limitSwitch = new DigitalInput(0);
    ProfiledPIDController pidController;
    private ElevatorFeedforward feedforward;

    public ElevatorSparkMax() {

        feedforward = new ElevatorFeedforward(Ks, Kg, Kv, Ka);
        pidController = new ProfiledPIDController(Kp, Ki, Kd,
                new TrapezoidProfile.Constraints(MAX_VELOCITY, MAX_ACCELERATION));

        SparkMaxConfig config = new SparkMaxConfig();

        config.idleMode(IdleMode.kBrake).inverted(INVERTED)
                .smartCurrentLimit(CURRENT_LIMIT)
                .voltageCompensation(VOLTAGE_COMPENSATION);

        config.encoder.positionConversionFactor(POSITION_CONVERSION_FACTOR)
                .velocityConversionFactor(POSITION_CONVERSION_FACTOR / 60.0);

        motor.configure(config);

        encoder.setPosition(0);

        pidController.setTolerance(0);

    }

    

    
        

          

        
                 
                

