package frc.robot.POM_lib.Joysticks;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.event.EventLoop;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import static frc.robot.POM_lib.Joysticks.JoystickConstants.*;

public class PomXboxController implements PomController {
    CommandXboxController controller;
    int port = 0;

    public PomXboxController(int port) {
        controller = new CommandXboxController(port);
        this.port = port;
    }

    @Override
    public Trigger LB() {
        return controller.leftBumper();
    }

    @Override
    public Trigger LB(EventLoop loop) {
        return controller.leftBumper(loop);
    }

    @Override
    public BooleanSupplier LBPressed() {
        return () -> DriverStation.getStickButtonPressed(port, LB);
    }

    @Override
    public BooleanSupplier LBReleased() {
        return () -> DriverStation.getStickButtonReleased(port, LB);
    }

    @Override
    public Trigger RB() {
        return controller.rightBumper();
    }

    @Override
    public Trigger RB(EventLoop loop) {
        return controller.rightBumper(loop);
    }

    @Override
    public BooleanSupplier RBPressed() {
        return () -> DriverStation.getStickButtonPressed(port, RB);
    }

    @Override
    public BooleanSupplier RBReleased() {
        return () -> DriverStation.getStickButtonReleased(port, RB);
    }

    @Override
    public Trigger leftStickClick() {
        return controller.leftStick();
    }

    @Override
    public Trigger leftStickClick(EventLoop loop) {
        return controller.leftStick(loop);
    }

    @Override
    public BooleanSupplier leftStickClickPressed() {
        return () -> DriverStation.getStickButtonPressed(port, LEFT_STICK_CLICK);
    }

    @Override
    public BooleanSupplier leftStickClickReleased() {
        return () -> DriverStation.getStickButtonReleased(port, LEFT_STICK_CLICK);
    }

    @Override
    public Trigger rightStickClick() {
        return controller.rightStick();
    }

    @Override
    public Trigger rightStickClick(EventLoop loop) {
        return controller.rightStick(loop);
    }

    @Override
    public BooleanSupplier rightStickClickPressed() {
        return () -> DriverStation.getStickButtonPressed(port, RIGHT_STICK_CLICK);
    }

    @Override
    public BooleanSupplier rightStickClickReleased() {
        return () -> DriverStation.getStickButtonReleased(port, RIGHT_STICK_CLICK);
    }

    @Override
    public Trigger a() {
        return controller.a();
    }

    @Override
    public Trigger a(EventLoop loop) {
        return controller.a(loop);
    }

    @Override
    public BooleanSupplier aPressed() {
        return () -> DriverStation.getStickButtonPressed(port, A);
    }

    @Override
    public BooleanSupplier aReleased() {
        return () -> DriverStation.getStickButtonReleased(port, A);
    }

    @Override
    public Trigger b() {
        return controller.b();
    }

    @Override
    public Trigger b(EventLoop loop) {
        return controller.b(loop);
    }

    @Override
    public BooleanSupplier bPressed() {
        return () -> DriverStation.getStickButtonPressed(port, B);
    }

    @Override
    public BooleanSupplier bReleased() {
        return () -> DriverStation.getStickButtonReleased(port, B);
    }

    @Override
    public Trigger x() {
        return controller.x();
    }

    @Override
    public Trigger x(EventLoop loop) {
        return controller.x(loop);
    }

    @Override
    public BooleanSupplier xPressed() {
        return () -> DriverStation.getStickButtonPressed(port, X);
    }

    @Override
    public BooleanSupplier xReleased() {
        return () -> DriverStation.getStickButtonReleased(port, X);
    }

    @Override
    public Trigger y() {
        return controller.y();
    }

    @Override
    public Trigger y(EventLoop loop) {
        return controller.y(loop);
    }

    @Override
    public BooleanSupplier yPressed() {
        return () -> DriverStation.getStickButtonPressed(port, Y);
    }

    @Override
    public BooleanSupplier yReleased() {
        return () -> DriverStation.getStickButtonReleased(port, Y);
    }

    @Override
    public Trigger start() {
        return controller.start();
    }

    @Override
    public Trigger start(EventLoop loop) {
        return controller.start(loop);
    }

    @Override
    public BooleanSupplier startPressed() {
        return () -> DriverStation.getStickButtonPressed(port, START);
    }

    @Override
    public BooleanSupplier startReleased() {
        return () -> DriverStation.getStickButtonReleased(port, START);
    }

    @Override
    public Trigger back() {
        return controller.back();
    }

    @Override
    public Trigger back(EventLoop loop) {
        return controller.back(loop);
    }

    @Override
    public BooleanSupplier backPressed() {
        return () -> DriverStation.getStickButtonPressed(port, BACK);
    }

    @Override
    public BooleanSupplier backReleased() {
        return () -> DriverStation.getStickButtonReleased(port, BACK);
    }

    @Override
    public Trigger PovUp() {
        return controller.povUp();
    }

    @Override
    public Trigger PovUp(EventLoop loop) {
        return controller.pov(0, POV_UP, loop);
    }

    @Override
    public Trigger PovDown() {
        return controller.povDown();
    }

    @Override
    public Trigger PovDown(EventLoop loop) {
        return controller.pov(0, POV_DOWN, loop);
    }

    @Override
    public Trigger PovLeft() {
        return controller.povLeft();
    }

    @Override
    public Trigger PovLeft(EventLoop loop) {
        return controller.pov(0, POV_LEFT, loop);
    }

    @Override
    public Trigger PovRight() {
        return controller.povRight();
    }

    @Override
    public Trigger PovRight(EventLoop loop) {
        return controller.pov(0, POV_RIGHT, loop);
    }

    @Override
    public double povAngle() {
        if (PovUp().getAsBoolean()) {
            return POV_UP;
        }
        if (PovDown().getAsBoolean()) {
            return POV_DOWN;
        }
        if (PovLeft().getAsBoolean()) {
            return POV_LEFT;
        }
        if (PovRight().getAsBoolean()) {
            return POV_RIGHT;
        }
        return POV_NONE;
    }

    @Override
    public Trigger leftTrigger(double threshold, EventLoop loop) {
        return controller.leftTrigger(threshold, loop);
    }

    @Override
    public Trigger leftTrigger(double threshold) {
        return controller.leftTrigger(threshold);
    }

    @Override
    public Trigger leftTrigger() {
        return controller.leftTrigger();
    }

    @Override
    public Trigger rightTrigger(double threshold, EventLoop loop) {
        return controller.rightTrigger(threshold, loop);
    }

    @Override
    public Trigger rightTrigger(double threshold) {
        return controller.rightTrigger(threshold);
    }

    @Override
    public Trigger rightTrigger() {
        return controller.rightTrigger();
    }

    @Override
    public Trigger leftYUp(double threshold, EventLoop loop) {
        return controller.axisLessThan(LEFT_STICK_Y, threshold, loop);
    }

    @Override
    public Trigger leftYUp(double threshold) {
        return controller.axisLessThan(LEFT_STICK_Y, threshold);
    }

    @Override
    public Trigger leftYUp() {
        return controller.axisLessThan(LEFT_STICK_Y, THRESHOLD);
    }

    @Override
    public Trigger rightYUp(double threshold, EventLoop loop) {
        return controller.axisLessThan(RIGHT_STICK_Y, threshold, loop);
    }

    @Override
    public Trigger rightYUp(double threshold) {
        return controller.axisLessThan(RIGHT_STICK_Y, threshold);
    }

    @Override
    public Trigger rightYUp() {
        return controller.axisLessThan(RIGHT_STICK_Y, THRESHOLD);
    }

    @Override
    public Trigger leftYDown(double threshold, EventLoop loop) {
        return controller.axisGreaterThan(LEFT_STICK_Y, threshold, loop);
    }

    @Override
    public Trigger leftYDown(double threshold) {
        return controller.axisGreaterThan(LEFT_STICK_Y, threshold);
    }

    @Override
    public Trigger leftYDown() {
        return controller.axisGreaterThan(LEFT_STICK_Y, THRESHOLD);
    }

    @Override
    public Trigger rightYDown(double threshold, EventLoop loop) {
        return controller.axisGreaterThan(RIGHT_STICK_Y, threshold, loop);
    }

    @Override
    public Trigger rightYDown(double threshold) {
        return controller.axisGreaterThan(RIGHT_STICK_Y, threshold);
    }

    @Override
    public Trigger rightYDown() {
        return controller.axisGreaterThan(RIGHT_STICK_Y, THRESHOLD);
    }

    @Override
    public Trigger leftXLeft(double threshold, EventLoop loop) {
        return controller.axisLessThan(LEFT_STICK_X, threshold, loop);
    }

    @Override
    public Trigger leftXLeft(double threshold) {
        return controller.axisLessThan(LEFT_STICK_X, threshold);
    }

    @Override
    public Trigger leftXLeft() {
        return controller.axisLessThan(LEFT_STICK_X, THRESHOLD);
    }

    @Override
    public Trigger rightXLeft(double threshold, EventLoop loop) {
        return controller.axisLessThan(RIGHT_STICK_X, threshold, loop);
    }

    @Override
    public Trigger rightXLeft(double threshold) {
        return controller.axisLessThan(RIGHT_STICK_X, threshold);
    }

    @Override
    public Trigger rightXLeft() {
        return controller.axisLessThan(RIGHT_STICK_X, THRESHOLD);
    }

    @Override
    public Trigger leftXRight(double threshold, EventLoop loop) {
        return controller.axisGreaterThan(LEFT_STICK_X, threshold, loop);
    }

    @Override
    public Trigger leftXRight(double threshold) {
        return controller.axisGreaterThan(LEFT_STICK_X, threshold);
    }

    @Override
    public Trigger leftXRight() {
        return controller.axisGreaterThan(LEFT_STICK_X, THRESHOLD);
    }

    @Override
    public Trigger rightXRight(double threshold, EventLoop loop) {
        return controller.axisGreaterThan(RIGHT_STICK_X, threshold, loop);
    }

    @Override
    public Trigger rightXRight(double threshold) {
        return controller.axisGreaterThan(RIGHT_STICK_X, threshold);
    }

    @Override
    public Trigger rightXRight() {
        return controller.axisGreaterThan(LEFT_STICK_X, THRESHOLD);
    }

    @Override
    public double getLeftX() {
        return -controller.getLeftX();
    }

    @Override
    public double getRightX() {
        return -controller.getRightX();
    }

    @Override
    public double getLeftY() {
        return -controller.getLeftY();
    }

    @Override
    public double getRightY() {
        return -controller.getRightY();
    }

    @Override
    public double getLeftTriggerAxis() {
        return controller.getLeftTriggerAxis();
    }

    @Override
    public double getRightTriggerAxis() {
        return controller.getRightTriggerAxis();
    }
}
