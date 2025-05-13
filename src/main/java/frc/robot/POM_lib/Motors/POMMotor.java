package frc.robot.POM_lib.Motors;

public interface POMMotor {
    public enum Direction{
        ClockWise,
        CounterClockWise
    }
    public void stop();
    public void setDirection(Direction direction);
    public void setBrake(boolean isBrake);  
} 