package ohm.softa.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import ohm.softa.a03.Cat;

public abstract class State {

    int t = 0;
    final int duration = 10;
    public static final Logger logger = LogManager.getLogger();

   public final State tick(Cat cat){

       logger.info("tick()");
       setTime(getTime() + 1);
       return cat.getCurrentState().successor(cat);
       /*if(getTime() == cat.getSleep()){
           return new HungryState();
       }
       if(getTime() == cat.getAwake() && cat.isHungry())
       {
           return new DeathState();
       }
       if(getTime() == cat.getDigest() && cat.getCurrentState().getClass() == new DigestingState().getClass()){
           return new PlayfulState();
       }

    return new SleepingState();*/

    }
    public abstract State successor(Cat cat);
    public int getTime(){
       return t;
    }
    public void setTime(int a){
       t = a;
    }
    public int getDuration(){
       return duration;
    }
}
/*public final class DigestingState extends State{
    @java.lang.Override
    public ohm.softa.a03.State successor(Cat cat) {
        return null;
    }
}
public final class HungryState extends State{
    @java.lang.Override
    public ohm.softa.a03.State successor(Cat cat) {
        return null;
    }
}
public final class PlayfulState extends State{
    @java.lang.Override
    public ohm.softa.a03.State successor(Cat cat) {
        return null;
    }
}
public final class SleepingState extends State{
    @java.lang.Override
    public ohm.softa.a03.State successor(Cat cat) {
        return null;
    }
}
public final class DeathState extends State{
    @java.lang.Override
    public ohm.softa.a03.State successor(Cat cat) {
        return null;
    }
}*/
