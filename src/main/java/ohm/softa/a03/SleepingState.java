package ohm.softa.a03;

import ohm.softa.a03.State;


public final class SleepingState extends State{
    @java.lang.Override
    public ohm.softa.a03.State successor(Cat cat) {

        if(cat.getCurrentState().getTime() < cat.getSleep()){
            return cat.getCurrentState();
        }
        else{
            logger.info("Yoan... getting hungry!");
            return new HungryState();
        }
    }
}