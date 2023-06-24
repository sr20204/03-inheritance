package ohm.softa.a03;

public final class DeathState extends State{
    @java.lang.Override
    public ohm.softa.a03.State successor(Cat cat) {
        return cat.getCurrentState();
    }
}