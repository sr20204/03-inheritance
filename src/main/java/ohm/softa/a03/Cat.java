package ohm.softa.a03;

import ohm.softa.a03.State;
import ohm.softa.a03.HungryState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import static ohm.softa.a03.Cat.State.*;

public class Cat {
	//private static final Logger logger = LogManager.getLogger();

	// valid states
	public enum StateS {SLEEPING, HUNGRY, DIGESTING, PLAYFUL, DEAD}

	// initially, animals are sleeping
	private State currentState = new SleepingState();

	// state durations (set via constructor), ie. the number of ticks in each state
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;


	public Cat(String name, int sleep, int awake, int digest) {
		this.name = name;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
	}

	public void tick(){
	currentState = currentState.tick(this);

		/*switch (state) {
			case SLEEPING:
				if (time == sleep) {
					logger.info("Yoan... getting hungry!");
					state = HUNGRY;
					time = 0;
				}
				break;
			case HUNGRY:
				if(time == awake){
					logger.info("I've starved for a too long time...good bye...");
					state = DEAD;
				}
				break;
			case DIGESTING:
				timeDigesting = timeDigesting + 1;
				if (timeDigesting == digest) {
					logger.info("Getting in a playful mood!");
					state = PLAYFUL;
				}
				break;
			case PLAYFUL:
				if (time >= awake) {
					logger.info("Yoan... getting tired!");
					state = SLEEPING;
					time = 0;
				}
				break;

			case DEAD:
				break;
			default:
				throw new IllegalStateException("Unknown cat state " + state.name());
		}
*/
		//logger.info(currentState.name());

	}

	/**
	 * This would be a user interaction: feed the cat to change its state!
	 */
	public void feed(){
		if (!isHungry())
			throw new IllegalStateException("Can't stuff a cat...");
		HungryState hung = new HungryState();
		currentState = hung.feed(this);
		getCurrentState().logger.info("You feed the cat...");
		/*currentState = (HungryState) currentState;
		currentState.feed();*/
	 	//currentState = currentState.feed(this);
		//logger.info("You feed the cat...");

		// change state and reset the timer
		//currentState = new DigestingState();
		//timeDigesting = 0;
	}

	public boolean isAsleep() {
		SleepingState s = new SleepingState();
		return currentState.getClass() == s.getClass();
	}

	public boolean isPlayful() {
		return currentState.getClass() == new PlayfulState().getClass();
	}

	public boolean isHungry() {
		return currentState.getClass() == new HungryState().getClass();
	}

	public boolean isDigesting() {
		return currentState.getClass() == new DigestingState().getClass();
	}

	public boolean isDead() {
		return currentState.getClass() == new DeathState().getClass(); //currentState == StateS.DEAD;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getSleep() {
		return sleep;
	}
	public int getAwake() {
		return awake;
	}


	public int getDigest() {
		return digest;
	}

	public State getCurrentState() {
		return currentState;
	}
}
