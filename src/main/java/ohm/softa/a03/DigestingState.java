package ohm.softa.a03;

public final class DigestingState extends State{
    @java.lang.Override
    public ohm.softa.a03.State successor(Cat cat) {


        if(cat.getCurrentState().getTime() == cat.getDigest() )
        {
            logger.info("Getting in a playful mood!");
            PlayfulState play = new PlayfulState();
            play.setTime(cat.getCurrentState().getTime());
            return play;

        }
        else{
            return cat.getCurrentState();
        }
    }
}