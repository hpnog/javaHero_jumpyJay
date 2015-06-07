package jumpyjay.gamestates;

import jumpyjay.gamestates.GameState;
import jumpyjay.handlers.SingletonVandC;

// TODO: Auto-generated Javadoc
/**
 * The Class GameStateManager.
 */
public class GameStateManager {
	
	//Current gamestate
	/** The current game state. */
	private GameState currentGameState;
	
	/** The singleton. */
	private SingletonVandC singleton;
	
	/**
	 * Instantiates a new game state manager.
	 */
	public GameStateManager() {
		singleton = SingletonVandC.getSingleton();
		setState(singleton.MENU);
	}
	
	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(int state) {
		if (currentGameState != null)
			currentGameState.dispose();
		if (state == singleton.MENU) {
			currentGameState = new MenuState(this);
		}
		else if (state == singleton.PLAY) {
			currentGameState = new PlayState(this);
		}
		else if (state == singleton.LEVEL)
			currentGameState = new LevelMenu(this);
		else if (state == singleton.SUCCESS)
			currentGameState = new LevelSucceded(this);
	}
	
	/**
	 * Update.
	 *
	 * @param dt the dt
	 */
	public void update (float dt) {
		currentGameState.update(dt);
	}
	
	/**
	 * Draw.
	 */
	public void draw () {
		currentGameState.render();
	}

	/**
	 * Pause.
	 */
	public void pause() {
		currentGameState.pause();
	}
}
