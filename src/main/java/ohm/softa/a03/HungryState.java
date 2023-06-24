package ohm.softa.a03;

import ohm.softa.a03.State;
import ohm.softa.a03.Cat;

public final class HungryState extends State{
    @java.lang.Override
    public State successor(Cat cat) {
        if(cat.getCurrentState().getTime() < cat.getAwake()){
            return cat.getCurrentState();
        }
        else{
            logger.info("I've starved for a too long time...good bye...");
            return new DeathState();
        }
    }

    public State feed(Cat cat){
    if (cat.isHungry()){
        return new DigestingState();
    }
    else{
        return cat.getCurrentState();
    }
    }
}