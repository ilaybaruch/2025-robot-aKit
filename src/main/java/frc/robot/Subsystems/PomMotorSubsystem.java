package frc.robot.Subsystems;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public abstract class PomMotorSubsystem extends SubsystemBase {
    public abstract void stopMotor();

    public abstract void setMotor(double percent);

    public abstract void setVolage(double volts);

    /**
     * Set brake mode
     * If motor should always be the smae, ignore paramter!
     * 
     * @param brake
     */
    public abstract void setIdleMode(boolean brake);

    public void resetEncoder() {
    };

    public double getEncoderPosition() {
        return 0;
    };

    /*
     * thanks to trigon 5990 for inspiration
     */
    private static final List<PomMotorSubsystem> SUBSYSTEMS = new ArrayList<>();
    private static final Trigger DISABLE_TRIGGER = new Trigger(DriverStation::isDisabled);

    static {
        DISABLE_TRIGGER.onTrue((new InstantCommand(() -> forEach(PomMotorSubsystem::stopMotor))
                .andThen(() -> forEach(subsystem -> subsystem.setIdleMode(false)))).ignoringDisable(true));
        DISABLE_TRIGGER.onFalse(
                new InstantCommand(() -> forEach(subsystem -> subsystem.setIdleMode(true))).ignoringDisable(true));
    }

    public PomMotorSubsystem() {
        SUBSYSTEMS.add(this);
    }

    public static void forEach(Consumer<PomMotorSubsystem> toRun) {
        SUBSYSTEMS.forEach(toRun);
    }
}