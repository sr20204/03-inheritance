package ohm.softa.a03;

public final class PlayfulState extends State{
    @java.lang.Override
    public ohm.softa.a03.State successor(Cat cat) {

        if(cat.getCurrentState().getTime() < cat.getAwake()){
            return cat.getCurrentState();
        }
        else{
            logger.info("Yoan... getting tired!");
            return new SleepingState();
        }
    }
}