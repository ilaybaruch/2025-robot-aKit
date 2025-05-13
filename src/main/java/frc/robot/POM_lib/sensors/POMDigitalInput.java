package frc.robot.POM_lib.sensors;

import edu.wpi.first.wpilibj.DigitalInput;

public class POMDigitalInput {
    DigitalInput input;
    boolean normallyOpen;
    public POMDigitalInput(int channel, boolean isNormallyOpen){
        input = new DigitalInput(channel);
        this.normallyOpen = isNormallyOpen;
    }
    public POMDigitalInput(int channel){
        this(channel, true);
    }
    public boolean get(){
        return normallyOpen ^ input.get(); //if normally open, reverse. else not. 
    }
    public void close(){
        input.close();
    }
    public int getChannel(){
        return input.getChannel();
    }
    public boolean getNormallyOpen(){
        return normallyOpen;
    }
    public DigitalInput getInput(){
        return input;
    }
}
