package frc.robot.POM_lib.Joysticks;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.event.EventLoop;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public interface PomController{
    Trigger LB();
    Trigger LB(EventLoop loop);
    BooleanSupplier LBPressed();
    BooleanSupplier LBReleased();

    Trigger RB();
    Trigger RB(EventLoop loop);
    BooleanSupplier RBPressed();
    BooleanSupplier RBReleased();

    Trigger leftStickClick();
    Trigger leftStickClick(EventLoop loop);
    BooleanSupplier leftStickClickPressed();
    BooleanSupplier leftStickClickReleased();

    Trigger rightStickClick();
    Trigger rightStickClick(EventLoop loop);
    BooleanSupplier rightStickClickPressed();
    BooleanSupplier rightStickClickReleased();

    Trigger a();
    Trigger a(EventLoop loop);
    BooleanSupplier aPressed();
    BooleanSupplier aReleased();

    Trigger b();
    Trigger b(EventLoop loop);
    BooleanSupplier bPressed();
    BooleanSupplier bReleased();

    Trigger x();
    Trigger x(EventLoop loop);
    BooleanSupplier xPressed();
    BooleanSupplier xReleased();

    Trigger y();
    Trigger y(EventLoop loop);
    BooleanSupplier yPressed();
    BooleanSupplier yReleased();

    Trigger start();
    Trigger start(EventLoop loop);
    BooleanSupplier startPressed();
    BooleanSupplier startReleased();

    Trigger back();
    Trigger back(EventLoop loop);
    BooleanSupplier backPressed();
    BooleanSupplier backReleased();

    Trigger PovUp();
    Trigger PovUp(EventLoop loop);

    Trigger PovDown();
    Trigger PovDown(EventLoop loop);

    Trigger PovLeft();
    Trigger PovLeft(EventLoop loop);
    
    Trigger PovRight();
    Trigger PovRight(EventLoop loop);

    double povAngle();

    Trigger leftTrigger(double threshold, EventLoop loop);

    Trigger leftTrigger(double threshold);

    Trigger leftTrigger();

    Trigger rightTrigger(double threshold, EventLoop loop);

    Trigger rightTrigger(double threshold);

    Trigger rightTrigger();

    Trigger leftYUp(double threshold, EventLoop loop);

    Trigger leftYUp(double threshold);

    Trigger leftYUp();

    Trigger rightYUp(double threshold, EventLoop loop);

    Trigger rightYUp(double threshold);

    Trigger rightYUp();

    Trigger leftYDown(double threshold, EventLoop loop);

    Trigger leftYDown(double threshold);

    Trigger leftYDown();

    Trigger rightYDown(double threshold, EventLoop loop);

    Trigger rightYDown(double threshold);

    Trigger rightYDown();
    
    Trigger leftXLeft(double threshold, EventLoop loop);

    Trigger leftXLeft(double threshold);

    Trigger leftXLeft();

    Trigger rightXLeft(double threshold, EventLoop loop);

    Trigger rightXLeft(double threshold);

    Trigger rightXLeft();

    Trigger leftXRight(double threshold, EventLoop loop);

    Trigger leftXRight(double threshold);

    Trigger leftXRight();

    Trigger rightXRight(double threshold, EventLoop loop);

    Trigger rightXRight(double threshold);

    Trigger rightXRight();

    double getLeftX();

    double getRightX();

    double getLeftY();

    double getRightY();

    double getLeftTriggerAxis();

    double getRightTriggerAxis();
    
}