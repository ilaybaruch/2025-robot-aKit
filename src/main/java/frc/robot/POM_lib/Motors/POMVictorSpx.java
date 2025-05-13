package frc.robot.POM_lib.Motors;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class POMVictorSpx extends WPI_VictorSPX implements POMMotor {
    public POMVictorSpx(int id){
        super(id);
    }

    @Override
    public void setDirection(Direction direction) {
        setInverted(direction == Direction.CounterClockWise);
    }
    @Override
    public void stop() {
        stopMotor();
    }
    @Override
    public void setBrake(boolean isBrake) {
        setNeutralMode(isBrake ? NeutralMode.Brake: NeutralMode.Coast);
    }

    public void set(double percentage){
        set(ControlMode.PercentOutput, percentage);
    }
}
