package frc.robot.POM_lib.Motors;

import com.revrobotics.CANSparkMax;

public class POMSparkMax extends CANSparkMax implements POMMotor{
    public POMSparkMax(int id){
        this(id, MotorType.kBrushless);
    }

    public POMSparkMax(int id, MotorType type){
        super(id, type);
    }

    @Override
    public void stop() {
        set(0);
    }
    @Override
    public void setDirection(Direction direction) {
        setInverted(direction == Direction.CounterClockWise);
    }

    @Override
    public void setBrake(boolean isBrake) {
        setIdleMode(isBrake ? IdleMode.kBrake : IdleMode.kCoast);
    }
}
